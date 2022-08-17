<template>
  <div id="app">
    <div id="nav">
             <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App',
  components: { },
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