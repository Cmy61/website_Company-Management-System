<template>
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
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.card-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  gap: 20px;
}

a-card {
  margin-bottom: 10px;
  margin-bottom: 10px;
}
</style>
