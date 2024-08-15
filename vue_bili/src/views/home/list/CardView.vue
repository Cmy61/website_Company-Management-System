<template>
  <div>
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
          <a-breadcrumb-item><a href="">卡片列表</a></a-breadcrumb-item>
        </a-breadcrumb>
        <br />
        <div class="top_blank">卡片列表</div>
        <br />
        <p>
          段落示意：蚂蚁金服务设计平台
          ant.design，用最小的工作量，无缝接入蚂蚁金服生态，
          提供跨越设计与开发的体验解决方案。
        </p>
        <br />
        <span slot="action">
          <a-button type="link" icon="rocket" style="font-size: 17px"
            >快速开始</a-button
          >
        </span>
        <span slot="action">
          <a-button
            type="link"
            icon="exclamation-circle"
            style="font-size: 17px"
            >产品介绍</a-button
          >
        </span>
        <span slot="action">
          <a-button type="link" icon="form" style="font-size: 17px"
            >产品文档</a-button
          >
        </span>
        <br />
        <br />
      </div>
    </a-layout-content>
    <br />
    <div
      id="div_secondPart"
      style="
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
        gap: 16px;
        margin-top: 16px;
      "
    >
      <a-button
        @click="addCard"
        class="button_card"
        style="width: 300px; height: 140px"
        icon="plus"
        >新建卡片</a-button
      >
      <a-card hoverable style="width: 300px; height: 140px" class="button_card">
        <template slot="actions">
          <a-icon key="setting" type="setting" />
          <a-icon key="edit" type="edit" />
          <a-icon key="ellipsis" type="ellipsis" />
        </template>
        <a-card-meta title="Alipay" description="This is Alipay">
          <a-avatar
            slot="avatar"
            src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
          />
        </a-card-meta>
      </a-card>
      <a-card hoverable style="width: 300px; height: 140px" class="button_card">
        <template slot="actions">
          <a-icon key="setting" type="setting" />
          <a-icon key="edit" type="edit" />
          <a-icon key="ellipsis" type="ellipsis" />
        </template>
        <a-card-meta title="Alipay" description="This is Alipay">
          <a-avatar
            slot="avatar"
            src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
          />
        </a-card-meta>
      </a-card>
      <a-card hoverable style="width: 300px; height: 140px" class="button_card">
        <template slot="actions">
          <a-icon key="setting" type="setting" />
          <a-icon key="edit" type="edit" />
          <a-icon key="ellipsis" type="ellipsis" />
        </template>
        <a-card-meta title="Alipay" description="This is Alipay">
          <a-avatar
            slot="avatar"
            src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
          />
        </a-card-meta>
      </a-card>
      <a-card hoverable style="width: 300px; height: 140px" class="button_card">
        <template slot="actions">
          <a-icon key="setting" type="setting" />
          <a-icon key="edit" type="edit" />
          <a-icon key="ellipsis" type="ellipsis" />
        </template>
        <a-card-meta title="Alipay" description="This is Alipay">
          <a-avatar
            slot="avatar"
            src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
          />
        </a-card-meta>
      </a-card>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      data: "",
    };
  },
  methods: {
    addCard() {
      // 创建一个新的卡片对象
      const newCard = {
        id: this.cardIdCounter++,
      };

      // 将新卡片添加到卡片列表
      this.cards.push(newCard);
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

.div_secondPart {
  margin-top: 100px;
  margin: 24px auto 0;
}

.button_card {
  width: 300px;
  height: 140px;
}

.top_blank {
  font-size: 20px;
  font-weight: bold;
  color: black;
}
</style>
