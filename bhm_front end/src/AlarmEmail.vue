<template>
  <a-form :layout="formLayout">
    <a-form-item
      label="Email Address"
      :label-col="formItemLayout.labelCol"
      :wrapper-col="formItemLayout.wrapperCol"
    >
      <!-- <a-radio-group default-value="horizontal" @change="handleFormLayoutChange"> -->
     <a-radio-group default-value="horizontal">
      </a-radio-group>
      <a-input v-model="emailInfo.emailaddress" placeholder="Input user's Email Address" />
    </a-form-item>
    <a-form-item
      label="Email Subject"
      :label-col="formItemLayout.labelCol"
      :wrapper-col="formItemLayout.wrapperCol"
    >
      <a-input v-model="emailInfo.emailsubject" placeholder="Input Email Subject" />
    </a-form-item>
    <a-form-item
      label="Description"
      :label-col="formItemLayout.labelCol"
      :wrapper-col="formItemLayout.wrapperCol"
    >
      <a-input v-model="emailInfo.description" placeholder="Input some description of bridge health situation" />
    </a-form-item>
    <a-form-item :wrapper-col="buttonItemLayout.wrapperCol">
      <a-button @click="sendAlert" type="primary">
        Send Alert
      </a-button>
    </a-form-item>
  </a-form>
</template>

<script>
export default {
  data () {
    return {
      formLayout: 'horizontal',
      emailInfo: {
        emailaddress: '',
        emailsubject: '',
        description: ''
      }

    }
  },
  computed: {
    formItemLayout () {
      const { formLayout } = this
      return formLayout === 'horizontal'
        ? {
          labelCol: { span: 4 },
          wrapperCol: { span: 14 }
        }
        : {}
    },
    buttonItemLayout () {
      const { formLayout } = this
      return formLayout === 'horizontal'
        ? {
          wrapperCol: { span: 14, offset: 4 }
        }
        : {}
    }
  },
  methods: {
    handleFormLayoutChange (e) {
      this.formLayout = e.target.value
    },
    sendAlert () {
      console.log('预警了')
      this.$axios.post('/api/alert/sendspecifiedalert', {'to': this.emailInfo.emailaddress,
        'subject': this.emailInfo.emailsubject,
        'text': this.emailInfo.description}).then(({data}) => {
        console.log(data)
      })
    }
  }
}
</script>
