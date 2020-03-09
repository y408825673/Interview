import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

const store = new Vuex.Store({
  strict: true,
  state: {
    interviewerID: sessionStorage.getItem('interviewerID') ? sessionStorage.getItem('interviewerID') : '',
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
    }
  },
  mutations: {
    updateBI (state, arg) {
      state.basicinfo = arg
    },
    updateInterviewerID (state, arg) {
      state.interviewerID = arg
      /* 存入sessionStorage防止页面刷新后数据丢失，Vuex从sessionStorage取数据，再给各组件使用 */
      sessionStorage.setItem('interviewerID', arg)
    }
  },
  actions: {
    setBI (context, basicinfo) {
      context.commit('updateBI', basicinfo)
    },
    updateInterviewerID (context, interviewerID) {
      context.commit('updateInterviewerID', interviewerID)
    }
  },
  getters: {// getters相当于store的计算属性,可在此计算及添加过滤器
    basicinfo: state => {
      return state.basicinfo
    },
    interviewerID: state => {
      return state.interviewerID
    }
  }
})
export default store
