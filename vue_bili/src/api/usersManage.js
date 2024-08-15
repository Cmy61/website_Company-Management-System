import request from "@/utils/request";
export default {
  addUsers(users) {
    return request({
      url: "/stepForm",
      method: "post",
      data: users,
    });
  },
};
