<script setup>
import { Maprobe } from '@/clients/maprobe';
import MonsterLayout from '@/components/MonsterLayout.vue';
import { ref } from 'vue';

const monsters = ref(null);

(async function fetchMonsters() {
  monsters.value = await (new Maprobe()).getMonsters()
})()
</script>

<template>
  <MonsterLayout v-if="monsters !== null" :monsters="monsters"></MonsterLayout>
  <div v-else class="spinner-border text-muted d-block mx-auto"></div>
</template>
