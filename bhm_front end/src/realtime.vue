<template>
  <a-table :columns="columns" :data-source="records">
    <a slot="name" slot-scope="text">{{ text }}</a>
    <span slot="customTitle"><a-icon type="smile-o" /> Id</span>
    <span slot="tags" slot-scope="tags">
      <a-tag
        v-for="tag in tags"
        :key="tag"
        :color="tag === 'loser' ? 'volcano' : tag.length > 5 ? 'geekblue' : 'green'"
      >
        {{ tag.toUpperCase() }}
      </a-tag>
    </span>
    <span slot="action" slot-scope="text, record">
      <a>Add {{ record.name }}</a>
      <a-divider type="vertical" />
      <a @click="getRecords">Refresh</a>
      <a-divider type="vertical" />
      <a class="ant-dropdown-link"> More actions <a-icon type="down" /> </a>
    </span>
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
  {
    title: 'Tags',
    key: 'tags',
    dataIndex: 'tags',
    scopedSlots: { customRender: 'tags' }
  },
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
      this.$axios.post('/api/data/gettendata', {}).then(({data}) => {
        console.log(data.data.data)
        this.records = data.data.data
        console.log(records)
      })
    }
  }
}
</script>
