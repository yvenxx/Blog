<script setup>
const handleOpen = (key,keyPath) => {
}
const handleClose = (key,keyPath) => {
}
</script>


<template>
  <el-row >
    <el-col :span="24">
      <el-menu
          router
          style="border-right:0;"
          active-text-color="#ffd04b"
          default-active="/"
          background-color="#fff"
          text-color="#000000"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
      >
        <div style="justify-content: center;display: flex;margin-top: 20px;margin-bottom: 5px;">
          <el-avatar :size="70" src="/logo.jpg" />
        </div>
        <el-menu-item index="/">
          <el-icon><setting /></el-icon>
          <span>首页</span>
        </el-menu-item>
        <el-sub-menu index="/system">
          <template #title>
            <el-icon><location /></el-icon>
            <span>系统管理</span>
          </template>
            <el-menu-item index="/links">友联管理</el-menu-item>
            <el-menu-item index="/settings">修改密码</el-menu-item>
            <el-menu-item index="/about">关于</el-menu-item>
<!--          <el-sub-menu index="1-4">-->
<!--            <template #title>item four</template>-->
<!--            <el-menu-item index="1-4-1">item one</el-menu-item>-->
<!--          </el-sub-menu>-->
        </el-sub-menu>
        <el-menu-item index="/user">
          <el-icon><setting /></el-icon>
          <span>用户管理</span>
        </el-menu-item>
        <el-menu-item index="/article">
          <el-icon><setting /></el-icon>
          <span>文章管理</span>
        </el-menu-item>
      </el-menu>
    </el-col>
  </el-row>
</template>

<style scoped>

</style>