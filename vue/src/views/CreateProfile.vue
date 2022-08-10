<template>
  <div id="register" class="text-center">
      <form class="form-register" @submit.prevent="create">
          <h1 class="h3 mb-3 font-weight-normal" >Create Profile</h1>
            <div class="alert alert-danger" role="alert"></div>
      
      <label for="age" class="sr-only">Age</label>
      <input type="number" id="age" class="form-control" placeholder="Age" v-model="profile.age" required autofocus>
      
      <label for="height" class="sr-only">Height</label>
      <input type="number" id="height" class="form-control" placeholder="Height" v-model="profile.height" required>
      
      <label for="current_weight" class="sr-only">Current Weight</label>
      <input type="number" id="current_weight" class="form-control" placeholder="Current Weight" v-model="profile.currentWeight" required>

      <label for="desired_weight" class="sr-only">Desired Weight</label>
      <input type="number" id="desired_weight" class="form-control" placeholder="Desired Weight" v-model="profile.desiredWeight" required>
 
      <label for="goal_calories" class="sr-only">Goal Calories</label>
      <input type="number" id="goal_calories" class="form-control" placeholder="Goal Calories" v-model="profile.goalCalories" required>

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
                this.$router.push({ name: "home" });
              }
            });
            }
          }
        
    

}
</script>

<style>



</style>
