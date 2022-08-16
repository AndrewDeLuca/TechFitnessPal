<template>
  <div>
      <ul class="list">
<li v-for="m in meals" v-bind:key="m.meal_id" >{{ m.mealName }}  ||  {{ m.calories }} <input  v-model="selectedMealIDs" v-bind="meals.meal_id" type="checkbox"></li> 
        </ul>
 


<router-link :to="{ name: 'mainprofilepage' }" class="tab" tag="button" >Add Meal</router-link>
  </div>


  
</template>

<script>
import mealsService from '../services/MealsService.js'
export default {
  
  data() {
    return {
      meals: []
      }
    },
    selectedMealIDs: [],
    methods: {
      getMeals() {
        mealsService.getMeals().then(response => {
          return this.meals = response.data;
        })
        
      }
    },
    created() {
      this.getMeals();
    }
  }
</script>





<style>


.list {
  margin-top: 100px;
  font-size: 135%;
  font-family: Arial, Helvetica, sans-serif;
  list-style-type: none;
}


</style>