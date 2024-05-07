<template>
  <section class="w3l-hotair-form">
    <h1>yven's Blog</h1>
    <div class="container">
      <!-- /form -->
      <div class="workinghny-form-grid">
        <div class="main-hotair">
          <!--          <div class="alert-close">-->
          <!--            <span class="fa fa-close"></span>-->
          <!--          </div>-->
          <div class="content-wthree">
            <h2>登录</h2>
            <p>Log in</p>
            <form @submit.prevent="submitLogin" action="" method="post">
              <input
                type="text"
                class="text"
                name="username"
                placeholder="用户名"
                required=""
                v-model="user.username"
              />
              <input
                type="password"
                class="password"
                name="password"
                placeholder="密码"
                required=""
                v-model="user.password"
              />
              <button class="btn" type="submit">登录</button>
            </form>
            <p>第三方登录</p>
            <div class="social-icons w3layouts">
              <ul>
                <li>
                  <a href="#url" class="qq"><span class="fa fa-qq"></span> </a>
                </li>
                <li>
                  <a href="#url" class="github"
                    ><span class="fa fa-github"></span>
                  </a>
                </li>
                <li>
                  <a href="#url" class="wechat"
                    ><span class="fa fa-wechat"></span>
                  </a>
                </li>
              </ul>
            </div>
            <!--            <p class="account">Don't have an account? <a href="#signup">Register</a></p>-->
          </div>
          <div class="w3l_form align-self">
            <div class="left_grid_info"></div>
          </div>
        </div>
      </div>
      <!-- //form -->
    </div>
    <!-- copyright-->
    <div class="copyright text-center">
      <p class="copy-footer-29">Copyright &copy; 2023 yven</p>
    </div>
    <!-- //copyright-->
  </section>
</template>

<script>

import request from "@/router/axios";
import {useTokenStore} from "@/stores/counter.js";
export default {
  data() {
    return {
      user:{
        username:'',
        password:'',
      }
    };
  },
  methods: {
    submitLogin() {
      request({
        url: "/api/auth/login",
        method: "post",
        params: {
          "username":this.user.username,
          "password":this.user.password,
        },
      }).then((res) => {
        if (res.status === 200) {
          useTokenStore().setToken(res.data.data);
          this.$router.push({ path: "/dashboard" });
        }
      });
    },
  },
};
</script>
<style scoped>
@import "@/assets/css/style.css";
@import "@/assets/css/font-awesome.min.css";
@import "@/assets/css/googleapis.css";
</style>
