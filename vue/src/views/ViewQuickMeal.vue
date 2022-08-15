<template>
  <div>
      <ul class="list">
<li v-for="m in meals" v-bind:key="m.meal_id">{{ m.mealName }}</li>
        </ul>



<router-link :to="{ name: 'mainprofilepage' }" class="tab" tag="button">Add Meal</router-link>
  </div>


  
</template>

<script>
export default {

}
</script>
import mealsService from '../services/MealsService.js'

export default {
  data() {
    return {
      meals: []
      }
    },
    methods: {
      getMeals() {
        return this.meal = response.data;
      }
    },
    created() {
      this.getMeals();
    }
  }


<style>


.list {
  margin-top: 100px;
  font-size: 135%;
  font-family: Arial, Helvetica, sans-serif;
  list-style-type: none;
}


</style>