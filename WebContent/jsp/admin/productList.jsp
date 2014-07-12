<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" media="screen">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js"></script>  
<script src="${pageContext.request.contextPath}/resources/js/jqgrid/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jqgrid/jquery.jqGrid.src.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/angular.min.js" type="text/javascript"></script>
<script src="productList.js" ></script>
<link type="text/css" href="${pageContext.request.contextPath}/resources/css/themes/base/jquery.ui.all.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css/jqgrid/ui.jqgrid.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>

<script>
var productDataUrl = "${pageContext.request.contextPath}/product/list" ;
var productDetailUrl = "${pageContext.request.contextPath}/product/detail"
</script>
</head>
<body>
<div class="row">
<div  class = "left" style="width: 70%;">
<table id="list4" class="loadingBack" style="width: 100%;"></table>
<div id="pnewapi" style=""></div>
</div>

<div ng-app="pricerApp" class = "left" style="margin-left:30px;" >
	<div class="" ng-controller="productDetailController" ng-show="product.itemSize>0">
	
	
	<div>
	<div class="row">
<div class="left width150">Name</div>

<div class="left">
<input type="text" ng-disabled="true" id="productName" ng-model="product.name" />
</div>

<div class="clear"></div>
</div>

<div class="row">
<div class="left width150">Product bar code</div>

<div class="left">
<input type="text" ng-disabled="true" ng-model="product.barcode" name="barCode" />
</div>

<div class="clear"></div>
</div>

<div class="row">
<div class="left width150">Notes</div>

<div class="left">
<input type="text" ng-disabled="true" ng-model="product.notes" name="notes" />
</div>

<div class="clear"></div>
</div>

<div class="row">
<div class="left width150">Average Price</div>

<div class="left">
<input type="text" name="price" ng-disabled="true" ng-model="product.avgPrice" />
</div>

<div class="clear"></div>
</div>

<div class="row">
<div class="left width150">Lowest Price</div>

<div class="left">
<input type="text" name="price" ng-disabled="true" ng-model="product.minPrice"/>
</div>

<div class="clear"></div>
</div>

<div class="row">
<div class="left width150">Hightest Price</div>

<div class="left">
<input type="text" name="price" ng-disabled="true" ng-model="product.maxPrice"/>
</div>

<div class="clear"></div>
</div>

<div class="row">
<div class="left width150">Ideal Price</div>

<div class="left">
<input type="text" name="price" ng-disabled="true" ng-model="product.idealPrice"/>
</div>

<div class="clear"></div>
</div>


<div class="row">
<div class="left width150">Number of prices collected</div>

<div class="left">
<input type="text" name="price" ng-disabled="true" ng-model="product.itemSize"/>
</div>

<div class="clear"></div>
</div>

<div class="row">
<div class="left width150">Created By </div>

<div class="left">
<input type="text" name="price" ng-disabled="true" ng-model="product.createdBy"/>
</div>

<div class="clear"></div>
</div>

<div class="row">
<div class="left width150">Created On </div>

<div class="left">
<input type="text" name="price" ng-disabled="true" ng-model="product.date"/>
</div>

<div class="clear"></div>
</div>
	</div> <!-- end of detail view -->
	
	</div>
</div>
<div class = "clear"></div>
</div>
 <button onclick="window.location='${pageContext.request.contextPath}'" id="backButton" >HOME</button>
</body>
</html>