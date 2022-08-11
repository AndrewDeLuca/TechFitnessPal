import axios from 'axios'


const baseUrl = 'https://api.edamam.com';
const searchUrl = '/api/food-database/v2/parser';
const appIdKey = '?app_id=1fc651a9&app_key=a936d0cecf053bcf1ae2855b4a87342b';
const ingredientSearch = '&ingr=' + 'apple';


export default {
    foodSearch(ingredients) {
        const url = searchUrl + appIdKey + ingredientSearch + ingredients;
        return axios.get(url, {baseURL:baseUrl}).then(response => {
            const thing = response.data;
            console.log(thing);
            return thing;
        });
    }

}