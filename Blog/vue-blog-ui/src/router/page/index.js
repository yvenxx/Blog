export default[
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
    {
        path: '/archive',
        component: () => import ('@/page/archive/index.vue'),
        name: "archive",
        meta:{
            title:"archive"
        },
    },
    {
        path: '/about',
        component: () => import ('@/page/about/index.vue'),
        name: "about",
        meta:{
            title:"about"
        },
    },
    {
        path: '/message',
        component: () => import ('@/page/MessageBoard/index.vue'),
        name: "message",
        meta:{
            title:"message"
        },
    },


]