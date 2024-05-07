import request from '@/router/axios';

export const getArticle = (id) => {
    return request({
        url: '/api/system/article/'+id,
        method: 'get',
        authorization: false,
        params: {
        }
    })
}

export const getAllArticle = (currentPage,pageSize) => {
    return request({
        url: '/api/system/article',
        method: 'get',
        authorization: false,
        params: {
            "currentPage":currentPage,
            "pageSize":pageSize,
        }
    })
}
export const getArticlesByParam = (param,currentPage,pageSize) => {
    return request({
        url: '/api/system/article',
        method: 'get',
        params: {
            "param":param,
            "currentPage":currentPage,
            "pageSize":pageSize,
        }
    })
}

export const getArticleCategories = () => {
    return request({
        url: '/api/system/article/category',
        method: 'get',
        params: {
        }
    })
}

export const getArticleYears = () => {
    return request({
        url: '/api/system/article/year',
        method: 'get',
        params: {
        }
    })
}
export const getArticleTotal = () => {
    return request({
        url: '/api/system/article/total',
        method: 'get',
        params: {
        }
    })
}
