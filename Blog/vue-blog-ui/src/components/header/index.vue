<template>
    <el-menu
        router
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        :ellipsis="false"
    >
      <el-menu-item style="padding-left: 50px;">
        <img
            style="width: 60px"
            src="/images/logo.jpg"
            alt="blog logo"
        />
      </el-menu-item>
      <div class="flex-grow"/>
      <el-menu-item index="/">首页</el-menu-item>
      <el-menu-item index="/archive">归档</el-menu-item>
      <el-menu-item index="/message">留言板</el-menu-item>
      <el-menu-item index="/history">历史</el-menu-item>
      <el-menu-item index="/about" style="margin-right: 41%">关于</el-menu-item>
    </el-menu>
</template>

<script lang="ts" setup>
import {ref} from 'vue'

const activeIndex = ref('/')
</script>

<style>
.el-menu-demo {
  width: 100%;
}

.flex-grow {
  flex-grow: 1;
}
</style>
