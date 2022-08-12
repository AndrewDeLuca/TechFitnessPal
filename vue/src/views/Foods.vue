<template>
  <div>
      <input type="text" id="foodSearch" placeholder="Enter Search Term" v="search">
      <button type="submit">fml</button>
      
      <form class="form-register" @submit.prevent="addFood">

          <label for="name" class="sr-only"></label>
          <input type="text" id="name" class="form-control" placeholder="Name" v-model="food.name">

          <label for="servingSize" class="sr-only"></label>
          <input type="number" id="servingSize" class="form-control" placeholder="Serving Size" v-model="food.servingSize">

          <label for="numberOfServings" class="sr-only"></label>
          <input type="number" id="numberOfServings" class="form-control" placeholder="Number Of Servings" v-model="food.numberOfServings">

          <label for="meal" class="sr-only"></label>
          <input type="text" id="meal" class="form-control" placeholder="Meal" v-model="food.meal">

          <label for="calories" class="sr-only"></label>
          <input type="number" id="calories" class="form-control" placeholder="Calories" v-model="food.calories">

          <button class="btn btn-lg btn-primary btn-block" type="submit">Add Food</button>
      </form>
  </div>
</template>

<script>
import foodService from '../services/FoodService.js'
import APIService from '../services/APIService.js'

export default {
    name: 'food',
    components: {},
    data() {
        return {
            food: {
                name: '',
                servingSize: '',
                numberOfServings: '',
                meal: '',
                calories: '',
                profileId: this.$store.state.user.id,
                foodConsumed: ''
            }
        }
    },
    methods: {
        addFood() {
            foodService.addFood(this.food).then(response => {
            if (response.status === 201) {
                this.$router.push({ name: "mainprofilepage" });
            }
        }
        
    )},
        search() {
            const userInput = document.getElementById('name').value;
            APIService.foodSearch(userInput).then(response => {
                if (response.status === 200) {
                    console.log(response.data);
                }
            })
        }
    }

}
</script>

<style>

</style>