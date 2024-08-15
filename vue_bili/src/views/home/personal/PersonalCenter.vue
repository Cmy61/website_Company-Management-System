<template>
  <div>
    <div id="div_top"></div>
    <a-row>
      <a-col :span="6">
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            minHeight: '280px',
            margin: '20px 0px',
            overflow: 'initial',
            top: '64px',
          }"
        >
          <div
            style="
              display: flex;
              flex-direction: column;
              align-items: center;
              text-align: center;
            "
          >
            <a-avatar :size="100">
              <template #icon><UserOutlined /></template>
            </a-avatar>
            <br />
            <h1 style="font-size: 20px">{{ username }}</h1>
            <span style="font-size: 15px">{{ signature }}</span>
            <br />
          </div>
          <div>
            <span
              style="font-size: 15px; display: inline-block; text-align: left"
              ><a-icon type="idcard" /> 交互专家</span
            >
            <span style="font-size: 15px; display: inline-block"
              ><a-icon type="apartment" /> 蚂蚁金服 - 某某某事业群 - UED</span
            >
            <span style="font-size: 15px; display: inline-block"
              ><a-icon type="home" /> 浙江省杭州市</span
            >
          </div>
          <br />
          <a-divider />
          <br />
          <div>
            <h1 style="font-size: 15px; font-weight: bold">标签</h1>
            <div>
              <template v-for="(tag, index) in tags">
                <a-tooltip v-if="tag.length > 20" :key="tag" :title="tag">
                  <a-tag
                    :key="tag"
                    :closable="index !== 0"
                    @close="() => handleClose(tag)"
                  >
                    {{ `${tag.slice(0, 20)}...` }}
                  </a-tag>
                </a-tooltip>
                <a-tag
                  v-else
                  :key="tag"
                  :closable="index !== 0"
                  @close="() => handleClose(tag)"
                >
                  {{ tag }}
                </a-tag>
              </template>
              <a-input
                v-if="inputVisible"
                ref="input"
                type="text"
                size="small"
                :style="{ width: '78px' }"
                :value="inputValue"
                @change="handleInputChange"
                @blur="handleInputConfirm"
                @keyup.enter="handleInputConfirm"
              />
              <a-tag
                v-else
                style="background: #fff; borderstyle: dashed"
                @click="showInput"
              >
                <a-icon type="plus" /> New Tag
              </a-tag>
            </div>
          </div>
          <br />
          <a-divider />
          <br />
          <div>
            <h1 style="font-size: 15px; font-weight: bold">团队</h1>
          </div>
        </a-layout-content>
      </a-col>
      <a-col :span="18">
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            minHeight: '280px',
            overflow: 'initial',
            margin: '20px 20px',
            top: '64px',
          }"
        >
          <div>
            <a-menu v-model="current" mode="horizontal">
              <a-menu-item key="passage"
                ><router-link to="/pass"></router-link>文章</a-menu-item
              >
              <a-menu-item key="application"
                ><router-link to="/app"></router-link>应用</a-menu-item
              >
              <a-menu-item key="project"
                ><router-link to="/pro"></router-link>项目</a-menu-item
              >
            </a-menu>
          </div>
          <br />
          <div>
            <router-view />
          </div>
        </a-layout-content>
      </a-col>
    </a-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: "Serati Ma",
      signature: "海纳百川，有容乃大",
      tags: ["Unremovable", "Tag 2", "Tag 3Tag 3Tag 3Tag 3Tag 3Tag 3Tag 3"],
      inputVisible: false,
      inputValue: "",
      current: "passage",
    };
  },
  methods: {
    handleClose(removedTag) {
      const tags = this.tags.filter((tag) => tag !== removedTag);
      console.log(tags);
      this.tags = tags;
    },

    showInput() {
      this.inputVisible = true;
      this.$nextTick(function () {
        this.$refs.input.focus();
      });
    },

    handleInputChange(e) {
      this.inputValue = e.target.value;
    },
    changePage(route) {
      console.log(route);
      //获取路由对象并切换
      this.$router.push(route);
    },
    handleInputConfirm() {
      const inputValue = this.inputValue;
      let tags = this.tags;
      if (inputValue && tags.indexOf(inputValue) === -1) {
        tags = [...tags, inputValue];
      }
      console.log(tags);
      Object.assign(this, {
        tags,
        inputVisible: false,
        inputValue: "",
      });
    },
  },
};
</script>

<style>
/* 添加你的样式 */
</style>
