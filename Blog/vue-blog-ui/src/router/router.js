import { createRouter, createWebHistory } from 'vue-router'
import PageRouter from './page/'

const baseRoutes = [];
const routes = baseRoutes.concat(PageRouter);
const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
})
router.beforeEach((to, from, next) => {
    /* 路由发生变化修改页面title */
    if (to.meta.title) {
        document.title = to.meta.title
    }
    next()
})
export default router
