<template>
  <div>
    <a-button type="primary"
              @click="add">
      Add Bridge
    </a-button>
    <a-table :columns="columns"
             :data-source="records"
             :rowKey="records=>records.id">
      <template slot="name"
                slot-scope="text">{{ text }}</template>
      <!-- <a-icon type="smile-o" /> -->
      <span slot="customTitle">Bridge ID</span>
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
          <a-button type="primary"
                    @click="showModal">
            See it in map
          </a-button>
          <a-modal title="Maps"
                   :visible="visible"
                   :confirm-loading="confirmLoading"
                   :footer="null"
                   :centered="true"
                   @ok="handleOk"
                    @cancel="handleCancel">
            <maps></maps>
          </a-modal>
        <!-- <a-divider type="vertical" />
      <a @click="getRecords">Refresh</a>
      <a-divider type="vertical" />
      <a class="ant-dropdown-link"> More actions <a-icon type="down" /> </a> -->
      </template>
    </a-table>
  </div>
</template>
<script>
import maps from './maps.vue'

const columns = [
  // {
  //   dataIndex: 'id',
  //   key: 'id',
  //   slots: { title: 'customTitle' },
  //   scopedSlots: { customRender: 'name' }
  // },
  {
    title: 'Name',
    dataIndex: 'name',
    key: 'name'
  },
  {
    title: 'Type',
    dataIndex: 'type',
    key: 'type'
  },
  {
    title: 'Location',
    dataIndex: 'location',
    key: 'location'
  },
  {
    title: 'Risk Status (1-10)',
    dataIndex: 'status',
    key: 'status'
  },
  {
    title: 'Build Date',
    dataIndex: 'date',
    key: 'date'
  },
  // {
  //   title: 'Reserved',
  //   dataIndex: 'reserved',
  //   key: 'reserved'
  // },
  {
    title: 'Description',
    dataIndex: 'description',
    key: 'description'
  },
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
    key: '',
    id: '',
    temperature: '',
    humidity: '',
    air_pressure: '',
    time: '',
    risk_level: '',
    acc: ''
  }
]

export default {
  components: { maps },
  data () {
    return {
      records,
      columns,
      info: null,
      humiTure: [],
      ModalText: 'Content of the modal',
      visible: false,
      confirmLoading: false
    }
  },
  methods: {
    showModal () {
      this.visible = true
    },
    handleOk (e) {
      this.visible = false
    },
    handleCancel (e) {
      this.visible = false
    },
    add () {
      this.$router.push('/addbridge')
    },
    getRecords () {
      this.$axios.post('/api/bridge/listBridge', {}).then(({ data }) => {
        for (var i = 0; i < data.data.bridges.length; i++) {
          data.data.bridges[i].date = data.data.bridges[i].date.substring(0, 10)
        }
        // console.log(data.data.bridges[0])
        this.records = data.data.bridges
      })
    },
    onDelete (key) {
      // console.log(key)
      this.$axios.post('/api/bridge/removeBridge', { 'id': key }).then(({ data }) => {
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
