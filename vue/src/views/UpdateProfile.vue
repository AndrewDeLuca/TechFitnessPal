<template>
  <div id="register" class="text-center">
      <form class="form-register" @submit.prevent="update">
        <img src="https://prod.wp.cdn.aws.wfu.edu/sites/22/2020/04/iStock-854725402.blog_.jpg" width="500" />
      <h1 class="h3 mb-3 font-weight-normal">Welcome to Waist Management</h1>
          <h1 class="h3 mb-3 font-weight-normal" >Create/Edit Your Waist Management Profile!</h1>
            <div class="alert alert-danger" role="alert"></div>
      
      
<section class=profileImage>      
<label for="Profile1" class="sr-only"></label>
<img class=image src="https://www.pngitem.com/pimgs/m/145-1454911_healthy-food-view-fruits-clipart-free-nutrition-and.png">
<input type="radio" value=https://www.pngitem.com/pimgs/m/145-1454911_healthy-food-view-fruits-clipart-free-nutrition-and.png class="form-control" v-model="profile.imgUrl"> 
   
<label for="Profile2" class="sr-only"></label>
<img class=image src="https://www.pngitem.com/pimgs/m/334-3347596_view-health-litjpg-clipart-free-nutrition-and-healthy.png">
<input type="radio" value=https://www.pngitem.com/pimgs/m/334-3347596_view-health-litjpg-clipart-free-nutrition-and-healthy.png class="form-control" v-model="profile.imgUrl"> 

<label for="Profile3" class="sr-only"></label>
<img class=image src="https://www.pngitem.com/pimgs/m/441-4413519_carrot-hd-png-download.png">
<input type="radio" value=https://www.pngitem.com/pimgs/m/441-4413519_carrot-hd-png-download.png class="form-control" v-model="profile.imgUrl">
<h2>Please Choose Your Profile Image</h2>
</section>

      
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

      <label for="date_of_birth" class="sr-only"></label>
      <input type="date" id="birthday" class="form-control" placeholder="Date of Birth" onfocus="(this.type='date')" onblur="(this.type='text')" v-model="profile.dateOfBirth">

      <label for="display_name" class="sr-only"></label>
      <input type="text" id="display_name" class="form-control" placeholder="Display Name" v-model="profile.displayName">

      <button class="btn btn-lg btn-primary btn-block" type="submit">Update Profile</button>
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
                height: '',
                displayName: '',
                dateOfBirth: '',
                imgUrl: ''
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
            },
            update() {
              profileService.updateProfile(this.profile).then(response => {
                if (response.status === 200) {
                  this.$router.push({ name: "mainprofilepage" });
                }
              })
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

profileImage {

}

.image {
  
  width: 100px;
  height: 100px;
}



</style>
