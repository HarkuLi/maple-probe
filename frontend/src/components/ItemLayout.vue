<script setup>
import SearchableSelect from '@/components/form/SearchableSelect.vue';
import { Tooltip } from 'bootstrap';
import { computed, onUpdated, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

defineProps({
  items: { type: Array /* [{'id': Number, 'name': String}, ...] */, required: true },
})

const route = useRoute()
const router = useRouter()

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
  console.log(`fetch dropper of item: ${item.value.id}`)

  droppers.value = [
    {id: 100100, name: 'Snail', chance: 100},
    {id: 100101, name: 'Blue Snail', chance: 100},
    {id: 100120, name: 'Tino', chance: 100},
    {id: 100121, name: 'Tiv', chance: 100},
    {id: 100122, name: 'Timu', chance: 100},
    {id: 100123, name: 'Tiru', chance: 100},
    {id: 100124, name: 'Tiguru', chance: 100},
    {id: 1110100, name: 'Green Mushroom', chance: 100},
    {id: 1110101, name: 'Dark Stump', chance: 100},
    {id: 1120100, name: 'Octopus', chance: 100},
    {id: 1130100, name: 'Axe Stump', chance: 100},
    {id: 1140100, name: 'Ghost Stump', chance: 100},
    {id: 120100, name: 'Shroom', chance: 100},
    {id: 1210100, name: 'Pig', chance: 100},
    {id: 1210101, name: 'Ribbon Pig', chance: 100},
    {id: 1210102, name: 'Orange Mushroom', chance: 100},
    {id: 2230131, name: 'Annoyed Zombie Mushroom', chance: 100},
    {id: 1110130, name: 'Dejected Green Mushroom', chance: 100},
    {id: 1140130, name: 'Smirking Ghost Stump', chance: 100},
    {id: 1210103, name: 'Bubbling', chance: 100},
  ];
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
        :title="`name: ${dropper.name}<br/>chance: ${dropper.chance}`"
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
