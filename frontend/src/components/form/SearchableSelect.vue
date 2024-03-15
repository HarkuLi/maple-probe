<script setup>
import { Dropdown } from 'bootstrap';
import Fuse from 'fuse.js';
import { ref, watch } from 'vue';

const props = defineProps({
  options: { type: Array /* object[] */, required: true },
  idKey: { type: String, default: 'id' },
  selectedId: { type: String },
  searchKeys: { type: Array /* string[] */, required: true },
  optionFormatter: { type: Function /* (option) => string */, required: true },
  maxSuggestionNum: { type: Number, default: 10 },
})

const emit = defineEmits(['select']) // return the selected option object or null

const fuse = new Fuse(props.options, { keys: props.searchKeys })

const userInput = ref('')
const target = ref(null)
const matchedOptions = ref(props.options.slice(0, props.maxSuggestionNum))
const activeIdx = ref(0)

const inputRef = ref(null)
const dropdownMenuRef = ref(null)

selectById(props.selectedId)

watch(() => props.selectedId, selectById)

watch(userInput, (newValue) => {
  matchedOptions.value = newValue
    ? fuse.search(newValue, { limit: props.maxSuggestionNum }).map((e) => e.item)
    : props.options.slice(0, props.maxSuggestionNum)

  if (matchedOptions.value.length && target.value === null) {
    showDropdown()
  } else {
    hideDropdown()
  }
})

function selectById(id) {
  if (!id) {
    userInput.value = ''
    emit('select', null)
    return
  }

  let option = props.options
    .find((option) => option[props.idKey] == id)
  if (option) {
    select(option)
  }
}

function select(option) {
  target.value = option
  userInput.value = props.optionFormatter(option)
  activeIdx.value = 0
  emit('select', option)
}

function showDropdown() {
  if (inputRef.value.classList.contains('show') || !matchedOptions.value.length) {
    return;
  }

  activeIdx.value = 0
  Dropdown.getInstance(inputRef.value).show()
}

function hideDropdown() {
  Dropdown.getInstance(inputRef.value).hide()
}

function handleKeydown(keydownEvent) {
  if (keydownEvent.defaultPrevented) {
    return;
  }

  target.value = null

  switch (keydownEvent.key) {
    case "ArrowDown":
      activeIdx.value = (activeIdx.value + 1) % matchedOptions.value.length
      showDropdown()
      break;
    case "ArrowUp":
      activeIdx.value = activeIdx.value === 0
        ? matchedOptions.value.length - 1
        : activeIdx.value - 1
      showDropdown()
      break;
    case "Enter":
      dropdownMenuRef.value.querySelector("span.active").click()
      break;
    default:
      return;
  }

  keydownEvent.preventDefault();
}
</script>

<template>
  <input
    class="form-control dropdown-toggle"
    data-bs-toggle="dropdown"
    @keydown="handleKeydown"
    v-model="userInput"
    ref="inputRef"
  >
  <ul class="container dropdown-menu" ref="dropdownMenuRef">
    <li v-for="[idx, option] of matchedOptions.entries()" :key="option[props.idKey]">
      <span
        :class="{ 'dropdown-item': true, 'active': idx === activeIdx }"
        @click="select(option)"
      >
        {{ props.optionFormatter(option) }}
      </span>
    </li>
  </ul>
</template>
