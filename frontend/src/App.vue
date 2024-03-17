<script setup>
import { RouterView } from 'vue-router'
import NavBar from './components/navbar/NavBar.vue'
</script>

<template>
  <NavBar />
  <div class="container mt-4">
    <RouterView />
  </div>
</template>
