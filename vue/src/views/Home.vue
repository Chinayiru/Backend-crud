<template>
<div>
  <el-row :gutter="10" style="margin-bottom: 40px">
    <el-col :span="6">
      <el-card style="color: #409EFF">
        <div >用户总数</div>
        <div style="padding: 10px 0 ; text-align: center; font-weight: bold">
          100
        </div>
      </el-card>
    </el-col>
    <el-col :span="6">
      <el-card style="color: #409EFF">
        <div >销售总量</div>
        <div style="padding: 10px 0 ; text-align: center; font-weight: bold">
         ￥ 100w
        </div>
      </el-card>
    </el-col>
    <el-col :span="6">
      <el-card  style="color: #67C23A">
        <div >收益</div>
        <div style="padding: 10px 0 ; text-align: center; font-weight: bold">
          ￥ 30w
        </div>
      </el-card>
    </el-col>
    <el-col :span="6">
      <el-card style="color: #E6A23C">
        <div >门店</div>
        <div style="padding: 10px 0 ; text-align: center; font-weight: bold">
          39
        </div>
      </el-card>
    </el-col>
  </el-row>
  <el-row>
    <el-col :span="12">
      <div id="main" style="width: 500px; height: 400px"></div>
    </el-col>
    <el-col :span="12 ">
      <div id="pie"style="width: 500px; height: 400px"></div>
    </el-col>
  </el-row>

</div>
</template>

<script>
import * as echarts from 'echarts';

export default {
  name: "Home",
  data(){
    return{

    }
  },
  mounted() {//页面元素渲染

    let option = {
      title: {
        text: '个季度会员数量',
        subtext: '趋势图',
        left: 'center'
      },
      legend: {
        orient: 'vertical',
        left: 'left'
      },
      xAxis: {
        type: 'category',
        data: ["第一季度","第二季度","第三季度","第四季度"]
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          name: "123",
          data: [],
          type: 'line'
        },
        {
          name: "456",
          data: [],
          type: 'bar'
        }
      ]
    };

    //  饼图

    let pieOption = {
      title: {
        text: '个季度会员数量',
        subtext: '比例图',
        left: 'center'
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        orient: 'vertical',
        left: 'left'
      },
      series: [
        {
          type: 'pie',
          radius: '50%',
          label: {
            normal:{
              show:true,
              position:'inner',
              textStyle:{
                fontWeight:300,
                fontSize:16,
                color:"#fff"
              },
              formatter:'{d}%'

            }
          },
          data: [],
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }
      ]
    };

    let chartDom = document.getElementById('main');
    let myChart = echarts.init(chartDom);

    let pieDom = document.getElementById('pie');
    let pieChart = echarts.init(pieDom);

    this.request.get("/echarts/members").then(res =>{
      //
      // option.xAxis.data = res.data.x
      option.series[0].data = res.data
      option.series[1].data = res.data
      myChart.setOption(option)


      pieOption.series[0].data = [
        {name:"一季度", value:res.data[0]},
        {name:"二季度", value:res.data[1]},
        {name:"三季度", value:res.data[2]},
        {name:"四季度", value:res.data[3]},
      ]
      pieChart.setOption(pieOption)
    })

    pieChart.setOption(pieOption)

  }
}
</script>

<style scoped>

</style>