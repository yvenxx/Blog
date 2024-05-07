<script setup>

import {RouterView} from "vue-router";
import AdminHeader from "@/components/header/index.vue";
import AdminAside from "@/components/aside/index.vue";

</script>
<script>
import {useTokenStore} from "@/stores/counter.js";

export default {
  created() {
    if (useTokenStore().getToken===undefined||useTokenStore().getToken===null||useTokenStore().getToken===""){
      this.$router.push({path: "/login"});
    }
  }
}
</script>

<template>
  <el-container>
    <el-aside width="200px" style="height: 100vh;margin: 0;padding: 0;background-color: white">
      <AdminAside></AdminAside>
    </el-aside>
    <el-container>
      <el-header style="padding: 0;margin: 0;height: 60px;">
        <AdminHeader></AdminHeader>
      </el-header>
      <el-main style="padding: 0;">
        <div style="margin-left:10px;margin-top:10px;margin-right:10px;background-color: white;height: 95%;">
          <router-view></router-view>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<style scoped>

</style>