<script>
import {getArticleTotal} from "@/api/article/article.js";

export default {
  data() {
    return {
      articleTotal: 0,
      articleYears: [],
      articleCategories: [],
      articleYear: 0,
      articleCategory: 0,
      articleList: [],
      articlePage: 1,
      articlePageSize: 10,
      articleTotalPage: 0,
      articleParam: ''
    }
  },
  methods: {
    init() {
      getArticleTotal().then(response => {
        this.articleTotal = response.data
      })
    }
  },
  created() {
    this.init();
  }
}

</script>

<template>
  <el-row style="padding-top: 100px;width: 80%;margin-left: auto;margin-right: auto">
    <el-col :span="6">
      <div style="width: 60%;margin-left: auto;margin-right: auto">
        <el-row>
          <el-col :span="10">
            <el-icon color="#37f546" size="66" >
              <Notebook />
            </el-icon>
          </el-col>
          <el-col :span="12">
            <p style="margin-bottom: 20px;">文章总数</p>
            <p>{{ articleTotal }}</p>
          </el-col>
        </el-row>
      </div>
    </el-col>
    <el-col :span="6">
      <div style="width: 60%;margin-left: auto;margin-right: auto">
        <el-row>
          <el-col :span="10">
            <el-icon color="#800080" size="66" >
              <ChatLineRound />
            </el-icon>
          </el-col>
          <el-col :span="12">
            <p style="margin-bottom: 20px;">留言总数</p>
            <p>1</p>
          </el-col>
        </el-row>
      </div>
    </el-col>
    <el-col :span="6">
      <div style="width: 60%;margin-left: auto;margin-right: auto">
        <el-row>
          <el-col :span="10">
            <el-icon color="#37f546" size="66" >
              <Pointer />
            </el-icon>
          </el-col>
          <el-col :span="12">
            <p style="margin-bottom: 20px;">访问量</p>
            <p>1</p>
          </el-col>
        </el-row>
      </div>
    </el-col>
    <el-col :span="6">
      <div style="width: 60%;margin-left: auto;margin-right: auto">
        <el-row>
          <el-col :span="10">
            <el-icon color="#37f546" size="66" >
              <Link />
            </el-icon>
          </el-col>
          <el-col :span="12">
            <p style="margin-bottom: 20px;">友情链接</p>
            <p>1</p>
          </el-col>
        </el-row>
      </div>
    </el-col>
  </el-row>
</template>

<style scoped>
</style>