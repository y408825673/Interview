import Vue from 'vue'
import Router from 'vue-router'
// import BasicInfo from '@/components/pc/BasicInfo'
// import Education from '@/components/pc/Education'
// import Family from '@/components/pc/Family'
// import Health from '@/components/pc/Health'
// import RelatedEmp from '@/components/pc/RelatedEmp'
// import Experience from '@/components/pc/Experience'
// import Confirm from '@/components/pc/Confirm'

// 移动端页面

// import MBasicInfo from '@/components/mobile/MBasicInfo'
// import MEducation from '@/components/mobile/MEducation'
// import MFamily from '@/components/mobile/MFamily'
// import MHealth from '@/components/mobile/MHealth'
// import MRelatedEmp from '@/components/mobile/MRelatedEmp'
// import MExperience from '@/components/mobile/MExperience'
// import MConfirm from '@/components/mobile/MConfirm'
// 异步加载方案
const Login = r => require.ensure([], () => r(require('@/components/login')), 'Login')

const MBasicInfo = r => require.ensure([], () => r(require('@/components/mobile/MBasicInfo')), 'MBasicInfo')
const MEducation = r => require.ensure([], () => r(require('@/components/mobile/MEducation')), 'MEducation')
const MFamily = r => require.ensure([], () => r(require('@/components/mobile/MFamily')), 'MFamily')
const MHealth = r => require.ensure([], () => r(require('@/components/mobile/MHealth')), 'MHealth')
const MRelatedEmp = r => require.ensure([], () => r(require('@/components/mobile/MRelatedEmp')), 'MRelatedEmp')
const MExperience = r => require.ensure([], () => r(require('@/components/mobile/MExperience')), 'MExperience')
const MConfirm = r => require.ensure([], () => r(require('@/components/mobile/MConfirm')), 'MConfirm')

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    // {
    //   path: '/bi',
    //   name: 'basicinfo',
    //   component: BasicInfo
    // },
    // {
    //   path: '/edu',
    //   name: 'education',
    //   component: Education
    // },
    // {
    //   path: '/fam',
    //   name: 'family',
    //   component: Family
    // },
    // {
    //   path: '/hea',
    //   name: 'health',
    //   component: Health
    // },
    // {
    //   path: '/rlat',
    //   name: 'relatedEmp',
    //   component: RelatedEmp
    // },
    // {
    //   path: '/expr',
    //   name: 'experience',
    //   component: Experience
    // },
    // {
    //   path: '/confirm',
    //   name: 'confirm',
    //   component: Confirm
    // },
    {
      path: '/m_bi',
      name: 'MobileBasicInfo',
      component: MBasicInfo
    },
    {
      path: '/m_edu',
      name: 'MEducation',
      component: MEducation
    },
    {
      path: '/m_fam',
      name: 'MFamily',
      component: MFamily
    },
    {
      path: '/m_hea',
      name: 'MHealth',
      component: MHealth
    },
    {
      path: '/m_rlat',
      name: 'MRelatedEmp',
      component: MRelatedEmp
    },
    {
      path: '/m_expr',
      name: 'MExperience',
      component: MExperience
    },
    {
      path: '/m_confirm',
      name: 'MConfirm',
      component: MConfirm
    }
  ]
})
