<script setup>
import { Maprobe } from '@/clients/maprobe';
import ItemLayout from '@/components/ItemLayout.vue';
import { ref } from 'vue';

const items = ref(null);

(async function fetchItems() {
  items.value = await (new Maprobe()).getCoats()
})()
</script>

<template>
  <ItemLayout v-if="items !== null" :items="items"></ItemLayout>
</template>
