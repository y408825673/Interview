<template>
  <div id="rxpr_m">
    <van-nav-bar title="工作经历" left-text="上一步"  left-arrow right-arrow
    @click-left="onClickLeft" />
    <van-skeleton title :row="20" v-if="loading" style="margin:10px"/>
    <van-form @submit="onSubmit" v-if="!loading">
      <van-field name="experienceFlag" label="有无工作经历" label-width="14.5rem" input-align="right" :value="basicinfo.experienceFlag" :rules="rules.experienceFlag" >
        <van-radio-group v-model="basicinfo.experienceFlag" direction="horizontal" slot="input">
          <van-radio name="0">无</van-radio>
          <van-radio name="1">有</van-radio>
        </van-radio-group>
      </van-field>
      <van-notice-bar v-if="basicinfo.experienceFlag == '1'" wrapable :scrollable="false" >
        请自最近服务单位填起，至毕业前所有的工作经历
      </van-notice-bar>
      <!-- 循环显示工作经历 -->
      <div v-for="(item,index) in basicinfo.experienceList" :key="index" >
      <!-- 工作经历标题 -->
      <van-swipe-cell>
        <van-cell :border="false"  :title="`工作经历${index+1}`" class="van-hairline--surround" value="左划删除" />
        <template slot="right">
          <van-button square type="danger" text="删除" @click.prevent="onCancel(index)" />
        </template>
      </van-swipe-cell>
      <!-- 单位名称 -->
      <van-field v-model="item.company" name="company" label="单位名称" placeholder="单位名称" :rules="rules.company"/>
      <!-- 地点 -->
      <van-field v-model="item.city" name="city" label="地点" placeholder="地点" :rules="rules.city"/>
      <!-- 职称 -->
      <van-field v-model="item.jobTitle" name="jobTitle" label="职称" placeholder="职称" :rules="rules.jobTitle"/>
      <!-- 薪资 -->
      <van-field v-model="item.salary" name="salary" label="薪资" placeholder="薪资" :rules="rules.salary"/>
      <!-- 入职日期 -->
      <van-field readonly clickable name="fromDate" :value="item.fromDate" label="入职日期" placeholder="点击选择日期" @click="showCalendar = true ; dateType = 'from' ; experienceIndex = index" :rules="rules.fromDate"/>
      <!-- 离职日期 -->
      <van-field readonly clickable name="toDate" :value="item.toDate" label="离职日期" placeholder="点击选择日期" @click="showCalendar = true ; dateType = 'to' ; experienceIndex = index" :rules="rules.toDate"/>
      <!-- 直属主管 -->
      <van-field v-model="item.supervior" name="supervior" label="直属主管" placeholder="直属主管姓名/职称" :rules="rules.supervior"/>
      <!-- 联系电话 -->
      <van-field v-model="item.telephone" name="telephone" label="联系电话" placeholder="联系电话" :rules="rules.telephone"/>
      <!-- 离职原因 -->
      <van-field v-model="item.resignReason" rows="1" autosize label="离职原因" type="textarea" placeholder="请输入离职原因" :rules="rules.resignReason" />
      <br/>
      </div>
      <div v-if="basicinfo.experienceFlag == '1'" style="margin: 0 16px 16px 0 ; text-align: right;">
        <van-button icon="plus" plain size="small" type="primary" @click.prevent="addExperience">增加经历</van-button>
      </div>
      <!-- 下一步 -->
      <div style="margin: 16px;">
          <van-button round block type="info" native-type="submit" >
            下一步
          </van-button>
      </div>
    </van-form>
    <!-- 日期界面 -->
    <van-calendar v-model="showCalendar" @confirm="onConfirm" :show-confirm="false" :min-date="minDate" :max-date="maxDate"  />
  </div>
</template>
<script>
import dateUtil from '@/utils/DateUtil.js'

export default {
  name: 'experience_m',
  data () {
    return {
      loading: true,
      basicinfo: {
        experienceFlag: '',
        experienceList: []
      },
      experience: {
        experienceID: '',
        company: '',
        city: '',
        jobTitle: '',
        salary: '',
        fromDate: '',
        toDate: '',
        supervior: '',
        telephone: '',
        resignReason: ''
      },
      showCalendar: false,
      dateType: '',
      experienceIndex: '',
      minDate: new Date(1990, 0, 1),
      maxDate: new Date(),
      rules: {
        experienceFlag: [
          { required: true, message: '请选择有无工作经历' }
        ],
        company: [
          { required: true, message: '请填写单位名称' }
        ],
        city: [
          { required: true, message: '请填写地点' }
        ],
        jobTitle: [
          { required: true, message: '请填写职称' }
        ],
        salary: [
          { required: true, message: '请填写薪资' }
        ],
        fromDate: [
          { required: true, message: '请选择入职日期' }
        ],
        toDate: [
          { required: true, message: '请选择离职日期' }
        ],
        supervior: [
          { required: true, message: '请填写直属主管' }
        ],
        telephone: [
          { required: true, message: '请填写联系方式' },
          { validator: this.phoneValidate, message: '请填写正确格式的联系方式' }
        ],
        resignReason: [
          { required: true, message: '请填写离职原因' }
        ]
      }
    }
  },
  computed: {
    experienceFlag_: function () {
      return this.basicinfo.experienceFlag
    }
  },
  mounted () {
    // 获取面试者基本信息
    this.$axios.post('/getInterviewer', {
      interviewerID: this.$store.state.interviewerID
    }).then(sr => {
      if (sr.data.code === 200) {
        this.basicinfo = sr.data.data
        let exprList = this.basicinfo.experienceList
        for (let i = 0; i < exprList.length; i++) {
          let expr = exprList[i]
          // 日期格式处理
          for (var key in expr) {
            if (key.indexOf('Date') > -1) {
              expr[key] = expr[key] === null ? '' : expr[key].substring(0, 10)
            }
          }
        }
        this.loading = false
      } else {
        this.$toast('获取用户信息失败')
      }
    }).catch()
  },
  watch: {
    experienceFlag_: function (newVal, oldVal) {
      if (newVal === '1') {
        if (this.basicinfo.experienceList.length < 1) {
          this.addExperience()
        }
      } else if (newVal === '0') {
        this.basicinfo.experienceList = []
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
          this.$router.push('m_confirm')
        } else {
          this.$toast.fail('信息保存失败，请稍后再试')
        }
      }).catch(fail => {
      })
    },
    onConfirm (date) {
      let dateRes = dateUtil.toDate(date)
      this.basicinfo.experienceList[this.experienceIndex][this.dateType + 'Date'] = dateRes
      this.showCalendar = false
    },
    onCancel (index) {
      // 删除工作经历
      let expr = this.basicinfo.experienceList[index]
      this.$dialog.confirm({
        title: '确认删除',
        message: '该条工作经历将被删除'
      }).then(() => {
        // on confirm
        console.log(expr.experienceID)
        this.$axios.post('/cancelExpr', {
          experienceID: expr.experienceID
        }).then(sr => {
          if (sr.data.code === 200) {
            this.$toast.success(sr.data.message)
            this.basicinfo.experienceList.splice(index, 1)
          } else {
            this.$toast.fail('删除失败')
          }
        }).catch(fail => {})
      }).catch(() => {
        // on cancel
      })
    },
    addExperience () {
      // 复制模板
      let experienceObj = {}
      for (let key in this.experience) {
        experienceObj[key] = this.experience[key]
      }
      this.basicinfo.experienceList.push(experienceObj)
    },
    phoneValidate (val) {
      return /^1[3456789]\d{9}$/.test(val)
    }
  }
}
</script>
<style>
</style>
