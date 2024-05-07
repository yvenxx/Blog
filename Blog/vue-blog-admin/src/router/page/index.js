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
        path:'/',
        component:()=>import('@/views/dashboard/index.vue'),
        name:'首页',
        meta:{
            title:"首页"
        },
        children:[
            {
                path:'/',
                redirect:'/dashboard',
            },
            {
                path:'/dashboard',
                component:()=>import('@/views/index/index.vue'),
                name:'首页',
                meta:{
                    title:"首页"
                },
            },
            {
                path:'/system',
                component:()=>import("@/views/system/index.vue"),
                name: "系统管理",
                meta: {
                    title: "系统管理",
                }
            },
            {
                path:'/article',
                component:() =>import("@/views/article/index.vue"),
                name: "文章管理",
                meta: {
                    title: "文章管理",
                }
            },
            {
                path: '/article/edit',
                component: () => import('@/views/article/edit/index.vue'),
                name: '文章编辑',
                meta: {
                    title: "文章编辑",
                },
            },
            {
                path: '/article/add',
                component: () => import('@/views/article/edit/index.vue'),
                name: '新增文章',
                meta: {
                    title: "新增文章",
                },
            },

        ]
    }
]