<template>
  <div id="edu">

    <Row>
      <i-col :xs="{span:24,offset:0}" :sm="{span:20,offset:2}" :md="{span:16,offset:4}" :lg="{span:12,offset:6}">
        <Card >
        <p slot="title">最高学历</p>
        <Form :label-width="labelwidth" >
           <FormItem label="学校:" >
              <Input v-model="formItem.input" placeholder=""></input>
           </FormItem>
           <FormItem label="地点:">
              <Input v-model="formItem.input" placeholder=""></input>
           </FormItem>
           <FormItem label="入校时间:">
              <DatePicker type="date" placeholder="选择日期" v-model="formItem.input" style="width:100%"></DatePicker>
           </FormItem>
           <FormItem label="离校时间:">
              <DatePicker type="date" placeholder="选择日期" v-model="formItem.input" style="width:100%"></DatePicker>
           </FormItem>
           <FormItem label="专业:">
              <Input v-model="formItem.input" placeholder=""></input>
           </FormItem>
           <FormItem label="学历:">
             <Select v-model="formItem.input" filterable>
                 <Option value="beijing">New York</Option>
                 <Option value="shanghai">London</Option>
                 <Option value="shenzhen">Sydney</Option>
             </Select>
           </FormItem>
           <FormItem label="教育方式:">
             <Select v-model="formItem.input" filterable>
                 <Option value="beijing">New York</Option>
                 <Option value="shanghai">London</Option>
                 <Option value="shenzhen">Sydney</Option>
             </Select>
           </FormItem>
        </Form>
        </card>
        <Card style="margin-top: 0.3125rem;">
        <p slot="title">次等学历</p>
        <Form :label-width="labelwidth" >
           <FormItem label="学校:" >
              <Input v-model="formItem.input" placeholder=""></input>
           </FormItem>
           <FormItem label="地点:">
              <Input v-model="formItem.input" placeholder=""></input>
           </FormItem>
           <FormItem label="入校时间:">
              <DatePicker type="date" placeholder="选择日期" v-model="formItem.input" style="width:100%"></DatePicker>
           </FormItem>
           <FormItem label="离校时间:">
              <DatePicker type="date" placeholder="选择日期" v-model="formItem.input" style="width:100%"></DatePicker>
           </FormItem>
           <FormItem label="专业:">
              <Input v-model="formItem.input" placeholder=""></input>
           </FormItem>
           <FormItem label="学历:">
             <Select v-model="formItem.input" filterable>
                 <Option value="beijing">New York</Option>
                 <Option value="shanghai">London</Option>
                 <Option value="shenzhen">Sydney</Option>
             </Select>
           </FormItem>
           <FormItem label="教育方式:">
             <Select v-model="formItem.input" filterable>
                 <Option value="beijing">New York</Option>
                 <Option value="shanghai">London</Option>
                 <Option value="shenzhen">Sydney</Option>
             </Select>
           </FormItem>
           <FormItem :label-width="0">
             <Row>
               <i-col span="12"><router-link to="/bi"><Button style="float:right;margin-right: 0.5rem;">上一步</Button></router-link></i-col>
               <i-col span="12"><router-link to="/fam"><Button style="float:left;margin-left: 0.5rem;" type="primary" >下一步</Button></router-link></i-col>
             </Row>
           </FormItem>
        </Form>
        </card>
      </i-col>
    </Row>

    </div>
</template>

<script>
export default {
  name: 'edu',
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
