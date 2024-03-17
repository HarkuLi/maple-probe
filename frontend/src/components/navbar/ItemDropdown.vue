<script setup>
import { RouterLink, useRouter } from 'vue-router'

const router = useRouter()

const routes = router.options.routes
  .find((route) => route.name === 'items')
  .children
</script>

<template>
  <li class="nav-item dropdown">
    <RouterLink
      to="/items"
      class="nav-link dropdown-toggle"
      active-class="active"
      role="button"
      data-bs-toggle="dropdown"
    >
      Items
    </RouterLink>
    <ul class="dropdown-menu">
      <template v-for="route in routes" :key="route.path">
        <li v-if="route.name !== 'single-item'">
          <RouterLink
            :to="`/items/${route.path.substring(0, route.path.indexOf('/'))}`"
            class="dropdown-item"
            active-class="active"
          >
            {{ route.name.charAt(0).toUpperCase() + route.name.slice(1) }}
          </RouterLink>
        </li>
      </template>
    </ul>
  </li>
</template>
