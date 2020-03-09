<template>
  <div id="fam">
      <Row>
        <i-col :xs="{span:22,offset:1}" :sm="{span:20,offset:2}" :md="{span:16,offset:4}" :lg="{span:12,offset:6}">
          <Form :label-width="labelwidth" >
            
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
