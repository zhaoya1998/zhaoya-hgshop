<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >
<script type="text/javascript" src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"> </script>
<!-- sku的添加 -->
<div class="container">
	<div class="container">
	<form action="" id="spuForm">
		<input type="hidden" name="spuId" value="${spu.id}">
		<div class="form-group row">
		    <label  class="col-sm-2 col-form-label">商品名称</label>
		    <div class="col-sm-10">
		      <input type="text" disabled="disabled"  value="${spu.goodsName}" class="form-control" >
		    </div>
		 </div>
		 <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">标题</label>
		    <div class="col-sm-10">
		      <input type="text" name="title" class="form-control" >
		    </div>
		 </div>
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">卖点</label>
		    <div class="col-sm-10">
		      <input type="text" name="sellPoint" class="form-control" >
		    </div>
		 </div>
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">价格</label>
		    <div class="col-sm-10">
		      <input type="text" name="price" class="form-control" >
		    </div>
		 </div>
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">大图</label>
		    <div class="col-sm-10">
		    	<input type="file" class="form-control-file" id="image" name="imageFile">
		    </div>
		 </div>
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">小图</label>
		    <div class="col-sm-10">
		    	<input type="file" class="form-control-file" id="file" name="cartFile">
		    </div>
		 </div>
		
		 <div class="form-group row" id="specs">
		    <label  class="col-sm-2 col-form-label">规格管理</label>
		     <div class="col-sm-10">
		    	<input type="button" value="添加属性"  onclick="addSpec()"> 
		    </div>
		 </div>
	 </form>
	 </div>
	 <div hidden="true" id="oneSepec">
	 	<div class="row col-md-12" style="height: 30px">
	 		<div class="col-md-2">
	 		</div>
		    <div class="col-md-3">
		      <select name="specId">
		      	<c:forEach items="${specList}" var="spec">
		      		<option value="${spec}">${spec.specName}</option>
		      	</c:forEach>
		      </select>
		    </div>
		    <div class="col-md-3">
		       <select name="optionId"></select>
		    </div>
		 </div>
	 </div>
</div>

<script>
	function addSpec(){
		alert($("#oneSepec").html())
		$("#specs").append($("#oneSepec").html())
		
	}

</script>
		 