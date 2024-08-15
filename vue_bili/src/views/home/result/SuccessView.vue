<template>
  <div>
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
      <a-result
        status="success"
        title="提交成功"
        sub-title="提交结果页用于反馈一系列操作任务的处理结果， 如果仅是简单操作，使用 Message 全局提示反馈即可。 本文字区域可以展示简单的补充说明，如果有类似展示 “单据”的需求，下面这个灰色区域可以呈现比较复杂的内容。"
      >
        <template #extra>
          <a-button key="console" type="primary">返回列表</a-button>
          <a-button key="buy">查看项目</a-button>
          <a-button key="buy">打印</a-button>
        </template>
      </a-result>
      <div id="result_div_suc">
        <h1 class="project-title">项目名称</h1>
        <div class="project-details">
          <p>项目ID：2341</p>
          <p>负责人：11</p>
          <p>生效时间：2023</p>
        </div>
        <br />
        <div>
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
      </div>
    </a-layout-content>
  </div>
</template>
<script>
export default {
  data() {
    return {};
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

#result_div_suc {
  background-color: #f0f0f0; /* 设置背景颜色为浅灰色 */
  margin-left: 20px; /* 设置左边边距为 20px */
  margin-right: 20px; /* 设置右边边距为 20px */
  margin-bottom: 40px;
  padding: 20px; /* 设置内边距为 20px */
}

.project-title {
  font-size: 24px; /* 字体放大为 24px */
  font-weight: bold; /* 字体加粗 */
  margin-bottom: 10px; /* 与下面的项目详情之间添加间距 */
}

.project-details {
  display: flex; /* 使用 Flexbox 布局 */
  justify-content: space-between; /* 平分空间 */
  color: black;
}

.project-details p {
  margin: 0; /* 去除段落默认的外边距，以减小行间距 */
}

a-step {
  color: black;
}
</style>
