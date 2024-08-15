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
      <div :style="{ marginLeft: '2%' }">
        <br />
        <a-breadcrumb>
          <a-breadcrumb-item><a href="">列表项</a></a-breadcrumb-item>
          <a-breadcrumb-item><a href="">搜索列表</a></a-breadcrumb-item>
          <a-breadcrumb-item><a href="">搜索列表（文章）</a></a-breadcrumb-item>
        </a-breadcrumb>
        <br />
        <div class="top_blank">搜索列表（文章）</div>
        <br />
        <div
          style="display: flex; justify-content: center; align-items: center"
        >
          <a-input-search
            id="search_pass"
            placeholder="请输入"
            enter-button="搜索"
            style="width: 50%"
            @search="onSearch"
          />
        </div>
        <a-menu v-model="current" mode="horizontal">
          <a-menu-item key="passage"
            ><router-link to="/searchList_pass"></router-link>文章</a-menu-item
          >
          <a-menu-item key="application"
            ><router-link to="/searchList_app"></router-link>应用</a-menu-item
          >
          <a-menu-item key="project"
            ><router-link to="/searchList_pro"></router-link>项目</a-menu-item
          >
        </a-menu>
      </div>
    </a-layout-content>
    <a-layout-content
      :style="{
        background: '#fff',
        padding: '24px',
        margin: '24px auto 0',
        minHeight: '150px',
        overflow: 'initial',
        width: '100%',
        top: '64px',
      }"
    >
      <span>
        所有类目：
        <a-button type="link" style="font-size: 13px; color: black"
          >全部</a-button
        >
        <a-button type="link" style="font-size: 13px; color: black"
          >类目一</a-button
        >
        <a-button type="link" style="font-size: 13px; color: black"
          >类目二</a-button
        >
        <a-button type="link" style="font-size: 13px; color: black"
          >类目三</a-button
        >
        <a-button type="link" style="font-size: 13px; color: black"
          >类目四</a-button
        >
      </span>
      <br />
      <a-divider></a-divider>
      <div>
        <span>
          其他选项:
          <a-form-model
            :model="form"
            :label-col="labelCol"
            :wrapper-col="wrapperCol"
            style="width: 50%"
          >
            <span>
              <a-form-model-item label="作者">
                <a-select
                  v-model="form.region"
                  placeholder="please select your zone"
                >
                  <a-select-option value="shanghai">Zone one</a-select-option>
                  <a-select-option value="beijing">Zone two</a-select-option>
                </a-select>
              </a-form-model-item>
              <a-form-model-item label="好评度">
                <a-select
                  v-model="form.region"
                  placeholder="please select your zone"
                >
                  <a-select-option value="shanghai">Zone one</a-select-option>
                  <a-select-option value="beijing">Zone two</a-select-option>
                </a-select>
              </a-form-model-item>
            </span>
          </a-form-model>
        </span>
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
      <a-list
        item-layout="vertical"
        size="large"
        :pagination="pagination"
        :data-source="listData"
      >
        <div slot="footer"><b>ant design vue</b> footer part</div>
        <a-list-item slot="renderItem" key="item.title" slot-scope="item">
          <template v-for="{ type, text } in actions" slot="actions">
            <span :key="type">
              <a-icon :type="type" style="margin-right: 8px" />
              {{ text }}
            </span>
          </template>
          <a-list-item-meta :description="item.description">
            <a slot="title" :href="item.href">{{ item.title }}</a>
            <a-avatar slot="avatar" :src="item.avatar" />
          </a-list-item-meta>
          {{ item.content }}
        </a-list-item>
      </a-list>
    </a-layout-content>
  </div>
</template>
<script>
const listData = [];
for (let i = 0; i < 23; i++) {
  listData.push({
    href: "https://www.antdv.com/",
    title: `ant design vue part ${i}`,
    avatar: "https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png",
    description: "Ant Design",
    content:
      "We supply a `样式美观大方,无缝对接 Ant Design 最佳实践 自带多场景最佳实践,默认好用 TypeScript 全量使用 TypeScript 开发 Let’sPro 命令行运行下列命令,快速启动开发服务: $ npm i @...样式美观大方,无缝对接 Ant Design 最佳实践 自带多场景最佳实践,默认好用 TypeScript 全量使用 TypeScript 开发 Let’sPro 命令行运行下列命令,快速启动开发服务: $ npm i @...1111.",
  });
}
export default {
  data() {
    return {
      listData,
      pagination: {
        onChange: (page) => {
          console.log(page);
        },
        pageSize: 3,
      },
      labelCol: { span: 4 },
      wrapperCol: { span: 14 },
      form: {
        name: "",
        region: undefined,
        date1: undefined,
        delivery: false,
        type: [],
        resource: "",
        desc: "",
      },
      actions: [
        { type: "star-o", text: "156" },
        { type: "like-o", text: "156" },
        { type: "message", text: "2" },
      ],
    };
  },
  methods: {
    onSearch(value) {
      console.log(value);
    },
    changeMenu(route) {
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
