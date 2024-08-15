<template>
  <div>
    <div>
      <a-row>
        <a-col :span="18">
          <a-layout-content
            :style="{
              background: '#fff',
              padding: '24px',
              minHeight: '600px',
              margin: '20px 10px',
              overflow: 'initial',
              top: '64px',
            }"
          >
            <div style="font-size: 17px">活动实时交易情况</div>
            <a-divider />
            <a-row :gutter="16">
              <a-col :span="6">
                <a-statistic
                  title="Feedback"
                  :value="1128"
                  style="margin-right: 50px"
                >
                  <template #suffix>
                    <a-icon type="like" />
                  </template>
                </a-statistic>
              </a-col>
              <a-col :span="6">
                <a-statistic title="Unmerged" :value="93" class="demo-class">
                  <template #suffix>
                    <span> / 100</span>
                  </template>
                </a-statistic>
              </a-col>
              <a-col :span="6">
                <a-statistic-countdown
                  title="Million Seconds"
                  :value="deadline"
                  format="HH:mm:ss:SSS"
                  style="margin-right: 50px"
                />
              </a-col>
              <a-col :span="6">
                <a-statistic-countdown
                  title="Million Seconds"
                  :value="deadline"
                  format="HH:mm:ss:SSS"
                  style="margin-right: 50px"
                />
              </a-col>
            </a-row>
          </a-layout-content>
        </a-col>
        <row>
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
              <div style="font-size: 17px">券核销率</div>
              <e-charts class="chart" :option="option1" />
            </a-layout-content>
          </a-col>
        </row>
      </a-row>
      <a-row>
        <a-col :span="12">
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
            <div style="font-size: 17px">活动实时交易情况</div>
            <a-divider />
            <a-progress
              stroke-linecap="square"
              :percent="75"
              type="circle"
              style="margin-left: 2%"
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
              title="访问量"
              :value="8846"
              style="margin-right: 50px"
            >
            </a-statistic>
            <a-divider />
            <div>日访问量 1234</div>
          </a-layout-content>
        </a-col>
      </a-row>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      deadline: Date.now() + 1000 * 60 * 60 * 24 * 2 + 1000 * 30,
      option1: {
        series: [
          {
            type: "gauge",
            progress: {
              show: true,
              width: 18,
            },
            axisLine: {
              lineStyle: {
                width: 18,
              },
            },
            axisTick: {
              show: false,
            },
            splitLine: {
              length: 15,
              lineStyle: {
                width: 2,
                color: "#999",
              },
            },
            axisLabel: {
              distance: 25,
              color: "#999",
              fontSize: 20,
            },
            anchor: {
              show: true,
              showAbove: true,
              size: 25,
              itemStyle: {
                borderWidth: 10,
              },
            },
            title: {
              show: false,
            },
            detail: {
              valueAnimation: true,
              fontSize: 80,
              offsetCenter: [0, "70%"],
            },
            data: [
              {
                value: 70,
              },
            ],
          },
        ],
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

.chart {
  height: 200px;
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
