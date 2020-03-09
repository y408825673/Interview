<template>
  <div id="bi">
    <Row>
      <i-col :xs="{span:24,offset:0}" :sm="{span:20,offset:2}" :md="{span:16,offset:4}" :lg="{span:12,offset:6}">
        <Card>
        <p slot="title">个人信息</p>
        <Form :label-width="labelwidth" label-position="left" style="margin-top: 10px;">
           <FormItem label="姓名:" >
              <Input v-model="formItem.input" placeholder=""></input>
           </FormItem>
           <FormItem label="身份证号:">
              <Input v-model="formItem.input" placeholder=""></input>
           </FormItem>
           <FormItem label="出生日期:">
              <DatePicker type="date" placeholder="选择日期" v-model="formItem.input" style="width:100%"></DatePicker>
           </FormItem>
           <FormItem label="籍贯:">
              <Select v-model="formItem.input"  filterable>
                  <Option value="beijing">New York</Option>
                  <Option value="shanghai">London</Option>
                  <Option value="shenzhen">Sydney</Option>
              </Select>
           </FormItem>
           <FormItem label="性别:" prop="gender"  >
               <RadioGroup v-model="formItem.input">
                   <Radio label="1">男</Radio>
                   <Radio label="2">女</Radio>
               </RadioGroup>
           </FormItem>
           <FormItem label="民族:">
             <Select v-model="formItem.input" filterable>
                 <Option value="beijing">New York</Option>
                 <Option value="shanghai">London</Option>
                 <Option value="shenzhen">Sydney</Option>
             </Select>
           </FormItem>
           <FormItem label="政治面貌:">
               <CheckboxGroup v-model="formItem.checkbox">
                   <Checkbox label="000">群众</Checkbox>
                   <Checkbox label="102">团员</Checkbox>
                   <Checkbox label="101">党员</Checkbox>
               </CheckboxGroup>
           </FormItem>
           <FormItem label="婚姻:" prop="gender"  >
               <RadioGroup v-model="formItem.input">
                   <Radio label="0">未婚</Radio>
                   <Radio label="1">已婚</Radio>
               </RadioGroup>
           </FormItem>
           <FormItem label="配偶姓名:">
              <Input v-model="formItem.input" placeholder=""></input>
           </FormItem>
           <FormItem label="配偶身份证号:">
              <Input v-model="formItem.input" placeholder=""></input>
           </FormItem>
           <FormItem label="户籍地址:">
              <Input v-model="formItem.input" placeholder="" type="textarea"></input>
           </FormItem>
           <FormItem label="家庭地址:">
              <Input v-model="formItem.input" placeholder="" type="textarea"></input>
           </FormItem>
           <FormItem label="现居住地:">
              <Input v-model="formItem.input" placeholder="" type="textarea"></input>
           </FormItem>
           <FormItem label="手机号码:">
              <Input v-model="formItem.input" placeholder=""></input>
           </FormItem>
           <FormItem label="邮箱地址:">
              <Input v-model="formItem.input" placeholder=""></input>
           </FormItem>
           <FormItem label="应聘媒介:">
             <Select v-model="formItem.input" filterable>
                 <Option value="beijing">New York</Option>
                 <Option value="shanghai">London</Option>
                 <Option value="shenzhen">Sydney</Option>
             </Select>
           </FormItem>
        </Form>
        <Form>
          <FormItem :label-width="0" style="text-align: center;">
            <router-link to="/edu">
            <Button  type="primary" >下一步</Button>
            </router-link>
          </FormItem>
        </Form>
        </Card>
      </i-col>
    </Row>
</div>
</template>

<script>
export default {
  name: 'basicinfo',
  data () {
    return {
      labelwidth: 100,
      formItem: {
        employeename: '',
        date: '',
        input: ''

      }
    }
  }
}
</script>

<style lang="postcss">
</style>
