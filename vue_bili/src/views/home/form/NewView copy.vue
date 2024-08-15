<template>
  <div>
    <a-row>
      <a-col :span="6">
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            height: '500px',
            margin: '20px 5px',
            overflow: 'initial',
            top: '64px',
          }"
        >
          <h1>{{ temp }}</h1>
          <h1>{{ checkedList }}</h1>
          <div
            style="
              display: flex;
              flex-direction: column;
              align-items: center;
              text-align: center;
            "
          >
            <div>
              <div style="margin-bottom: 16px">
                showLine: <a-switch v-model="showLine" />
                <br />
                <br />
                showIcon: <a-switch v-model="showIcon" />
              </div>
              <a-tree
                :show-line="showLine"
                :show-icon="showIcon"
                :default-expanded-keys="defaultExpandedKeys"
                @select="onSelect"
              >
                <a-icon slot="icon" type="carry-out" />
                <a-tree-node
                  :key="treeNode.id"
                  v-for="treeNode in treeNodes"
                  :title="treeNode.title"
                >
                  <a-icon slot="icon" type="carry-out" />
                  <span slot="title" style="color: #1890ff">{{
                    treeNode.title
                  }}</span>
                  <a-tree-node
                    :key="child.key"
                    v-for="child in treeNode.children"
                    :title="child.title"
                  >
                    <a-icon slot="icon" type="carry-out" />
                    <span slot="title" style="color: #1890ff">{{
                      child.title
                    }}</span>
                    <!-- 可以继续嵌套更多的 a-tree-node 用于处理更深层级的树节点 -->
                    <a-tree-node
                      :key="child_.key"
                      v-for="child_ in child.children"
                      :title="child_.title"
                    >
                      <a-icon slot="icon" type="carry-out" />
                      <span slot="title" style="color: #1890ff">{{
                        child_.title
                      }}</span>
                      <!-- 可以继续嵌套更多的 a-tree-node 用于处理更深层级的树节点 -->
                    </a-tree-node>
                  </a-tree-node>
                </a-tree-node>
              </a-tree>
            </div>
          </div>
        </a-layout-content>
      </a-col>
      <a-col :span="18">
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            height: '500px',
            overflow: 'initial',
            margin: '20px 5px',
            top: '64px',
          }"
        >
          <span>
            <a-input-search style="width: 200px" @search="onSearch" />
            <span style="margin-left: 8px">
              <a-button type="primary" @click="showModal">添加</a-button>
              <a-modal
                title="添加用户"
                :visible="visible"
                :confirm-loading="confirmLoading"
                @ok="handleOk"
                @cancel="handleCancel"
              >
                <a-form>
                  <a-form-item
                    :label-col="formItemLayout.labelCol"
                    :wrapper-col="formItemLayout.wrapperCol"
                    label="用户名称"
                  >
                    <a-input
                      v-decorator="[
                        'userName',
                        {
                          rules: [
                            {
                              required: true,
                              message: '请输入',
                            },
                          ],
                        },
                      ]"
                      placeholder="请输入"
                      v-model="form.userName"
                    />
                  </a-form-item>
                  <a-form-item
                    :label-col="formItemLayout.labelCol"
                    :wrapper-col="formItemLayout.wrapperCol"
                    label="用户id"
                  >
                    <a-input
                      v-decorator="[
                        'userId',
                        {
                          rules: [
                            {
                              required: true,
                              message: '请输入',
                            },
                          ],
                        },
                      ]"
                      placeholder="请输入"
                      v-model="form.userId"
                    />
                  </a-form-item>
                  <a-form-item
                    :label-col="formItemLayout.labelCol"
                    :wrapper-col="formItemLayout.wrapperCol"
                    label="公司序号"
                  >
                    <a-input
                      v-decorator="[
                        'companyNumber',
                        {
                          rules: [
                            {
                              required: true,
                              message: '请输入',
                            },
                          ],
                        },
                      ]"
                      placeholder="请输入"
                      v-model="form.companyNumber"
                    />
                  </a-form-item>
                  <a-form-item
                    :label-col="formItemLayout.labelCol"
                    :wrapper-col="formItemLayout.wrapperCol"
                    label="部门序号"
                  >
                    <a-input
                      v-decorator="[
                        'departmentNumber',
                        {
                          rules: [
                            {
                              required: true,
                              message: '请输入',
                            },
                          ],
                        },
                      ]"
                      placeholder="请输入"
                      v-model="form.departmentNumber"
                    />
                  </a-form-item>
                  <a-form-item
                    :label-col="formTailLayout.labelCol"
                    :wrapper-col="formTailLayout.wrapperCol"
                  >
                  </a-form-item>
                  <a-form-item
                    :label-col="formTailLayout.labelCol"
                    :wrapper-col="formTailLayout.wrapperCol"
                  >
                    <!-- <a-button type="primary" @click="check">提交</a-button> -->
                  </a-form-item>
                </a-form>
              </a-modal>
            </span>
            <!-- <router-link to="/addUser">
              <a-button type="primary" style="margin-left: 10%" @click="onAdd">
                添加
              </a-button>
            </router-link> -->
          </span>
          <br />
          <br />
          <a-table
            :columns="columns"
            :data-source="positionList"
            :scroll="{ x: 500, y: 300 }"
            :v-for="(position, index) in positionList"
            @change="onChange"
          >
            <a slot="action">编辑</a>
            <a slot="action" slot-scope="text, record">
              <a @click="deleteAutho(record)">删除</a>
              <a @click="showModaledit(record)" style="margin-left: 8px"
                >编辑</a
              >
            </a>
          </a-table>
          <a-modal
            title="编辑角色"
            :visible="visibleEdit"
            :confirm-loading="confirmLoading"
            @ok="handleOkEdit"
            @cancel="handleCancelEdit"
          >
            <a-form-item>
              <a-form-item
                :label-col="formItemLayout.labelCol"
                :wrapper-col="formItemLayout.wrapperCol"
                label="角色名称"
              >
                <a-input
                  v-decorator="[
                    'roleName',
                    {
                      rules: [
                        {
                          required: true,
                          message: '请输入',
                        },
                      ],
                    },
                  ]"
                  placeholder="请输入"
                  v-model="formEdit.roleName"
                />
              </a-form-item>
              <a-form-item :label-col="4" :wrapper-col="16" label="权限">
                <a-checkbox-group
                  v-model="checkedList"
                  :options="plainOptions"
                />
              </a-form-item>
              <a-form-item
                :label-col="formTailLayout.labelCol"
                :wrapper-col="formTailLayout.wrapperCol"
              >
              </a-form-item>
              <a-form-item
                :label-col="formTailLayout.labelCol"
                :wrapper-col="formTailLayout.wrapperCol"
              >
                <!-- <a-button type="primary" @click="check">提交</a-button> -->
              </a-form-item>
            </a-form-item>
          </a-modal>
        </a-layout-content>
      </a-col>
    </a-row>
  </div>
</template>
<script>
const formItemLayout = {
  labelCol: { span: 4 },
  wrapperCol: { span: 8 },
};
const formTailLayout = {
  labelCol: { span: 4 },
  wrapperCol: { span: 8, offset: 4 },
};
const columns = [
  {
    title: "序号",
    dataIndex: "roleNumber",
    key: "roleNumber",
    width: 100,
  },
  {
    title: "角色名称",
    dataIndex: "roleName",
    key: "roleName",
    sorter: (a, b) => a.positionName.localeCompare(b.positionName),
    sortDirections: ["descend", "ascend"],
    width: 100,
  },
  {
    title: "权限名称",
    dataIndex: "roleAutho",
    key: "roleAutho",
    width: 100,
  },
  {
    title: "Action",
    key: "operation",
    fixed: "right",
    width: 100,
    scopedSlots: { customRender: "action" },
  },
];
const data = [];
const treeNodes = [
  {
    key: "0-0",
    title: "parent 1",
    iconType: "carry-out",
    titleColor: "#1890ff",
    children: [
      {
        key: "0-0-0",
        title: "parent 1-0",
        iconType: "carry-out",
        titleColor: "#1890ff",
        children: [
          {
            key: "0-0-0-0",
            title: "leaf 1-0-0",
            iconType: "carry-out",
            titleColor: "#1890ff",
            children: [], // 可以继续添加子节点
          },
          {
            key: "0-0-0-1",
            title: "leaf 1-0-1",
            iconType: "carry-out",
            titleColor: "#1890ff",
            children: [], // 可以继续添加子节点
          },
          // 可以继续添加更多的子节点
        ],
      },
      {
        key: "0-0-1",
        title: "parent 1-1",
        iconType: "carry-out",
        titleColor: "#1890ff",
        children: [
          // 可以添加更多的子节点和子子节点
        ],
      },
      // 可以继续添加更多的父节点
    ],
  },
];
for (let i = 0; i < 100; i++) {
  data.push({
    key: i,
    name: `Edrward ${i}`,
    age: 32,
    address: `London Park no. ${i}`,
  });
}
function onChange(pagination, filters, sorter) {
  console.log("params", pagination, filters, sorter);
}
// 前后端对接的配置
// import positionApi from "@/api/positionManage";
import axios from "axios";
//import userApi from "C:\\Users\\lenovo\\Desktop\\resource\\vue_01\\vue_bili_03\\vue_bili\\src\\api\\usersManage.js";
export default {
  data() {
    return {
      showLine: true,
      showIcon: false,
      data,
      columns,
      positionList: [],
      plainOptions: [],
      checkedList: [],
      ModalText: "Content of the modal",
      visible: false,
      visibleEdit: false,
      confirmLoading: false,
      checkNick: false,
      formItemLayout,
      formTailLayout,
      form: {
        userName: "",
        userId: "",
        companyNumber: null,
        departmentNumber: null,
      },
      formEdit: {
        roleName: "",
        roleNumber: null,
        Auhto: [],
      },
      temp: 0,
      data1: {},
      defaultExpandedKeys: ["0-0-0", "0-0-1", "0-0-2"],
      treeNodes, // 后端传输的树节点数据
    };
  },
  methods: {
    showChooseAutho(record) {
      axios
        .get("/sys/have1/chooseAutho", {
          params: {
            roleNumber: record.roleNumber,
          },
        })
        .then((response) => {
          // 处理成功响应
          // console.log("成功发送表单数据至后端", response);
          var baseResult = response.data;
          this.temp = baseResult.code;
          if (baseResult.code == 20000) {
            this.checkedList = baseResult.data;
            this.positionList = baseResult.data;
          } else {
            this.$message.error("没有权限！", 5);
          }
        });
    },
    // showChooseAutho(record) {
    //   console.log("choose au");
    //   var url = "http://localhost:8090/sys/have1/chooseAutho";
    //   axios
    //     .get(url, {
    //       params: {
    //         roleNumber: record.roleNumber,
    //       },
    //     })
    //     .then((response) => {
    //       // 处理成功响应
    //       // console.log("成功发送表单数据至后端", response);
    //       var baseResult = response.data;
    //       this.temp = baseResult.code;
    //       if (baseResult.code == 20000) {
    //         this.checkedList = baseResult;
    //         this.positionList = baseResult.data;
    //       } else {
    //         this.$message.error("没有权限！", 5);
    //       }
    //     });
    // },
    showAllRole() {
      var url = "http://localhost:8090/sys/role/allRole";
      console.log("all role su");
      axios
        .get(url)
        .then((res) => {
          // 获得查询结果 BaseResult
          var baseResult = res.data;
          // 判断
          if (baseResult.code == 20000) {
            // 成功 -- 将结果存放到数据区域
            this.positionList = baseResult.data;
          } else {
            // 失败
            alert(baseResult.message);
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
    deleteAutho(record) {
      axios
        .get("/sys/users/userDelete", {
          params: {
            token: localStorage.getItem("token"),
          },
        })
        .then((response) => {
          // 处理成功响应
          // console.log("成功发送表单数据至后端", response);
          var baseResult = response.data;
          if (baseResult.code == 20000) {
            this.deleteRow(record);
          } else {
            this.$message.error("没有权限！", 5);
          }
        });
    },
    deleteRow(record) {
      console.info("success");
      //提交给后台
      axios
        .post("/sys/users/deleteUsers", {
          userNumber: record.userNumber,
          userName: record.userName,
          userId: record.userId,
          companyNumber: record.companyNumber,
          departmentNumber: record.departmentNumber,
        })
        .then((response) => {
          // 处理成功响应
          // console.log("成功发送表单数据至后端", response);
          if (response.status === 200) {
            this.$message.success("成功添加！", 5);
            this.visible = false;
            this.selectAllClasses(); //刷新
          }
        });
    },
    showModal() {
      this.visible = true;
    },
    showModaledit(record) {
      this.visibleEdit = true;
      this.showChooseAutho(record);
      this.formEdit.roleName = record.roleName;
      this.formEdit.Auhto = this.checkedList;
    },
    handleOk(e) {
      this.visible = false;
      this.checkAutho();
    },
    handleCancel(e) {
      console.log("Clicked cancel button");
      this.visible = false;
    },
    handleOkEdit(e) {
      this.visibleEdit = false;
      this.editAutho();
      // this.edit();
    },
    handleCancelEdit(e) {
      console.log("Clicked cancel button");
      this.visibleEdit = false;
    },
    onSelect(selectedKeys, info) {
      console.log("selected", selectedKeys, info);
    },
    onSearch(value) {
      this.data = {
        userName: value,
      };
      console.info("search success");
      console.info(value);
      //提交给后台
      axios
        .get("/sys/users/allSearch", {
          params: {
            userName: value,
          },
        })
        .then((response) => {
          // 处理成功响应
          // console.log("成功发送表单数据至后端", response);
          var baseResult = response.data;
          this.selectsearchClasses(value);
        });
    },
    handleTableChange(pagination, filters, sorter) {
      console.log(pagination);
      const pager = { ...this.pagination };
      pager.current = pagination.current;
      this.pagination = pager;
      this.fetch({
        results: pagination.pageSize,
        page: pagination.current,
        sortField: sorter.field,
        sortOrder: sorter.order,
        ...filters,
      });
    },
    editAutho() {
      axios
        .get("/sys/users/userEdit", {
          params: {
            token: localStorage.getItem("token"),
          },
        })
        .then((response) => {
          // 处理成功响应
          // console.log("成功发送表单数据至后端", response);
          var baseResult = response.data;
          if (baseResult.code == 20000) {
            this.edit();
          } else {
            this.$message.error("没有权限！", 5);
          }
        });
    },
    edit() {
      console.info("success edit");
      //提交给后台
      axios
        .post("/sys/users/editUsers", {
          userNumber: this.formEdit.userNumber,
          userName: this.formEdit.userName,
          userId: this.formEdit.userId,
          companyNumber: this.formEdit.companyNumber,
          departmentNumber: this.formEdit.departmentNumber,
        })
        .then((response) => {
          // 处理成功响应
          // console.log("成功发送表单数据至后端", response);
          if (response.status === 200) {
            this.$message.success("成功修改！", 5);
            this.visibleEdit = false;
            this.selectAllClasses(); //刷新
          }
        });
    },
    onAdd() {
      console.log("点击了添加");
    },
    checkAutho() {
      axios
        .get("/sys/users/userAdd", {
          params: {
            token: localStorage.getItem("token"),
          },
        })
        .then((response) => {
          // 处理成功响应
          // console.log("成功发送表单数据至后端", response);
          var baseResult = response.data;
          if (baseResult.code == 20000) {
            this.check();
          } else {
            this.$message.error("没有权限！", 5);
          }
        });
    },
    check() {
      console.info("success");
      //提交给后台
      axios
        .post("/sys/users/addUsers", {
          userName: this.form.userName,
          userId: this.form.userId,
          companyNumber: this.form.companyNumber,
          departmentNumber: this.form.departmentNumber,
        })
        .then((response) => {
          // 处理成功响应
          // console.log("成功发送表单数据至后端", response);
          if (response.status === 200) {
            this.$message.success("成功添加！", 10);
            this.visible = false;
            this.selectAllClasses(); //刷新
          }
        });
    },
    // 添加下面这个方法来提交表单数据给后端
    submitForm() {
      // 从这里发送 POST 请求，将 this.form 中的数据发送给后端
      axios
        .post("/addUsers", this.form)
        .then((response) => {
          // 处理成功响应
          console.log("成功发送表单数据至后端", response);
        })
        .catch((error) => {
          // 处理错误
          console.error("发送表单数据至后端出错", error);
        });
    },
    onChange,
    // getPositionList() {
    //   // userApi.getUserList 开始调用后端，并传递参数searchModel
    //   // then表示后端查询后返回的数据
    //   positionApi.getPositionList().then((response) => {
    //     this.positionList = response.data.rows;
    //     this.total = response.data.total;
    //   });
    // },
    async fetchData() {
      try {
        const response = axios.get("http://localhost:8090/sys/users/all"); // 使用正确的URL来获取后端数据
        const responseData = response.data; // 从响应中提取数据
        if (responseData.code === 20000) {
          this.positionList = responseData.data; // 将后端返回的数据赋值给前端的data变量
        } else {
          console.error(responseData.message); // 如果出现错误，输出错误信息
        }
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    },
    selectAllClasses() {
      // ajax 查询
      var url = "http://localhost:8090/sys/users/all";
      axios
        .get(url)
        .then((res) => {
          // 获得查询结果 BaseResult
          var baseResult = res.data;
          // 判断
          if (baseResult.code == 20000) {
            // 成功 -- 将结果存放到数据区域
            this.positionList = baseResult.data;
          } else {
            // 失败
            alert(baseResult.message);
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
    selectsearchClasses(userName) {
      // ajax 查询
      console.log("search");
      var url =
        "http://localhost:8090/sys/users/allSearch?userName=" + userName;
      axios
        .get(url)
        .then((response) => {
          // 获得查询结果 BaseResult
          var baseResult = response.data;
          // 判断
          if (baseResult.code == 20000) {
            // 成功 -- 将结果存放到数据区域
            this.positionList = baseResult.data;
            this.$message.success("成功查询！", 5);
          } else {
            // 失败
            alert(baseResult.message);
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
  created() {
    this.showAllRole();
  },
};
</script>
<style>
.div_form {
  width: 10% !important; /* 控制表单容器的宽度为 50% */
  margin: 0 auto; /* 让表单容器水平居中对齐 */
}

.form {
  width: 50% !important; /* 控制表单容器的宽度为 50% */
  margin: 0 auto; /* 让表单容器水平居中对齐 */
}

.outer-container {
  width: 50%; /* 控制外部容器的宽度 */
  margin: 0 auto; /* 让外部容器水平居中对齐 */
}

.custom-label::before {
  content: "*";
  color: red; /* 设置星号颜色 */
  margin-left: 4px; /* 设置星号与标签之间的距离 */
}

.div_top {
  background-color: white;
  width: 100%;
  height: 100%;
}
.editable-cell {
  position: relative;
}

.editable-cell-input-wrapper,
.editable-cell-text-wrapper {
  padding-right: 24px;
}

.editable-cell-text-wrapper {
  padding: 5px 24px 5px 5px;
}

.editable-cell-icon,
.editable-cell-icon-check {
  position: absolute;
  right: 0;
  width: 20px;
  cursor: pointer;
}

.editable-cell-icon {
  line-height: 18px;
  display: none;
}

.editable-cell-icon-check {
  line-height: 28px;
}

.editable-cell:hover .editable-cell-icon {
  display: inline-block;
}

.editable-cell-icon:hover,
.editable-cell-icon-check:hover {
  color: #108ee9;
}

.editable-add-btn {
  margin-bottom: 8px;
}
</style>
