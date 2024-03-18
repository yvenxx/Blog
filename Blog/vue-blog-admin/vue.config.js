module.exports = {
    //路径前缀
    publicPath: "/",
    lintOnSave: true,
    productionSourceMap: false,
    chainWebpack: (config) => {
        //忽略的打包文件
        config.externals({
            'vue': 'Vue',
            'vue-router': 'VueRouter',
            'vuex': 'Vuex',
            'axios': 'axios',
            'element-ui': 'ELEMENT',
        });
    },
    css: {
        extract: { ignoreOrder: true }
    },
    //开发模式反向代理配置，生产模式请使用Nginx部署并配置反向代理
    devServer: {
        port: 8082,
        proxy: {
            '/api': {
                //本地服务接口地址  可加端口号和后端匹配 application.yml
                target: 'http://localhost:8081',
                //远程演示服务地址,可用于直接启动项目
                ws: true,
                pathRewrite: {
                    '^/api': '/'
                }
            },
        }
    },
};
