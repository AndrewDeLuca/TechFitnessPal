<template>
  <div id="app">
    <div id="nav">
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      <router-link :to="{ name: 'login'}" class='tab' tag="button"> Sign In</router-link>
      <router-link :to="{ name: 'register'}" class='tab' tag="button" >Sign Up</router-link>
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
    </div>
    <router-view />
  </div>
</template>

<script>
//import MainProfilePage from '../views/MainProfilePage.vue'
import BarChart from './components/BarChart.vue'
export default {
  //components: MainProfilePage
component: { BarChart }
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