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
        :color="tag === '0' ? 'volcano' : tag > 1 ? 'geekblue' : 'green'"
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
  {
    title: 'Acceleration',
    dataIndex: 'acc',
    key: 'acc'
  },
  {
    title: 'Risk Level',
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
      console.log('获取cable数据')
      this.$axios.post('/api/data/getallcabledata', {}).then(({data}) => {
        this.records = data.data.bridgecabledata
      })
    },
    showHighrisk () {
      console.log('展示数据')
      this.$axios.post('/api/data/getallcabledata', {}).then(({data}) => {
        for (var i = 0; i < data.data.bridgecabledata.length; i++) {
          if (data.data.bridgecabledata[i].risk_level >= 3) {
            this.highriskdata.push(data.data.bridgecabledata[i])
            /* this.highriskdata[this.jidx] = data.data.bridgecabledata[i]
            this.jidx++ */
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
