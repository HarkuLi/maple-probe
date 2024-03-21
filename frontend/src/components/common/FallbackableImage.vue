<script setup>
import { ref } from 'vue';

const props = defineProps({
  src: { type: String, required: true },
  fallbackSrc: { type: String, default: '' }
})

const isFallback = ref(false)

/**
 * @param {Event} event 
 */
function useFallbackSrc(event) {
  event.target.src = props.fallbackSrc
  isFallback.value = true
}
</script>

<template>
  <img :src="props.src" @error="!isFallback && useFallbackSrc($event)">
</template>
