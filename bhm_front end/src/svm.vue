<template>
    <div id="map" style="width:500px;height:400px;"></div>
</template>

<script src="https://map.qq.com/api/gljs?v=1.exp&key=E5ZBZ-UNARJ-37HFF-FWOWJ-X2IUF-6NBGC"></script>
<script>
export default {
  data () {
    return {
    }
  },
  methods: {
    initMap () {
      var center = new window.TMap.LatLng(22.301944,113.972079)
      var map = new window.TMap.Map(document.getElementById('map'), {
        center: center, // 设置地图中心点坐标
        zoom: 15, // 设置地图缩放级别
        // pitch: 43.5, // 设置俯仰角
        baseMap: { type: 'satellite', features: ['base'] }
      })
      // map.setBaseMap({ type: 'satellite', features: ['base'] })
      // console.log(map)
      // console.log(window)
    }
  },
  mounted () {
    this.initMap()
  }
}
</script>

<style>

</style>
