<script setup>
import { Maprobe } from '@/clients/maprobe';
import SearchableSelect from '@/components/form/SearchableSelect.vue';
import { BbbHidenStreetUrl } from '@/utils/bbb-hidden-street-url';
import { PublicUrl } from '@/utils/public-url';
import { Tooltip } from 'bootstrap';
import { computed, onUpdated, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import FallbackableImage from './common/FallbackableImage.vue';

const props = defineProps({
  items: { type: Array /* [{'id': Number, 'name': String}, ...] */, required: true },
})

const route = useRoute()
const router = useRouter()
const maprobe = new Maprobe()
const publicUrl = new PublicUrl()
const bbbHidenStreetUrl = new BbbHidenStreetUrl()

const id = computed(() => route.params.id)
const item = ref(props.items.length === 1 ? props.items[0] : null)

const droppedByRef = ref(null)

const droppers = ref(null)

function handleSelect(selectedItem) {
  item.value = null
  droppers.value = null

  if (!selectedItem) {
    return
  }

  router.push({name: router.currentRoute.value.name, params: {id: selectedItem.id}})

  item.value = selectedItem

  fetchDroppers()
}

async function fetchDroppers() {
  droppers.value = await maprobe.getDroppers(item.value.id)
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
      :options="items"
      :selectedId="id"
      :searchKeys="['id', 'name']"
      :optionFormatter="(option) => `${option.name} (${option.id})`"
      @select="handleSelect"
    />
  </div>
  <template v-if="item">
    <div class="mt-4">
      <FallbackableImage
        :src="publicUrl.item(item.id)"
        :fallback-src="publicUrl.itemDefault()"
        :alt="item.name"
        class="img-thumbnail mx-auto d-block"
        width="120"
        height="120"
      />
    </div>
    <div class="mt-4">
      <ul class="nav nav-tabs">
        <li class="nav-item">
          <a class="nav-link active" href="#">Dropped by</a>
        </li>
        <li class="nav-item">
          <a
            class="nav-link"
            :href="bbbHidenStreetUrl.search(item.name)"
            target="_blank"
            rel="noreferrer noopenner"
          >
            Details
          </a>
        </li>
      </ul>
    </div>
    <div v-if="droppers" class="d-flex flex-wrap pt-4" ref="droppedByRef">
      <div v-for="dropper of droppers"
        :key="dropper.id"
        class="m-1 item-dropper align-self-end"
        data-bs-toggle="tooltip"
        data-bs-html="true"
        :title="`ID: ${dropper.id}<br/>Name: ${dropper.name}<br/>Chance: ${dropper.chance}`"
      >
        <RouterLink :to="{ name: 'monsters', params: { id: dropper.id } }" target="_blank">
          <FallbackableImage
            :src="publicUrl.monster(dropper.id)"
            :fallback-src="publicUrl.monsterDefault()"
            :alt="dropper.name"
            class="img-thumbnail"
          />
        </RouterLink>
      </div>
    </div>
    <div v-else class="mt-5 spinner-border text-muted d-block mx-auto"></div>
  </template>
</template>

<style>
.tooltip-inner {
  text-align: left;
}

.item-dropper .img-thumbnail {
  width: 6rem;
}
</style>
