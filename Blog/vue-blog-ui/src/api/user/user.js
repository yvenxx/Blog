import request from '@/router/axios';

export const getUserinfo = (id) => {
    return request({
        url: '/api/system/userinfo/info',
        method: 'get',
        authorization: false,
        params: {
        }
    })
}