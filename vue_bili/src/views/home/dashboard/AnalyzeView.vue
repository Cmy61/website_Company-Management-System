<template>
  <div>
    <div id="div_top"></div>
    <div>
      <a-row>
        <a-col :span="6">
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
            <a-statistic
              title="总销售额"
              :value="126560"
              style="margin-right: 50px"
            >
            </a-statistic>
            <a-divider />
            <div>日销售额 123423元</div>
          </a-layout-content>
        </a-col>
        <a-col :span="6">
          <a-layout-content
            :style="{
              background: '#fff',
              padding: '24px',
              minHeight: '250px',
              overflow: 'initial',
              margin: '20px 10px',
              top: '64px',
            }"
          >
            <a-statistic
              title="访问量"
              :value="8846"
              style="margin-right: 50px"
            >
            </a-statistic>
            <e-charts class="chart_2" :option="option2" />
            <a-divider />
            <div>日访问量 1234</div>
          </a-layout-content>
        </a-col>
        <a-col :span="6">
          <a-layout-content
            :style="{
              background: '#fff',
              padding: '24px',
              minHeight: '250px',
              overflow: 'initial',
              margin: '20px 10px',
              top: '64px',
            }"
          >
            <a-statistic
              title="支付笔数"
              :value="6560"
              style="margin-right: 50px"
            >
            </a-statistic>
            <e-charts class="chart_2" :option="option3" />
            <a-divider />
            <div>转化率 60%</div>
          </a-layout-content>
        </a-col>
        <a-col :span="6">
          <a-layout-content
            :style="{
              background: '#fff',
              padding: '24px',
              minHeight: '250px',
              overflow: 'initial',
              margin: '20px 10px',
              top: '64px',
            }"
          >
            <a-statistic
              title="运营活动效果"
              :value="78"
              style="margin-right: 50px"
            >
              <template #suffix>
                <span> %</span>
              </template>
            </a-statistic>
            <e-charts class="chart_2" :option="option4" />
            <a-divider />
          </a-layout-content>
        </a-col>
      </a-row>
    </div>
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
      <a-menu v-model="current" mode="horizontal">
        <a-menu-item key="first" @click="cur = 1">销售额</a-menu-item>
        <a-menu-item key="second" @click="cur = 1">访问量</a-menu-item>
      </a-menu>
      <div v-show="cur == 0">
        <a-row>
          <a-col :span="12">
            <e-charts class="chart_3" :option="option5" />
          </a-col>
          <a-col :span="12">
            <div>门店销售额排名</div>
          </a-col>
        </a-row>
      </div>
      <div v-show="cur == 1">
        <a-row>
          <a-col :span="12">
            <e-charts class="chart_3" :option="option6" />
          </a-col>
          <a-col :span="12">
            <div>门店访问量排名</div>
          </a-col>
        </a-row>
      </div>
    </a-layout-content>
    <div>
      <a-row>
        <a-col :span="12">
          <a-layout-content
            :style="{
              background: '#fff',
              padding: '24px',
              minHeight: '700px',
              margin: '24px 0px',
              overflow: 'initial',
              top: '64px',
            }"
          >
            <div>线上热门搜索</div>
            <a-divider></a-divider>
            <a-row>
              <a-col :span="12">
                <a-statistic
                  title="访问量"
                  :value="8846"
                  style="margin-right: 50px"
                >
                </a-statistic>
                <e-charts class="chart_2" :option="option2" />
                <a-divider />
                <div>日访问量 1234</div>
              </a-col>
              <a-col :span="12">
                <a-statistic
                  title="访问量"
                  :value="8846"
                  style="margin-right: 50px"
                >
                </a-statistic>
                <e-charts class="chart_2" :option="option2" />
                <a-divider />
                <div>日访问量 1234</div>
              </a-col>
            </a-row>
            <br />
            <a-table
              :columns="columns"
              :data-source="data"
              @change="onChange"
            />
          </a-layout-content>
        </a-col>
        <a-col :span="12">
          <a-layout-content
            :style="{
              background: '#fff',
              padding: '24px',
              minHeight: '700px',
              overflow: 'initial',
              margin: '24px 20px',
              top: '64px',
            }"
          >
            <span>销售额类别占比</span>
            <span style="margin-left: 10%">
              <a-radio-group :value="mode" @change="modeChange">
                <a-radio-button value="all" @click="buttt = 1"
                  >全部渠道</a-radio-button
                >
                <a-radio-button value="online" @click="buttt = 2"
                  >线上</a-radio-button
                >
                <a-radio-button value="store" @click="buttt = 3"
                  >门店</a-radio-button
                >
              </a-radio-group>
            </span>
            <a-divider></a-divider>
            <e-charts class="chart_4" :option="option7" v-show="buttt == 1" />
            <e-charts class="chart_4" :option="option7" v-show="buttt == 2" />
            <e-charts class="chart_4" :option="option7" v-show="buttt == 3" />
          </a-layout-content>
        </a-col>
      </a-row>
    </div>
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
      <div>
        <a-progress
          stroke-linecap="square"
          :percent="75"
          type="circle"
          style="margin-left: 5%"
        />
        <a-progress
          stroke-linecap="square"
          :percent="75"
          type="circle"
          title="store1"
          style="margin-left: 5%"
        />
        <a-progress
          stroke-linecap="square"
          :percent="75"
          type="circle"
          style="margin-left: 5%"
        />
        <a-progress
          stroke-linecap="square"
          :percent="75"
          type="circle"
          style="margin-left: 5%"
        />
        <a-progress
          stroke-linecap="square"
          :percent="75"
          type="circle"
          style="margin-left: 5%"
        />
        <a-progress
          stroke-linecap="square"
          :percent="75"
          type="circle"
          style="margin-left: 5%"
        />
      </div>
      <e-charts class="chart" :option="option" />
    </a-layout-content>
  </div>
</template>
<script>
const columns = [
  {
    title: "Name",
    dataIndex: "name",
    filters: [
      {
        text: "Joe",
        value: "Joe",
      },
      {
        text: "Jim",
        value: "Jim",
      },
      {
        text: "Submenu",
        value: "Submenu",
        children: [
          {
            text: "Green",
            value: "Green",
          },
          {
            text: "Black",
            value: "Black",
          },
        ],
      },
    ],
    // specify the condition of filtering result
    // here is that finding the name started with `value`
    onFilter: (value, record) => record.name.indexOf(value) === 0,
    sorter: (a, b) => a.name.length - b.name.length,
    sortDirections: ["descend"],
  },
  {
    title: "Age",
    dataIndex: "age",
    defaultSortOrder: "descend",
    sorter: (a, b) => a.age - b.age,
  },
  {
    title: "Address",
    dataIndex: "address",
    filters: [
      {
        text: "London",
        value: "London",
      },
      {
        text: "New York",
        value: "New York",
      },
    ],
    filterMultiple: false,
    onFilter: (value, record) => record.address.indexOf(value) === 0,
    sorter: (a, b) => a.address.length - b.address.length,
    sortDirections: ["descend", "ascend"],
  },
];

const data = [
  {
    key: "1",
    name: "John Brown",
    age: 32,
    address: "New York No. 1 Lake Park",
  },
  {
    key: "2",
    name: "Jim Green",
    age: 42,
    address: "London No. 1 Lake Park",
  },
  {
    key: "3",
    name: "Joe Black",
    age: 32,
    address: "Sidney No. 1 Lake Park",
  },
  {
    key: "4",
    name: "Jim Red",
    age: 32,
    address: "London No. 2 Lake Park",
  },
];

function onChange(pagination, filters, sorter) {
  console.log("params", pagination, filters, sorter);
}
export default {
  data() {
    return {
      buttt: 1,
      data,
      columns,
      cur: 1,
      option: {
        xAxis: {
          type: "category",
          data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            data: [150, 230, 224, 218, 135, 147, 260],
            type: "line",
          },
          {
            data: [200, 210, 180, 90, 140, 147, 260],
            type: "line",
          },
        ],
      },
      option3: {
        grid: {
          left: "0",
          right: "0",
          bottom: "0",
          top: "0",
          // grid 区域是否包含坐标轴的刻度标签
          containLabel: false,
        },
        xAxis: {
          show: false,
          type: "category",
          data: [
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
          ],
        },
        yAxis: {
          show: false,
          type: "value",
        },
        series: [
          {
            itemStyle: {
              color: "#2D8BD2",
            },
            data: [
              120, 160, 150, 80, 70, 110, 130, 200, 300, 250, 120, 50, 180, 30,
            ],
            type: "bar",
            // 柱状图宽度
            // barWidth: 10
          },
        ],
      },
      option2: {
        color: ["#9D509F"],
        grid: {
          left: "0",
          right: "0",
          bottom: "0",
          top: "0",
          // grid 区域是否包含坐标轴的刻度标签
          containLabel: false,
        },
        xAxis: [
          {
            type: "category",
            boundaryGap: false,
            data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
            show: true,
          },
        ],
        yAxis: [
          {
            show: false,
            axisLine: {
              show: false,
            },
            axisTick: {
              show: false,
            },
            splitLine: {
              show: false,
            },
          },
        ],
        series: [
          {
            type: "line",
            stack: "Total",
            smooth: true,
            lineStyle: {
              width: 0,
            },
            showSymbol: false,
            areaStyle: {
              opacity: 0.8,
              color: "#9D509F",
            },
            emphasis: {
              focus: "series",
            },
            data: [140, 232, 101, 264, 90, 340, 250],
          },
        ],
      },
      option4: {
        grid: {
          left: "0",
          right: "0",
          bottom: "0",
          top: "0",
          containLabel: false,
        },
        xAxis: {
          show: false,
          type: "value",
          boundaryGap: false,
        },
        yAxis: {
          show: false,
          type: "category",
          data: ["Brazil"],
        },
        series: [
          {
            type: "bar",
            data: [18203],
            stack: "sear",
            itemStyle: {
              color: "#39C44A",
            },
            barWidth: 10,
          },
          {
            type: "bar",
            data: [6000],
            stack: "sear",
            itemStyle: {
              color: "#EEEEEE",
            },
            barWidth: 10,
          },
          {
            type: "custom",
            stack: "总量",
            data: [100],
            renderItem: (params, api) => {
              const value = api.value(0);
              const endPoint = api.coord([value, 0]);
              return {
                type: "group",
                position: endPoint,
                children: [
                  {
                    type: "path",
                    shape: {
                      d: "M1024 255.996 511.971 767.909 0 255.996 1024 255.996z",
                      x: 310,
                      y: -20,
                      width: 10,
                      height: 10,
                      layout: "cover",
                    },
                    style: {
                      fill: "#45c946",
                    },
                  },
                  {
                    type: "path",
                    shape: {
                      d: "M0 767.909l512.029-511.913L1024 767.909 0 767.909z",
                      x: 310,
                      y: 10,
                      width: 10,
                      height: 10,
                      layout: "cover",
                    },
                    style: {
                      fill: "#45c946",
                    },
                  },
                ],
              };
            },
          },
        ],
      },
      option5: {
        xAxis: {
          type: "category",
          data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            data: [120, 200, 150, 80, 70, 110, 130],
            type: "bar",
            color: "#fc8251",
          },
        ],
      },
      option6: {
        xAxis: {
          type: "category",
          data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        },
        yAxis: {
          type: "value",
        },
        series: [
          {
            data: [120, 200, 150, 80, 70, 110, 130],
            type: "bar",
          },
        ],
      },
      option7: {
        tooltip: {
          trigger: "item",
        },
        legend: {
          top: "5%",
          left: "center",
        },
        series: [
          {
            name: "Access From",
            type: "pie",
            radius: ["40%", "70%"],
            avoidLabelOverlap: false,
            label: {
              show: false,
              position: "center",
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 40,
                fontWeight: "bold",
              },
            },
            labelLine: {
              show: false,
            },
            data: [
              { value: 1048, name: "Search Engine" },
              { value: 735, name: "Direct" },
              { value: 580, name: "Email" },
              { value: 484, name: "Union Ads" },
              { value: 300, name: "Video Ads" },
            ],
          },
        ],
      },
    };
  },
  methods: {
    drawLine() {
      let myChart = this.$echarts.init(document.getElementById("myChart"));
      myChart.setOption(this.option);
    },
    onChange,
  },
  mounted() {
    this.drawLine();
  },
};
</script>
<style>
.chart {
  height: 400px;
}

.chart_2 {
  height: 70px;
  margin-bottom: 0px;
}

.chart_3 {
  height: 300px;
  margin-bottom: 0px;
}

.chart_4 {
  height: 500px;
  margin-bottom: 0px;
}

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
