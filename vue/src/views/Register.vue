<template>
  <div id="register" class="text-center">
    <router-link :to="{ name: 'login' }" class="tab" tag="button"
      >Sign In</router-link
    >
    <form class="form-register" @submit.prevent="register">
      <img
        src="https://prod.wp.cdn.aws.wfu.edu/sites/22/2020/04/iStock-854725402.blog_.jpg"
        width="500"
      />
      <h1 class="h3 mb-3 font-weight-normal">Welcome to Waist Management!!</h1>
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />

      <button class="tab btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import APIService from "../services/APIService.js";
export default {
  created() {
    APIService.foodSearch("apple");
  },
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {

              const loginUser = {
                username: this.user.username,
                password: this.user.password
              };

              authService.login(loginUser).then((responselogin) => {
                if (responselogin.status == 200) {
                  this.$store.commit("SET_AUTH_TOKEN", responselogin.data.token);
                  this.$store.commit("SET_USER", responselogin.data.user);

                  this.$router.push({
                    path: "/profile",
                    query: { registration: "success" },
                  });
                }
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style>
.tab {
  margin: auto;
  width: 21%;
  padding: 10px;
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}</style>
