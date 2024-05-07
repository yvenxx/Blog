<script setup>

</script>
<script>
import {getUserinfo} from "@/api/user/user.js";
import {getArticleCategories, getArticleTotal} from "@/api/article/article.js";

export default {
  name: 'Aside',
  components: {
  },
  data() {
    return {
      articleTotal:0,
      categories:"",
      user:{
        avatar:"",
        username:"",
        avatarPath:"",
      }
    }
  },
  methods: {
    init(){
      getUserinfo().then(res=>{
        this.user = res.data.data;
      });
      getArticleTotal().then(res=>{
        this.articleTotal = res.data;
      });
      getArticleCategories().then(res=>{
        this.categories = res.data;
      });
    },
    changeCategory(category){
      eventBus.emit('categoryChange',category);
    }
  },
  created() {
    this.init();
  }
}
</script>

<template>
    <el-card style="margin-top: 10px;margin-bottom: 20px;border-radius: 12px;" shadow="never">
      <div style="justify-content: center;display: flex">
        <el-avatar :size="100" :src="user.avatarPath" />
      </div>
      <div style="text-align: center">
        <p style="margin-top:20px;margin-bottom:20px;font-size: 20px;text-align: center">{{user.name}}</p>
        <el-tag type="primary" effect="light" style="margin-left: 5px;margin-right: 5px;">文章 {{ articleTotal }}</el-tag>
        <el-tag type="primary" effect="light" style="margin-left: 5px;margin-right: 5px;">Github</el-tag>
      </div>
    </el-card>
  <el-card style="margin-bottom: 40px;border-radius: 12px;text-align: center" shadow="never">
    <a href="#" @click="changeCategory(null)" class="category-a">全部文章</a>
    <ul class="category-ul" v-for="item in categories">
      <li class="category-li"><a class="category-a" href="#" @click="changeCategory(item)">{{ item }}</a></li>
    </ul>
  </el-card>
</template>

<style scoped>
.category-ul{
  list-style: none;
  padding: 0;
}
.category-li{
  padding-top: 10px;
  text-align: center;
}
.category-a{
  color: #606266;
  text-decoration: none;
}
.category-a:hover{
  color: #409EFF;
}

</style>