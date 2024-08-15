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
          <a-breadcrumb-item><a href="">搜索列表（项目）</a></a-breadcrumb-item>
        </a-breadcrumb>
        <br />
        <div class="top_blank">搜索列表（项目）</div>
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
    <div class="card-container">
      <a-card title="Alipay" style="width: 300px">
        <template>
          <a-row>
            <a-col :span="12">
              <a-statistic
                title="活跃用户"
                :value="112893"
                style="margin-right: 50px"
              />
            </a-col>
            <a-col :span="12">
              <a-statistic title="新增用户" :value="112893" />
            </a-col>
          </a-row>
        </template>
        <template slot="actions">
          <a-icon key="setting" type="setting" />
          <a-icon key="edit" type="edit" />
          <a-icon key="ellipsis" type="ellipsis" />
        </template>
      </a-card>
      <a-card title="Alipay" style="width: 300px">
        <template>
          <a-row>
            <a-col :span="12">
              <a-statistic
                title="活跃用户"
                :value="112893"
                style="margin-right: 50px"
              />
            </a-col>
            <a-col :span="12">
              <a-statistic title="新增用户" :value="112893" />
            </a-col>
          </a-row>
        </template>
        <template slot="actions">
          <a-icon key="setting" type="setting" />
          <a-icon key="edit" type="edit" />
          <a-icon key="ellipsis" type="ellipsis" />
        </template>
      </a-card>
      <a-card title="Alipay" style="width: 300px">
        <template>
          <a-row>
            <a-col :span="12">
              <a-statistic
                title="活跃用户"
                :value="112893"
                style="margin-right: 50px"
              >
              </a-statistic>
            </a-col>
            <a-col :span="12">
              <a-statistic title="新增用户" :value="112893" />
            </a-col>
          </a-row>
        </template>
        <template slot="actions">
          <a-icon key="setting" type="setting" />
          <a-icon key="edit" type="edit" />
          <a-icon key="ellipsis" type="ellipsis" />
        </template>
      </a-card>
      <a-card title="Alipay" style="width: 300px">
        <template>
          <a-row>
            <a-col :span="12">
              <a-statistic
                title="活跃用户"
                :value="112893"
                style="margin-right: 50px"
              >
              </a-statistic>
            </a-col>
            <a-col :span="12">
              <a-statistic title="新增用户" :value="112893" />
            </a-col>
          </a-row>
        </template>
        <template slot="actions">
          <a-icon key="setting" type="setting" />
          <a-icon key="edit" type="edit" />
          <a-icon key="ellipsis" type="ellipsis" />
        </template>
      </a-card>
      <a-card title="Alipay" style="width: 300px">
        <template>
          <a-row>
            <a-col :span="12">
              <a-statistic
                title="活跃用户"
                :value="112893"
                style="margin-right: 50px"
              >
              </a-statistic>
            </a-col>
            <a-col :span="12">
              <a-statistic title="新增用户" :value="112893" />
            </a-col>
          </a-row>
        </template>
        <template slot="actions">
          <a-icon key="setting" type="setting" />
          <a-icon key="edit" type="edit" />
          <a-icon key="ellipsis" type="ellipsis" />
        </template>
      </a-card>
      <a-card title="Alipay" style="width: 300px">
        <template>
          <a-row>
            <a-col :span="12">
              <a-statistic
                title="活跃用户"
                :value="112893"
                style="margin-right: 50px"
              >
              </a-statistic>
            </a-col>
            <a-col :span="12">
              <a-statistic title="新增用户" :value="112893" />
            </a-col>
          </a-row>
        </template>
        <template slot="actions">
          <a-icon key="setting" type="setting" />
          <a-icon key="edit" type="edit" />
          <a-icon key="ellipsis" type="ellipsis" />
        </template>
      </a-card>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
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

.card-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  gap: 20px;
  margin-top: 20px;
}

a-card {
  margin-bottom: 10px;
  margin-bottom: 10px;
}
</style>
