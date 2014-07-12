/**
 * 
 */
$(function(){
	
	
	$( "#barcode" )
	// don't navigate away from the field on tab when selecting an item
	.bind( "keydown", function( event ) {
	if ( event.keyCode === $.ui.keyCode.TAB &&
			$( this ).data( "autocomplete" ).menu.active ) {
		event.preventDefault();
	}
	})
	.autocomplete({
		minLength: 0,
		source: fetchProductsUrl, 
		focus: function() {
			// prevent value inserted on focus
			return false;
		},
		}).data( "autocomplete" )._resizeMenu= function() {
			  this.menu.element.outerWidth( 320 );
		}
});

var split=function( val ) {
	return val.split( /,\s*/ );
}
var webAttendance = angular.module('pricerApp', [ ]);

webAttendance.controller('storePriceCreateController', function ($scope,$http) {
	$scope.storePrice={}
	$scope.isSaving = false;
	 $scope.saveStorePrice = function (){
		if(isNaN($scope.storePrice.price)){
			alert("Price should be numeric");
			return;
		}
		$scope.isSaving = true;
		 $http({
			    url: saveStorePriceUrl, 
			    method: "POST",
			    data:$scope.storePrice
			 }).success(function(data, status, headers, config) {
				 alert("Saved !!");
				 $("#backButton").click();
			    }).
			    error(function(data, status, headers, config) {
			    });
	 }
	 
	 $scope.resetStorePrice = function(){
		 $scope.storePrice={};
	 }
});
