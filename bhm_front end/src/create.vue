<template>
  <div class="_452c3ec4 d68c66a8">
    <div>
      <ul class="cf325dbd list ma0 pa0 tr z-999"
          aria-live="polite"></ul>
    </div>
    <div class="_75ce47e7">
      <main id="main">
        <header><a></a></header>
        <div class="_94d452dc">
          <section class="_2b1f4808 bg-white br3">
            <div class="_66e908c6">

              <form id="login"
                    class="ma0">
                <h1 class="aa630ec5 f3 fw6 pb3 pt0 mt0 mb3 black-70 b--black-10 bb">Create account</h1>
                <div class=" "><label class="_64c2ccaf db mt1 mb2 f5 fw6 black-90 nowrap "
                         for="login_username">Username</label><input type="text"
                         v-model="registerInfo.username"
                         id="login_username"
                         class="_425fdea4 relative w-100 ma2 ml0 pv3 pl2 pr2 br2 black-70 ba b--black-10  "
                         name="username"
                         placeholder=""
                         element="input"
                         value="">
                </div>
                <div class=" "><label class="_64c2ccaf db mt1 mb2 f5 fw6 black-90 nowrap "
                         for="login_password">Password</label><input type="password"
                         v-model="registerInfo.password"
                         id="login_password"
                         required=""
                         minlength="0"
                         class="_425fdea4 relative w-100 ma2 ml0 pv3 pl2 pr2 br2 black-70 ba b--black-10  "
                         name="password"
                         placeholder=""
                         element="input"
                         value="">
                </div>
                <div class=" "><label class="_64c2ccaf db mt1 mb2 f5 fw6 black-90 nowrap "
                         for="login_username">Phone</label><input type="text"
                         v-model="registerInfo.phone"
                         id="login_username"
                         class="_425fdea4 relative w-100 ma2 ml0 pv3 pl2 pr2 br2 black-70 ba b--black-10  "
                         name="username"
                         placeholder=""
                         element="input"
                         value="">
                </div>

                <div class=" "><label class="_64c2ccaf db mt1 mb2 f5 fw6 black-90 nowrap "
                         for="login_username">Address</label><input type="text"
                         v-model="registerInfo.address"
                         id="login_username"
                         class="_425fdea4 relative w-100 ma2 ml0 pv3 pl2 pr2 br2 black-70 ba b--black-10  "
                         name="username"
                         placeholder=""
                         element="input"
                         value="">
                </div>

                <div class=" "><label class="_64c2ccaf db mt1 mb2 f5 fw6 black-90 nowrap "
                         for="login_username">Organization</label><input type="text"
                         v-model="registerInfo.organization"
                         id="login_username"
                         class="_425fdea4 relative w-100 ma2 ml0 pv3 pl2 pr2 br2 black-70 ba b--black-10  "
                         name="username"
                         placeholder=""
                         element="input"
                         value="">
                </div>
                <div class=" "><label class="_64c2ccaf db mt1 mb2 f5 fw6 black-90 nowrap "
                         for="login_username">Email</label><input type="text"
                         v-model="registerInfo.email"
                         id="login_username"
                         class="_425fdea4 relative w-100 ma2 ml0 pv3 pl2 pr2 br2 black-70 ba b--black-10  "
                         name="username"
                         placeholder=""
                         element="input"
                         value="">
                </div>
                <input type="hidden"
                       name="csrftoken"
                       value="lC9InYxUa-9enP0NR-7kPKCFZLbVuJMM_Sk3oazB79t"><button type="button"
                        @click="register"
                        class="_24a1e9c7 dab9924c br2 pv2 ph3 fw5 f5 tc button button-reset pointer ma2 truncate ml0 no-underline e64d5a00 w-100"
                        title="Submit">Register</button>
              </form>
            </div>
          </section>
        </div>
      </main>
    </div>
    <div class="_8a62ca63 fixed top-0 left-0 z-999"
         style="opacity:0;transform:scaleX(1);-webkit-transform:scaleX(1);-moz-transform:scaleX(1)"></div>
  </div>
</template>

<script>
import '@/assets/login.css'
export default {
  data () {
    return {
      registerInfo: {
        username: '',
        password: '',
        phone: '',
        address: '',
        organization: '',
        email: ''
      }
    }
  },
  methods: {
    register () {
      console.log('click register')
      this.$axios.post('/api/user/register', {
        'name': this.registerInfo.username,
        'password': this.registerInfo.password,
        'phone': this.registerInfo.phone,
        'address': this.registerInfo.address,
        'organization': this.registerInfo.organization,
        'email': this.registerInfo.email

      }).then(({ data }) => {
        console.log(data)
        if (data.data.isRegisterSuccess === 1) {
          this.$message.success('Register successful!', 2, () => {
            this.$router.push('/')
          }
          )
        }
      }).catch(() => {
        this.$message.warning('The user information has been registered!')
      })
    }
  }
}

</script>

<style>
</style>
