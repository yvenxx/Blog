<script>
import HomeHeader from "@/components/header/index.vue";
import HomeAside from "@/components/aside/index.vue";
import HomeFooter from "@/components/footer/index.vue";
import {getAllArticle} from "@/api/article/article.js";

export default {
  components: {HomeHeader, HomeAside,HomeFooter},
  data() {
    return {
      articles:[],
      page:{
        pageSize:10,
        currentPage:1,
        total:0,
      },
    }
  },
  methods:{
    toArticleDetail(id){
      this.$router.push({path:'/article',query:{id:id}});
    },
    getArticles(){
      getAllArticle(this.page.currentPage,this.page.pageSize).then((res)=>{
        this.articles = res.data.records;
        this.page.pageSize = res.data.size;
        this.page.currentPage = res.data.current;
        this.page.total = res.data.total;
      })
    }
  },
  created() {
    this.getArticles();
  }
}
</script>

<template>
  <el-container style="height: 100%">

    <el-container style="height: 100%">
      <el-aside class="index-aside" style="width: 16%">
        <HomeAside></HomeAside>
      </el-aside>
      <el-container style="height: 100%">
        <el-main class="index-main" style="width: 50%">
          <div v-for="item in articles">
            <el-card class="article-card" shadow="never" @click="toArticleDetail(item.id)">
              <template #header>
                <div class="card-header article-card-title">
                  <span>{{ item.title }}</span>
                </div>
              </template>
              <div class="article-card-content">
                <v-md-editor height="100px" :model-value="item.content" mode="preview"></v-md-editor>
              </div>
            </el-card>
          </div>
          <el-pagination
              :current-page="page.currentPage"
              :page-size="page.pageSize"
              :hide-on-single-page="true"
              :total="page.total"
              layout="prev, pager, next"
              @current-change="getArticles"
          />
        </el-main>
      </el-container>
    </el-container>

  </el-container>
</template>

<style scoped>
.index-aside{
  margin-left: 12%;
  border-radius: 15px;
}
.index-main{
  padding-top: 10px;
  border-radius: 15px;
  margin-left: 1%;
  margin-right: 11%;
}
.article-card{
  margin-bottom: 10px;
  width: 95%;
  border-radius: 12px;
  cursor: pointer;
}
.article-card:hover{
  box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.1);
}
.article-card-title{
  color: #004c7a;
  font-size: 24px;
  padding-left: 34px;
}
</style>