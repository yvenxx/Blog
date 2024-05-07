import { createApp } from 'vue'
import { createPinia } from 'pinia'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router/router'
import VueAxios from 'vue-axios'
import axios from './router/axios'

import App from './App.vue'
// markdown
import VueMarkdownEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress.js';
import '@kangc/v-md-editor/lib/theme/style/vuepress.css';
import Prism from "prismjs";
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const app = createApp(App)

VueMarkdownEditor.use(vuepressTheme, {
    Prism,
});

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

app.use(VueMarkdownEditor);
app.use(createPinia())
app.use(ElementPlus)
app.use(router)
app.use(VueAxios, axios)

app.mount('#app')
