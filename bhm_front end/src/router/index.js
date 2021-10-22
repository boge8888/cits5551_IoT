import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    {
      path: '/layout',
      component: () => import('@/layout'),
      children: [
        {
          path: '/user',
          component: () => import('@/user')
        },
        {
          path: '/cableacceleration',
          component: () => import('@/cableacceleration')
        },
        {
          path: '/LogRecords',
          component: () => import('@/LogRecords')
        },
        {
          path: '/accelerationall',
          component: () => import('@/accelerationall')
        },
        {
          path: '/accelerationx',
          component: () => import('@/accelerationx')
        },
        {
          path: '/accelerationy',
          component: () => import('@/accelerationy')
        },
        {
          path: '/accelerationz',
          component: () => import('@/accelerationz')
        },
        {
          path: '/rnn',
          component: () => import('@/rnn')
        },
        {
          path: '/svm',
          component: () => import('@/svm')
        },
        {
          path: '/AlarmEmail',
          component: () => import('@/AlarmEmail')
        },
        {
          path: '/alarm',
          component: () => import('@/alarm')
        },
        {
          path: '/cableinfo',
          component: () => import('@/cableinfo')
        },
        {
          path: '/towerinfo',
          component: () => import('@/towerinfo')
        },
        {
          path: '/bridgeinfo',
          component: () => import('@/bridgeinfo')
        },
        {
          path: '/deviceinfo',
          component: () => import('@/deviceinfo')
        },
        {
          path: '/realtime',
          component: () => import('@/realtime')
        },
        {
          path: '/user',
          component: () => import('@/user')
        },
        {
          path: '/allData',
          component: () => import('@/allData')
        },
        {
          path: '/incline',
          component: () => import('@/incline')
        },
        {
          path: '/tcn',
          component: () => import('@/tcn')
        },
        {
          path: '/lstm',
          component: () => import('@/lstm')
        },
        {
          path: '/addbridge',
          component: () => import('@/addbridge')
        },
        {
          path: '/adddevice',
          component: () => import('@/adddevice')
        }

      ]
    },

    {
      path: '/',
      component: () => import('@/login')
    },
    {
      path: '/create',
      component: () => import('@/create')
    },
    {
      path: '*',
      component: () => import('@/404')
    }
  ]
}
)

export default router
