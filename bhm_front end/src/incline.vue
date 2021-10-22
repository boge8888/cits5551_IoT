<template>
<div id="Incline" style="width: 100%;height: 400px;">
</div>
</template>
<script>
import * as echarts from 'echarts'
export default {
  name: 'Incline',
  data () {
    return {
      charts: '',
      opinionData: [''],
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
          data: ['Incline of Tower']
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
          name: 'Incline of Tower',
          type: 'line',
          stack: '总量',
          data: this.opinionData
        }]
      })
    }
  },
  beforeMount () {
    this.$nextTick(function () {
      this.$axios.post('/api/data/getalltowerdata', {}).then(({data}) => {
        for (let i = 0; i < 100; i++) {
          this.opinionData[i] = data.data.bridgetowerdata[i].tilter_aline.toString()
          this.axisdata[i] = data.data.bridgetowerdata[i].time.toString()
        }
        /* this.opinionData[0] = data.data.bridgetowerdata[0].tilter_aline.toString()
        this.opinionData[1] = data.data.bridgetowerdata[1].tilter_aline.toString()
        this.opinionData[2] = data.data.bridgetowerdata[2].tilter_aline.toString()
        this.opinionData[3] = data.data.bridgetowerdata[3].tilter_aline.toString()
        this.opinionData[4] = data.data.bridgetowerdata[4].tilter_aline.toString()
        this.opinionData[5] = data.data.bridgetowerdata[5].tilter_aline.toString()
        this.opinionData[6] = data.data.bridgetowerdata[6].tilter_aline.toString()
        this.opinionData[7] = data.data.bridgetowerdata[7].tilter_aline.toString()
        this.opinionData[8] = data.data.bridgetowerdata[8].tilter_aline.toString()
        this.opinionData[9] = data.data.bridgetowerdata[9].tilter_aline.toString()
        this.opinionData[10] = data.data.bridgetowerdata[10].tilter_aline.toString()
        this.opinionData[11] = data.data.bridgetowerdata[11].tilter_aline.toString()
        this.opinionData[12] = data.data.bridgetowerdata[12].tilter_aline.toString()
        this.opinionData[13] = data.data.bridgetowerdata[13].tilter_aline.toString()
        this.opinionData[14] = data.data.bridgetowerdata[14].tilter_aline.toString()

        this.axisdata[0] = data.data.bridgetowerdata[0].time.toString()
        this.axisdata[1] = data.data.bridgetowerdata[1].time.toString()
        this.axisdata[2] = data.data.bridgetowerdata[2].time.toString()
        this.axisdata[3] = data.data.bridgetowerdata[3].time.toString()
        this.axisdata[4] = data.data.bridgetowerdata[4].time.toString()
        this.axisdata[5] = data.data.bridgetowerdata[5].time.toString()
        this.axisdata[6] = data.data.bridgetowerdata[6].time.toString()
        this.axisdata[7] = data.data.bridgetowerdata[7].time.toString()
        this.axisdata[8] = data.data.bridgetowerdata[8].time.toString()
        this.axisdata[9] = data.data.bridgetowerdata[9].time.toString()
        this.axisdata[10] = data.data.bridgetowerdata[10].time.toString()
        this.axisdata[11] = data.data.bridgetowerdata[11].time.toString()
        this.axisdata[12] = data.data.bridgetowerdata[12].time.toString()
        this.axisdata[13] = data.data.bridgetowerdata[13].time.toString()
        this.axisdata[14] = data.data.bridgetowerdata[14].time.toString() */

        console.log(this.opinionData)

        this.drawLine('Incline')
      })
    })
  },
  mounted () {
    // this.drawLine('Incline')
  }
}
</script>
<style>
</style>
