<template>
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
      actions: [
        { type: "star-o", text: "156" },
        { type: "like-o", text: "156" },
        { type: "message", text: "2" },
      ],
    };
  },
};
</script>
<style></style>
