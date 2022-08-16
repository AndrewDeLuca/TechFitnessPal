<template>

  <div id="login" class="text-center">
    <router-link :to="{ name: 'login'}" class='tab' tag="button"> Sign In</router-link>
      <router-link :to="{ name: 'register'}" class='tab' tag="button" >Sign Up</router-link>
    
    <form class="form-signin" @submit.prevent="login">
      <img src="https://prod.wp.cdn.aws.wfu.edu/sites/22/2020/04/iStock-854725402.blog_.jpg" width="500" />
      <h1 class="h3 mb-3 font-weight-normal">Welcome to Waist Management</h1>
      
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
      <label for="username" class="sr-only"></label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only"></label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      
      <button type="submit">Sign In</button>
     
    </form>
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
            this.$store.commit("SET_PROFILE", response.data.profile);
            this.$router.push("/mainprofilepage");
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
  margin: 0;
  font-family: Georgia, 'Times New Roman', Times, serif;
  font-style: italic;
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
width: 540px;
height: 300px;

}

</style>
