<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<label>输入商品名称:</label> <input id="queryName" value="${name }" type="text">
	<label>输入商品标题:</label> <input id="queryCaption" value="${names }" type="text">
	<button type="button" class="btn btn-success" onclick="query(0)">搜索</button>
	<button type="button" class="btn btn-danger" onclick="delBatch()">批量删除</button>
	<button type="button" class="btn btn-danger" onclick="toadd()">添加</button>
</div>
<div>
	<table class="table">
		<tr>
			<th><input type="checkbox" id="ids" onchange="selAll()">
				id</th>
			<th>商品名称</th>
			<th>是否上线</th>
			<th>品牌</th>
			<th>标题</th>
			<!-- <th>分类</th>
			<th>小图</th> -->
			<th>操作</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="spu">
			<tr>
				<td><input type="checkbox" value="${spu.id }" name="id">
					${spu.id}</td>
				<td>${spu.goodsName}</td>
				<td>${spu.isMarketable==1?'上线':'未上线' }</td>
				<td>${spu.brand.name }</td>
				<td>${spu.caption }</td>
				<%-- <td>${spu.actegory.name }</td> --%>
				<%-- <td>
					<img alt="" src="/pic/${spu.smallPic }" width="50px" height="50px">
				</td> --%>
				<td>
					<button type="button" class="btn btn-success"
						onclick="toModify(${spu.id})">修改</button>
					<button type="button" class="btn btn-danger"
						onclick="del(${spu.id})">删除</button>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">

				<nav aria-label="...">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="javaScript:query(1)" tabindex="-1">首页</a></li>
						<c:forEach begin="1" end="${pageInfo.pages }" var="page">
							<c:if test="${page!=pageInfo.pageNum }">
								<!-- 显示非当前页数 -->
								<li class="page-item"><a class="page-link"
									href="javaScript:query(${page })">${page }</a></li>
							</c:if>
							<c:if test="${page==pageInfo.pageNum }">
								<!-- 显示当前页数 -->
								<li class="page-item active" aria-current="page"><a
									class="page-link" href="#">${page } <span class="sr-only">(current)</span></a>
								</li>
							</c:if>
						</c:forEach>


						<li class="page-item"><a class="page-link"
							href="javaScript:query(${pageInfo.pages })">尾页</a></li>
					</ul>
				</nav>

			</td>
		</tr>
	</table>
</div>
<script>
	function toModify(id){
		$("#workcontent").load("/spu/toupdate?id="+id);
		$("#workTitle").html("规格修改");
	}
	
	//显示的页数
	function query(page) {
		$("#workcontent").load("/spu/list?page="+ page + "&name="+$("#queryName").val() );
		$("#workcontent").load("/spu/list?page="+ page + "&names="+$("#queryCaption").val() );
	}
	
	function selAll() {
		$("[name=id]").each(function(){
			$(this).prop("checked",$("#ids").prop("checked"));
		});
	}	
	//批量删除
	function delBatch() {
		//被删除的id
		var delIds = new Array();
		$("[name=id]:checked").each(function(){
			delIds.push($(this).val());
		})
		if(delIds.length<=0) {
			alert("没有选择数据");
			return;
		}
		
		var result=confirm("确认删除这些数据吗");
		if(!result) {
			return;
		}
		
		alert(delIds);
		$.post("/spec/delBatch",{ids:delIds},function(data){
			if(data=="success") {
				alert("删除成功");
				query(1);
			} else {
				alert("删除失败");
			}
		})
	}
	
	function del(id) {
		var result=confirm("确认删除这条数据吗");
		if(!result) {
			return;
		}
		var delIds = new Array();
		delIds.push(id);
		alert(delIds);
		$.post("/spu/delBatch",{ids:delIds},function(data){
			if(data=="success") {
				alert("删除成功");
				query(1);
			} else {
				alert("删除失败");
			}
		})
	}
	
	function toadd() {
		$("#workcontent").load("/spu/toadd");
		$("#workTitle").html("商品添加");
	}
</script>