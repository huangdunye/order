$(function(){
		select();
	})

	$('#js-export').click(function(){
		alert("kkkk")
        window.location.href="/myproject/report/export";
});

	function select(){
		alert(">>>")
		$.ajax({
			url :"/myproject/menu/getmenuList" ,
			type : "Get",
			data : "",
			dataType:"json",
			success : function(re) {
				console.log(re.list)
				 var vm = new Vue({
        el: '.content',
        data:{lists:re.list},
        methods: {
        	nextlevel: function(id) {
        		window.location.href="/myproject/menu/add?pid="+id
			},
			deletelist: function(id,pid) {
				if(confirm("此操作后删除数据后不可恢复。你确定要删除吗？")){
					window.location.href="/myproject/menu/deletelist?id="+id+"&pid="+pid;
				}
        		
			},
			
			dateFormat:function dateFormat(time) {
			    var date=new Date(time);
			    var year=date.getFullYear();
			    /* 在日期格式中，月份是从0开始的，因此要加0
			     * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
			     * */
			    var month= date.getMonth()+1<10 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
			    var day=date.getDate()<10 ? "0"+date.getDate() : date.getDate();
			    var hours=date.getHours()<10 ? "0"+date.getHours() : date.getHours();
			    var minutes=date.getMinutes()<10 ? "0"+date.getMinutes() : date.getMinutes();
			    var seconds=date.getSeconds()<10 ? "0"+date.getSeconds() : date.getSeconds();
			    // 拼接
			    return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
			}
		}
      
    })	
	}
		
	})
	}
	