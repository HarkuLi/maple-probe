<script setup>
import { Maprobe } from '@/clients/maprobe';
import SearchableSelect from '@/components/form/SearchableSelect.vue';
import { Tooltip } from 'bootstrap';
import { computed, onUpdated, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

defineProps({
  items: { type: Array /* [{'id': Number, 'name': String}, ...] */, required: true },
})

const route = useRoute()
const router = useRouter()
const maprobe = new Maprobe()

const id = computed(() => route.params.id)
const item = ref(null)

const droppedByRef = ref(null)

const droppers = ref([])

function handleSelect(selectedItem) {
  if (!selectedItem) {
    droppers.value = []
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
      <ul class="nav nav-tabs">
        <li class="nav-item">
          <a class="nav-link active" href="#">Dropped by</a>
        </li>
        <li class="nav-item">
          <a
            class="nav-link"
            :href="`https://bbb.hidden-street.net/search_finder/${item.name}`"
            target="_blank"
            rel="noreferrer noopenner"
          >
            Details
          </a>
        </li>
      </ul>
    </div>
    <div class="d-flex flex-wrap pt-4" ref="droppedByRef">
      <div v-for="dropper of droppers"
        :key="dropper.id"
        class="m-1"
        data-bs-toggle="tooltip"
        data-bs-html="true"
        :title="`Name: ${dropper.name}<br/>Chance: ${dropper.chance}`"
      >
        <a href="#">
          <img class="img-thumbnail" src="@/assets/monster/default.gif" :alt="dropper.name">
        </a>
      </div>
    </div>
  </template>
</template>

<style>
.tooltip-inner {
  text-align: left;
}
</style>
