<script setup>
</script>
<script>
import {getAllArticle, getArticleCategories, getArticlesByParam, getArticleYears} from "@/api/article/article.js";
export default {
  data() {
    return {
      articles:[],
      years:[],
      categories:[],
      searchValue:"",
      page:{
        pageSize:15,
        currentPage:1,
        total:0,
      },
    }
  },
  methods:{
    init(){
      this.getAllArticles();
      this.getYears();
      this.getCategory();
    },
    getAllArticles(){
      getAllArticle(this.page.currentPage,this.page.pageSize).then((res)=>{
        this.articles = res.data.records;
        this.page.pageSize = res.data.size;
        this.page.currentPage = res.data.current;
        this.page.total = res.data.total;
      })
    },
    getArticlesListByParam(){
      getArticlesByParam(this.searchValue,this.page.currentPage,this.page.pageSize).then((res)=>{
        this.articles = res.data.records;
        this.page.pageSize = res.data.size;
        this.page.currentPage = res.data.current;
        this.page.total = res.data.total;
      })
    },
    setSearchValue(value){
      this.searchValue = value;
    },
    getYears(){
      getArticleYears().then((res)=>{
        this.years = res.data;
      })
    },
    getCategory(){
      getArticleCategories().then((res)=>{
        this.categories = res.data;
      })
    }
  },
  created() {
    this.init();
  },
  watch:{
    searchValue:function (val) {
      this.getArticlesListByParam();
    }
  }
}
</script>
<template>
  <el-container style="height: 100%">
    <el-container style="height: 100%">
      <el-main class="index-main">
        <!--          文章位置-->
        <el-container style="height: 100%">
          <el-aside class="article-catalog" style="width: 16%">
            <el-card style="margin-bottom: 20px;border-radius: 12px" shadow="never">
              <!--            年份选择-->
              <div class="catalog-header catalog-line">
                <div style="font-size: 20px;text-align: center;padding-top: 10px;">年份</div>
              </div>
              <ul class="archive-ui"  v-for="item in years">
                <li @click="setSearchValue(item)" class="archive-li">{{ item }}</li>
              </ul>
            </el-card>
            <el-card style="margin-bottom: 40px;border-radius: 12px" shadow="never">
              <!--            分类选择-->
              <div class="catalog-header catalog-line">
                <div style="font-size: 20px;text-align: center;padding-top: 10px;">分类</div>
              </div>
              <ul class="archive-ui" v-for="item in categories">
                <li @click="setSearchValue(item)" class="archive-li">{{ item }}</li>
              </ul>
            </el-card>
          </el-aside>
          <el-main class="article-main" style="width: 50%">
<!--            文章列表-->
            <div class="catalog-header catalog-line">
            <h1 style="text-align: center;font-size: 36px;margin-top: 30px;">归档</h1>
            </div>
            <ul class="article-list-ul" v-for="item in articles">
              <li class="article-list-li"><a target="_blank" class="article-list-a" :href="'article?id='+item.id">{{ item.title }}</a></li>
              <div style="display: flex; justify-content: center;">
                <el-pagination
                    :current-page="page.currentPage"
                    :page-size="page.pageSize"
                    :total="page.total"
                    :hide-on-single-page="true"
                    layout="prev, pager, next"
                    @current-change="getArticlesListByParam()"
                />
              </div>
            </ul>
          </el-main>
        </el-container>
      </el-main>
    </el-container>
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
  margin-left: 1%;
  margin-right: 11%;
}
.article-catalog{
  margin-left: 11%;
  border-radius: 15px;
}
.catalog-header {
  align-items: center;
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
.archive-ui{
  list-style: none;
  text-align: center;
  padding-top: 10px;
  padding-bottom: 10px;
}
.archive-li{
  cursor: pointer;
  transition: all 0.2s ease-in-out;
  font-size: 18px;
  padding: 2px 6px;
  overflow: hidden;
  color: black;
  text-decoration: none;
  text-overflow: ellipsis;
}
.archive-li:hover{
  color: #49b1f5;
}
.article-list-ul {
  list-style: none; /* 移除列表前的默认项目符号 */
  padding: 20px 0 0;
}
.article-list-li {
  margin-bottom: 8px; /* 列表项之间的间距 */
  /* 列表项内部的填充 */
  padding: 10px 10px 10px 20px;
  border-bottom: 1px solid #f0f0f0;
  transition: all 0.2s ease-in-out; /* 添加过渡效果 */
}
.article-list-a {
  text-decoration: none; /* 移除链接的下划线 */
  color: #333; /* 链接的文字颜色 */
}
.article-list-a:hover {
  color: #0077cc; /* 鼠标悬停时链接的颜色 */
}
</style>