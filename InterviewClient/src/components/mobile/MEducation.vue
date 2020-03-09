<template>
  <div id="edu_m">
    <van-nav-bar title="教育背景" left-text="上一步"  left-arrow right-arrow
    @click-left="onClickLeft" />
    <van-skeleton title :row="20" v-if="loading" style="margin:10px"/>
    <van-form @submit="onSubmit" v-if="!loading">
      <div v-for="(item, index) in basicinfo.educationList" :key="index">
      <van-divider>{{eduSortValue[index+1]}}</van-divider>
      <!-- 学校 -->
      <van-field v-model="item.school" name="school" label="学校" placeholder="请输入学校" :rules="rules.school"/>
      <!-- 地点 -->
      <van-field readonly clickable name="area" :value="item.area" label="地点" placeholder="点击选择省市区" @click="showArea = true ; eduFlag = 'edu' ;eduIndex = index" :rules="rules.area"/>
      <van-popup v-model="showArea" position="bottom">
        <van-area :area-list="areaList" @confirm="areaConfirm" @cancel="showArea = false"/>
      </van-popup>
      <!-- 入校时间 -->
      <van-field readonly clickable name="regDate" :value="item.regDate" label="入校时间" placeholder="点击选择日期" @click="showCalendar = true ; dateType = 'reg';eduIndex = index" :rules="rules.regDate"/>
      <!-- 离校时间 -->
      <van-field readonly clickable name="graDate" :value="item.graDate" label="离校时间" placeholder="点击选择日期" @click="showCalendar = true ; dateType = 'gra';eduIndex = index" :rules="rules.graDate"/>
      <!-- 专业 -->
      <van-field v-model="item.profession" name="profession" label="专业" placeholder="请输入专业" :rules="rules.profession"/>
      <!-- 学历 -->
      <van-field readonly clickable name="degree" :value="item.degree" label="学历" placeholder="点击选择学历" @click="showDegree = true ; eduFlag = 'edu';eduIndex = index" :rules="rules.degree"/>
      <van-popup v-model="showDegree" position="bottom">
        <van-picker show-toolbar :columns="degreeList" @confirm="degreeConfirm" @cancel="showDegree = false"/>
      </van-popup>
      <!-- 教育方式 -->
      <van-field readonly clickable name="eduType" :value="item.eduType" label="教育方式" placeholder="点击选择教育方式" @click="showEduType = true ; eduFlag = 'edu';eduIndex = index" :rules="rules.eduType"/>
      <van-popup v-model="showEduType" position="bottom">
        <van-picker show-toolbar :columns="eduTypeList" @confirm="eduTypeConfirm" @cancel="showEduType = false"/>
      </van-popup>
      </div>
      <!-- 下一步 -->
      <div style="margin: 16px;">
          <van-button round block type="info" native-type="submit">
            下一步
          </van-button>
      </div>
      <!-- 日期页面 -->
      <van-calendar v-model="showCalendar" @confirm="dataConfirm" :show-confirm="false" :min-date="minDate" :max-date="maxDate" />
    </van-form>
  </div>
</template>
<script>
import area from '@/utils/area.js'
import dateUtil from '@/utils/DateUtil.js'
export default {
  name: 'education_m',
  data () {
    return {
      loading: true,
      basicinfo: {
        educationList: []
      },
      edu: {// 学历模版
        educationID: '',
        school: '',
        area: '',
        regDate: '',
        graDate: '',
        profession: '',
        degree: '',
        eduType: '',
        eduSort: ''
      },
      showCalendar: false,
      showArea: false,
      showSource: false,
      showDegree: false,
      showEduType: false,
      eduIndex: '',
      dateType: '',
      eduFlag: '',
      areaList: area,
      degreeList: ['大专', '本科', '硕士', '博士', '高中', '高职', '技校', '中专', '职高', '小学', '初中'],
      eduTypeList: ['统招', '定向', '委培', '成教', '自考', '其它'],
      eduSortValue: {1: '最高学历', 2: '次等学历'},
      minDate: new Date(1960, 0, 1),
      maxDate: new Date(),
      rules: {
        school: [
          { required: true, message: '请填写学校' }
        ],
        area: [
          { required: true, message: '请选择地点' }
        ],
        regDate: [
          { required: true, message: '请选择入校时间' }
        ],
        graDate: [
          { required: true, message: '请选择离校时间' }
        ],
        profession: [
          { required: true, message: '请填写专业' }
        ],
        degree: [
          { required: true, message: '请选择专业' }
        ],
        eduType: [
          { required: true, message: '请选择教育方式' }
        ]
      }
    }
  },
  mounted () {
    // 获取应聘者全部信息
    this.$axios.post('/getInterviewer', {
      interviewerID: this.$store.state.interviewerID
    }).then(sr => {
      if (sr.data.code === 200) {
        this.basicinfo = sr.data.data
        // 日期格式处理
        let eduList = this.basicinfo.educationList
        for (let i = 0; i < eduList.length; i++) {
          let edu = eduList[i]
          // 日期格式处理
          for (var key in edu) {
            if (key.indexOf('Date') > -1) {
              edu[key] = edu[key] === null ? '' : edu[key].substring(0, 10)
            }
          }
        }
        // 初始化最高学历
        if (this.basicinfo.educationList.length < 1) {
          this.addEducation(1)
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
      console.log(this.basicinfo.educationList)
      // 保存数据
      this.$axios.post('/saveInterviewer', {
        interviewer: this.basicinfo
      }).then(sr => {
        if (sr.data.code === 200) {
          this.$router.push('m_fam')
        } else {
          this.$toast.fail('信息保存失败，请稍后再试')
        }
      }).catch(fail => {
      })
    },
    addEducation (sort) {
      // 复制模板
      let eduObj = {}
      for (let key in this.edu) {
        eduObj[key] = this.edu[key]
      }
      eduObj['eduSort'] = sort
      this.basicinfo.educationList.push(eduObj)
    },
    dataConfirm (date) {
      let date_ = dateUtil.toDate(date)
      this.basicinfo.educationList[this.eduIndex][this.dateType + 'Date'] = date_
      this.showCalendar = false
    },
    areaConfirm (areas) {
      let edu = this.basicinfo.educationList[this.eduIndex]
      edu.area = areas.map(item => item.name).join('-')
      this.showArea = false
    },
    degreeConfirm (degree) {
      let edu = this.basicinfo.educationList[this.eduIndex]
      edu.degree = degree
      this.showDegree = false
    },
    eduTypeConfirm (eduType) {
      let edu = this.basicinfo.educationList[this.eduIndex]
      edu.eduType = eduType
      // 变更教育方式后，判断是否要填写次等学历
      this.eduTypeOnchange(this.eduIndex)
      this.showEduType = false
    },
    eduTypeOnchange (index) {
      if (index !== 0) return
      let eduList = this.basicinfo.educationList
      if (eduList[index].eduType !== '统招') {
        this.addEducation(2)
      } else {
        if (eduList.length > 1) {
          eduList.splice(1, 1)
        }
      }
    }
  }
}
</script>
<style>
</style>
