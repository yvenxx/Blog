<script>
import {deleteArticle, getAllArticle, getArticlesByParam} from "@/api/article/article.js";
import eventBus from '@/libs/eventBus'
export default {
  data(){
    return{
      articleData:[],
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
      // 获取文章列表
      this.getArticlesListByParam();
    },
    handleDelete(id){
      // 先让用户确定是否删除，再进行删除
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteArticle(id).then((res)=>{
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
          this.getArticlesListByParam();
        })
      }).catch(() => {
        this.$message()
      });
    },
    handleEdit(id){
      this.$router.push({path:"/article/edit",query:{articleId:id}});
    },
    getArticlesListByParam(){
      getArticlesByParam(this.searchValue,this.page.currentPage,this.page.pageSize).then((res)=>{
        this.articleData = res.data.records;
        this.page.pageSize = res.data.size;
        this.page.currentPage = res.data.current;
        this.page.total = res.data.total;
      })
    },
    addArticle(){
      this.$router.push({path:"/article/add"});
    },
  },
  created() {
    this.init();
  }
}
</script>
<template>
  <div class="main-list">
    <el-input v-model="searchValue" style="width: 240px" placeholder="Please input" />&nbsp;&nbsp;<el-button type="primary" @click="getArticlesListByParam">搜索</el-button><br><br>

    <el-button type="success" @click="addArticle">新增</el-button><br><br>
    <el-table :data="articleData" style="width: 100%">
      <el-table-column prop="title" label="标题" width="180" />
      <el-table-column prop="author" label="作者" width="180" />
      <el-table-column prop="category" label="分类" />
      <el-table-column fixed="right" label="Operations" width="120">
        <template #default="scope">
          <el-button link type="primary" size="small" @click="handleEdit(scope.row.id)">编辑</el-button>
          <el-button link type="danger" size="small" @click="handleDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="text-align: center">
      <el-pagination
          :current-page="page.currentPage"
          :page-size="page.pageSize"
          :total="page.total"
          :hide-on-single-page="true"
          layout="prev, pager, next"
          @current-change="getArticlesListByParam()"
      />
    </div>
  </div>
</template>

<style scoped>
.main-list{
  padding: 20px;
}
</style>