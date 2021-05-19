


Vue.prototype.$echarts = echarts

var app = new Vue({
  el: '#app',
  data: {
    table_list: ["temperature","humidity","pressure","time","acc_x","acc_y","acc_z"],
    message: 'Hello Vue!',
    tableData: [{"temperature":1,"humidity":1,"pressure":1,"time":1,"acc_x":1,"acc_y":1,"acc_z":1} ],
    sub_page:[-1],
    

  }
  ,
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },

    switch_page(num)
    {
      this.$set(this.sub_page,0,num-2)
      console.log(this.sub_page[0])
      if (num!=1)
        this.draw_chart()
    },

    get_data()
    {
      // `this` 指向 vm 实例
      let url = "api";//这里我用了个代理，其实就是博哥那个ip地址
      axios.post(url,{}).then(response=> {
        //console.log(response)
        //this.message = response
        var All_data=response["data"]
        
        for (var i=0;i<All_data.length;i++)
        { 
          var data={};
          
          for (var j =0; j<this.table_list.length;j++)
          {
            if (this.table_list[j]!="time")
              data[this.table_list[j]]=All_data[i][this.table_list[j]]
            else
              {
                var CrDate = new Date();
                CrDate.setTime(All_data[i][this.table_list[j]]*1000);
                var createDate = CrDate.toLocaleString('en-US');
                data[this.table_list[j]]=createDate
              }
  
          }
          this.$set(this.tableData,i,data)
        }
        
      })
    },
  
    draw_chart()
    {


      this.$echart
      console.log(option)
      myChart.setOption(option)

    },
    warning()
    {
      if (this.tableData[0]["pressure"]>1050)
      {
        alert("Warning!!!!!!Pressure unusal")
      }
    }







  },
  mounted() {
    setInterval(this.get_data, 1000);
    setInterval(this.warning, 1000);
    //setInterval(this.draw_chart,1000);
  },
  created: function () {
    this.get_data()
  }



})







