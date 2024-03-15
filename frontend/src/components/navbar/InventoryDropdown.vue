<script setup>
import { RouterLink, useRouter } from 'vue-router'

const router = useRouter()

const paths = router.options.routes
  .find((route) => route.name === 'inventory')
  .children
  .map((route) => route.path)
</script>

<template>
  <li class="nav-item dropdown">
    <RouterLink
      to="/inventory"
      class="nav-link dropdown-toggle"
      active-class="active"
      role="button"
      data-bs-toggle="dropdown"
    >
      Inventory
    </RouterLink>
    <ul class="dropdown-menu">
      <li v-for="path in paths" :key="path">
        <RouterLink
          :to="`/inventory/${path}`"
          class="dropdown-item"
          active-class="active"
        >
          {{ path.charAt(0).toUpperCase() + path.slice(1) }}
        </RouterLink>
      </li>
    </ul>
  </li>
</template>
