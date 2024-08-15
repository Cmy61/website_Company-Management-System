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
          <a-breadcrumb-item><a href="">Dashboard</a></a-breadcrumb-item>
          <a-breadcrumb-item><a href="">工作台</a></a-breadcrumb-item>
        </a-breadcrumb>
        <br />
        <div class="top_blank">工作台</div>
        <br />
        <a-row>
          <a-col :span="2">
            <a-avatar :size="64" icon="user" />
          </a-col>
          <a-col :span="10">
            <div class="top_blank">早安，祝你开心每一天！</div>
            <br />
            <div>
              交互专家 |蚂蚁金服－某某某事业群－某某平台部－某某技术部－UED
            </div>
          </a-col>
          <a-col :span="3"></a-col>
          <a-col :span="3">
            <a-statistic title="项目数" :value="78" style="margin-right: 50px">
              <template #suffix>
                <span> %</span>
              </template>
            </a-statistic>
          </a-col>
          <a-col :span="3">
            <a-statistic
              title="团队内排名"
              :value="8"
              style="margin-right: 50px"
            >
              <template #suffix>
                <span> /24</span>
              </template>
            </a-statistic>
          </a-col>
          <a-col :span="3">
            <a-statistic
              title="项目访问"
              :value="1178"
              style="margin-right: 50px"
            >
            </a-statistic>
          </a-col>
        </a-row>
        <br />
        <br />
      </div>
    </a-layout-content>
    <a-row>
      <a-col :span="18">
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            minHeight: '250px',
            margin: '20px 10px',
            overflow: 'initial',
            top: '64px',
          }"
        >
          <a-card title="进行中的项目">
            <a-card-grid style="width: 25%">
              <a-card-meta
                title="Card title"
                description="This is the description"
              >
                <a-avatar
                  slot="avatar"
                  src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
              </a-card-meta>
            </a-card-grid>
            <a-card-grid style="width: 25%; text-align: center">
              <a-card-meta
                title="Card title"
                description="This is the description"
              >
                <a-avatar
                  slot="avatar"
                  src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
              </a-card-meta>
            </a-card-grid>
            <a-card-grid style="width: 25%; text-align: center">
              <a-card-meta
                title="Card title"
                description="This is the description"
              >
                <a-avatar
                  slot="avatar"
                  src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
              </a-card-meta>
            </a-card-grid>
            <a-card-grid style="width: 25%; text-align: center">
              <a-card-meta
                title="Card title"
                description="This is the description"
              >
                <a-avatar
                  slot="avatar"
                  src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
              </a-card-meta>
            </a-card-grid>
            <a-card-grid style="width: 25%; text-align: center">
              <a-card-meta
                title="Card title"
                description="This is the description"
              >
                <a-avatar
                  slot="avatar"
                  src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
              </a-card-meta>
            </a-card-grid>
            <a-card-grid style="width: 25%; text-align: center">
              <a-card-meta
                title="Card title"
                description="This is the description"
              >
                <a-avatar
                  slot="avatar"
                  src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
              </a-card-meta>
            </a-card-grid>
            <a-card-grid style="width: 25%; text-align: center">
              <a-card-meta
                title="Card title"
                description="This is the description"
              >
                <a-avatar
                  slot="avatar"
                  src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
              </a-card-meta>
            </a-card-grid>
            <a-card-grid style="width: 25%; text-align: center">
              <a-card-meta
                title="Card title"
                description="This is the description"
              >
                <a-avatar
                  slot="avatar"
                  src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
              </a-card-meta>
            </a-card-grid>
          </a-card>
        </a-layout-content>
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            minHeight: '250px',
            margin: '20px 10px',
            overflow: 'initial',
            top: '64px',
          }"
        >
          <a-list item-layout="horizontal" :data-source="data">
            <a-list-item slot="renderItem" slot-scope="item">
              <a-list-item-meta
                description="Ant Design, a design language for background applications, is refined by Ant UED Team"
              >
                <a slot="title" href="https://www.antdv.com/">{{
                  item.title
                }}</a>
                <a-avatar
                  slot="avatar"
                  src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"
                />
              </a-list-item-meta>
            </a-list-item>
          </a-list>
        </a-layout-content>
      </a-col>
      <a-col :span="6">
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            minHeight: '100px',
            overflow: 'initial',
            margin: '20px 10px',
            top: '64px',
          }"
        >
          <div style="font-size: 17px">快速开始/便捷导航</div>
          <a-divider />
          <span>
            <a-button type="link" style="font-size: 13px; color: black"
              >操作一</a-button
            >
            <a-button type="link" style="font-size: 13px; color: black"
              >操作二</a-button
            >
            <a-button type="link" style="font-size: 13px; color: black"
              >操作三</a-button
            >
          </span>
        </a-layout-content>
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            minHeight: '250px',
            margin: '20px 10px',
            overflow: 'initial',
            top: '64px',
          }"
        >
          <div style="font-size: 17px">xx指数</div>
          <a-divider />
          <e-charts class="chart" :option="option" />
        </a-layout-content>
        <a-layout-content
          :style="{
            background: '#fff',
            padding: '24px',
            minHeight: '250px',
            margin: '20px 10px',
            overflow: 'initial',
            top: '64px',
          }"
        >
          <div style="font-size: 17px">团队</div>
          <a-divider />
          <div>
            <a-button type="link" style="font-size: 13px; color: black"
              >科学搬砖组</a-button
            >
            <a-button type="link" style="font-size: 13px; color: black"
              >中二少女团</a-button
            >
            <a-button type="link" style="font-size: 13px; color: black"
              >高逼格设计天团</a-button
            >
          </div>
        </a-layout-content>
      </a-col>
    </a-row>
  </div>
</template>

<script>
const data = [
  {
    title: "Ant Design Title 1",
  },
  {
    title: "Ant Design Title 2",
  },
  {
    title: "Ant Design Title 3",
  },
  {
    title: "Ant Design Title 4",
  },
];
export default {
  data() {
    return {
      data,
      option: {
        legend: {
          data: ["Allocated Budget", "Actual Spending"],
        },
        radar: {
          // shape: "circle",
          indicator: [
            { name: "Sales", max: 6500 },
            { name: "Administration", max: 16000 },
            { name: "Information Technology", max: 30000 },
            { name: "Customer Support", max: 38000 },
            { name: "Development", max: 52000 },
            { name: "Marketing", max: 25000 },
          ],
        },
        series: [
          {
            name: "Budget vs spending",
            type: "radar",
            data: [
              {
                value: [4200, 3000, 20000, 35000, 50000, 18000],
                name: "Allocated Budget",
              },
              {
                value: [5000, 14000, 28000, 26000, 42000, 21000],
                name: "Actual Spending",
              },
            ],
          },
        ],
      },
    };
  },
};
</script>

<style scoped>
.chart {
  height: 300px;
}
</style>
