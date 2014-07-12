<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" media="screen">
<link type="text/css" href="${pageContext.request.contextPath}/resources/css/themes/base/jquery.ui.all.css"
	rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js"></script> 
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.8.7.custom.min.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/resources/js/angular.min.js" type="text/javascript"></script>
<script src="newProduct.js" ></script>
<script>
var saveStorePriceUrl = "${pageContext.request.contextPath}/storePrice/save";
var fetchProductsUrl = "${pageContext.request.contextPath}/product/fetchProduct"
</script>
</head>
<body ng-app="pricerApp">
<div ng-controller="storePriceCreateController">
<div class="row">
<div class="left width150">Store</div>

<div class="left">
<input type="text" name="store" ng-model="storePrice.store" ng-disabled="isSaving" id="store" />
</div>

<div class="clear"></div>
</div>

<div class="row">
<div class="left width150">Product bar code</div>

<div class="left">
<input type="text" name="barCode" ng-model="storePrice.barCode" ng-disabled="isSaving" id="barcode" />
</div>

<div class="clear"></div>
</div>

<div class="row">
<div class="left width150">Price</div>

<div class="left">
<input type="text" name="price" ng-model="storePrice.price" ng-disabled="isSaving"  />
</div>

<div class="clear"></div>
</div>

<div class="row">
<div class="left width150">Notes</div>

<div class="left">
<input type="text" name="notes" ng-model="storePrice.notes"  ng-disabled="isSaving" />
</div>

<div class="clear"></div>
</div>
<div class="row"><button ng-click="saveStorePrice()" >SAVE</button> &nbsp; <button ng-click="resetStorePrice()" >RESET</button>&nbsp;  <button onclick="window.location='${pageContext.request.contextPath}'" id="backButton" >BACK</button></div>

</div>
</body>
</html>