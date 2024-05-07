import axios from 'axios';
import router from '@/router/router';
import { baseUrl } from '@/config/env';
import {Base64} from 'js-base64';
import website from '@/config/website';
import NProgress from 'nprogress';
import 'nprogress/nprogress.css';
import {isURL} from "@/util/validate";
import {ElMessage} from "element-plus";
import {useTokenStore} from "@/stores/counter.js";
//默认超时时间
axios.defaults.timeout = 10000;
//返回其他状态码
axios.defaults.validateStatus = function (status) {
    return status >= 200 && status <= 500;
};
//跨域请求，允许保存cookie
axios.defaults.withCredentials = true;

// NProgress 配置
NProgress.configure({
    showSpinner: false
});

//http request拦截
axios.interceptors.request.use(config => {
    //开启 progress bar
    NProgress.start();
    //地址为已经配置状态则不添加前缀
    if(config.baseUrl!==false){
        if (!isURL(config.url) && !config.url.startsWith(baseUrl)) {
            config.url = baseUrl + config.url
            console.log(config.url);
        }
    }
    //headers判断是否需要
    // const authorization = config.authorization === false;
    // if (!authorization) {
    //     config.headers['Authorization'] = `Basic ${Base64.encode(`${website.clientId}:${website.clientSecret}`)}`;
    // }
    // config.headers['Authorization'] = `Basic ${Base64.encode(`${website.clientId}:${website.clientSecret}`)}`;
    if (useTokenStore().getToken!=null||useTokenStore().getToken!=''||useTokenStore().getToken!=undefined){
        config.headers['Authorization'] =useTokenStore().getToken
    }

    //让每个请求携带token
    // const meta = (config.meta || {});
    // const isToken = meta.isToken === false;
    // if (getToken() && !isToken) {
    //     config.headers[website.tokenHeader] = 'bearer ' + getToken()
    // }
    //headers中配置text请求
    if (config.text === true) {
        config.headers["Content-Type"] = "text/plain";
    }
    //headers中配置serialize为true开启序列化
    // if (config.method === 'post' && meta.isSerialize === true) {
    //     config.data = serialize(config.data);
    // }
    return config
}, error => {
    return Promise.reject(error)
});

//http response 拦截
axios.interceptors.response.use(res => {
    //关闭 progress bar
    NProgress.done();
    //获取状态码
    const status = res.data.code || res.status;
    const statusWhiteList = website.statusWhiteList || [];
    const message = res.data.msg || res.data.message || '未知错误';
    //如果在白名单里则自行catch逻辑处理
    if (statusWhiteList.includes(status)) return Promise.reject(res);
    //如果是401则跳转到登录页面,退出登录   暂定
    // if (status === 401) store.dispatch('FedLogOut').then(() => router.push({path: '/login'}));

    // 如果请求为非200否则默认统一处理
    if (status !== 200) {
        ElMessage({
            message: message,
            type: 'error'
        });
        return Promise.reject(new Error(message))
    }
    return res;
}, error => {
    NProgress.done();
    return Promise.reject(new Error(error));
});

export default axios;
