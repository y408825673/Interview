<template>
  <div id="rlat">
      <Row>
        <i-col :xs="{span:22,offset:1}" :sm="{span:20,offset:2}" :md="{span:16,offset:4}" :lg="{span:12,offset:6}">
          <Form :label-width="labelwidth" >
            <FormItem label="姓名:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="工号:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="联系电话:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="身份证号:" >
               <Input v-model="formItem.input" placeholder=""></input>
            </FormItem>
            <FormItem label="关系:" >
               <Select v-model="formItem.input" filterable>
                   <Option value="beijing">New York</Option>
                   <Option value="shanghai">London</Option>
                   <Option value="shenzhen">Sydney</Option>
               </Select>
            </FormItem>
            <FormItem :label-width="0">
              <Row>
                <i-col span="12"><router-link to="/hea"><Button style="float:right;margin-right: 0.5rem;">上一步</Button></router-link></i-col>
                <i-col span="12"><router-link to="/expr"><Button style="float:left;margin-left: 0.5rem;" type="primary" >下一步</Button></router-link></i-col>
              </Row>
            </FormItem>
          </Form>
        </i-col>
      </Row>
  </div>
</template>

<script>
export default {
  name: 'relatedEmp',
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
