<template>
<div id="accelerationx" style="width: 100%;height: 400px;">
</div>
</template>
<script>
import * as echarts from 'echarts'
export default {
  name: 'accelerationx',
  data () {
    return {
      charts: '',
      /* opinionData: ['0.965499', '0.956078', '0.958723', '0.957516', '0.960375', '0.960692', '0.95556', '0.958741',
        '0.957033', '0.95749', '0.961923', '0.958989', '0.960213', '0.96059', '0.960606'] */
      opinionData: ['1', '2', '3'],
      axisdata: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15']
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
          data: ['Acceleration of Cable']
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
          data: this.axisdata
        },
        yAxis: {
          type: 'value'
        },

        series: [{
          name: 'Acceleration of Cable',
          type: 'line',
          stack: '总量',
          data: this.opinionData
        }]
      })
    }
  },
  beforeMount () {
    this.$nextTick(function () {
      this.$axios.post('/api/data/getallcabledata', {}).then(({data}) => {
        for (let i = 0; i < 100; i++) {
          this.opinionData[i] = data.data.bridgecabledata[i].acc.toString()
          this.axisdata[i] = data.data.bridgecabledata[i].time.toString()
        }
        /* this.opinionData[0] = data.data.bridgecabledata[0].acc.toString()
        this.opinionData[1] = data.data.bridgecabledata[1].acc.toString()
        this.opinionData[2] = data.data.bridgecabledata[2].acc.toString()
        this.opinionData[3] = data.data.bridgecabledata[3].acc.toString()
        this.opinionData[4] = data.data.bridgecabledata[4].acc.toString()
        this.opinionData[5] = data.data.bridgecabledata[5].acc.toString()
        this.opinionData[6] = data.data.bridgecabledata[6].acc.toString()
        this.opinionData[7] = data.data.bridgecabledata[7].acc.toString()
        this.opinionData[8] = data.data.bridgecabledata[8].acc.toString()
        this.opinionData[9] = data.data.bridgecabledata[9].acc.toString()
        this.opinionData[10] = data.data.bridgecabledata[10].acc.toString()
        this.opinionData[11] = data.data.bridgecabledata[11].acc.toString()
        this.opinionData[12] = data.data.bridgecabledata[12].acc.toString()
        this.opinionData[13] = data.data.bridgecabledata[13].acc.toString()
        this.opinionData[14] = data.data.bridgecabledata[14].acc.toString()

        this.axisdata[0] = data.data.bridgecabledata[0].time.toString()
        this.axisdata[1] = data.data.bridgecabledata[1].time.toString()
        this.axisdata[2] = data.data.bridgecabledata[2].time.toString()
        this.axisdata[3] = data.data.bridgecabledata[3].time.toString()
        this.axisdata[4] = data.data.bridgecabledata[4].time.toString()
        this.axisdata[5] = data.data.bridgecabledata[5].time.toString()
        this.axisdata[6] = data.data.bridgecabledata[6].time.toString()
        this.axisdata[7] = data.data.bridgecabledata[7].time.toString()
        this.axisdata[8] = data.data.bridgecabledata[8].time.toString()
        this.axisdata[9] = data.data.bridgecabledata[9].time.toString()
        this.axisdata[10] = data.data.bridgecabledata[10].time.toString()
        this.axisdata[11] = data.data.bridgecabledata[11].time.toString()
        this.axisdata[12] = data.data.bridgecabledata[12].time.toString()
        this.axisdata[13] = data.data.bridgecabledata[13].time.toString()
        this.axisdata[14] = data.data.bridgecabledata[14].time.toString() */
        console.log(this.opinionData)
        // console.log(this.charts.xAxis.data)
        this.drawLine('accelerationx')
      })
    })
  },
  mounted () {
  }
}
</script>
<style>
</style>
