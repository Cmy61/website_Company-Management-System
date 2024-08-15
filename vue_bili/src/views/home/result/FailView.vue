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
        status="error"
        title="提交失败"
        sub-title="请核对并修改一下信息后，再重新提交"
      >
        <template #extra>
          <a-button key="console" type="primary">返回修改</a-button>
        </template>

        <div class="desc">
          <p style="font-size: 16px">
            <strong>您提交的内容有如下错误:</strong>
          </p>
          <p>
            <a-icon :style="{ color: 'red' }" type="close-circle" />
            您的账户已被冻结
            <a>立即解冻 &gt;</a>
          </p>
          <p>
            <a-icon :style="{ color: 'red' }" type="close-circle" />
            您的账户还不具备申请资格 <a>立即升级 &gt;</a>
          </p>
        </div>
      </a-result>
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

.desc p {
  margin-bottom: 1em;
}
</style>
