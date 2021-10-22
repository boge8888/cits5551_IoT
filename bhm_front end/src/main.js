import Vue from 'vue'
import Button from 'ant-design-vue/lib/button'
import 'ant-design-vue/dist/antd.css'
import App from './App'
import Antd from 'ant-design-vue'
import router from './router/index.js'
import axios from 'axios'
import accelerationx from './accelerationx.vue'
import realtime from './realtime.vue'

Vue.component('accelerationx', accelerationx)
Vue.component('realtime', realtime)
Vue.prototype.$axios = axios
Vue.use(Antd)
Vue.use(Button)

Vue.component(Button.name, Button)
Vue.config.productionTip = false

router.beforeEach((to, from, next) => {
  console.log(to.path)
  if (to.path === '/') {
    next()
  } else if (to.path === '/create') {
    next()
  } else {
    console.log(window.sessionStorage.isLoginSuccess)
    if (window.sessionStorage.isLoginSuccess !== '1') {
      next({path: '/'})
    } else {
      next()
    }
  }
}
)

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
