import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
    },
    {
      path: '/monsters',
      name: 'monsters',
    },
    {
      path: '/items',
      name: 'items',
      children: [
        {
          path: 'accessories/:id?',
          name: 'accessories',
          component: () => import('@/views/item/AccessoryView.vue'),
        },
        {
          path: 'caps/:id?',
          name: 'caps',
          component: () => import('@/views/item/CapView.vue'),
        },
        {
          path: 'capes/:id?',
          name: 'capes',
          component: () => import('@/views/item/CapeView.vue'),
        },
        {
          path: 'coats/:id?',
          name: 'coats',
          component: () => import('@/views/item/CoatView.vue'),
        },
        {
          path: 'faces/:id?',
          name: 'faces',
          component: () => import('@/views/item/FaceView.vue'),
        },
        {
          path: 'gloves/:id?',
          name: 'gloves',
          component: () => import('@/views/item/GloveView.vue'),
        },
        {
          path: 'longcoats/:id?',
          name: 'longcoats',
          component: () => import('@/views/item/LongCoatView.vue'),
        },
        {
          path: 'pants/:id?',
          name: 'pants',
          component: () => import('@/views/item/PantsView.vue'),
        },
        {
          path: 'rings/:id?',
          name: 'rings',
          component: () => import('@/views/item/RingView.vue'),
        },
        {
          path: 'shields/:id?',
          name: 'shields',
          component: () => import('@/views/item/ShieldView.vue'),
        },
        {
          path: 'shoes/:id?',
          name: 'shoes',
          component: () => import('@/views/item/ShoesView.vue'),
        },
        {
          path: 'weapons/:id?',
          name: 'weapons',
          component: () => import('@/views/item/WeaponView.vue'),
        },
        {
          path: 'etc/:id?',
          name: 'etc',
          component: () => import('@/views/item/EtcView.vue'),
        },
        {
          path: 'uses/:id?',
          name: 'uses',
          component: () => import('@/views/item/UseView.vue'),
        },
      ]
    },
  ]
})

export default router
