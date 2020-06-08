$(function(){
		select();
	})
	function select(){
		alert(">>>")
		$.ajax({
			url :"/myproject/menu/getmenuList" ,
			type : "get",
			data : {"pid":""},
			dataType:"json",
			success : function(re) {
				console.log(re.list)
				/* var vm = new Vue({
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
        		
			}
		}
      
    })	*/
	}
		
	})
	}
	