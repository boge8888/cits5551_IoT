<template>
  <div>
    <a-button type="primary"
              @click="add">
      Add device
    </a-button>
    <a-table :columns="columns"
             :data-source="records"
             :rowKey="records=>records.id">
      <a slot="name"
         slot-scope="text">{{ text }}</a>
      <!-- <a-icon type="smile-o" /> -->
      <span slot="customTitle"> Device ID</span>
      <span slot="tags"
            slot-scope="tags">
        <a-tag v-for="tag in tags"
               :key="tag"
               :color="tag === 'loser' ? 'volcano' : tag.length > 5 ? 'geekblue' : 'green'">
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
  // {
  //   dataIndex: 'id',
  //   key: 'id',
  //   slots: { title: 'customTitle' },
  //   scopedSlots: { customRender: 'name' }
  // },
  {
    title: 'Device_id',
    dataIndex: 'id',
    key: 'id'
  },
  {
    title: 'Type',
    dataIndex: 'type',
    key: 'type'
  },
  {
    title: 'Deployment Date',
    dataIndex: 'date',
    key: 'date'
  },
  {
    title: 'Location',
    dataIndex: 'location',
    key: 'location'
  },
  {
    title: 'Bridge',
    dataIndex: 'bridge',
    key: 'bridge'
  },
  {
    title: 'Running Status',
    dataIndex: 'status',
    key: 'status'
  },
  // {
  //   title: 'Reserved',
  //   dataIndex: 'reserved',
  //   key: 'reserved'
  // },
  // {
  //   title: 'Tags',
  //   key: 'tags',
  //   dataIndex: 'tags',
  //   scopedSlots: { customRender: 'tags' }
  // },
  {
    title: 'Action',
    key: 'action',
    scopedSlots: { customRender: 'action' }
  }
]

var records = [
  {
    // key: '',
    // id: '001',
    // CPUutilisation: '47%',
    // cores: '4',
    // memory: '5.2GB/8GB',
    // responsetime: '2021-10-07 11:41:57'
    id: '',
    type: '',
    date: '',
    location: '',
    bridge_id: '',
    bridge: '',
    user_id: '',
    status: '',
    reserved: ''
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
    add () {
      this.$router.push('/adddevice')
    },
    getRecords () {
      this.$axios.post('/api/device/listDevice', {}).then(({ data }) => {
        for (var i = 0; i < data.data.devices.length; i++) {
          data.data.devices[i].date = data.data.devices[i].date.substring(0, 10)
          if (data.data.devices[i].status === 3) {
            data.data.devices[i].status = 'Starting up'
          } else if (data.data.devices[i].status === 2) {
            data.data.devices[i].status = 'Shutdown'
          } else {
            data.data.devices[i].status = 'Running'
          }
        }
        this.records = data.data.devices
      })
    },
    onDelete (key) {
      // console.log(key)
      this.$axios.post('/api/device/removeDevice', { 'id': key }).then(({ data }) => {
        if (data.data.isDeleteSuccess === 1) {
          this.$message.success('Delete successful!', 2, () => {
            this.getRecords()
          })
        }
      })
    }
  },
  created () {
    this.getRecords()
  }
}
</script>
