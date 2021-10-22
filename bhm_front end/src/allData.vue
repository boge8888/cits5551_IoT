<template>
  <a-table :columns="columns" :data-source="records">
    <a slot="name" slot-scope="text">{{ text }}</a>
    <span slot="customTitle"><a-icon type="smile-o" /> Id</span>
    <span slot="tags" slot-scope="tags">
      <a-tag
        v-for="tag in tags"
        :key="tag"
        :color="risk_level === 0 ? 'volcano' : risk_level > 1 ? 'geekblue' : 'green'"
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
    title: 'Pressure',
    dataIndex: 'pressure',
    key: 'pressure'
  },
  {
    title: 'Time',
    dataIndex: 'time',
    key: 'time'
  },
  /* {
    title: 'Level',
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
    pressure: '',
    time: ''
    // tags: ['nice', 'developer']
  }
]

export default {
  data () {
    return {
      records,
      columns,
      info: null,
      humiTure: []
    }
  },
  methods: {
    getRecords () {
      console.log('点击了')
      this.$axios.post('/api/data/getalldata', {}).then(({data}) => {
        console.log(data.data.data)
        this.records = data.data.data
        console.log(records)
      })
    },
    sendAlert () {
      console.log('预警了')
      this.$axios.post('/api/alert/sendalert', {id: 1}).then(({data}) => {
        console.log(data)
      })
    }
  },
  created () {
    this.getRecords()
  }
}
</script>
