<template>
  <div id="expr">
      <Row>
        <i-col :xs="{span:22,offset:1}" :sm="{span:20,offset:2}" :md="{span:16,offset:4}" :lg="{span:12,offset:6}">
          <Form :label-width="labelwidth"  label-position="left" >
            <FormItem label="单位名称:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="地点:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="职称:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="薪资:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="到职时间:" >
              <DatePicker type="date" placeholder="选择日期" v-model="formItem.input" style="width:100%"></DatePicker>
            </FormItem>
            <FormItem label="离职时间:" >
              <DatePicker type="date" placeholder="选择日期" v-model="formItem.input" style="width:100%"></DatePicker>
            </FormItem>
            <FormItem label="直属主管 姓名/职称:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="联系电话:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="离职原因:" >
               <Input v-model="formItem.input" placeholder="" type="textarea"></input>
            </FormItem>
            <FormItem :label-width="0">
              <Row>
                <i-col span="12"><router-link to="/rlat"><Button style="float:right;margin-right: 0.5rem;">上一步</Button></router-link></i-col>
                <i-col span="12"><router-link to="/confirm"><Button style="float:left;margin-left: 0.5rem;" type="primary" >下一步</Button></router-link></i-col>
              </Row>
            </FormItem>
          </Form>
        </i-col>
      </Row>
  </div>
</template>

<script>
export default {
  name: 'experience',
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
