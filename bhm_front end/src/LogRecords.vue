<template>
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
    title: 'Bridge_id',
    dataIndex: 'bridge_id',
    key: 'bridge_id'
  },
  {
    title: 'Device_id',
    dataIndex: 'device_id',
    key: 'device_id'
  },
  {
    title: 'Degree',
    dataIndex: 'degree',
    key: 'degree'
  },
  {
    title: 'Parameter',
    dataIndex: 'parameter',
    key: 'parameter'
  },
  {
    title: 'Date',
    dataIndex: 'date',
    key: 'date'
  },
  {
    title: 'Timestamp',
    dataIndex: 'timestamp',
    key: 'timestamp'
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
    air_pressure: '',
    time: '',
    risk_level: '',
    acc: ''
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
      this.$axios.post('/api/log/listLog', {}).then(({data}) => {
        console.log(data.data.logs)
        this.records = data.data.logs
      })
    }
  },
  created () {
    this.getRecords()
  }
}
</script>
