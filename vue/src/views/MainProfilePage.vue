<template>
  <div class="grid_container">
    <router-link :to="{ name: 'login' }" class="tabs" tag="button">
      Log Out</router-link
    >

    <div id="title">
      <h1>Waist Management</h1>
      <img
        src="https://media.istockphoto.com/vectors/logo-barbell-cross-with-kettlebell-plate-shoe-and-muscled-arm-icons-vector-id1159989622?k=20&m=1159989622&s=612x612&w=0&h=83TBa4eikGfEIfwS9MWWHpXRadoBbtUbyd1gExKU9BI="
        alt="img"
        id="logo"
      />
    </div>

    <section class="header">
    <img v-bind:src="profile.imgUrl"/>
    

      <section class="button">
        <h2>{{ profile.displayName }} </h2>
        <router-link :to="{ name: 'profile' }" class="edit" tag="button"
          >Edit Profile</router-link
        >
      
        
        
        <router-link :to="{ name: 'meals' }" class="tab" tag="button"
          >Create Meal</router-link
        >
      </section>
      <section class="calories">
        <h2>{{ calorieTotal }} current calories/</h2>
        <span> </span>
        <h2>{{ profile.goalCalories }} goal calories</h2>

        <!-- v-for="meal in meals" v-bind:key = "meal.id">
   -->
        <h2>Log 3 Consecutive Meals in One Day to Earn a Dumbbell!</h2>
        <img
          class="stars"
          src="data:image/jpeg;base64,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"
          alt="dumbbell"
          v-for="n in profile.stars" v-bind:key="n"
        />
       
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
          <li v-for="food in breakfastFoods" v-bind:key="food.food_id">
            {{ food.name }} || {{ food.calories }} @ {{ food.foodConsumed }}
          </li>
        </ul>
        <p>{{ this.selectedMealIds }}</p>
        <router-link :to="{ name: 'viewquickmeal' }" class="tab" tag="button"
          >Quick Meal</router-link
        >
      </section>

      <section class="lunch">
        <h3>Lunch</h3>
        <router-link :to="{ name: 'foods' }" class="tab" tag="button"
          >Add Lunch</router-link
        >
        <ul class="list">
          <li v-for="food in lunchFoods" v-bind:key="food.food_id">
            {{ food.name }} || {{ food.calories }} @ {{ food.foodConsumed }}
          </li>
        </ul>
        <router-link :to="{ name: 'viewquickmeal' }" class="tab" tag="button"
          >Quick Meal</router-link
        >
      </section>

      <section class="dinner">
        <h3>Dinner</h3>
        <router-link :to="{ name: 'foods' }" class="tab" tag="button"
          >Add Dinner</router-link
        >
        <ul class="list">
          <li v-for="food in dinnerFoods" v-bind:key="food.food_id">
            {{ food.name }} || {{ food.calories }} @ {{ food.foodConsumed }}
          </li>
        </ul>
        <router-link :to="{ name: 'viewquickmeal' }" class="tab" tag="button"
          >Quick Meal</router-link
        >
      </section>

      <section class="snack">
        <h3>Graph</h3>
        <BarChart class="chart" v-if="calorieTotal && monthlyCalorieTotal" :bar-data="[ calorieTotal, monthlyCalorieTotal ]"/>
      </section>
      <section>
        
      </section>
    </section>
  </div>
</template>

<script>
import foodService from "../services/FoodService.js";
import BarChart from "../components/BarChart.vue";
import profileService from "../services/ProfileService.js";


export default {
  data() {
    return {
      counter: 0,
      food: [],
      profile: {
        stars: 5
      },
    };
  },
  components: { BarChart },
  methods: {
    getFood() {
      foodService.getFood().then((response) => {
        this.food = response.data;
      });
    },
    getProfile() {
      profileService.getProfile(this.$store.state.user.id).then((response) => {
        this.profile = response.data;
        this.profile.stars = 5;
      });
    },
  },
  created() {
    this.getFood();
    this.getProfile();
  },
  computed: {
    breakfastFoods() {
      return this.food.filter((response) => {
        return response.meal == "breakfast";
      });
    },

    lunchFoods() {
      return this.food.filter((response) => {
        return response.meal == "lunch";
      });
    },
    dinnerFoods() {
      return this.food.filter((response) => {
        return response.meal == "dinner";
      });
    },
    snackFoods() {
      return this.food.filter((response) => {
        return response.meal == "snack";
      });
    },
    dailyFood() {
      const now = new Date();
      return this.food.filter((response) => {
        const foodConsumedDate = new Date(response.foodConsumed);
        return (
          now.getDate() == foodConsumedDate.getDate() &&
          now.getFullYear() == foodConsumedDate.getFullYear() &&
          now.getMonth() == foodConsumedDate.getMonth()
        );
      });
    },
    monthlyFood() {
      const now = new Date();
      return this.food.filter((response) => {
        const foodConsumedDate = new Date(response.foodConsumed);
        return (
          now.getFullYear() == foodConsumedDate.getFullYear() &&
          now.getMonth() == foodConsumedDate.getMonth()
        );
      });
    },
    yearlyFood() {
      const now = new Date();
      return this.food.filter((response) => {
        const foodConsumedDate = new Date(response.foodConsumed);
        return now.getFullYear() == foodConsumedDate.getFullYear();
      });
    },
    calorieTotal() {
      var calories = 0;
      this.dailyFood.forEach((element) => {
        calories += element.calories;
      });
      return calories;
    },
    monthlyCalorieTotal() {
      var calories = 0;
      this.monthlyFood.forEach(element => {
        calories += element.calories;
      })
      return calories;
    }
  },
};
</script>


<style scoped>
template {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "header header"
    "meals meals"
    "meals graph";
    

  gap: 10px;
  gap: 20px;
}
#title {
  display: grid;
  grid-area: span;
  grid-template-areas: "h1 h1 h1 img";
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
    "img edit edit h2";
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
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "breakfast lunch"
    "dinner graph";

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
  margin-left: 450px;
  font-size: 300%;
  grid-area: h1;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
  color: goldenrod;
  text-align: center;
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
.snack {
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
  margin-left: 325px;
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

.tabs {
margin-left: 800px;
width: 200px;

}



</style>