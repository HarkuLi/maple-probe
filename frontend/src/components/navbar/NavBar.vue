<script setup>
import { RouterLink } from 'vue-router'
import ItemDropdown from './ItemDropdown.vue'
</script>

<template>
  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
      <RouterLink to="/" class="navbar-brand">Maprobe</RouterLink>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
          <ItemDropdown />
          <li class="nav-item">
            <RouterLink to="/monsters" class="nav-link" active-class="active">Monsters</RouterLink>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>./ItemDropdown.vue
