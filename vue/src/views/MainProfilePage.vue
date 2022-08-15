<template>
  <div class="grid_container">
          <div id="title">
      <h1>Waist Management</h1>
      <img src="https://media.istockphoto.com/vectors/logo-barbell-cross-with-kettlebell-plate-shoe-and-muscled-arm-icons-vector-id1159989622?k=20&m=1159989622&s=612x612&w=0&h=83TBa4eikGfEIfwS9MWWHpXRadoBbtUbyd1gExKU9BI=" alt="img" id="logo">
    </div>
            
    <section class="header">
      <img class="profile_img"
        src="data:image/jpeg;base64,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"
        alt="profile_picture"
      />
      <section class="button">
        <router-link :to="{ name: 'profile'}" class='edit' tag="button">Edit Profile</router-link>
        <button class="edit">Goals</button>
        <button class="edit">Friends</button>
      </section>
      <section class="calories">
        <h2>current calories/</h2>
        <span>

        </span>
        <h2>goal calories</h2>

<!-- v-for="meal in meals" v-bind:key = "meal.id">
   -->
      <img class = "stars" src="data:image/jpeg;base64,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" alt="">
<!-- 
  v-for= "n in meal.mealsLogged" v-bind:key = "n">     COLTON TO HELP US 
 -->
      </section>
    </section>

    <section class="meals">
      <section class="breakfast">
        <h3>Breakfast</h3>
        <router-link :to="{ name: 'foods' }" class="tab" tag="button"
          >Add Breakfast</router-link
        >
        <ul class="list">
          <li>1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
          <li>5</li>
          <li>1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
          <li>5</li>
        </ul>
        <router-link :to="{ name: 'meals' }" class="tab" tag="button">Quick Meal</router-link>
      </section>

      <section class="lunch">
        <h3>Lunch</h3>
        <router-link :to="{ name: 'foods' }" class="tab" tag="button"
          >Add Lunch</router-link
        >
        <ul class="list">
          <li>1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
          <li>5</li>
          <li>1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
          <li>5</li>
        </ul>
        <router-link :to="{ name: 'meals' }" class="tab" tag="button">Quick Meal</router-link>
      </section>

      <section class="dinner">
        <h3>Dinner</h3>
        <router-link :to="{ name: 'foods' }" class="tab" tag="button"
          >Add Dinner</router-link
        >
                <ul class="list">
          <li>1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
          <li>5</li>
          <li>1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
          <li>5</li>
        </ul>
        <router-link :to="{ name: 'meals' }" class="tab" tag="button">Quick Meal</router-link>
      </section>

      <section class="snacks">
        <h3>Snacks</h3>
        <router-link :to="{ name: 'foods' }" class="tab" tag="button"
          >Add Snack</router-link
        >
        <ul class="list">
          <li>1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
          <li>5</li>
          <li>1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
          <li>5</li>
        </ul>
        <router-link :to="{ name: 'meals' }" class="tab" tag="button">Quick Meal</router-link>
      </section>
      <bar-chart></bar-chart>
    </section>
  </div>
</template>

<script>
import foodService from '../services/FoodService.js'
import BarChart from '../components/BarChart.vue'

export default {
  component: { BarChart },
  methods: {
    getFoodByMeal(meal) {
      foodService.getFoodByMeal(meal).then(response => {
        return this.$store.state.currentFood.food = response.data;
      })
    }
  }
}
</script>


<style scoped>
template {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas:
    "header header header header"
    "meals meals '' '' "
    "meals meals '' '' "
    "graph graph graph graph ";

  gap: 10px;
  gap: 20px;
}
#title {
  display: grid;
  grid-area: span;
  grid-template-areas: 
  "h1 h1 h1 img";
  border: 10px, solid, rgb(rgb(0, 0, 0), green, blue);
}
h1 {
  padding: 10%;
}
.header {
  display: grid;
  grid-area: header;
  grid-template-columns: 300px 100px 1fr 1fr;
  border-style: solid;
  padding: 5%;

  grid-template-areas:
    "img edit edit h2"
    "img edit edit h2"
}
.button {
  display: edit;

  grid-template-columns: 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas:
    "Edit Profile"
    "Goals"
    "Friends";
}
.calories {
  grid-area: h2;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas:
    "current calories/"
    "goal calories"
    "stars";
}

.meals {
  display: grid;
  grid-template-columns: 500px 500px;
  grid-template-areas:
    "breakfast lunch"
    "dinner snacks";

  gap: 10px;
  gap: 20px;
}
button {
  display: block;
  margin-top: 50px;
  grid-area: button;
}
.edit {
  height: 50px;
  width: 100px;
  font-size: medium;
  margin: 0px;
  margin-left: 0px;
  margin-top: 5px;
}
.button {
  margin-top: 65px;
}

h1 {
  margin-top: 50px;
  font-size: 300%;
  grid-area: h1;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
  color: goldenrod;
}

h2 {
  text-align: right;
  margin-left: 0px;
  grid-area: h2;
}

h3 {
  margin-top: 0px;
  font-size: 300%;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
  color: goldenrod;
  text-align: center;
}

.meals {
  grid-area: meals;
  margin-left: 35px;
}
.breakfast {
  border-style: solid;
  height: 700px;
}
.lunch {
  border-style: solid;
  height: 700px;
}
.dinner {
  border-style: solid;
  height: 700px;
}
.snacks {
  border-style: solid;
  height: 700px;
}

.edit {
  grid-area: edit;
}

img {
  width: 250px;
  height: 250px;
}

.tab {
  margin-left: 110px;
}
.list {
  margin-top: 100px;
  font-size: 135%;
  font-family: Arial, Helvetica, sans-serif;
  list-style-type: none;
}
.stars {
height: 60px;
width: 60px;
}

span {

  border-style: solid;
  border: steelblue;
}

.graph{
   border-style: solid;
  height: 450px;
   grid-area: span;

}
</style>