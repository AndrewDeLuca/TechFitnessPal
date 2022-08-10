<template>
  <div id="register" class="text-center">
      <form class="form-register" @submit.prevent="create">
        <img src="https://prod.wp.cdn.aws.wfu.edu/sites/22/2020/04/iStock-854725402.blog_.jpg" width="500" />
      <h1 class="h3 mb-3 font-weight-normal">Welcome to Waist Management</h1>
          <h1 class="h3 mb-3 font-weight-normal" >Create Your Waist Management Profile!</h1>
            <div class="alert alert-danger" role="alert"></div>
      
      <label for="age" class="sr-only"></label>
      <input type="number" min="0" id="age" class="form-control" placeholder="Age" v-model="profile.age" required autofocus>
      
      <label for="height" class="sr-only"></label>
      <input type="text" min="0" id="height" class="form-control" placeholder="Height" v-model="profile.height" required>
      
      <label for="current_weight" class="sr-only"></label>
      <input type="number" min="0" id="current_weight" class="form-control" placeholder="Current Weight" v-model="profile.currentWeight" required>

      <label for="desired_weight" class="sr-only"></label>
      <input type="number" min="0" id="desired_weight" class="form-control" placeholder="Desired Weight" v-model="profile.desiredWeight" required>
 
      <label for="goal_calories" class="sr-only"></label>
      <input type="number" min="0" id="goal_calories" class="form-control" placeholder="Goal Calories" v-model="profile.goalCalories" required>

      <button class="btn btn-lg btn-primary btn-block" type="submit">Create Profile</button>
      </form>
  </div>
</template>

<script>
import profileService from '../services/ProfileService.js'


export default {
    name: 'profile',
    components: {},
    data() {
    return {
            profile: {
                userId: this.$store.state.user.id,
                goalCalories: '',
                currentWeight: '',
                desiredWeight: '',
                age: '',
                height: ''
            }
        }
    },
    methods: {
        create() {
            profileService.createProfile(this.profile).then(response => {
              if (response.status === 201) {
                this.$router.push({ name: "mainprofilepage" });
              }
            });
            }
          }
        
    

}
</script>

<style>

input{

  display: flex;
  margin: auto;
  height: 40px;
  width: 525px;
  font-size: larger;
  text-align: center;
  margin-bottom: 20px;
}

#username {

  margin-bottom: 6px;
}

form{

padding: 20px;
margin: auto;

}


button {

  margin-top: 20px;
  height: 50px;
  width: 535px;
  font-size: xx-large;
  font-weight: bolder;

}


</style>
