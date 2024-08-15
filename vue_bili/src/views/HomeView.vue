<template>
  <a-layout id="layout-outter">
    <a-layout-header
      class="header"
      :style="{ position: 'fixed', width: '100%', overflow: 'auto' }"
    >
      <div class="logo" />
      <!-- <a-menu
        v-model="selectedKeys1"
        theme="dark"
        mode="horizontal"
        :style="{ lineHeight: '64px' }"
      >
        <a-menu-item key="1">nav 1</a-menu-item>
        <a-menu-item key="2">nav 2</a-menu-item>
        <a-menu-item key="3">nav 3</a-menu-item>
      </a-menu> -->
      <a-col :span="8">
        <h1 style="color: white">Manage Platform</h1>
      </a-col>
      <a-col :span="9"></a-col>
      <a-col :span="1" style="color: white">
        <a-icon type="search" />
      </a-col>
      <a-col :span="1" style="color: white">
        <a-icon type="question-circle" />
      </a-col>
      <a-col :span="1" style="color: white">
        <a-badge :count="5" title="Custom hover text">
          <a-icon type="message" />
        </a-badge>
      </a-col>
      <a-col :span="1" style="color: white">
        <a-avatar size="small" icon="user" />
      </a-col>
      <a-col :span="2" style="color: white">
        <span>SeratiMa</span>
      </a-col>
      <a-col :span="1" style="color: white">
        <a-icon type="logout" @click="logout" />
        <!-- <LogoutOutlined @click="logout" /> -->
      </a-col>
    </a-layout-header>
    <a-layout height="100vh" style="top: 64px">
      <a-layout-sider id="sider" class="sider">
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
            <a-menu-item key="1" @click="changeMenu('/analyseView')"
              >分析页</a-menu-item
            >
            <a-menu-item key="2" @click="changeMenu('/monitorView')"
              >监控页</a-menu-item
            >
            <a-menu-item key="3" @click="changeMenu('/workView')"
              >控制台</a-menu-item
            >
          </a-sub-menu>
          <a-sub-menu key="sub2">
            <template #title>
              <span>
                <laptop-outlined />
                组织用户权限
              </span>
            </template>
            <a-menu-item key="5" @click="changeMenu('/newForm')"
              >角色管理</a-menu-item
            >
            <a-menu-item key="6" @click="changeMenu('/stepForm')"
              >用户管理</a-menu-item
            >
            <a-menu-item key="7" @click="changeMenu('/higherForm')"
              >权限管理</a-menu-item
            >
          </a-sub-menu>
          <a-sub-menu key="sub3">
            <template #title>
              <span>
                <notification-outlined />
                应用中心
              </span>
            </template>
            <a-menu-item key="13" @click="changeMenu('/queryList')"
              >应用管理</a-menu-item
            >
            <a-menu-item key="14" @click="changeMenu('/standardList')"
              >功能模块管理</a-menu-item
            >
            <a-menu-item key="15" @click="changeMenu('/cardList')"
              >卡片列表</a-menu-item
            >
          </a-sub-menu>
          <a-sub-menu key="sub4">
            <template #title>
              <span>
                <laptop-outlined />
                详情页
              </span>
            </template>
            <a-menu-item key="16" @click="changeMenu('/basicDetail')"
              >基础详情页</a-menu-item
            >
            <a-menu-item key="17" @click="changeMenu('/higherDetail')"
              >高级详情页</a-menu-item
            >
          </a-sub-menu>
          <a-sub-menu key="sub5">
            <template #title>
              <span>
                <laptop-outlined />
                结果页
              </span>
            </template>
            <a-menu-item key="18" @click="changeMenu('/successView')"
              >成功页</a-menu-item
            >
            <a-menu-item key="19" @click="changeMenu('/failView')"
              >失败页</a-menu-item
            >
          </a-sub-menu>
          <a-sub-menu key="sub6">
            <template #title>
              <span>
                <laptop-outlined />
                异常页
              </span>
            </template>
            <a-menu-item key="20" @click="changeMenu('/View403')"
              >403</a-menu-item
            >
            <a-menu-item key="21" @click="changeMenu('/View404')"
              >404</a-menu-item
            >
            <a-menu-item key="22" @click="changeMenu('/View500')"
              >500</a-menu-item
            >
          </a-sub-menu>
          <a-sub-menu key="sub7">
            <template #title>
              <span>
                <laptop-outlined />
                个人页
              </span>
            </template>
            <a-menu-item key="23" @click="changeMenu('/pass')"
              >个人中心</a-menu-item
            >
            <a-menu-item key="24" @click="changeMenu('/BasicSetting')"
              >个人设置</a-menu-item
            >
          </a-sub-menu>
        </a-menu>
      </a-layout-sider>
      <a-layout style="padding: 0 24px 24px">
        <a-layout :style="{ marginLeft: '20%' }">
          <a-breadcrumb style="margin: 20px 20px">
            <a-breadcrumb-item>Home</a-breadcrumb-item>
            <a-breadcrumb-item>List</a-breadcrumb-item>
            <a-breadcrumb-item>App</a-breadcrumb-item>
          </a-breadcrumb>
          <router-view />
        </a-layout>
        <a-layout-footer :style="{ textAlign: 'center' }">
          Ant Design ©2018 Created by Ant UED
        </a-layout-footer>
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      selectedKeys: ["1"],
      collapsed: false,
    };
  },
  methods: {
    //路由内容切换
    changeMenu(route) {
      console.log(route);
      //获取路由对象并切换
      this.$router.push(route);
    },
    logout() {
      console.info("success logout");
      //提交给后台
      axios.post("/sys/users/logout", {}).then((response) => {
        // 处理成功响应
        // console.log("成功发送表单数据至后端", response);
        if (response.status === 200) {
          localStorage.clear();
          this.$message.success("成功退出！", 5);
          this.$router.push("/login");
        }
      });
    },
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

.header {
  position: fixed;
  width: 100%;
  overflow: auto;
  z-index: 1000;
}
.sider {
  overflow: auto;
  height: 91vh;
  position: fixed;
  left: 0;
  top: 64px;
  bottom: 0;
  min-width: 20%;
  z-index: 900;
}
</style>
