<template>
  <div id="confirm_m">
    <van-nav-bar title="信息确认" left-text="上一步"  left-arrow right-arrow
    @click-left="onClickLeft" />
    <van-skeleton title :row="20" v-if="loading" style="margin:10px"/>
    <van-form @submit="onSubmit"  v-if="!loading">
      <!-- 是否曾参加非法集会？ -->
      <van-field name="unlawful" label="是否曾参加非法集会？" label-width="14.5rem" input-align="right"   :value="basicinfo.unlawful" :rules="rules.unlawful">
        <van-radio-group v-model="basicinfo.unlawful" direction="horizontal" slot="input">
          <van-radio name="0">无</van-radio>
          <van-radio name="1">有</van-radio>
        </van-radio-group>
      </van-field>
      <!-- 期望待遇 -->
      <van-field label-width="6rem" v-model="basicinfo.expectedSalary" name="expectedSalary" label="期望待遇(税前)" placeholder="" :rules="rules.expectedSalary"/>
      <!-- 到职日期 -->
      <van-field label-width="6rem" readonly clickable name="regDate" :value="basicinfo.regDate" label="到职日期" placeholder="点击选择日期" @click="showCalendar = true" :formatter="formatter" :rules="rules.regDate"   />
      <van-calendar v-model="showCalendar" @confirm="onConfirm" :show-confirm="false" />
      <!-- 是否住宿？ -->
      <van-field name="dormFlag" label="是否住宿？" label-width="14.5rem" input-align="right"  :value="basicinfo.dormFlag" :rules="rules.dormFlag">
        <van-radio-group v-model="basicinfo.dormFlag" direction="horizontal" slot="input">
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
      <van-notice-bar wrapable :scrollable="false">
        ※本人所填列表均属确实,如有虚假，个人愿意承担所有法律责任并接受公司处理包括但不限于辞退及个人承担所有法律责任。
        <br/>   All the information that I fill in is true, and I agree to have it checked. If there is anything concoctive, I'll accept dismission without any supplementary conditions at any time.
      </van-notice-bar>
      <!--  确认并提交 -->
      <div style="margin: 16px;">
          <van-button round block type="info" native-type="submit">
            确认并提交
          </van-button>
      </div>
    </van-form>
  </div>
</template>
<script>
import dateUtil from '@/utils/DateUtil.js'
export default {
  name: 'confirm_m',
  data () {
    return {
      loading: true,
      basicinfo: {
        unlawful: '',
        expectedSalary: '',
        regDate: '',
        dormFlag: ''
      },
      showCalendar: false,
      submitFlag: false,
      rules: {
        unlawful: [
          { required: true, message: '请确认该问题' }
        ],
        expectedSalary: [
          { required: true, message: '请填写期望薪资' }
        ],
        regDate: [
          { required: true, message: '请选择可入职日期' }
        ],
        dormFlag: [
          { required: true, message: '请选择是否入住宿舍' }
        ]
      }
    }
  },
  computed: {

  },
  mounted () {
    this.$axios.post('/getInterviewer', {
      interviewerID: this.$store.state.interviewerID
    }).then(sr => {
      if (sr.data.code === 200) {
        this.basicinfo = sr.data.data
        // 日期格式处理
        for (var key in this.basicinfo) {
          if (key.indexOf('Date') > -1) {
            this.basicinfo[key] = this.basicinfo[key].substring(0, 10)
          }
        }
        this.loading = false
      } else {
        this.$toast('获取用户信息失败')
      }
    }).catch()
  },
  watch: {
  },
  methods: {
    onClickLeft () {
      this.$router.go(-1)
    },
    onSubmit () {
      if (this.submitFlag) return
      this.submitFlag = true
      this.$dialog.confirm({
        title: '确认提交',
        message: '提交后将无法修改，是否继续提交'
      }).then(() => {
        // 保存数据
        this.$axios.post('/saveInterviewer', {
          interviewer: this.basicinfo
        }).then(sr => {
          if (sr.data.code === 200) {
            // this.$router.push('m_fam')
            this.$toast.success('提交成功')
            this.submitFlag = false
          } else {
            this.$toast.fail('信息保存失败，请稍后再试')
          }
        }).catch(fail => {
        })
      }).catch()
    },
    onConfirm (date) {
      this.basicinfo.regDate = dateUtil.toDate(date)
      this.showCalendar = false
    }
  }
}
</script>
<style>
</style>
