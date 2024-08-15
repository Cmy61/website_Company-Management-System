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
          <a-breadcrumb-item><a href="">列表项</a></a-breadcrumb-item>
          <a-breadcrumb-item><a href="">查询表格</a></a-breadcrumb-item>
        </a-breadcrumb>
        <br />
        <div class="top_blank">查询表格</div>
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
      <div class="title-row">
        <h3>查询表格</h3>
        <div class="right-section">
          <a-button type="primary" icon="plus">新建</a-button>
          <a-icon type="setting" />
          <a-icon type="reload" />
        </div>
      </div>
      <br />
      <a-table
        :columns="columns"
        :data-source="data"
        class="components-table-demo-nested"
      >
        <template slot="name" slot-scope="text">
          <a>{{ text }}</a>
        </template>
        <a slot="operation">Publish</a>
        <a-table
          slot="expandedRowRender"
          :columns="innerColumns"
          :data-source="innerData"
          :pagination="false"
        >
          <span slot="status"> <a-badge status="success" />Finished </span>
          <span slot="operation" class="table-operation">
            <a>Pause</a>
            <a>Stop</a>
            <a-dropdown>
              <a-menu slot="overlay">
                <a-menu-item>Action 1</a-menu-item>
                <a-menu-item>Action 2</a-menu-item>
              </a-menu>
              <a> More <a-icon type="down" /> </a>
            </a-dropdown>
          </span>
        </a-table>
      </a-table>
    </a-layout-content>
  </div>
</template>

<script>
const columns = [
  { title: "Name", dataIndex: "name", key: "name" },
  { title: "Platform", dataIndex: "platform", key: "platform" },
  { title: "Version", dataIndex: "version", key: "version" },
  { title: "Upgraded", dataIndex: "upgradeNum", key: "upgradeNum" },
  { title: "Creator", dataIndex: "creator", key: "creator" },
  { title: "Date", dataIndex: "createdAt", key: "createdAt" },
  {
    title: "Action",
    key: "operation",
    scopedSlots: { customRender: "operation" },
  },
];

const data = [];
for (let i = 0; i < 3; ++i) {
  data.push({
    key: i,
    name: "Screem",
    platform: "iOS",
    version: "10.3.4.5654",
    upgradeNum: 500,
    creator: "Jack",
    createdAt: "2014-12-24 23:12:00",
  });
}

const innerColumns = [
  { title: "Date", dataIndex: "date", key: "date" },
  { title: "Name", dataIndex: "name", key: "name" },
  { title: "Status", key: "state", scopedSlots: { customRender: "status" } },
  { title: "Upgrade Status", dataIndex: "upgradeNum", key: "upgradeNum" },
  {
    title: "Action",
    dataIndex: "operation",
    key: "operation",
    scopedSlots: { customRender: "operation" },
  },
];

const innerData = [];
for (let i = 0; i < 3; ++i) {
  innerData.push({
    key: i,
    date: "2014-12-24 23:12:00",
    name: "This is production name",
    upgradeNum: "Upgraded: 56",
  });
}
export default {
  data() {
    return {
      data,
      columns,
      innerColumns,
      innerData,
    };
  },
  computed: {
    count() {
      return this.expand ? 6 : 3;
    },
  },
  updated() {
    console.log("updated");
  },
  mounted() {
    this.fetch();
  },
  methods: {},
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

.div_top {
  background-color: white;
  width: 100%;
  height: 100%;
}

.ant-advanced-search-form .ant-form-item {
  display: flex;
}

.ant-advanced-search-form .ant-form-item-control-wrapper {
  flex: 1;
}

#components-form-demo-advanced-search .ant-form {
  max-width: none;
}

.action-item {
  padding-right: 8px; /* 为了增加一些间距 */
}

h3 {
  margin-right: 10px; /* 调整标题与按钮之间的间距 */
}

.title-row {
  display: flex;
  justify-content: space-between; /* 将内容分散排列，标题在左，按钮在右 */
  align-items: center; /* 垂直居中对齐 */
}

.right-section {
  display: flex;
  gap: 10px; /* 右边部分的元素之间的间隔 */
  align-items: center;
}
</style>
