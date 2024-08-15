<template>
  <span>
    <a-layout-content style="margin-top: 10%; margin-left: 15%">
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
          <a-button type="primary" @click="check">提交</a-button>
        </a-form-item>
      </a-form>
    </a-layout-content>
  </span>
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
    dataIndex: "userNumber",
    key: "userNumber",
    width: 150,
  },
  {
    title: "用户名称",
    dataIndex: "userName",
    key: "userName",
    sorter: (a, b) => a.positionName.localeCompare(b.positionName),
    sortDirections: ["descend", "ascend"],
    width: 150,
  },
  {
    title: "用户id",
    dataIndex: "userId",
    key: "userId",
    width: 150,
  },
  {
    title: "公司名称",
    dataIndex: "companyName",
    key: "companyName",
    sorter: (a, b) => a.positionName.localeCompare(b.positionName),
    sortDirections: ["descend", "ascend"],
    width: 150,
  },
  {
    title: "部门名称",
    dataIndex: "departmentName",
    key: "departmentName",
    sorter: (a, b) => a.positionName.localeCompare(b.positionName),
    sortDirections: ["descend", "ascend"],
    width: 150,
  },
  {
    title: "岗位名称",
    dataIndex: "positionNumber",
    key: "positionNumber",
    sorter: (a, b) => a.positionName.localeCompare(b.positionName),
    sortDirections: ["descend", "ascend"],
    width: 150,
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
        userName: "",
        userId: "",
        companyNumber: null,
        departmentNumber: null,
        userNumber: null,
      },
      data1: {},
      defaultExpandedKeys: ["0-0-0", "0-0-1", "0-0-2"],
      treeNodes, // 后端传输的树节点数据
    };
  },
  methods: {
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
      this.formEdit.userId = record.userId;
      this.formEdit.userName = record.userName;
      this.formEdit.departmentNumber = record.departmentNumber;
      this.formEdit.companyNumber = record.companyNumber;
      this.formEdit.userNumber = record.userNumber;
    },
    handleOk(e) {
      this.visible = false;
      this.check();
    },
    handleCancel(e) {
      console.log("Clicked cancel button");
      this.visible = false;
    },
    handleOkEdit(e) {
      this.visibleEdit = false;
      this.edit();
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
    edit() {
      console.info("success");
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
    changeMenu(route) {
      console.log(route);
      //获取路由对象并切换
      this.$router.push(route);
    },
    check() {
      console.info("success add");
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
            this.changeMenu("/stepForm");
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
    // this.fetchData();
    this.selectAllClasses();
  },
};
</script>
<style></style>
