import request from "@/utils/request";
export default {
  getPositionList() {
    return request({
      url: "/newForm",
      method: "get",
      params: {},
    });
  },
};
