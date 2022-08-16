<template>
  <div id="app">
    <div id="nav">
      <BarChart />
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
    </div>
    <router-view />
  </div>
</template>

<script>
import BarChart from './components/BarChart.vue'
export default {
  name: 'App',
  components: { BarChart },
}
</script>



<style>

#app {

  padding: 0;
}

#nav {

  padding: 0;
}

.tab {

  height: 50px;
  width: 267.5px;

margin: 0px;
}


</style>