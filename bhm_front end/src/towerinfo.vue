<template>
<div>
  <a-button type="primary"
              @click="showHighrisk">
      Show High Risk Records
    </a-button>
<a-table :columns="columns" :data-source="records">
    <a slot="name" slot-scope="text">{{ text }}</a>
    <span slot="customTitle"><a-icon type="smile-o" /> ID</span>
    <span slot="tags" slot-scope="tags">
      <a-tag
        v-for="tag in tags"
        :key="tag"
        :color="tag === 'loser' ? 'volcano' : tag.length > 5 ? 'geekblue' : 'green'"
      >
        {{ tag.toUpperCase() }}
      </a-tag>
    </span>
     <template slot="action"
                slot-scope="text, record">
        <a-popconfirm v-if="records.length"
                      title="Sure to delete?"
                      @confirm="() => onDelete(record.id)">
          <a-button type="danger">
            Delete
          </a-button>
        </a-popconfirm>
        <!-- <a-divider type="vertical" />
      <a @click="getRecords">Refresh</a>
      <a-divider type="vertical" />
      <a class="ant-dropdown-link"> More actions <a-icon type="down" /> </a> -->
      </template>
  </a-table>
</div>
</template>
<script>
const columns = [
  {
    dataIndex: 'id',
    key: 'id',
    slots: { title: 'customTitle' },
    scopedSlots: { customRender: 'name' }
  },
  {
    title: 'Time',
    dataIndex: 'time',
    key: 'time'
  },
  /* {
    title: 'Temperature',
    dataIndex: 'temperature',
    key: 'temperature'
  },
  {
    title: 'Humidity',
    dataIndex: 'humidity',
    key: 'humidity'
  },
  {
    title: 'Air Pressure',
    dataIndex: 'air_pressure',
    key: 'air_pressure'
  }, */
  {
    title: 'Tilter_aline',
    dataIndex: 'tilter_aline',
    key: 'tilter_aline'
  },
  {
    title: 'Tilter_vertical',
    dataIndex: 'tilter_vertical',
    key: 'tilter_vertical'
  },
  {
    title: 'Risk_level',
    dataIndex: 'risk_level',
    key: 'risk_level'
  },
  /* {
    title: 'Tags',
    key: 'tags',
    dataIndex: 'tags',
    scopedSlots: { customRender: 'tags' }
  }, */
  {
    title: 'Action',
    key: 'action',
    scopedSlots: { customRender: 'action' }
  }
]

var records = [
  {
    key: '',
    id: '',
    temperature: '',
    humidity: '',
    air_pressure: '',
    time: '',
    risk_level: '',
    acc: ''
    // tags: ['nice', 'developer']
  }
]

var highriskdata = []

export default {
  data () {
    return {
      records,
      columns,
      highriskdata,
      info: null,
      humiTure: []
    }
  },
  methods: {
    getRecords () {
      console.log('点击了')
      this.$axios.post('/api/data/getalltowerdata', {}).then(({data}) => {
        this.records = data.data.bridgetowerdata
      })
    },
    showHighrisk () {
      console.log('展示数据')
      this.$axios.post('/api/data/getalltowerdata', {}).then(({data}) => {
        for (var i = 0; i < data.data.bridgetowerdata.length; i++) {
          if (data.data.bridgetowerdata[i].risk_level >= 0) { // Risk Threshold
            this.highriskdata.push(data.data.bridgetowerdata[i])
          }
        }
        console.log(this.highriskdata)
        this.records = highriskdata
      })
    }
  },
  created () {
    this.getRecords()
  }
}
</script>
