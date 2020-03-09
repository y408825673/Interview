<template>
  <div id="login">
  <img class="logo" src="./ivo.png" />
    <div class="content">
      <van-form  @submit="onSubmit">
        <div class="user">
        <van-field  left-icon="user-circle-o" v-model="idNumber" placeholder="身份证号" type="text" :rules="rules.idNumberRule"/>
        </div>
        <br/>
        <van-button block type="info" size="small" native-type="submit" >登陆/注册</van-button>
      </van-form>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      idNumber: '',
      rules: {
        idNumberRule: [
          { required: true, message: '请输入身份证号' },
          { validator: this.idNumberValidate, message: '身份号格式错误' }
        ]
      }
    }
  },
  beforeCreate () {
    document.querySelector('body').setAttribute('style', 'background:#3895e8')
  },
  beforeDestroy () {
    document.querySelector('body').setAttribute('style', '')
  },
  methods: {
    idNumberValidate (val) {
      return /^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/.test(val)
    },
    onSubmit () {
      // 读取/创建个人信息，并把登陆人存入vuex
      this.$axios
        .post('/itvLogin', {
          idNumber: this.idNumber
        })
        .then(sr => {
          if (sr.data.code === 200) {
            let itvID = sr.data.data.interviewerID
            this.$store.dispatch('updateInterviewerID', itvID)
            // 跳转到新的页面
            this.$router.push('/m_bi')
          } else {
            this.$toast.fail('登陆/注册失败')
          }
        })
        .catch(fail => {
          this.$toast.fail('网络出现异常')
        })
    }
  }
}
</script>
<style>
  .content {
    width: 80%;
    height: 9.5rem;
    background-color: #ffffff;
    border-radius: 0.625rem;
    margin-left: -45%;
    margin-top: -6rem;
    position: absolute;
    left: 50%;
    top:27rem;
    padding: 1.25rem;
  }
  .user {
    border: 2px dashed black;
    border-radius: 0.625rem;
  }
  .logo {
    position: absolute;
    margin-left:-3.75rem ;
    left: 50%;
    top:16rem;
  }

</style>
