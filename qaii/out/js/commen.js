// JavaScript Document
$(function() {
	$(".btn").click(function(){
		$(".table2excel").table2excel({
			// 不被导出的表格行的CSS class类
			exclude: ".noExl",
			// 导出的Excel文档的名称
			name: "Excel Document Name",
			// Excel文件的名称
			filename: "test",
			//文件后缀名
			fileext: ".xls",
			//是否排除导出图片
			exclude_img: false,
			//是否排除导出超链接
			exclude_links: false,
			//是否排除导出输入框中的内容
			exclude_inputs: false
		});
	});
	//点击不显示序号
	
	$(":checkbox").click(function(){
		var val=$(this).attr("id");
		if( $(this).prop('checked')){
			$("[name='"+val+"']").removeClass("noExl");
		}else{
			$("[name='"+val+"']").addClass("noExl");
		}
	});
});