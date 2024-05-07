import {ref, computed} from 'vue'
import {defineStore} from 'pinia'

export const useTokenStore = defineStore({
    id: 'token',
    state: () => ({
        token: null
    }),
    getters: {
        getToken() {
            return localStorage.getItem('token');
        }
    },
    actions: {
        setToken(token) {
            localStorage.setItem('token', token);
        }
    }
})
