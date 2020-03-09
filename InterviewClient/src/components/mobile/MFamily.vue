<template>
  <div id="fam_m">
    <van-nav-bar title="家庭情况" left-text="上一步"  left-arrow right-arrow
    @click-left="onClickLeft" />
    <van-skeleton title :row="20" v-if="loading" style="margin:10px"/>
    <!-- 婚姻 -->
    <van-field name="marriageStatus" label="婚姻" v-if="!loading">
      <van-radio-group v-model="basicinfo.marriageStatus" direction="horizontal" slot="input">
        <van-radio name="0">未婚</van-radio>
        <van-radio name="1">已婚</van-radio>
      </van-radio-group>
    </van-field>
    <van-form @submit="onSubmit"  v-if="!loading">
      <div v-for="(item,index) in basicinfo.relativeList" :key="index">
      <!-- 称谓 -->
      <van-field v-model="item.relationship" name="relationship" readonly label="称谓" :rules="rules.relationship" />
      <!-- 姓名 -->
      <van-field v-model="item.name" name="name" label="姓名" placeholder="请输入姓名" :rules="rules.name"/>
      <!-- 年龄 -->
      <van-field v-model="item.age" name="age" label="年龄" placeholder="请输入年龄" :rules="rules.age"/>
      <!-- 职业 -->
      <van-field v-model="item.job" name="job" label="职业" placeholder="请输入职业" :rules="rules.job"/>
      <!-- 工作单位 -->
      <van-field v-model="item.workplace" name="workplace" label="工作单位" placeholder="请输入工作单位" :rules="rules.workplace"/>
      <!-- 家庭地址 -->
      <van-field v-model="item.homeAddress" rows="1" autosize label="家庭地址" type="textarea" placeholder="请输入家庭地址"  :rules="rules.homeAddress"/>
      <!-- 联系电话 -->
      <van-field v-model="item.telephone" name="telephone" label="联系电话" placeholder="请输入联系电话" :rules="rules.telephone"/>
      <!-- 紧急联系人 -->
      <van-field name="emergency" label="紧急联系人"  :value="item.emergency" :rules="rules.emergency">
        <van-radio-group v-model="item.emergency" direction="horizontal" slot="input">
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
      <van-divider />
      </div>
      <!-- 下一步 -->
      <div style="margin: 16px;">
          <van-button round block type="info" native-type="submit">
            下一步
          </van-button>
      </div>
    </van-form>
  </div>
</template>
<script>
export default {
  name: 'education_m',
  data () {
    return {
      loading: true,
      basicinfo: {
        marriageStatus: '3',
        relativeList: []
      },
      fam: {
        relativeID: '',
        relationship: '',
        name: '',
        age: '',
        job: '',
        workplace: '',
        homeAddress: '',
        telephone: '',
        emergency: ''
      },
      relationshipList: ['父亲', '母亲', '配偶', '哥哥', '姐姐', '弟弟', '妹妹'],
      rules: {
        relationship: [
          { required: true, message: '请选择称谓' }
        ],
        name: [
          { required: true, message: '请填写姓名' }
        ],
        age: [
          { required: true, message: '请填写年龄' }
        ],
        job: [
          { required: true, message: '请填写职业' }
        ],
        workplace: [
          { required: true, message: '请填写工作单位' }
        ],
        homeAddress: [
          { required: true, message: '请填写家庭地址' }
        ],
        telephone: [
          { required: true, message: '请填写手机号码' },
          { validator: this.phoneValidate, message: '请填写正确格式的联系方式' }
        ],
        emergency: [
          { required: true, message: '请选择是否为紧急联系人' }
        ]
      }
    }
  },
  mounted () {
    this.$axios.post('/getInterviewer', {
      interviewerID: this.$store.state.interviewerID
    }).then(sr => {
      if (sr.data.code === 200) {
        this.basicinfo = sr.data.data
        this.loading = false
      } else {
        this.$toast('获取用户信息失败')
      }
    }).catch()
  },
  computed: {
    marriageStatus_: function () {
      return this.basicinfo.marriageStatus
    }
  },
  watch: {
    marriageStatus_: function (newVal, oldVal) {
      if (oldVal === '3') return // 加载防呆，使得该监控只对手动修改起作用
      if (newVal === '1') {
        this.basicinfo.relativeList = []
        this.addRelative('配偶')
      } else if (newVal === '0') {
        this.basicinfo.relativeList = []
        this.addRelative('父亲')
        this.addRelative('母亲')
      }
    }
  },
  methods: {
    onClickLeft () {
      this.$router.go(-1)
    },
    onSubmit () {
      // 保存数据
      this.$axios.post('/saveInterviewer', {
        interviewer: this.basicinfo
      }).then(sr => {
        if (sr.data.code === 200) {
          this.$router.push('m_hea')
        } else {
          this.$roast.fail('信息保存失败，请稍后再试')
        }
      }).catch(fail => {
      })
    },
    addRelative (relationship) {
      let relativeObj = {}
      for (let key in this.fam) {
        relativeObj[key] = this.fam[key]
      }
      relativeObj['relationship'] = relationship
      this.basicinfo.relativeList.push(relativeObj)
    },
    phoneValidate (val) {
      return /^1[3456789]\d{9}$/.test(val)
    }
  }
}
</script>
<style>
</style>
