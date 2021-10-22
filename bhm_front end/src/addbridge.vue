<template>
  <a-form :form="form"
          :label-col="{ span: 5 }"
          :wrapper-col="{ span: 12 }"
          @submit="handleSubmit">
    <a-form-item label="Bridge name">
      <a-input placeholder="Please input the bridge name" v-decorator="['name', { rules: [{ required: true, message: 'Please input Bridge name!' }] }]" />
    </a-form-item>
    <a-form-item label="Type">
      <a-input placeholder="Please input the bridge type (e.g. large)" v-decorator="['type', { rules: [{ required: false}] }]" />
    </a-form-item>
    <a-form-item label="Location">
      <a-input placeholder="Please input the location (e.g. 115°49’E:31°58’N)" v-decorator="['location', { rules: [{ required: false}] }]" />
    </a-form-item>
    <a-form-item label="Risk status">
      <a-input placeholder="Please rate the risk status from 1 to 10 (10 is the highest risk)" v-decorator="['status', { rules: [{ required: false}] }]" />
    </a-form-item>
        <a-form-item label="Date">
      <a-input placeholder="Please input the bulid date of the bridge (e.g. 2021-08-01)" v-decorator="['date', { rules: [{ required: false}] }]" />
    </a-form-item>
                <a-form-item label="Description">
      <a-input placeholder="Please input the description of the bridge" v-decorator="['description', { rules: [{ required: false}] }]" />
    </a-form-item>
    <a-form-item :wrapper-col="{ span: 12, offset: 5 }">
      <a-button type="primary"
                html-type="submit">
        Submit
      </a-button>
    </a-form-item>
  </a-form>
</template>

<script>
export default {
  data () {
    return {
      formLayout: 'horizontal',
      form: this.$form.createForm(this, { name: 'coordinated' })
    }
  },
  methods: {
    handleSubmit (e) {
      e.preventDefault()
      this.form.validateFields((err, values) => {
        if (!err) {
          // console.log('Received values of form: ', values)
          this.$axios.post('/api/bridge/addBridge', {
            'name': values.name,
            'type': values.type,
            'location': values.location,
            'status': values.status,
            'date': values.date,
            'description': values.description
          }).then(({
            data }) => {
            console.log(data)
            if (data.data.isCreateSuccess === 1) {
              this.$message.success('Add successful!', 2, () => {
                this.$router.push('/bridgeinfo')
              })
            }
          })
        }
      })
    }
    // handleSelectChange (value) {
    //   console.log(value)
    //   this.form.setFieldsValue({
    //     note: `Hi, ${value === 'male' ? 'man' : 'lady'}!`
    //   })
    // }
  }
}
</script>
