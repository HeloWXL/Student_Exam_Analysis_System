layui.use(['rate'], function() {
  var rate = layui.rate;
  //只读
  rate.render({
    elem: '#test'
    ,value: 3
    ,readonly: true
  });
})


//饼图
var dom = document.getElementById("container");
var myChart = echarts.init(dom,'light');
option1 = null;
option1 = {
  title : {
    text: '能力类型分析',
    subtext: '我的能力分析',
    x:'center'
  },
  tooltip : {
    trigger: 'item',
    formatter: "{a} <br/>{b} : {c} ({d}%)"
  },
  legend: {
    bottom: 10,
    left: 'center',
    data: ['客观分析能力','观察能力','应用能力','计算能力','动手能力','推理能力']
  },
  series : [
    {
      name: '访问来源',
      type: 'pie',
      radius : '55%',
      center: ['50%', '60%'],
      data:[
        {value:335, name:'客观分析能力'},
        {value:310, name:'观察能力'},
        {value:234, name:'应用能力'},
        {value:135, name:'计算能力'},
        {value:135, name:'推理能力'},
        {value:1548, name:'动手能力'}
      ],
      itemStyle: {
        emphasis: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: 'rgba(0, 0, 0, 0.5)'
        }
      }
    }
  ]
};
if (option1 && typeof option1 === "object") {
  myChart.setOption(option1,true);
}

//统计直方图
var dom = document.getElementById("container2");
var myChart2 = echarts.init(dom,'light');
option2 = null;
option2 = {
  color: ['#3398DB'],
  tooltip : {
    trigger: 'axis',
    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
      type : 'shadow'       // 默认为直线，可选为：'line' | 'shadow'
    }
  },
  grid: {
    left: '3%',
    right: '4%',
    bottom: '3%',
    containLabel: true
  },
  xAxis : [
    {
      type : 'category',
      data : ['平均成绩', '我的成绩'],
      axisTick: {
        alignWithLabel: true
      }
    }
  ],
  yAxis : [
    {
      type : 'value'
    }
  ],
  series : [
    {
      name:['分数'],
      type:'bar',
      barWidth: '60%',
      data:[10, 52]
    }
  ]
};

if (option2 && typeof option2 === "object") {
  myChart2.setOption(option2,true);
}