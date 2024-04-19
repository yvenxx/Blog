<script setup>

import HomeHeader from "@/components/header/index.vue";
import HomeFooter from "@/components/footer/index.vue";
</script>

<script>
import { useScroll, watchThrottled } from '@vueuse/core';
export default {
  data() {
    return {
      text: '',
      markdown: '# 标题 \n ## 二级标题 \n \naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n ### 三级标题 \n #### 四级标题 \naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n \n ##### 五级标题 \n ###### 六级标题 \naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n\naaaaaaaaaaaaaaaaa\n \n',
      titleList: [],
      currentIndex: 0,
    };
  },
  mounted() {
    const { y } = useScroll(window)
    watchThrottled(y, () => {
      this.titleList.forEach((e, idx) => {
        const heading = document.querySelector(`[data-v-md-line="${e.lineIndex}"]`)
        if (y.value >= heading.offsetTop - 50) // 比 40 稍微多一点
          this.currentIndex = idx
      })
    }, { throttle: 200 })
    this.$nextTick(() => {
      this.getAnchorList();
    })
  },
  created() {
    this.getAnchorList();
  },
  methods:{
    handleAnchorClick(anchor, index) {
      this.currentIndex = index;
      const anchorElement = document.getElementById(anchor.id);
      if (anchorElement) {
        anchorElement.scrollIntoView({ behavior: 'smooth' });
      }
    },
    getAnchorList() {
      const titleList = [];
      const titleElements = document.querySelectorAll('.article-detail h1, .article-detail h2, .article-detail h3, .article-detail h4, .article-detail h5, .article-detail h6');
      titleElements.forEach((titleElement) => {
        const title = titleElement.innerText;
        const id = title.replace(/\s+/g, '-');
        titleElement.id = id;
        titleList.push({
          title,
          id,
          indent: titleElement.tagName[1] - 1,
          lineIndex: titleElement.getAttribute('data-v-md-line'),
        });
      });
      this.titleList = titleList;
    },
  }
};
</script>

<template>
  <el-container style="height: 100%">
    <el-header style="padding: 0;">
      <HomeHeader style="position: fixed;z-index: 100"></HomeHeader>
    </el-header>
    <el-container style="height: 100%">
        <el-main class="index-main">
          <!--          文章位置-->
          <el-container style="height: 100%">
            <el-aside class="article-catalog" style="width: 16%">
              <!-- 目录 -->
              <div class="catalog-header catalog-line">
                <div style="font-size: 20px;text-align: center;padding-top: 10px;">目录</div>
              </div>
              <div class="catalog-content">
                <div class="catalog-item" v-for="(anchor, index) of titleList" :key="anchor.title"
                     :class="currentIndex === index ? 'active' : ''" :style="{ paddingLeft: `${5 + anchor.indent * 15}px` }"
                     @click="handleAnchorClick(anchor, index)">
                  <a> {{ anchor.title }} </a>
                </div>
              </div>
<!--              添加侧边内容  todo-->
            </el-aside>
            <el-main class="article-main" style="width: 50%">
              <!-- 文章内容 -->
              <h1 class="article-title">title</h1>
              <div class="article-detail">
                <v-md-editor :model-value="markdown" mode="preview"></v-md-editor>
              </div>
              <el-backtop :right="100" :bottom="100" />
            </el-main>
          </el-container>
        </el-main>
    </el-container>
    <el-footer>
      <HomeFooter></HomeFooter>
    </el-footer>
  </el-container>
</template>

<style scoped>
.index-main{
  padding-top: 10px;
  width: 60%;
  height: 100%;
}
.article-main{
  background-color: white;
  padding-top: 2px;
  border-radius: 15px;
  margin-left: 29%;
  margin-right: 11%;
}
.article-catalog{
  margin-left: 11%;
  background-color: white;
  border-radius: 15px;
  position: fixed;
}
.catalog-header {
  align-items: center;
}
.catalog-content {
  padding: 1rem;
  max-height: calc(100vh - 100px);
  overflow: auto;
}
.catalog-item {
  margin: 5px 0;
  cursor: pointer;
  transition: all 0.2s ease-in-out;
  font-size: 18px;
  padding: 2px 6px;
  overflow: hidden;
  text-overflow: ellipsis;
}
.catalog-item:hover {
  color: #49b1f5;
}
.article-title{
  font-size: 32px;
  font-weight: bold;
  margin-bottom: 20px;
  padding-left:2.5rem;
  padding-right: 2.5rem;
}
.active {
  color: #49b1f5;
  //border-left: 4px solid #49b1f5;
}
.active:hover {
  color: #49b1f5;
}
.catalog-line {
  position: relative;
  padding: 10px;
  background-color: #fff;
}
.catalog-line::after {
  content: "";
  position: absolute;
  bottom: 0;
  left: 0;
  height: 1px;
  width: 100%;
  background: linear-gradient(to right, transparent, grey, transparent);
}
</style>