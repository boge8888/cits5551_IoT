<template>
  <a-layout id="layout">

    <a-layout-header class="header">
      <div class="logo" />
      <a-menu
        theme="dark"
        mode="horizontal"
        :default-selected-keys="['1']"
        :style="{ lineHeight: '64px' }"
      >
        <a-menu-item key="1">
          Bridge
        </a-menu-item>
        <a-menu-item key="2">
          Health
        </a-menu-item>
        <a-menu-item key="3">
          Monitoring
        </a-menu-item>
        <a-menu-item key="4">
              <a-dropdown>
          <a class="ant-dropdown-link"
             @click="(e) => e.preventDefault()">
             Logout
            <a-icon type="down" />
          </a>
          <a-menu slot="overlay">
            <a-menu-item>
              <a href="javascript:;"
                 @click="logout">
                <a-icon type="logout" />Logout
              </a>
            </a-menu-item>
          </a-menu>
        </a-dropdown>
          </a-menu-item>
      </a-menu>
    </a-layout-header>
    <a-layout>
      <a-layout-sider width="200" style="background: #fff">
        <a-menu
          mode="inline"
          :default-selected-keys="['1']"
          :default-open-keys="['sub1']"
          :style="{ height: '100%', borderRight: 0 }"
        >
          <a-sub-menu key="sub1">
            <span slot="title"><a-icon type="user" />User Center</span>
            <a-menu-item key="1-1">
              <router-link to='/user' tag='div'>User Management</router-link>
            </a-menu-item>
          </a-sub-menu>

          <a-sub-menu key="sub2">
            <span slot="title"><a-icon type="user" />Bridge Center</span>
            <a-menu-item key="2-1">
              <router-link to='/bridgeinfo' tag='div'>Bridge Information</router-link>
            </a-menu-item>
          </a-sub-menu>

          <a-sub-menu key="sub3">
            <span slot="title"><a-icon type="laptop" />Monitoring Parameters</span>

            <a-menu-item key="3-1">
              <router-link to='/allData' tag='div'>All data</router-link>
            </a-menu-item>

            <a-menu-item key="3-2">
              <router-link to='/cableinfo' tag='div'>Cable Information</router-link>
            </a-menu-item>

            <a-menu-item key="3-3">
              <router-link to='/towerinfo' tag='div'>Tower Information</router-link>
            </a-menu-item>

            <a-menu-item key="3-4">
              <router-link to='/cableacceleration' tag='div'>Cable Acceleration</router-link>
            </a-menu-item>

            <a-menu-item key="3-5">
              <router-link to='/incline' tag='div'>Tower Incline</router-link>
            </a-menu-item>

          </a-sub-menu>

          <a-sub-menu key="sub4">
            <span slot="title"><a-icon type="notification" />Device Information </span>

            <a-menu-item key="4-3">
              <router-link to='/deviceinfo' tag='div'>RasberryPi Info</router-link>
            </a-menu-item>
            </a-sub-menu>

          <!--a-sub-menu key="sub5">
            <span slot="title"><a-icon type="notification" />Machine Learning</span>

            <a-menu-item key="5-1">
              <router-link to='/lstm' tag='div'>LSTM</router-link>
            </a-menu-item>

            <a-menu-item key="5-2">
              <router-link to='/svm' tag='div'>SVM</router-link>
            </a-menu-item>

            <a-menu-item key="5-3">
              <router-link to='/tcn' tag='div'>TCN</router-link>
            </a-menu-item>

            <a-menu-item key="5-4">
              <router-link to='/rnn' tag='div'>RNN</router-link>
            </a-menu-item>

          </!--a-sub-menu-->
          <a-sub-menu key="sub6">
            <span slot="title"><a-icon type="notification" />
            Alarm Log
            </span>
            <a-menu-item key="6-1">
              <router-link to='/AlarmEmail' tag='div'>Send Alarm Email</router-link>
            </a-menu-item>
            <a-menu-item key="6-2">
              <router-link to='/LogRecords' tag='div'>LogRecords</router-link>
            </a-menu-item>
          </a-sub-menu>
        </a-menu>
      </a-layout-sider>
      <a-layout style="padding: 0 0px 24px, height:'100%'">
        <a-breadcrumb style="margin: 16px 0">
          <!-- <a-breadcrumb-item>Home</a-breadcrumb-item>
          <a-breadcrumb-item>List</a-breadcrumb-item>
          <a-breadcrumb-item>App</a-breadcrumb-item> -->
        </a-breadcrumb>
        <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
        >

          <router-view></router-view>
        </a-layout-content>
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<script>
import datatable from './datatable.vue'
export default {
  components: { datatable },
  data () {
    return {
      collapsed: false
    }
  },
  methods: {
    logout () {
      this.$router.push('/')
    }
  }

}
</script>

<style>
#layout .logo {
  width: 120px;
  height: 31px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px 28px 16px 0;
  float: left;
}
</style>
