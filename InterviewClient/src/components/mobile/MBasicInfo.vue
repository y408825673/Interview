<template>
  <div id="bi_m">
    <van-nav-bar title="个人信息" />
    <van-skeleton title :row="20" v-if="loading" style="margin:10px"/>
    <van-form @submit="onSubmit" v-if="!loading">
      <!-- 姓名 -->
      <van-field v-model="basicinfo.interviewerName" name="interviewerName" label="姓名" placeholder="姓名" :rules="rules.interviewerName"/>
      <!-- 身份证号 -->
      <van-field type="number"  v-model="basicinfo.idNumber" name="idNumber" label="身份证号" placeholder="身份证号" readonly/>
      <!-- 出生日期 -->
      <van-field readonly clickable name="calendar" :value="basicinfo.birthDate" label="出生日期" placeholder="点击选择日期" @click="showCalendar = true" :rules="rules.birthDate" />
      <van-calendar v-model="showCalendar" @confirm="onConfirm" :show-confirm="false" :min-date="minDate" :max-date="maxDate"  />
      <!-- 籍贯 -->
      <van-field readonly clickable name="nativePlace" :value="basicinfo.nativePlace" label="籍贯" placeholder="点击选择省市区" @click="showArea = true" :rules="rules.nativePlace"/>
      <van-popup v-model="showArea" position="bottom">
        <van-area :area-list="areaList" @confirm="areaConfirm" @cancel="showArea = false"/>
      </van-popup>
      <!-- 性别 -->
      <van-field name="gender" label="性别" :value="basicinfo.gender" :rules="rules.gender" >
        <van-radio-group v-model="basicinfo.gender" direction="horizontal" slot="input" >
          <van-radio name="1">男</van-radio>
          <van-radio name="2">女</van-radio>
        </van-radio-group>
      </van-field>
      <!-- 民族 -->
      <van-field readonly clickable name="ethnic" :value="basicinfo.ethnic" label="民族" placeholder="点击选择民族" @click="showEthnic = true" :rules="rules.ethnic" />
      <van-popup v-model="showEthnic" position="bottom">
        <van-picker show-toolbar :columns="ethnicList" @confirm="ethnicConfirm" @cancel="showEthnic = false"/>
      </van-popup>
      <!-- 政治面貌 -->
      <van-field name="politicalStatus" label="政治面貌" :value="basicinfo.politicalStatus" :rules="rules.politicalStatus" >
        <van-radio-group v-model="basicinfo.politicalStatus" direction="horizontal" slot="input">
          <van-radio name="000">群众</van-radio>
          <van-radio name="102">团员</van-radio>
          <van-radio name="101">党员</van-radio>
        </van-radio-group>
      </van-field>
      <!-- 婚姻 -->
      <van-field name="marriageStatus" label="婚姻" :value="basicinfo.marriageStatus" :rules="rules.marriageStatus">
        <van-radio-group v-model="basicinfo.marriageStatus" direction="horizontal" slot="input">
          <van-radio name="0">未婚</van-radio>
          <van-radio name="1">已婚</van-radio>
        </van-radio-group>
      </van-field>
      <!-- 配偶姓名 -->
      <van-field v-if="basicinfo.marriageStatus=='1'" v-model="basicinfo.spouseName" name="spouseName" label="配偶姓名" placeholder="配偶姓名" :rules="rules.spouseName"/>
      <!-- 配偶身份证 -->
      <van-field v-if="basicinfo.marriageStatus=='1'" v-model="basicinfo.spouseIdNumber" name="spouseIdNumber" label="配偶身份证号" placeholder="配偶身份证号" :rules="rules.spouseIdNumber"/>
      <!-- 户籍地址 -->
      <van-field v-model="basicinfo.nativeAddress" rows="1" autosize label="户籍地址" type="textarea" placeholder="请输入户籍地址"  :rules="rules.nativeAddress"/>
      <!-- 家庭地址 -->
      <van-field v-model="basicinfo.familyAddress" rows="1" autosize label="家庭地址" type="textarea" placeholder="请输入家庭地址" :rules="rules.familyAddress"/>
      <!-- 现居住地 -->
      <van-field v-model="basicinfo.nowAddress" rows="1" autosize label="现居住地" type="textarea" placeholder="请输入现居住地" :rules="rules.nowAddress"/>
      <!-- 手机号码 -->
      <van-field v-model="basicinfo.phone" name="phone" label="手机号码" placeholder="手机号码" :rules="rules.phone"/>
      <!-- 邮箱 -->
      <van-field v-model="basicinfo.email" name="email" label="邮箱" placeholder="邮箱" :rules="rules.email"/>
      <!-- 应聘媒介 -->
      <van-field readonly clickable name="source" :value="basicinfo.source" label="应聘媒介" placeholder="点击选择应聘来源" @click="showSource = true"  :rules="rules.source"/>
      <van-popup v-model="showSource" position="bottom">
        <van-picker show-toolbar :columns="sourceList" @confirm="sourceConfirm" @cancel="showSource = false"/>
      </van-popup>
      <!-- 补充说明 -->
      <van-field v-if="basicinfo.source=='网络'" v-model="basicinfo.additionInternet" name="additionInternet" label="网络来源" placeholder="请补充说明"/>
      <van-field v-if="basicinfo.source=='公司同仁介绍'" v-model="basicinfo.additionEmp" name="additionEmp" label="介绍人" placeholder="请填写同仁工号"/>
      <van-field v-if="basicinfo.source=='其他'" v-model="basicinfo.additionOther" name="additionOther" label="其他" placeholder="请补充说明"/>
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
import area from '@/utils/area.js'
import dateUtil from '@/utils/DateUtil.js'
export default {
  name: 'basicinfo_m',
  data () {
    return {
      loading: true,
      basicinfo: {
        interviewerName: '',
        idNumber: '',
        birthDate: '',
        nativePlace: '',
        gender: '',
        ethnic: '',
        politicalStatus: '',
        marriageStatus: '',
        spouseName: '',
        spouseIdNumber: '',
        nativeAddress: '',
        familyAddress: '',
        nowAddress: '',
        phone: '',
        email: '',
        source: '',
        additionInternet: '',
        additionOther: '',
        additionEmp: ''
      },
      showCalendar: false,
      showArea: false,
      showEthnic: false,
      showSource: false,
      areaList: area,
      ethnicList: ['汉族', '壮族', '蒙古族', '满族', '朝鲜族', '高山族', '回族', '土家族', '布依族', '瑶族', '傣族', '苗族', '白族', '傈僳族', '拉祜族', '阿昌族', '藏族', '保安族', '布朗族', '达斡尔族', '德昂族', '东乡族', '侗族', '独龙族', '俄罗斯族', '鄂伦春族', '鄂温克族', '仡佬族', '哈尼族', '哈萨克族', '赫哲族', '基诺族', '京族', '景颇族', '柯尔克孜族', '黎族', '珞巴族', '毛南族', '门巴族', '仫佬族', '纳西族', '怒族', '普米族', '羌族', '撒拉族', '畲族', '塔吉克族', '塔塔尔族', '土族', '佤族', '维吾尔族', '乌孜别克族', '锡伯族', '彝族', '裕固族'],
      sourceList: ['网络', '人才市场', '学校', '职介单位', '亲友介绍', '公司同仁介绍', '其他'],
      minDate: new Date(1960, 0, 1),
      maxDate: new Date(),
      // 验证规则
      rules: {
        interviewerName: [
          { required: true, message: '请输入姓名' }
        ],
        birthDate: [
          { required: true, message: '请选择出生日期' }
        ],
        nativePlace: [
          { required: true, message: '请选择籍贯' }
        ],
        gender: [
          { required: true, message: '请选择性别' }
        ],
        ethnic: [
          { required: true, message: '请选择民族' }
        ],
        politicalStatus: [
          { required: true, message: '请选择政治面貌' }
        ],
        marriageStatus: [
          { required: true, message: '请选择婚姻状态' }
        ],
        spouseName: [
          { required: true, message: '请输入配偶姓名' }
        ],
        spouseIdNumber: [
          { required: true, message: '请输入配偶身份证号' }
        ],
        nativeAddress: [
          { required: true, message: '请填写户籍地址' }
        ],
        familyAddress: [
          { required: true, message: '请填写家庭地址' }
        ],
        nowAddress: [
          { required: true, message: '请填写现居住地' }
        ],
        phone: [
          { required: true, message: '请填写手机号码' },
          { validator: this.phoneValidate, message: '请填写正确的手机号码' }
        ],
        email: [
          { required: true, message: '请填写邮箱' },
          { validator: this.emailValidate, message: '请填写正确格式的邮箱' }
        ],
        source: [
          { required: true, message: '请选择应聘媒介' }
        ],
        additionEmp: [
          { required: true, message: '请填写介绍人' }
        ],
        additionInternet: [
          { required: true, message: '请填写网络来源' }
        ],
        additionOther: [
          { required: true, message: '请填写其他' }
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
        // 日期格式处理
        for (var key in this.basicinfo) {
          if (key.indexOf('Date') > -1) {
            this.basicinfo[key] = this.basicinfo[key] === null ? '' : this.basicinfo[key].substring(0, 10)
          }
        }
        this.loading = false
      } else {
        this.$toast('获取用户信息失败')
      }
    }).catch()
  },
  computed: {
    marriageStatus_: function () {
      return this.basicinfo.marriageStatus
    },
    source: function () {
      return this.basicinfo.source
    }
  },
  watch: {
    marriageStatus (newVal, oldVal) {
      if (newVal === '0') {
        this.basicinfo.spouseName = ''
        this.basicinfo.spouseIdNumber = ''
      }
    },
    source (newVal, oldVal) {
      if (newVal !== '网络' && oldVal === '网络') this.basicinfo.additionInternet = ''
      if (newVal !== '公司同仁介绍' && oldVal === '公司同仁介绍') this.basicinfo.additionEmp = ''
      if (newVal !== '其他' && oldVal === '其他') this.basicinfo.additionOther = ''
    }
  },
  methods: {
    onSubmit () {
      // 保存数据
      this.$axios.post('/saveInterviewer', {
        interviewer: this.basicinfo
      }).then(sr => {
        if (sr.data.code === 200) {
          this.$router.push('m_edu')
        } else {
          this.$roast.fail('信息保存失败，请稍后再试')
        }
      }).catch(fail => {
      })
    },
    onConfirm (date) {
      this.basicinfo.birthDate = dateUtil.toDate(date)
      this.showCalendar = false
    },
    areaConfirm (areas) {
      this.basicinfo.nativePlace = areas.map(item => item.name).join('-')
      this.showArea = false
    },
    ethnicConfirm (ethnic) {
      this.basicinfo.ethnic = ethnic
      this.showEthnic = false
    },
    sourceConfirm (source) {
      this.basicinfo.source = source
      this.showSource = false
    },
    phoneValidate (val) {
      console.log(/^1[3456789]\d{9}$/.test(val))
      return /^1[3456789]\d{9}$/.test(val)
    },
    emailValidate (val) {
      return /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(val)
    }
  }
}
</script>

<style>
</style>
