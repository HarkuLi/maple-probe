<script setup>
import ItemLayout from '@/components/ItemLayout.vue';
import { useRoute } from 'vue-router';

const route = useRoute()
const items = [{ id: route.params.id, name: route.query.name }]
</script>

<template>
  <ItemLayout v-if="items !== null" :items="items"></ItemLayout>
  <div v-else class="spinner-border text-muted d-block mx-auto"></div>
</template>
