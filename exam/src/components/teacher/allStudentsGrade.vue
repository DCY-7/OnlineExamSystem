// 所有学生
<template>
  <div class="all">
    <ul class="top">
      <li class="order">学生信息列表</li>
      <li class="search-li"><div class="icon"><input type="text" placeholder="学生姓名" class="search" v-model="key"><i class="el-icon-search"></i></div></li>
      <li><el-button type="primary" @click="search()">搜索学生</el-button></li>
    </ul>
    <el-table :data="pagination.records" border>
      <el-table-column fixed="left" prop="studentId" label="学号" width="180"></el-table-column>
      <el-table-column fixed="left" prop="studentName" label="姓名" width="180"></el-table-column>
      <el-table-column prop="institute" label="学院" width="200"></el-table-column>
      <el-table-column prop="major" label="专业" width="200"></el-table-column>
      <el-table-column prop="grade" label="年级" width="200"></el-table-column>
      <el-table-column prop="clazz" label="班级" width="100"></el-table-column>
      <el-table-column prop="sex" label="性别" width="120"></el-table-column>
      <el-table-column prop="tel" label="联系方式" width="120"></el-table-column>
      <el-table-column fixed="right" label="查看成绩" width="150">
        <template slot-scope="scope">
          <el-button @click="checkGrade(scope.row.studentId)" type="primary" size="small">查看成绩</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[6, 10]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total"
      class="page"
    ></el-pagination>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pagination: {
        //分页后的学生成绩信息
        current: 1, //当前页
        total: null, //记录条数
        size: 6 //每页条数
      }
    };
  },
  created() {
    this.getAnswerInfo();
  },
  methods: {
    getAnswerInfo() {
      //分页查询所有学生成绩信息
      this.$axios(`/api/students/${this.pagination.current}/${this.pagination.size}`).then(res => {
        this.pagination = res.data.data;
      }).catch(error => {});
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getAnswerInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getAnswerInfo();
    },
    //按学生姓名模糊查询，学生考试信息
    search() {
      this.$axios(`/api/students/${this.pagination.current}/${this.pagination.size}/${this.key}`).then(res => {
        this.pagination = res.data.data;
      }).catch(error => {});
    },
    checkGrade(studentId) {
      this.$router.push({ path: "/grade", query: { studentId: studentId } });
    }
  }
};
</script>
<style lang="scss" scoped>
.all {
  padding: 0px 40px;
  .page {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .edit {
    margin-left: 20px;
  }
  .el-table tr {
    background-color: #dd5862 !important;
  }
}
.el-table .warning-row {
  background: #000 !important;
}

.el-table .success-row {
  background: #dd5862;
}

.top .order {
  cursor: pointer;
}
.top .order:hover {
  color: #0195ff;
  border-bottom: 2px solid #0195ff;
}
.top .order:visited {
  color: #0195ff;
  border-bottom: 2px solid #0195ff;
}
.top .el-icon-search {
  position: absolute;
  right: 10px;
  top: 10px;
}
.top .icon {
  position: relative;
}
.top {
  border-bottom: 1px solid #eee;
  margin-bottom: 20px;
}
.search-li {
  margin-left: auto;
}
.top .search-li {
  margin-left: auto;
}
.top li {
  display: flex;
  align-items: center;
}
.top .search {
  margin-left: auto;
  padding: 10px;
  border-radius: 4px;
  border: 1px solid #eee;
  box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
  transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
.top .search:hover {
  color: #0195ff;
  border-color: #0195ff;
}
.top {
  display: flex;
}
.top li {
  margin: 20px;
}
</style>
