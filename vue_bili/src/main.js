import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import { reactive } from "vue";
import ECharts from "vue-echarts";
import "echarts";

Vue.component("ECharts", ECharts);
Vue.config.productionTip = false;

import Antd from "ant-design-vue";
import "ant-design-vue/dist/antd.css";
Vue.use(Antd);
axios.defaults.baseURL = "http://localhost:8090";
import echarts from "echarts";
Vue.prototype.$echarts = echarts;

import axios from "axios";
Vue.prototype.$axios = axios;
new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
