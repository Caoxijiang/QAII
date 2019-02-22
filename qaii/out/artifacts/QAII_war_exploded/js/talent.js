// JavaScript Document
//绘制高端人才界面
//获取到canvas元素

        var canvas = document.getElementById('talents');
		var canvasBox = document.getElementById('canvasBox').offsetWidth;
		canvas.width = canvasBox;

	 
        //获取canvas中的画图环境
        var context = canvas.getContext('2d');
		var wid=canvas.width;
 
        //创建Image对象
        var img = new Image();
		var imgbox = new Image();
        //alert(img);
        //引入图片URL
        img.src = "../../image/talent.png";
//		imgbox.src ="bac.png";
		img.onload = function (){
			context.drawImage(img,0,0,wid,0.5*wid);
			//绘制高端人才矩形框
			context.fillStyle="#2574b7";
			context.fillRect(197*wid/500,98*wid/500,23*wid/500,28*wid/500);
			context.fillRect(223*wid/500,98*wid/500,23*wid/500,28*wid/500);
			context.fillRect(249*wid/500,98*wid/500,23*wid/500,28*wid/500);
			context.fillRect(275*wid/500,98*wid/500,23*wid/500,28*wid/500);

			context.fillStyle="#fff";
			context.font="bold 20px Arial";
			context.textAlign="left";
			context.fillText("1",204*wid/500,120*wid/500);
			context.fillText("3",230*wid/500,120*wid/500);
			context.fillText("5",256*wid/500,120*wid/500);
			context.fillText("0",282*wid/500,120*wid/500);
			
			context.font="bold 8px Arial";
			context.textAlign="center";
			context.shadowColor="rgba(0,0,0,0.4)";
			context.shadowOffsetX = 1;
    		context.shadowOffsetY = 1;
			//千人计划
			context.fillStyle="#8fc31f";
			context.fillText("6人",128*wid/500,49*wid/500);
			//百人计划
			context.fillStyle="#8e1c76";
			context.fillText("4人",64*wid/500,102*wid/500);
			//研究院人员
			context.fillStyle="#1576bd";
			context.fillText("172人",131*wid/500,155*wid/500);
			//国家期刊主编
			context.fillStyle="#f39800";
			context.fillText("4人",140*wid/500,231*wid/500);
			//国家优青
			context.fillStyle="#2ea7e0";
			context.fillText("1人",286*wid/500,231*wid/500);
			//国家杰青
			context.fillStyle="#e4007f";
			context.fillText("4人",358*wid/500,183*wid/500);
			//学科带头人
			context.fillStyle="#f8b62d";
			context.fillText("17人",438*wid/500,142*wid/500);
			//博士学历
			context.fillStyle="#6a2b85";
			context.fillText("36人",383*wid/500,78*wid/500);
		}
	
