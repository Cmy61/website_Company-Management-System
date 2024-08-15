<template>
  <a-layout id="layout-outter">
    <a-layout-header class="header">
      <div class="logo" />
      <a-menu
        v-model="selectedKeys1"
        theme="dark"
        mode="horizontal"
        :style="{ lineHeight: '64px' }"
      >
        <a-menu-item key="1">nav 1</a-menu-item>
        <a-menu-item key="2">nav 2</a-menu-item>
        <a-menu-item key="3">nav 3</a-menu-item>
      </a-menu>
    </a-layout-header>
    <a-layout height="100vh">
      <a-layout-sider id="layout_sider" width="200">
        <a-menu
          id="menu_left"
          v-model="selectedKeys2"
          mode="inline"
          theme="dark"
          :style="{ height: '100%', borderRight: 0 }"
        >
          <a-sub-menu key="sub1">
            <template #title>
              <span>
                <user-outlined />
                Dashboard
              </span>
            </template>
            <a-menu-item key="1">分析页</a-menu-item>
            <a-menu-item key="2">监控页</a-menu-item>
            <a-menu-item key="3">控制台</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub2">
            <template #title>
              <span>
                <laptop-outlined />
                表单页
              </span>
            </template>
            <a-menu-item key="5">基础表单</a-menu-item>
            <a-menu-item key="6">分步表单</a-menu-item>
            <a-menu-item key="7">高级表单</a-menu-item>
            <a-menu-item key="8">option8</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub3">
            <template #title>
              <span>
                <notification-outlined />
                列表页
              </span>
            </template>
            <a-menu-item key="9">搜索列表</a-menu-item>
            <a-menu-item key="10">查询列表</a-menu-item>
            <a-menu-item key="11">标准列表</a-menu-item>
            <a-menu-item key="12">卡片列表</a-menu-item>
          </a-sub-menu>
        </a-menu>
      </a-layout-sider>
      <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>Home</a-breadcrumb-item>
          <a-breadcrumb-item>List</a-breadcrumb-item>
          <a-breadcrumb-item>App</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            margin: 0,
            minHeight: '280px',
          }"
        >
        <router-view></router-view>
          Content...
          <br />
          Really
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          long
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
          ...
          <br />
        </a-layout-content>
        <a-layout-footer :style="{ textAlign: 'center' }">
          Ant Design ©2018 Created by Ant UED
        </a-layout-footer>
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<!-- <script lang="ts" setup>
import { ref } from 'vue';
import { UserOutlined, LaptopOutlined, NotificationOutlined } from '@ant-design/icons-vue';
const selectedKeys1 = ref<string[]>(['2']);
const selectedKeys2 = ref<string[]>(['1']);
const openKeys = ref<string[]>(['sub1']);
</script> -->
<script>
// import {
//   PieChartOutlined,
//   DesktopOutlined,
//   UserOutlined,
//   TeamOutlined,
//   FileOutlined,
// } from "@ant-design/icons-vue";
export default {
  data() {
    return {
      selectedKeys: ["1"],
      collapsed: false,
    };
  },
  methods: {//路由内容切换
            changeMenu(route){
                console.log(route)
                //获取路由对象并切换
                this.$router.push(route)
            }
        },
  mounted() {
    // 在这里可以执行一些初始化操作，如导入图标等
  },
};
</script>
<style scoped>
#components-layout-demo-top-side-2 .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}

.ant-row-rtl #components-layout-demo-top-side-2 .logo {
  float: right;
  margin: 16px 0 16px 24px;
}

.site-layout-background {
  background: #fff;
}

#layout-outter {
  min-height: 100vh;
}
</style>
