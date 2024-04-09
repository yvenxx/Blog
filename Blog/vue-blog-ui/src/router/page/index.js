export default[
    {
        path: '/Login',
        component: () => import ('@/page/login/index.vue'),
        name: '登录',
        meta:{
            title:"登录"
        },
    },
]