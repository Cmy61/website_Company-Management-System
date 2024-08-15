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
          padding: '0px',
          margin: '0',
          height: '100px',
          overflow: 'initial',
          width: '111%',
          top: '64px',
          marginLeft: '-7%',
          marginRight: '0',
        }"
      >
        <h1>卡片列表</h1>
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
      </a-layout-content>
    </div>
  </template>
  <script>
  export default {
    data() {
      return {
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
  