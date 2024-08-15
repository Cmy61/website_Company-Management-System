<template>
  <div>
    <div id="div_top"></div>
    <a-layout-content
      :style="{
        display: flex,
        background: '#fff',
        minheight: '500px',
        width: '111%',
        // marginTop: '0px',
        marginLeft: '-7%',
        marginRight: '0',
      }"
    >
      <div :style="{ marginLeft: '2%', marginBottom: '2%' }">
        <br />
        <a-breadcrumb>
          <a-breadcrumb-item><a href="">详情页</a></a-breadcrumb-item>
          <a-breadcrumb-item
            ><a href="/basicDetail">基础详情页</a></a-breadcrumb-item
          >
        </a-breadcrumb>
        <br />
        <div class="top_blank">基础详情页</div>
        <br />
      </div>
    </a-layout-content>
    <a-layout-content
      :style="{
        background: '#fff',
        padding: '24px',
        margin: '24px auto 0',
        minHeight: '280px',
        overflow: 'initial',
        width: '100%',
        top: '64px',
      }"
    >
      <template>
        <a-descriptions title="退款申请">
          <a-descriptions-item label="UserName">
            Zhou Maomao
          </a-descriptions-item>
          <a-descriptions-item label="Telephone">
            1810000000
          </a-descriptions-item>
          <a-descriptions-item label="Live">
            Hangzhou, Zhejiang
          </a-descriptions-item>
          <a-descriptions-item label="Remark">empty</a-descriptions-item>
          <a-descriptions-item label="Address">
            No. 18, Wantang Road, Xihu District, Hangzhou, Zhejiang, China
          </a-descriptions-item>
        </a-descriptions>
      </template>
      <a-divider />
      <template>
        <a-descriptions title="用户信息">
          <a-descriptions-item label="UserName">
            Zhou Maomao
          </a-descriptions-item>
          <a-descriptions-item label="Telephone">
            1810000000
          </a-descriptions-item>
          <a-descriptions-item label="Live">
            Hangzhou, Zhejiang
          </a-descriptions-item>
          <a-descriptions-item label="Remark">empty</a-descriptions-item>
          <a-descriptions-item label="Address">
            No. 18, Wantang Road, Xihu District, Hangzhou, Zhejiang, China
          </a-descriptions-item>
        </a-descriptions>
      </template>
      <a-divider />
      <template>
        <h1 style="font-size: 16px; font-weight: bold">退货商品</h1>
        <a-table :columns="columns" :data-source="data">
          <a slot="name" slot-scope="text">{{ text }}</a>
        </a-table>
      </template>
      <template>
        <h1 style="font-size: 16px; font-weight: bold">退货进度</h1>
        <a-table :columns="columns" :data-source="data">
          <a slot="name" slot-scope="text">{{ text }}</a>
        </a-table>
      </template>
    </a-layout-content>
  </div>
</template>
<script>
const columns = [
  {
    title: "Name",
    dataIndex: "name",
    key: "name",
    scopedSlots: { customRender: "name" },
  },
  {
    title: "Age",
    dataIndex: "age",
    key: "age",
    width: 80,
  },
  {
    title: "Address",
    dataIndex: "address",
    key: "address 1",
    ellipsis: true,
  },
  {
    title: "Long Column Long Column Long Column",
    dataIndex: "address",
    key: "address 2",
    ellipsis: true,
  },
  {
    title: "Long Column Long Column",
    dataIndex: "address",
    key: "address 3",
    ellipsis: true,
  },
  {
    title: "Long Column",
    dataIndex: "address",
    key: "address 4",
    ellipsis: true,
  },
];

const data = [
  {
    key: "1",
    name: "John Brown",
    age: 32,
    address: "New York No. 1 Lake Park, New York No. 1 Lake Park",
    tags: ["nice", "developer"],
  },
  {
    key: "2",
    name: "Jim Green",
    age: 42,
    address: "London No. 2 Lake Park, London No. 2 Lake Park",
    tags: ["loser"],
  },
  {
    key: "3",
    name: "Joe Black",
    age: 32,
    address: "Sidney No. 1 Lake Park, Sidney No. 1 Lake Park",
    tags: ["cool", "teacher"],
  },
];
export default {
  data() {
    return {
      data,
      columns,
    };
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
</style>
