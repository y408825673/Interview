<template>
  <div id="hea">
      <Row>
        <i-col :xs="{span:22,offset:1}" :sm="{span:20,offset:2}" :md="{span:16,offset:4}" :lg="{span:12,offset:6}">

          <p>健康声明：就本人所知之最大范围，本人郑重声明目前身体健康状况如下（请选择符合的选项)</p>
          <hr/>
          <Form   style="margin-top: 0.3125rem;" label-position="left" >
            <FormItem label="是否在近6个月内在医院住院治疗？" prop="hospitalized"  >
                <RadioGroup v-model="formItem.input" :style="radioStyle" >
                    <Radio label="0">否</Radio>
                    <Radio label="1">是</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem label="是否患有传染性呼吸系统疾病？" prop="respiratory"  >
                <RadioGroup v-model="formItem.input" :style="radioStyle" >
                    <Radio label="0">否</Radio>
                    <Radio label="1">是</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem label="是否有哮喘？" prop="asthma"   >
                <RadioGroup v-model="formItem.input" :style="radioStyle">
                    <Radio label="0">否</Radio>
                    <Radio label="1">是</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem label="是否有心脏病？" prop="heart"    >
                <RadioGroup v-model="formItem.input" :style="radioStyle">
                    <Radio label="0">否</Radio>
                    <Radio label="1">是</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem label="是否患有传染性皮肤病？" prop="skin"  >
                <RadioGroup v-model="formItem.input" :style="radioStyle" >
                    <Radio label="0">否</Radio>
                    <Radio label="1">是</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem label="是否经常性情绪波动较大，易激动？" prop="excited"  >
                <RadioGroup v-model="formItem.input" :style="radioStyle" >
                    <Radio label="0">否</Radio>
                    <Radio label="1">是</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem label="是否酗酒？" prop="drunk"  >
                <RadioGroup v-model="formItem.input" :style="radioStyle" >
                    <Radio label="0">否</Radio>
                    <Radio label="1">是</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem label="家族是否有遗传病史？" prop="genetic"  >
                <RadioGroup v-model="formItem.input" :style="radioStyle" >
                    <Radio label="0">否</Radio>
                    <Radio label="1">是</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem label="是否有癫痫病史？" prop="epilepsy"  >
                <RadioGroup v-model="formItem.input" :style="radioStyle" >
                    <Radio label="0">否</Radio>
                    <Radio label="1">是</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem label="是否有听力障碍？" prop="hear"  >
                <RadioGroup v-model="formItem.input" :style="radioStyle" >
                    <Radio label="0">否</Radio>
                    <Radio label="1">是</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem label="是否有其他可能对健康造成严重影响的疾病，或有可能给工作造成不便的疾病？" prop="other"  >
                <RadioGroup v-model="formItem.input" :style="radioStyle" >
                    <Radio label="0">否</Radio>
                    <Radio label="1">是</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem :label-width="0">
              <Row>
                <i-col span="12"><router-link to="/fam"><Button style="float:right;margin-right: 0.5rem;">上一步</Button></router-link></i-col>
                <i-col span="12"><router-link to="/rlat"><Button style="float:left;margin-left: 0.5rem;" type="primary" >下一步</Button></router-link></i-col>
              </Row>
            </FormItem>
          </Form>
        </i-col>
      </Row>
  </div>
</template>

<script>
export default {
  name: 'health',
  data () {
    return {
      labelwidth: 250,
      radioStyle: {
        width: '6rem',
        float: 'right'

      },
      formItem: {
        employeename: '',
        date: '',
        input: ''
      }
    }
  },
  created: {
  }
}
</script>
RadioGroup{
  float:right
}
<style>
</style>
