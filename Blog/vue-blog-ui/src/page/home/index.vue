<script>
import HomeHeader from "@/components/header/index.vue";
import HomeAside from "@/components/aside/index.vue";
import HomeFooter from "@/components/footer/index.vue";

export default {
  components: {HomeHeader, HomeAside,HomeFooter},
  data() {
    return {
      page:{
        pageSize:0,
        currentPage:0,
        total:0,
      },
    }
  }
}
</script>

<template>
  <el-container style="height: 100%">
    <el-header  style="padding: 0;">
      <HomeHeader></HomeHeader>
    </el-header>
    <el-container style="height: 100%">
      <el-aside class="index-aside">
        <HomeAside></HomeAside>
      </el-aside>
      <el-container style="height: 100%">
        <el-main class="index-main">
          <div>
            <el-card style="margin-bottom: 10px;width: 95%;border-radius: 12px" shadow="never">
              <template #header>
                <div class="card-header">
                  <span>文章标题</span>
                </div>
              </template>
              <p>文章详细</p>
            </el-card>
          </div>
          <el-pagination
              :current-page="page.currentPage"
              :page-size="page.pageSize"
              background layout="prev, pager, next" :total="page.total" />
        </el-main>
      </el-container>
    </el-container>
    <el-footer>
      <HomeFooter></HomeFooter>
    </el-footer>
  </el-container>
</template>

<style scoped>
.index-aside{
  width: 23%;
  padding-left: 70px;
}
.index-main{
  padding-top: 10px;
  width: 60%;
  height: 100%;
}
</style>