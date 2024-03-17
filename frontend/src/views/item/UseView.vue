<script setup>
import { Maprobe } from '@/clients/maprobe';
import ItemLayout from '@/components/ItemLayout.vue';
import { ref } from 'vue';

const items = ref(null);

(async function fetchItems() {
  items.value = await (new Maprobe()).getUses()
})()
</script>

<template>
  <ItemLayout v-if="items !== null" :items="items"></ItemLayout>
  <div v-else class="spinner-border text-muted d-block mx-auto"></div>
</template>
