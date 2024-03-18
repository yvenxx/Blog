let baseUrl = '';
let codeUrl = `${baseUrl}/code`
const env = process.env
if (env.NODE_ENV === 'development') {
    baseUrl = `/api`; // 开发环境地址
} else if (env.NODE_ENV === 'production') {
    baseUrl = ``; //生产环境地址
} else if (env.NODE_ENV === 'test') {
    baseUrl = ``; //测试环境地址
}
export {
    baseUrl,
    codeUrl,
    env
}
