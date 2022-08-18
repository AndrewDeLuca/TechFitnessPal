import axios from 'axios';

export default {
    
    createProfile(profile) {
        return axios.post('/profile', profile);
    },
    getProfile(userId) {
        return axios.get(`/profile/${userId}`);
    },
    updateProfile(profile) {
        return axios.put(`/profile/${profile.userId}`, profile);
    }
}
