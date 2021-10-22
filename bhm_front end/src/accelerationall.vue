<template>
  <div id="accelerationall">
    <accelerationx></accelerationx>
    <accelerationy></accelerationy>
    <accelerationz></accelerationz>
  </div>
</template>
<script>
import accelerationx from './accelerationx.vue'
import accelerationy from './accelerationy.vue'
import accelerationz from './accelerationz.vue'
export default {
  name: 'accelerationall',
  components: {
    accelerationx,
    accelerationy,
    accelerationz
  }
}
</script>
<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
