<template>
<div>
  <section class="header">
  <h1>Waist Management</h1>
  <h2>  current calories/         </h2>
  <h2>    goal calories       </h2>
  
<img src="data:image/jpeg;base64,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" alt="">
<button>Edit Profile</button>
<button>Goals</button>
<button>Friends</button>
</section>

<section class="meals">

<section>
<h3 class="breakfast">Breakfast</h3>
<router-link :to="{ name: 'foods' }" class='tab' tag="button">Add Breakfast</router-link>
</section>

<section>
<h3 class="lunch">Lunch</h3>

<router-link :to="{ name: 'foods' }" class='tab' tag="button">Add Lunch</router-link>
</section>

<section>
<h3 class="dinner">Dinner</h3>

<router-link :to="{ name: 'foods' }" class='tab' tag="button">Add Dinner</router-link>
</section>

<section>
<h3 class="snacks">Snacks</h3>

<router-link :to="{ name: 'foods' }" class='tab' tag="button">Add Snack</router-link>
<router-link :to="{ name: 'meals'}" class='tab' tag="button" >Meals</router-link>
</section>


</section>




</div>







</template>

<script>
export default {

}
</script>

<style scoped>

button{
  display: block;
 margin-top: 50px; 
 grid-area: button;
}



h1 {
margin-top: 50px;
font-size: 300%;
grid-area: h1;
font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
color: goldenrod

}

h2{
text-align: right;
margin-left: 0px;
grid-area: h2;
}

h3{
margin-top: 50px;
font-size: 300%;
font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
color: goldenrod;
text-align: left;
margin-right: 0px;
}

template {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas: 
                        "Header Header Header Header"      
                        "meals meals '' '' "
                         "meals meals '' '' "
                         "'' '' '' ''";
                        
    gap: 10px;
  gap: 20px;

}

.meals {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:  "breakfast lunch"
                         "dinner snacks";
                        
    gap: 10px;
  gap: 20px;

}

.meals{
  grid-area: meals;
}

.header{
  display: grid;
  
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas: "h1 h1 h1 h1"
                       "img button '' h2";
  
}

button{
  grid-area: button;
}

</style>
