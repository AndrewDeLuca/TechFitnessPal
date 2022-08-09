<template>

  <div id="login" class="text-center">
    
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register'}" class='link' >Need an account?</router-link>
      <button type="submit">Sign in</button>
     
    </form>
    <img src="https://images.unsplash.com/photo-1578880981498-3d60436ba825?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OTJ8fGZpdG5lc3N8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60" alt="">
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style >
/* Main styling */
 
h1 {
  color:cornflowerblue;
  text-align: center;
}

div {
  text-align: center;
  
}

html {
  background-color: lightgoldenrodyellow;
}

label {
  padding-inline: 10px;
}

.link {
   margin-left: 25px;
  margin-right: 15px;
}

button {
  margin-left: 10px;
  margin-right: 10px;
}

img {
padding: 25px;
width: 300px;
height: 300px;

}

</style>
