<template>
  <a-table :columns="columns" :data-source="records">
    <a slot="name" slot-scope="text">{{ text }}</a>
    <span slot="customTitle"><a-icon type="smile-o" />User ID</span>
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
    title: 'Name',
    dataIndex: 'name',
    key: 'name'
  },
  {
    title: 'Phone Number',
    dataIndex: 'phone',
    key: 'phone'
  },
  {
    title: 'Address',
    dataIndex: 'address',
    key: 'address'
  },
  {
    title: 'Organisation',
    dataIndex: 'organisation',
    key: 'organisation'
  },
  {
    title: 'Email',
    dataIndex: 'email',
    key: 'email'
  },
  {
    title: 'Role',
    dataIndex: 'role',
    key: 'role'
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
    key: '1',
    id: '1',
    name: 'Hao',
    phone: '+86 13579',
    address: 'Western Australia',
    organisation: 'UWA',
    email: 'test@uwa.edu.au',
    role: 'Head of department',
    status: 'Good',
    description: ''
    // tags: ['nice', 'developer']
  },
  {
    key: '2',
    id: '2',
    name: 'Yonghui',
    phone: '+86 02468',
    address: 'Western Australia',
    organisation: 'UWA',
    email: 'test2@uwa.edu.au',
    role: 'Head of school',
    status: 'Good',
    description: ''
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
      this.$axios.post('/api/bridge/listBridge', {}).then(({data}) => {
        console.log(data.data.bridges)
        this.records = data.data.bridges
      })
    }
  }
}
</script>
