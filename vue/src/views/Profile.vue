<template>
  <div>
<h1> Please Create Your Profile </h1>
 <form action="">



<section>

        <label for="name">Enter your name: </label>
        <input id="name" type="text" name="name" required>
    </section>


    <section>

         <label for="email">Enter your email: </label>
         <input id="email" type="email" name="email" required>
    </section>

    <section>

         <label for="date-of-birth">Enter you date of birth: </label>
         <input id="date-of-birth" type="date" name = "date-of-birth">
    
</section>

<section>

         <label for="height">Enter your height: </label>
         <input id="height" type="height" name = "height">

</section>


<section>

<label for="weight">Enter your current weight: </label>
         <input id="weight" type="weight" name = "weight">


</section>


<section>
         <label for="weight">Enter your desired weight: </label>
         <input id="weight" type="weight" name = "weight">
</section>

<section>

         <label for="confirmation">Check to Confirm Information is Correct: </label>
         <input id="confirmation" type="checkbox" name="confirmation">
</section>



<input class="submitButton"  type="submit" value="Submit Information">

    </form>

  </div>
</template>
<script>
</script>

<style>

form {
  text-align: left;
  display: inline-block;
  vertical-align: middle;
}


</style>