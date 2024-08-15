<template>
  <div>
    <h1 style="font-size: 20px; font-weight: bold">账号绑定</h1>
    <br />
    <a-list item-layout="horizontal" :data-source="data">
      <a-list-item slot="renderItem" slot-scope="item">
        <a slot="actions">绑定</a>
        <a-list-item-meta style="width: 20%">
          <a slot="title">{{ item.title }}</a>
          <span
            slot="description"
            style="color: rgb(174, 174, 174); font-size: 14px"
            >{{ item.description }}</span
          >
          <a-avatar
            slot="avatar"
            src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
          />
        </a-list-item-meta>
      </a-list-item>
    </a-list>
  </div>
</template>

<script>
const data = [
  {
    title: "绑定淘宝",
    description: "当前未绑定淘宝账号",
  },
  {
    title: "绑定支付宝",
    description: "当前未绑定支付宝账号",
  },
  {
    title: "绑定钉钉",
    description: "当前未绑定钉钉账号",
  },
  {
    title: "备用邮箱",
    description: "已绑定邮箱：abc@111.com",
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
