<template>
<div id="accelerationz" style="width: 600px;height: 400px;">
</div>
</template>
<script>
import * as echarts from 'echarts'
export default {
  name: 'accelerationz',
  data () {
    return {
      charts: '',
      opinionData: ['3', '2', '4', '4', '5']
    }
  },

  methods: {
    drawLine (id) {
      this.charts = echarts.init(document.getElementById(id))
      this.charts.setOption({
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['Acceleration on Z direction']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },

        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['1', '2', '3', '4', '5', '6', '7', '8']
        },
        yAxis: {
          type: 'value'
        },

        series: [{
          name: 'Acceleration on Z direction',
          type: 'line',
          stack: '总量',
          data: this.opinionData
        }]
      })
    }
  },
  getRecords () {
    console.log('点击了')
    this.$axios.post('/api/data/getalldata', {}).then(({data}) => {
      console.log(data.data.data)
      this.records = data.data.data
      console.log(this.records)
    })
  },
  // 调用
  mounted () {
    this.$nextTick(function () {
      this.drawLine('accelerationz')
    })
  }
}
</script>

<style>
</style>
