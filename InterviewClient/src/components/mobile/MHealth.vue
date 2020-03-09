<template>
  <div id="hea_m">
    <van-nav-bar title="健康声明" left-text="上一步"  left-arrow right-arrow
    @click-left="onClickLeft" />
    <van-skeleton title :row="20" v-if="loading" style="margin:10px"/>
    <van-notice-bar wrapable :scrollable="false">
      健康声明：就本人所知之最大范围，本人郑重声明目前身体健康状况如下（请选择符合的选项)
    </van-notice-bar>
    <van-form @submit="onSubmit" label-width="14.5rem" input-align="right" v-if="!loading">
      <van-field name="hospitalized" label="是否在近6个月内在医院住院治疗?" :value="hea.hospitalized" :rules="rules.common" >
        <van-radio-group v-model="hea.hospitalized" direction="horizontal" slot="input" >
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
      <van-field name="respiratory" label="是否患有传染性呼吸系统疾病？"  :value="hea.respiratory" :rules="rules.common" >
        <van-radio-group v-model="hea.respiratory" direction="horizontal" slot="input" >
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
      <van-field name="asthma" label="是否有哮喘？"  :value="hea.asthma" :rules="rules.common" >
        <van-radio-group v-model="hea.asthma" direction="horizontal" slot="input" >
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
      <van-field name="heart" label="是否有心脏病？"   :value="hea.heart" :rules="rules.common">
        <van-radio-group v-model="hea.heart" direction="horizontal" slot="input" >
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
      <van-field name="skin" label="是否患有传染性皮肤病？"   :value="hea.skin" :rules="rules.common">
        <van-radio-group v-model="hea.skin" direction="horizontal" slot="input" >
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
      <van-field name="excited" label="是否经常性情绪波动较大，易激动？"  :value="hea.excited" :rules="rules.common">
        <van-radio-group v-model="hea.excited" direction="horizontal" slot="input" >
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
      <van-field name="drunk" label="是否酗酒？"  :value="hea.drunk" :rules="rules.common">
        <van-radio-group v-model="hea.drunk" direction="horizontal" slot="input" >
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
      <van-field name="genetic" label="家族是否有遗传病史？"  :value="hea.genetic" :rules="rules.common">
        <van-radio-group v-model="hea.genetic" direction="horizontal" slot="input" >
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
      <van-field name="epilepsy" label="是否有癫痫病史？"  :value="hea.epilepsy" :rules="rules.common">
        <van-radio-group v-model="hea.epilepsy" direction="horizontal" slot="input" >
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
      <van-field name="hear" label="是否有听力障碍？"  :value="hea.hear" :rules="rules.common">
        <van-radio-group v-model="hea.hear" direction="horizontal" slot="input" >
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
      <van-field name="other" label="是否有其他可能对健康造成严重影响的疾病，或有可能给工作造成不便的疾病？"  :value="hea.other" :rules="rules.common">
        <van-radio-group v-model="hea.other" direction="horizontal" slot="input" >
          <van-radio name="0">否</van-radio>
          <van-radio name="1">是</van-radio>
        </van-radio-group>
      </van-field>
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
  name: 'health_m',
  data () {
    return {
      loading: true,
      hea: {
        hospitalized: '',
        respiratory: '',
        asthma: '',
        heart: '',
        skin: '',
        excited: '',
        drunk: '',
        genetic: '',
        epilepsy: '',
        hear: '',
        other: ''
      },
      rules: {
        common: [
          {required: true, message: '请确认该问题'}
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
        this.hea = sr.data.data
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
      // 保存数据
      console.log(this.hea)
      this.$axios.post('/saveInterviewer', {
        interviewer: this.hea
      }).then(sr => {
        if (sr.data.code === 200) {
          this.$router.push('m_rlat')
        } else {
          this.$roast.fail('信息保存失败，请稍后再试')
        }
      }).catch(fail => {
      })
    }
  }
}
</script>
<style>
</style>
