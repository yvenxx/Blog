import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router/router'
import VueAxios from 'vue-axios'
import axios from './router/axios'

const app = createApp(App)


app.use(createPinia())
app.use(router)

app.use(VueAxios, axios)
app.mount('#app')
