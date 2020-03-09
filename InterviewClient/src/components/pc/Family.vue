<template>
  <div id="fam">
      <Row>
        <i-col :xs="{span:24,offset:0}" :sm="{span:20,offset:2}" :md="{span:16,offset:4}" :lg="{span:12,offset:6}">
          <Card>
          <Form :label-width="labelwidth" >
            <FormItem label="称谓:" style="text-align: center;">
               <Input value="父亲" placeholder="" readonly ></input>
            </FormItem>
            <FormItem label="姓名:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="年龄:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="职业:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="工作单位:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="家庭住址:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="联系电话:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="紧急联系人:" :label-width="100" >
               <RadioGroup v-model="formItem.input">
                   <Radio label="1">是</Radio>
                   <Radio label="0">否</Radio>
               </RadioGroup>
            </FormItem>
          </Form>
          </Card>
          <Card>
          <Form :label-width="labelwidth" >
            <FormItem label="称谓:" style="text-align: center;">
               <Input value="母亲" placeholder="" readonly ></input>
            </FormItem>
            <FormItem label="姓名:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="年龄:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="职业:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="工作单位:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="家庭住址:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="联系电话:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="紧急联系人:" :label-width="100" >
               <RadioGroup v-model="formItem.input">
                   <Radio label="1">是</Radio>
                   <Radio label="0">否</Radio>
               </RadioGroup>
            </FormItem>
            <FormItem :label-width="0">
              <Row>
                <i-col span="12"><router-link to="/edu"><Button style="float:right;margin-right: 0.5rem;">上一步</Button></router-link></i-col>
                <i-col span="12"><router-link to="/hea"><Button style="float:left;margin-left: 0.5rem;" type="primary" >下一步</Button></router-link></i-col>
              </Row>
            </FormItem>
          </Form>
          </Card>
        </i-col>
      </Row>
  </div>
</template>

<script>
export default {
  name: 'family',
  data () {
    return {
      labelwidth: 80,
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
