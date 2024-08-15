<template>
  <div id="div_top">
    <h1 style="font-size: 20px; font-weight: bold">基本设置</h1>
    <div
      style="
        display: flex;
        flex-direction: column;
        align-items: center;
        text-align: center;
      "
    >
      <a-avatar :size="150">
        <template #icon><UserOutlined /></template>
      </a-avatar>
      <br />
      <a-button icon="upload">更换头像 </a-button>
    </div>
    <br />
    <a-form-model
      :model="form"
      :label-col="labelCol"
      :wrapper-col="wrapperCol"
      class="white-background"
    >
      <a-form-model-item label="邮箱">
        <a-input v-model="form.email" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="昵称">
        <a-input v-model="form.nickname" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="个人简介">
        <a-input v-model="form.introduction" type="textarea" />
      </a-form-model-item>
      <a-form-model-item label="国家/地区">
        <a-select v-model="form.country" placeholder="请输入">
          <a-select-option
            v-for="item in countries"
            :key="item.value"
            :value="item.value"
          >
            {{ item.label }}
          </a-select-option>
        </a-select>
      </a-form-model-item>
      <a-form-model-item label="所在省市">
        <a-cascader
          :options="options"
          placeholder="请选择"
          @change="onChange"
        />
      </a-form-model-item>
      <a-form-model-item label="街道地址">
        <a-input v-model="form.address" placeholder="请输入" />
      </a-form-model-item>
      <a-form-model-item label="联系电话">
        <a-input-group>
          <a-row :gutter="8">
            <a-col :span="5">
              <a-input v-model="form.number_before" />
            </a-col>
            <a-col :span="8">
              <a-input v-model="form.number_after" />
            </a-col>
          </a-row>
        </a-input-group>
      </a-form-model-item>
      <a-form-model-item :wrapper-col="{ span: 14, offset: 4 }">
        <a-button type="primary" @click="onSubmit">提交</a-button>
      </a-form-model-item>
    </a-form-model>
  </div>
</template>
<script>
export default {
  data() {
    return {
      labelCol: { span: 4 },
      wrapperCol: { span: 14 },
      options: [
        {
          value: "浙江",
          label: "浙江",
          children: [
            {
              value: "杭州",
              label: "杭州",
              children: [
                {
                  value: "西湖",
                  label: "西湖",
                },
              ],
            },
          ],
        },
        {
          value: "江苏",
          label: "江苏",
          children: [
            {
              value: "南京",
              label: "南京",
              children: [
                {
                  value: "中华门",
                  label: "中华门",
                },
              ],
            },
          ],
        },
      ],
      countries: [
        { label: "上海", value: "shanghai" },
        { label: "北京", value: "beijing" },
        // 添加更多项
      ],
      form: {
        email: "antdesign@alipay.com",
        nickname: "Serati Ma",
        introduction: undefined,
        country: "中国",
        type: [],
        address: "西湖区工专路77号",
        desc: "",
        number_after: "268888888",
        number_before: "0752",
      },
    };
  },
  methods: {
    onSubmit() {
      console.log("submit!", this.form);
    },
    onChange(value) {
      console.log(value);
    },
  },
};
</script>

<style>
#div_top {
  background-color: white;
}

#white-background {
  background-color: white;
}
</style>
