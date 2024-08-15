<template>
  <div>
    <!-- <div class="login_body_form"></div> -->
    <a-layout id="layout-outter">
      <a-layout-header id="layout_head" :style="headerStyle">
        <br />
        <h1 id="ant_design_txt">Ant Design</h1>
      </a-layout-header>
      <a-layout-content id="layout_body" :style="contentStyle">
        <template id="form_template">
          <div id="form_div" v-show="cur == 0">
            <div class="login_header">
              <span @click="cur = 0" :class="{ active: cur == 0 }"
                ><font color="#1890ff">账号密码登录</font></span
              >
              <span @click="cur = 1" :class="{ active: cur == 1 }"
                >手机号登录</span
              >
              <a-divider />
            </div>
            <a-form
              :model="formState"
              name="normal_login"
              class="login-form"
              @finish="onFinish"
              @finishFailed="onFinishFailed"
            >
              <a-form-item
                label="Username"
                name="username"
                :rules="[
                  { required: true, message: 'Please input your username!' },
                ]"
              >
                <a-input v-model="form.userName" allowClear="true">
                  <template #prefix>
                    <UserOutlined class="site-form-item-icon" />
                  </template>
                </a-input>
              </a-form-item>

              <a-form-item
                label="Password"
                name="password"
                :rules="[
                  { required: true, message: 'Please input your password!' },
                ]"
              >
                <a-input-password v-model="form.userPassword" allowClear="true">
                  <template #prefix>
                    <LockOutlined class="site-form-item-icon" />
                  </template>
                </a-input-password>
              </a-form-item>

              <a-form-item>
                <a-form-item name="remember" no-style>
                  <a-checkbox v-model="remember">Remember me</a-checkbox>
                </a-form-item>
                <a class="login-form-forgot" href="">Forgot password</a>
              </a-form-item>

              <a-form-item>
                <a-button
                  :disabled="disabled"
                  type="primary"
                  html-type="submit"
                  class="login-form-button"
                  @click="login"
                >
                  Log in
                </a-button>
                Or
                <a href="">register now!</a>
              </a-form-item>
            </a-form>
          </div>
          <!-- 这里是另一种登录方式 -->
          <div id="form_div" v-show="cur == 1">
            <div class="login_header">
              <span @click="cur = 0" :class="{ active: cur == 0 }"
                >账号密码登录</span
              >
              <span @click="cur = 1" :class="{ active: cur == 1 }"
                ><font color="#1890ff">手机号登录</font></span
              >
              <a-divider />
            </div>
            <a-form
              :model="formState"
              name="normal_login"
              class="login-form"
              @finish="onFinish"
              @finishFailed="onFinishFailed"
            >
              <a-form-item
                label="Phone number"
                name="phonenumber"
                :rules="[
                  { required: true, message: 'Please input your phonenumber!' },
                ]"
              >
                <a-input v-model="form.userName" allowClear="true">
                  <template #prefix>
                    <UserOutlined class="site-form-item-icon" />
                  </template>
                </a-input>
              </a-form-item>

              <a-form-item
                label="Verification Code"
                name="verificationCode"
                style="width: 250px"
                :rules="[
                  {
                    required: true,
                    message: 'Please input your verification code!',
                  },
                ]"
              >
                <a-space>
                  <a-input style="width: 330px" />
                  <a-button type="primary">GET</a-button>
                </a-space>
              </a-form-item>
              <a-form-item>
                <a-form-item name="remember" no-style>
                  <a-checkbox v-model="remember">Remember me</a-checkbox>
                </a-form-item>
              </a-form-item>

              <a-form-item>
                <a-button
                  :disabled="disabled"
                  type="primary"
                  html-type="submit"
                  class="login-form-button"
                >
                  Log in
                </a-button>
                Or
                <a href="">register now!</a>
              </a-form-item>
            </a-form>
          </div>
        </template>
      </a-layout-content>
      <a-layout-footer id="layout_foot" :style="{ textAlign: 'center' }">
        Ant Design ©2018 Created by Ant UED
      </a-layout-footer>
    </a-layout>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      form: {
        userName: "",
        userPassword: "",
        token: "",
      },
      remember: true,
      cur: 0,
    };
  },
  methods: {
    login() {
      console.info("login");
      console.info(this.form.userName);
      console.info(this.form.userPassword);
      //提交给后台
      axios
        .get("/sys/users/login", {
          params: {
            userName: this.form.userName,
            userPassword: this.form.userPassword,
          },
        })
        .then((response) => {
          // 处理成功响应
          var baseResult = response.data;
          // console.log("成功发送表单数据至后端", response);
          if (baseResult.code == 20000) {
            this.$message.success("登录成功", 5);
            this.$router.push("/analyseView");
            this.token = baseResult.token;
            axios.defaults.headers.common["Authorization"] =
              "Bearer ${baseResult.token}";
            localStorage.setItem("token", baseResult.data.token);
          } else {
            // 登录失败，提示错误信息
            this.$message.error("用户名或密码错误", 5);
            this.form.userName = "";
            this.form.userPassword = "";
            this.$router.push("/login");
          }
        });
    },
  },
};
</script>

<style scoped>
#components-form-demo-normal-login .login-form {
  width: 100px;
}

#components-form-demo-normal-login .login-form-forgot {
  float: right;
}

#components-form-demo-normal-login .login-form-button {
  width: 100%;
}

.login_body_form {
  background-color: black;
  width: 500px;
  height: 200px;
  position: fixed;
}
#layout-outter {
  min-height: 100vh;
}

#layout_head {
  background-color: rgba(255, 255, 255, 0.2);
  height: 150px;
}

#layout_body {
  background-color: rgba(255, 255, 255, 0.2);
}

#layout_foot {
  background-color: rgba(255, 255, 255, 0.2);
}

#form_div {
  width: 400px;
  height: 20px;
  margin: auto;
}

#ant_design_txt {
  text-align: center;
  font-size: 40px;
}

.login_header span {
  margin-right: 40px;
  cursor: pointer;
  font-size: 15px;
}
.login_header {
  margin: auto;
}
</style>
