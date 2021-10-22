<template>
  <a-form :form="form"
          :label-col="{ span: 5 }"
          :wrapper-col="{ span: 12 }"
          @submit="handleSubmit">
    <a-form-item label="Bridge ID">
      <a-input placeholder="Please input the Bridge ID"
               v-decorator="['bridge_id', { rules: [{ required: true, message: 'Please input Bridge ID!' }] }]" />
    </a-form-item>

    <a-form-item label="Bridge name">
      <a-input placeholder="Please input the bridge name (e.g. UWA bridge)"
               v-decorator="['name', { rules: [{ required: true, message: 'Please input Bridge name!' }] }]" />
    </a-form-item>

    <a-form-item label="Type">
      <a-input placeholder="Please input the device type(e.g. raspberry pi 4b)"
               v-decorator="['type', { rules: [{ required: false}] }]" />
    </a-form-item>

    <a-form-item label="Deployment date">
      <a-input placeholder="Please input the deployment date (e.g. 2011-08-01)"
               v-decorator="['date', { rules: [{ required: false}] }]" />
    </a-form-item>

    <a-form-item label="Location">
      <a-input placeholder="Please input the location (e.g. UWA campus)"
               v-decorator="['location', { rules: [{ required: false}] }]" />
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
          this.$axios.post('/api/device/addDevice', {
            'bridge_id': values.bridge_id,
            'user_id': 1,
            'bridge': values.name,
            'type': values.type,
            'date': values.date,
            'location': values.location,
            'status': 1
          }).then(({
            data }) => {
            console.log(data)
            if (data.data.isCreateSuccess === 1) {
              this.$message.success('Add successful!', 2, () => {
                this.$router.push('/deviceinfo')
              })
            }
          }
          )
        }
      })
    }
  }
}

</script>
