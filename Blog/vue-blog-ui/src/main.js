import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router/router'
import VueAxios from 'vue-axios'
import axios from './router/axios'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// markdown
import VueMarkdownEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress.js';
import '@kangc/v-md-editor/lib/theme/style/vuepress.css';
import Prism from "prismjs";

const app = createApp(App)

VueMarkdownEditor.use(vuepressTheme, {
    Prism,
});

app.use(VueMarkdownEditor);
app.use(createPinia())
app.use(router)
app.use(ElementPlus)

app.use(VueAxios, axios)
app.mount('#app')
