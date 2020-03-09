// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// import ViewUI from 'view-design'
// import 'view-design/dist/styles/iview.css'
// import Vant from 'vant'
import 'vant/lib/index.css'
import store from '@/store'

// Vue.use(ViewUI)
// 按需引入vant
import {Form, Calendar, Button, Field, NavBar, Skeleton, Popup, Area, RadioGroup, Radio, Picker, NoticeBar, Divider, Cell, SwipeCell} from 'vant'
Vue.use(Form)
Vue.use(Calendar)
Vue.use(Button)
Vue.use(Field)
Vue.use(NavBar)
Vue.use(Skeleton)
Vue.use(Popup)
Vue.use(Area)
Vue.use(RadioGroup)
Vue.use(Radio)
Vue.use(Picker)
Vue.use(NoticeBar)
Vue.use(Divider)
Vue.use(Cell)
Vue.use(SwipeCell)
// 设置anxios，
var axios = require('axios')
axios.defaults.baseURL = 'http://212.64.72.17:8080'
axios.defaults.timeout = 6000 // 6000的超时验证
// 将API方法绑定到全局
Vue.prototype.$axios = axios
Vue.config.productionTip = false

// 跳转后回到顶部
router.afterEach((to, from, next) => {
  window.scrollTo(0, 0)
})
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'

})
