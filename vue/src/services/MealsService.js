import axios from 'axios'

export default {
    addMeal(meal) {
        return axios.post('/meals', meal)
    },
    getMeals() {
        return axios.get('/meals')
    }
}