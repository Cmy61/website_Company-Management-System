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
          <a-breadcrumb-item><a href="">标准列表</a></a-breadcrumb-item>
        </a-breadcrumb>
        <br />
        <div class="top_blank">标准列表</div>
        <br />
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
        <a-row :gutter="16">
          <a-col :span="8">
            <a-statistic
              title="我的待办"
              value="8个任务"
              style="margin-right: 40px"
            />
          </a-col>
          <a-col :span="8">
            <a-statistic
              title="本周任务平均处理时间"
              value="32分钟"
              style="margin-right: 40px"
            />
          </a-col>
          <a-col :span="8">
            <a-statistic
              title="本周完成任务数"
              value="24个任务"
              style="margin-right: 40px"
            />
          </a-col>
        </a-row>
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
        <h3>基本列表</h3>
        <div class="right-section">
          <a-radio-group :value="mode" @change="modeChange">
            <a-radio-button value="all">全部</a-radio-button>
            <a-radio-button value="ing">进行中</a-radio-button>
            <a-radio-button value="waiting">等待中</a-radio-button>
          </a-radio-group>
          <a-input-search
            placeholder="请输入"
            style="width: 150px"
            @search="onSearch"
          />
        </div>
      </div>
      <br />
      <div>
        <a-list item-layout="horizontal" :data-source="data">
          <a-list-item slot="renderItem" slot-scope="item">
            <a slot="actions">编辑</a>
            <a slot="actions">更多</a>
            <a-list-item-meta
              style="width: 20%"
              description="Ant Design, a design language for background applications, is refined by Ant UED Team"
            >
              <a slot="title" href="https://www.antdv.com/">{{ item.title }}</a>
              <a-avatar
                slot="avatar"
                src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
              />
            </a-list-item-meta>
            <div style="margin-left: 50px">{{ item.owner }}</div>
            <div style="margin-left: 50px">{{ item.date }}</div>
            <div style="width: 170px; margin-left: 50px">
              <a-progress :percent="item.percent" :status="item.state" />
            </div>
          </a-list-item>
        </a-list>
      </div>
      <a-divider />
      <div style="display: flex; justify-content: flex-end">
        <a-pagination
          show-quick-jumper
          :default-current="2"
          :total="500"
          @change="onPageChange"
        />
      </div>
    </a-layout-content>
  </div>
</template>

<script>
const data = [
  {
    title: "Alipay",
    owner: "付晓晓",
    state: "active",
    percent: 80,
    date: "2023-10-11 09:41",
  },
  {
    title: "Angular",
    owner: "曲丽丽",
    state: "active",
    percent: 100,
    date: "2023-10-11 09:41",
  },
  {
    title: "Ant Design",
    owner: "林冬冬",
    state: "exception",
    percent: 60,
    date: "2023-10-11 09:41",
  },
  {
    title: "Ant Design Pro",
    owner: "周星星",
    state: "exception",
    percent: 0,
    date: "2023-10-11 09:41",
  },
];
export default {
  data() {
    return {
      mode: "all",
      data,
    };
  },
  methods: {
    onSearch(value) {
      console.log(value);
    },
    modeChange(e) {
      this.mode = e.target.value;
    },
    onPageChange(pageNumber) {
      console.log("Page: ", pageNumber);
    },
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
