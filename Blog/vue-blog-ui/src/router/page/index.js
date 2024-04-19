export default[
    {
        path: '/Login',
        component: () => import ('@/page/login/index.vue'),
        name: '登录',
        meta:{
            title:"登录"
        },
    },
    {
        path: '/',
        component: () => import ('@/page/home/index.vue'),
        name: "yven's blog",
        meta:{
            title:"yven's blog"
        },
    },
    {
        path: '/article',
        component: () => import ('@/page/ArticleDetail/index.vue'),
        name: "article",
        meta:{
            title:"article"
        },
    },

]