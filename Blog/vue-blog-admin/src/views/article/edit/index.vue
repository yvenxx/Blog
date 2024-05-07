<script>
import {getArticle, submitArticle} from "@/api/article/article.js";

export default {
  computed: {
    articleId() {
      return this.$route.query.articleId;
    }
  },
  data() {
    return {
      article: {
        title: '',
        author: '',
        content: '',
        category:"",
      }
    }
  },
  methods: {
    onSubmit(){
      submitArticle(this.article).then(response => {
        this.$router.push({path: "/article"});
      })
    },
  },
  created() {
    if (this.articleId!=null||this.articleId!=undefined||this.articleId!=''){
      getArticle(this.articleId).then(response => {
        this.article = response.data;
      })
    }
  }
}
</script>

<template>
  <div class="main-list">
    <el-form :model="article" label-width="80px">
      <el-form-item label="标题">
        <el-input v-model="article.title" placeholder="请输入标题"></el-input>
      </el-form-item>
      <div style="display: flex;">
      <el-form-item style="width: 50%;" label="作者">
        <el-input v-model="article.author" style="width: 100%;" placeholder="请输入作者"></el-input>
      </el-form-item>
      <el-form-item style="width: 50%;" label="分类">
        <el-input v-model="article.category" style="width: 100%;" placeholder="请输入分类"></el-input>
      </el-form-item>
      </div>
      <el-form-item label="内容">
        <v-md-editor v-model="article.content" height="70vh"></v-md-editor>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped>
.main-list{
  padding: 20px;
}
</style>