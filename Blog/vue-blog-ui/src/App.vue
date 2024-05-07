<script setup>
import HomeHeader from "@/components/header/index.vue";
import HomeFooter from "@/components/footer/index.vue";
</script>

<template>
  <el-header  style="padding: 0;">
    <HomeHeader></HomeHeader>
  </el-header>
    <router-view></router-view>
  <el-footer>
    <HomeFooter></HomeFooter>
  </el-footer>
</template>

<style>
html, body {
  background-color: rgba(166, 156, 156, 0.05);
}
*{
  padding: 0;
  margin: 0;
}
</style>
