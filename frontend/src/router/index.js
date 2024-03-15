import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
    },
    {
      path: '/monster',
      name: 'monster',
    },
    {
      path: '/inventory',
      name: 'inventory',
      component: () => import('../views/inventory/InventoryView.vue'),
      children: [
        {
          path: 'accessory',
          component: () => import('../views/inventory/AccessoryView.vue'),
        },
        {
          path: 'cap',
          name: 'cap',
        },
        {
          path: 'cape',
          name: 'cape',
        },
        {
          path: 'coat',
          name: 'coat',
        },
        {
          path: 'face',
          name: 'face',
        },
        {
          path: 'glove',
          name: 'glove',
        },
        {
          path: 'longcoat',
          name: 'longcoat',
        },
        {
          path: 'pants',
          name: 'pants',
        },
        {
          path: 'ring',
          name: 'ring',
        },
        {
          path: 'shield',
          name: 'shield',
        },
        {
          path: 'shoes',
          name: 'shoes',
        },
        {
          path: 'weapon',
          name: 'weapon',
        },
        {
          path: 'etc',
          name: 'etc',
        },
        {
          path: 'use',
          name: 'use',
        },
      ]
    },
  ]
})

export default router
