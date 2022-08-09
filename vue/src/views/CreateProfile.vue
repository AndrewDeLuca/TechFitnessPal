<template>
  <div id="register" class="text-center">
      <form class="form-register">
          <h1 class="h3 mb-3 font-weight-normal" @submit.prevent="create">Create Profile</h1>
            <div class="alert alert-danger" role="alert"></div>
      
      <label for="age" class="sr-only">Age</label>
      <input type="number" id="age" class="form-control" placeholder="Age" v-model="profile.age" required autofocus>
      
      <label for="height" class="sr-only">Height</label>
      <input type="number" id="height" class="form-control" placeholder="Height" v-model="profile.height" required>
      
      <label for="current_weight" class="sr-only">Current Weight</label>
      <input type="number" id="current_weight" class="form-control" placeholder="Current Weight" v-model="profile.current_weight" required>

      <label for="desired_weight" class="sr-only">Desired Weight</label>
      <input type="number" id="desired_weight" class="form-control" placeholder="Desired Weight" v-model="profile.desired_weight" required>
 
      <label for="goal_calories" class="sr-only">Goal Calories</label>
      <input type="number" id="goal_calories" class="form-control" placeholder="Goal Calories" v-model="profile.goal_calories" required>

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
                profile_id: '',
                user_id: '',
                goal_calories: '',
                current_weight: '',
                desired_weight: '',
                age: '',
                height: ''
            }
        }
    },
    methods: {
        create() {
            profileService.createProfile(this.user).then(response => {
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
