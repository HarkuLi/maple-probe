<script setup>
import { Maprobe } from '@/clients/maprobe';
import SearchableSelect from '@/components/form/SearchableSelect.vue';
import { BbbHidenStreetUrl } from '@/utils/bbb-hidden-street-url';
import { PublicUrl } from '@/utils/public-url';
import { Tooltip } from 'bootstrap';
import { computed, onUpdated, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

defineProps({
  monsters: { type: Array /* [{'id': Number, 'name': String}, ...] */, required: true },
})

const route = useRoute()
const router = useRouter()
const maprobe = new Maprobe()
const publicUrl = new PublicUrl()
const bbbHidenStreetUrl = new BbbHidenStreetUrl()

const id = computed(() => route.params.id)
const monster = ref(null)

const dropsRef = ref(null)

const drops = ref(null)

function handleSelect(selectedMonster) {
  monster.value = null
  drops.value = null

  if (!selectedMonster) {
    return
  }

  router.push({name: router.currentRoute.value.name, params: {id: selectedMonster.id}})

  monster.value = selectedMonster

  fetchDrops()
}

async function fetchDrops() {
  drops.value = await maprobe.getDrops(monster.value.id)
}

onUpdated(() => {
  (function triggerTooltips() {
    [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
      .map((toggles) => new Tooltip(toggles))
  })()
})
</script>

<template>
  <div>
    <SearchableSelect
      :options="monsters"
      :selectedId="id"
      :searchKeys="['id', 'name']"
      :optionFormatter="(option) => `${option.name} (${option.id})`"
      @select="handleSelect"
    />
  </div>
  <template v-if="monster">
    <div class="mt-4">
      <img :src="publicUrl.monster(monster.id)"
        :alt="monster.name"
        class="img-thumbnail mx-auto d-block"
        width="120"
        height="120"
        @error="e => e.target.src = publicUrl.monsterDefault()"
      >
    </div>
    <div class="mt-4">
      <ul class="nav nav-tabs">
        <li class="nav-item">
          <a class="nav-link active" href="#">Drops</a>
        </li>
        <li class="nav-item">
          <a
            class="nav-link"
            :href="bbbHidenStreetUrl.monster(monster.name)"
            target="_blank"
            rel="noreferrer noopenner"
          >
            Details
          </a>
        </li>
      </ul>
    </div>
    <div v-if="drops" class="d-flex flex-wrap pt-4" ref="dropsRef">
      <div v-for="drop of drops"
        :key="drop.id"
        class="m-1 dropped-item align-self-end"
        data-bs-toggle="tooltip"
        data-bs-html="true"
        :title="`ID: ${drop.id}<br/>Name: ${drop.name}<br/>Chance: ${drop.chance}`"
      >
        <a>
          <img :src="publicUrl.item(drop.id)"
            :alt="drop.name"
            class="img-thumbnail"
            @error="e => e.target.src = publicUrl.itemDefault()"
          >
        </a>
      </div>
    </div>
    <div v-else class="mt-5 spinner-border text-muted d-block mx-auto"></div>
  </template>
</template>

<style>
.tooltip-inner {
  text-align: left;
}

.dropped-item .img-thumbnail {
  width: 6rem;
}
</style>
