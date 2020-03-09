<template>
  <div id="rlat_m">
    <van-nav-bar title="亲属在本公司服务信息" left-text="上一步"  left-arrow right-arrow
    @click-left="onClickLeft" />
    <van-skeleton title :row="20" v-if="loading" style="margin:10px"/>
    <van-field name="releatedFlag" label="有无亲属在本公司服务" label-width="14.5rem" input-align="right" :value="basicinfo.relatedFlag"  v-if="!loading" >
      <van-radio-group v-model="basicinfo.relatedFlag" direction="horizontal" slot="input">
        <van-radio name="0">无</van-radio>
        <van-radio name="1">有</van-radio>
      </van-radio-group>
    </van-field>
    <van-form @submit="onSubmit" v-if="!loading">
      <div v-if="basicinfo.relatedFlag === '1'">
      <!-- 姓名 -->
      <van-field v-model="basicinfo.relatedName" name="rlatName" label="姓名" placeholder="姓名" :rules="rules.relatedName"/>
      <!-- 工号 -->
      <van-field v-model="basicinfo.relatedEmployee_ID" name="rlatEmployee_ID" label="工号" placeholder="工号"  :rules="rules.relatedEmployee_ID"/>
      <!-- 联系电话 -->
      <!-- <van-field v-model="relatedEmp.rlatPhone" name="rlatPhone" label="联系电话" placeholder="联系电话"/> -->
      <!-- 身份证号 -->
      <!-- <van-field v-model="relatedEmp.rlatIdNumber" name="rlatIdNumber" label="身份证号" placeholder="身份证号"/> -->
      <!-- 关系 -->
      <van-field readonly clickable name="rlatRelationship" :value="basicinfo.relatedRelationship" label="关系" placeholder="点击选择关系" @click="showList = true"  :rules="rules.relatedRelationship"/>
      <van-popup v-model="showList" position="bottom">
        <van-picker show-toolbar :columns="rlatList" @confirm="rlatConfirm" @cancel="showList = false"/>
      </van-popup>
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
  name: 'relatedEmp_m',
  data () {
    return {
      loading: true,
      basicinfo: {
        relatedFlag: '',
        relatedName: '',
        relatedEmployee_ID: '',
        relatedRelationship: ''
      },
      rlatList: ['父亲', '母亲', '配偶', '哥哥', '姐姐', '弟弟', '妹妹', '叔叔', '阿姨', '姑父', '姑姑'],
      showList: false,
      rules: {
        relatedFlag: [
          {required: true, message: '请选择'}
        ],
        relatedName: [
          {required: true, message: '请填写姓名'}
        ],
        relatedEmployee_ID: [
          {required: true, message: '请填写工号'}
        ],
        relatedRelationship: [
          {required: true, message: '请选择关系'}
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
          this.$router.push('m_expr')
        } else {
          this.$roast.fail('信息保存失败，请稍后再试')
        }
      }).catch(fail => {
      })
    },
    rlatConfirm (rlat) {
      this.basicinfo.relatedRelationship = rlat
      this.showList = false
    }
  }
}
</script>
<style>
</style>
