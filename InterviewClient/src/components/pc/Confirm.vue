<template>
  <div id="fam">
      <Row>
        <i-col :xs="{span:22,offset:1}" :sm="{span:20,offset:2}" :md="{span:16,offset:4}" :lg="{span:12,offset:6}">
          <Form :label-width="labelwidth" label-position="left"  >
            <FormItem label="是否曾参加非法集会？" label-width="100%"  prop="respiratory"  >
                <RadioGroup v-model="formItem.input" :style="radioStyle" >
                    <Radio label="0">否</Radio>
                    <Radio label="1">是</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem label="期望待遇(税前):" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="可到职日期:" >
               <DatePicker type="date" placeholder="选择日期" v-model="formItem.input" style="width:100%"></DatePicker>
            </FormItem>
            <FormItem label="是否住宿:" >
               <RadioGroup v-model="formItem.input" :style="radioStyle" >
                   <Radio label="0">否</Radio>
                   <Radio label="1">是</Radio>
               </RadioGroup>
            </FormItem>
            <Divider />
            </FormItem>
            <p style="border: 1px solid black;padding: 5px;">※本人所填列表均属确实,如有虚假，个人愿意承担所有法律责任并接受公司处理包括但不限于辞退及个人承担所有法律责任。
            <br/>   All the information that I fill in is true, and I agree to have it checked. If there is anything concoctive, I'll accept dismission without any supplementary conditions at any time.
            </p>
            </FormItem>
            <FormItem :label-width="0">
              <Row style="margin-top: 0.625rem;">
                <i-col span="12"><router-link to="expr"><Button style="float:right;margin-right: 0.5rem;">上一步</Button></router-link></i-col>
                <i-col span="12"><Button style="float:left;margin-left: 0.5rem;" type="primary" >确认并提交</Button></i-col>
              </Row>
            </FormItem>

          </Form>
        </i-col>
      </Row>
  </div>
</template>

<script>
export default {
  name: 'family',
  data () {
    return {
      labelwidth: 120,
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
  }
}
</script>

<style>
</style>
