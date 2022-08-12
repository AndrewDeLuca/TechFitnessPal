<template>
  <div>
    <form class="form-register" @submit.prevent="addMeals">
      <label for="numberOfServings" class="sr-only"></label>
      <input
        type="number"
        id="numberOfServings"
        class="form-control"
        placeholder="Number Of Servings"
        v-model="meal.numberOfServings"
      />

      <label for="calories" class="sr-only"></label>
      <input
        type="number"
        id="calories"
        class="form-control"
        placeholder="Calories"
        v-model="meal.calories"
      />

      <label for="mealName" class="sr-only"></label>
      <input
        type="text"
        id="mealName"
        class="form-control"
        placeholder="Meal Name"
        v-model="meal.mealName"
      />

      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Add Meal
      </button>
    </form>
  </div>
</template>

<script>
import mealsService from '../services/MealsService.js';
import profileService from '../services/ProfileService.js'
export default {
  name: 'meal',
  components: {},
  data() {
    return {
      meal: {
        mealId: '',
        numberOfServings: '',
        mealName: '',
        calories: '',
        profileId: ''
      },
    };
  },

  methods: {
    addMeals() {
      mealsService.addMeal(this.meal).then((response) => {
        if (response.status === 201) {
          this.$router.push({ name: "mainprofilepage" });
        }
      });
    },
    getProfileId(userId) {
      userId = this.$store.state.user.id;
      profileService.getProfile(userId).then(response => {
        return response.data;
      })
    }
  },
};
</script>

<style>
</style>