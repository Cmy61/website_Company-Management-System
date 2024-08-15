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
          <a-breadcrumb-item><a href="">高级详情页</a></a-breadcrumb-item>
        </a-breadcrumb>
        <br />
        <div style="display: flex; width: 100%">
          <template style="flex: 1">
            <a-descriptions title="单号：234231029431" style="width: 70%">
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
          <template>
            <div>
              <div>
                <a-radio-group>
                  <a-radio-button value="large">操作一</a-radio-button>
                  <a-radio-button value="default">操作二</a-radio-button>
                  <a-radio-button value="small">操作三 </a-radio-button>
                </a-radio-group>
              </div>
              <br />
              <div style="margin-left: 20%">
                <a-row :gutter="16">
                  <a-col :span="12">
                    <a-statistic
                      title="Feedback"
                      :value="1128"
                      style="margin-right: 50px"
                    >
                    </a-statistic>
                  </a-col>
                  <a-col :span="12">
                    <a-statistic title="Users" :value="93" class="demo-class">
                      <template #suffix>
                        <span> 万</span>
                      </template>
                    </a-statistic>
                  </a-col>
                </a-row>
              </div>
            </div>
          </template>
        </div>
      </div>
    </a-layout-content>
    <a-layout-content
      :style="{
        background: '#fff',
        padding: '24px',
        margin: '24px auto 0',
        minHeight: '100px',
        overflow: 'initial',
        width: '100%',
        top: '64px',
      }"
    >
      <div>
        <h1 style="font-size: 16px; font-weight: bold">流程进度</h1>
        <a-divider />
        <a-steps :current="1">
          <a-popover
            slot="progressDot"
            slot-scope="{ index, status, prefixCls }"
          >
            <template slot="content">
              <span>step {{ index }} status: {{ status }}</span>
            </template>
            <span :class="`${prefixCls}-icon-dot`" />
          </a-popover>
          <a-step title="创建项目" description="曲丽丽" />
          <a-step title="部门初审" description="周毛毛" />
          <a-step title="财务复核" description="You can hover on the dot." />
          <a-step title="完成" description="You can hover on the dot." />
        </a-steps>
      </div>
    </a-layout-content>
    <a-layout-content
      :style="{
        background: '#fff',
        padding: '24px',
        margin: '24px auto 0',
        minHeight: '100px',
        overflow: 'initial',
        width: '100%',
        top: '64px',
      }"
    >
      <div>
        <h1 style="font-size: 16px; font-weight: bold">用户信息</h1>
        <a-divider />
        <template>
          <a-descriptions>
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
        <template class="centered-container">
          <a-descriptions title="信息组">
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
        <br />
        <h1 style="font-size: 14px; font-weight: bold">信息组</h1>
        <div class="box">
          <template>
            <a-descriptions
              title="组名称"
              style="margin-left: 2%; margin-top: 2%"
            >
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
            <a-descriptions
              title="组名称"
              style="margin-left: 2%; margin-top: 2%"
            >
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
            <a-descriptions
              title="组名称"
              style="margin-left: 2%; margin-top: 2%"
            >
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
        </div>
      </div>
    </a-layout-content>
    <a-layout-content
      :style="{
        background: '#fff',
        padding: '24px',
        margin: '24px auto 0',
        minHeight: '100px',
        overflow: 'initial',
        width: '100%',
        top: '64px',
      }"
    >
      <div>
        <h1 style="font-size: 16px; font-weight: bold">用户近半年来电记录</h1>
        <a-divider />
        <a-empty />
      </div>
    </a-layout-content>
    <a-layout-content
      :style="{
        background: '#fff',
        padding: '24px',
        margin: '24px auto 0',
        minHeight: '100px',
        overflow: 'initial',
        width: '100%',
        top: '64px',
      }"
    >
      <div>
        <a-menu v-model="current" mode="horizontal">
          <a-menu-item key="first" @click="cur = 1">操作日志一</a-menu-item>
          <a-menu-item key="second" @click="cur = 2">操作日志二</a-menu-item>
          <a-menu-item key="third" @click="cur = 3">操作日志三</a-menu-item>
        </a-menu>
        <div v-show="cur == 1">
          <a-table :columns="columns1" :data-source="data">
            <a slot="name" slot-scope="text">{{ text }}</a>
          </a-table>
        </div>
        <div v-show="cur == 2">
          <a-table :columns="columns2" :data-source="data">
            <a slot="name" slot-scope="text">{{ text }}</a>
          </a-table>
        </div>
        <div v-show="cur == 3">
          <a-table :columns="columns3" :data-source="data">
            <a slot="name" slot-scope="text">{{ text }}</a>
          </a-table>
        </div>
      </div>
    </a-layout-content>
  </div>
</template>

<script>
const columns1 = [
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
const columns2 = [
  {
    title: "姓名",
    dataIndex: "name",
    key: "name",
    scopedSlots: { customRender: "name" },
  },
  {
    title: "年龄",
    dataIndex: "age",
    key: "age",
    width: 80,
  },
  {
    title: "地址",
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
const columns3 = [
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
    title: "地址",
    dataIndex: "address",
    key: "address 1",
    ellipsis: true,
  },
  {
    title: "其他",
    dataIndex: "address",
    key: "address 2",
    ellipsis: true,
  },
  {
    title: "其他",
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
      columns1,
      columns2,
      columns3,
      cur: 1,
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

.card-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  gap: 20px;
}

.box {
  width: 100%;
  min-height: 30px;
  border: 1px solid rgb(229, 224, 224); /* 可选的边框样式 */
}

.centered-container {
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
}
</style>
