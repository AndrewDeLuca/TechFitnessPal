<template>
  <div>
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



<router-link :to="{ name: 'mainprofilepage' }" class="tab" tag="button">Add Meal</router-link>
  </div>


  
</template>

<script>
export default {

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