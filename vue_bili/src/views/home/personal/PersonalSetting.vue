<template>
  <div>
    <a-layout style="padding: 24px 0; background: #fff; margin-top: 2%">
      <a-layout-sider width="200" style="background: #fff">
        <a-menu
          mode="inline"
          :default-selected-keys="['1']"
          :default-open-keys="['sub1']"
          style="height: 100%"
        >
          <a-menu-item key="1" @click="changePage('/BasicSetting')"
            >基本设置</a-menu-item
          >
          <a-menu-item key="2" @click="changePage('/SafeSetting')"
            >安全设置</a-menu-item
          >
          <a-menu-item key="3" @click="changePage('/BindSetting')"
            >账号绑定</a-menu-item
          >
          <a-menu-item key="4" @click="changePage('/MessageSetting')"
            >新消息通知</a-menu-item
          >
        </a-menu>
      </a-layout-sider>
      <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
        <router-view />
      </a-layout-content>
    </a-layout>
  </div>
</template>
<script>
export default {
  data() {
    return {
      rootSubmenuKeys: ["sub1", "sub2", "sub4"],
      openKeys: ["sub1"],
    };
  },
  methods: {
    onOpenChange(openKeys) {
      const latestOpenKey = openKeys.find(
        (key) => this.openKeys.indexOf(key) === -1
      );
      if (this.rootSubmenuKeys.indexOf(latestOpenKey) === -1) {
        this.openKeys = openKeys;
      } else {
        this.openKeys = latestOpenKey ? [latestOpenKey] : [];
      }
    },
    changePage(route) {
      console.log(route);
      //获取路由对象并切换
      this.$router.push(route);
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
</style>
