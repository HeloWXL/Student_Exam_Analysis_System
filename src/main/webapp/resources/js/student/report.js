$(function () {

    var ablilityList = abilitySeries.substring(1,abilitySeries.length-1).split(',');
    var name = new Array();
    var value =new Array();
    var data = [];
    for(var i = 0 ;i<ablilityList.length;i++){
        if(i%2==0){
            name.push(ablilityList[i])
        }else{
            value.push(ablilityList[i])
        }
    }
    for(var j = 0 ; j<name.length;j++){
        var items={
            name:name[j],
            value:value[j]
        };
        data.push(items)
    }
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
            data: name
        },
        series : [
            {
                name: '能力分析',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:data,
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
        title : {
            text: '成绩分析',
            x:'center'
        },
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
                barWidth: '40%',
                data:[avgScore, myScore]
            }
        ]
    };

    if (option2 && typeof option2 === "object") {
        myChart2.setOption(option2,true);
    }
})