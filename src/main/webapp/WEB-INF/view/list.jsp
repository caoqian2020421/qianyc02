<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link href="/resource/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
</head>

<body>
  <form action="/list" method="post">
   影片名称:<input type="text" name="name"/> 上映时间:<input type="text" name="t1"/>--<input type="text" name="t2"/><br><br>
 导演:<input type="text" name="actor"/>价格区间:<input type="text" name="p1"/>--<input type="text" name="p2"/><br><br>
 年代:<input type="text" name="years"/>电影时间长:<input type="text" name="l1"/>--<input type="text" name="l2"/><br><br>
  <input type="submit" value="查询"/>
  <button type="button" onclick="dele()">批量删除</button>
  </form>
  
    <button type="button" onclick="chk(1)">全选</button>
    <button type="button" onclick="chk(2)">反选</button>
    <button type="button" onclick="chk(3)">全不选</button>
    
    <table>
       <tr>
         <td>选择</td>
         <td>电影名称</td>
         <td>导演</td>
         <td><button type="button" class="btn btn-link" onclick="myorder('price')">票价</button></td>
         <td>上映时间</td>
         <td><button type="button" class="btn btn-link" onclick="myorder('longtime')">时长</button></td>
         <td>类型</td>
         <td><button type="button" class="btn btn-link" onclick="myorder('years')">年代</button></td>
         <td>区域</td>
         <td>状态</td>
       </tr>
       <c:forEach items="${info.list }" var="mo">
         <tr>
           <td><input type="checkbox" name="ids" value="${mo.id }"/></td>
           <td>${mo.name }</td>
           <td>${mo.actor }</td>
           <td>${mo.price }</td>
           <td>${mo.uptime }</td>
           <td>${mo.longtime }</td>
           <td>${mo.type }</td>
           <td>${mo.years }</td>
           <td>${mo.area }</td>
           <td>${mo.status }</td>
         </tr>
       </c:forEach>
       <tr>
         <td colspan="100">
       <jsp:include page="/WEB-INF/view/pages.jsp"></jsp:include>
         </td>
       </tr>
    </table>
</body>
<script type="text/javascript">

//全选
function chk(flag){
	if(flag==1){
		$("[name='ids']").prop("checked",true);
	}else if(flag==2){
		$("[name='ids']").each(function(){
			$(this).prop("checked",!$(this).prop("checked"));
		});
	}else{
		$("[name='ids']").prop("checked",false);
	}
}


//批量删除
function dele() {
	var ids = new Array();
	$("[name='ids']:checked").each(function(i){
		ids[i]=$(this).val();
	})
	if(ids.length==0){
		alert("请至少选择一个");
		return;
	}
	$.ajax({
		url:"/deleteBatch",
		type:"post",
		data:{ids:ids},
		success:function(flag){
			if(flag){
				alert("删除成功");
				location.href="/list";
			}else{
				alert("删除失败");
			}
		},
		dataType:"json"
	})
}


//排序
function myorder(orderName){
	var orderMethod='${movieVo.orderMethod}';
	orderMethod=orderMethod=='desc'?'asc':'desc';
	location.href="/list?orderName="+orderName+"&orderMethod="+orderMethod;
}


//分页
  function goPage(pageNum) {
	location.href="/list?pageNum="+pageNum
}
</script>
</html>