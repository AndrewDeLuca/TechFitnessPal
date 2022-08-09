import axios from 'axios';

export default {
    
    createProfile(user) {
        return axios.post('/profile', user);
    }
}