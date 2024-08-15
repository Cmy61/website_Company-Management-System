import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import Login from "../views/login/LoginView.vue";
import AnalyseView from "../views/home/dashboard/AnalyzeView.vue";
import IndexView from "../views/home/form/indexView.vue";
import NewForm from "../views/home/form/NewView.vue";
import StepForm from "../views/home/form/StepFrom.vue";
import HigherForm from "../views/home/form/higherForm.vue";
import QueryList from "../views/home/list/QueryView.vue";
import StandardList from "../views/home/list/StandardView.vue";
import CardList from "../views/home/list/CardView.vue";
import searchListPass from "../views/home/list/SearchPassage.vue";
import searchListPro from "../views/home/list/SearchProject.vue";
import searchListApp from "../views/home/list/SearchApplication.vue";
import successView from "../views/home/result/SuccessView.vue";
import failView from "../views/home/result/FailView.vue";
import View403 from "../views/home/exception/403View.vue";
import View404 from "../views/home/exception/404View.vue";
import View500 from "../views/home/exception/500View.vue";
import PersonalCenter from "../views/home/personal/PersonalCenter.vue";
import PersonalSetting from "../views/home/personal/PersonalSetting.vue";
import BasicSetting from "../views/home/personal/setting/BasicSetting.vue";
import SafeSetting from "../views/home/personal/setting/SafeSetting.vue";
import BindSetting from "../views/home/personal/setting/BindSetting.vue";
import MessageSetting from "../views/home/personal/setting/MessageSetting.vue";
import appInformation from "../views/home/personal/setting/information/AppView.vue";
import passInformation from "../views/home/personal/setting/information/PassView.vue";
import proInformation from "../views/home/personal/setting/information/ProView.vue";
import basicDetail from "../views/home/detail/BasicDetail.vue";
import higherDetail from "../views/home/detail/HigherDetail.vue";
import MonitorView from "../views/home/dashboard/MonitorView.vue";
import WorkView from "../views/home/dashboard/WorkView.vue";
import AddUser from "../views/home/form/AddUser.vue";
import EditUser from "../views/home/form/EditUser.vue";
Vue.use(VueRouter);
const originalPush = VueRouter.prototype.push; //修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch((err) => err);
};

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
    children: [
      {
        path: "/analyseView",
        name: "analyseView",
        component: AnalyseView,
      },
      {
        path: "/monitorView",
        name: "monitorView",
        component: MonitorView,
      },
      {
        path: "/workView",
        name: "workView",
        component: WorkView,
      },
      {
        path: "/index",
        name: "index",
        component: IndexView,
      },
      {
        path: "/newForm",
        name: "newForm",
        component: NewForm,
      },
      {
        path: "/stepForm",
        name: "stepForm",
        component: StepForm,
      },
      {
        path: "/addUser",
        name: "addUser",
        component: AddUser,
      },
      {
        path: "/editUser",
        name: "editUser",
        component: EditUser,
      },
      {
        path: "/higherForm",
        name: "higherForm",
        component: HigherForm,
      },
      {
        path: "/searchList_pass",
        name: "searchList_pass",
        component: searchListPass,
      },
      {
        path: "/searchList_pro",
        name: "searchList_pro",
        component: searchListPro,
      },
      {
        path: "/searchList_app",
        name: "searchList_app",
        component: searchListApp,
      },
      {
        path: "/queryList",
        name: "queryList",
        component: QueryList,
      },
      {
        path: "/standardList",
        name: "standardList",
        component: StandardList,
      },
      {
        path: "/cardList",
        name: "cardList",
        component: CardList,
      },
      {
        path: "/failView",
        name: "failView",
        component: failView,
      },
      {
        path: "/basicDetail",
        name: "basicDetail",
        component: basicDetail,
      },
      {
        path: "/higherDetail",
        name: "higherDetail",
        component: higherDetail,
      },
      {
        path: "/successView",
        name: "successView",
        component: successView,
      },
      {
        path: "/View403",
        name: "View403",
        component: View403,
      },
      {
        path: "/View404",
        name: "View404",
        component: View404,
      },
      {
        path: "/View500",
        name: "View500",
        component: View500,
      },
      {
        path: "/PersonalCenter",
        name: "PersonalCenter",
        component: PersonalCenter,
        children: [
          {
            path: "/app",
            name: "app",
            component: appInformation,
          },
          {
            path: "/pass",
            name: "pass",
            component: passInformation,
          },
          {
            path: "/pro",
            name: "pro",
            component: proInformation,
          },
        ],
      },
      {
        path: "/PersonalSetting",
        name: "PersonalSetting",
        component: PersonalSetting,
        children: [
          {
            path: "/BasicSetting",
            name: "BasicSetting",
            component: BasicSetting,
          },
          {
            path: "/SafeSetting",
            name: "SafeSetting",
            component: SafeSetting,
          },
          {
            path: "/BindSetting",
            name: "BindSetting",
            component: BindSetting,
          },
          {
            path: "/MessageSetting",
            name: "MessageSetting",
            component: MessageSetting,
          },
        ],
      },
    ],
  },
  {
    path: "/login",
    name: "login",
    component: Login,
  },
];

const router = new VueRouter({
  mode: "history",
  routes,
});

export default router;
