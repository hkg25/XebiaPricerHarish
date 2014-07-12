/**
 * 
 */

$(function(){
	
	jQuery.jgrid.no_legacy_api = true;
	$("#list4").jqGrid(
        { datatype: "json",
	      url: productDataUrl,
	      autowidth: true,
	      height:500,
	      loadonce: true,
	      //width: 1034,
	      loadtext:'',
	      rownumbers: true,
	      pager: '#pnewapi',
	      colNames:[
	                'Name',
	                'Barcode',
	                'created By',
	                'Created On',
	               ],
	      colModel:[ {name:'name',align:'left', search:false,sortable:true},
	                 {name:'barcode',index:'barcode', align:'left',  search:true,sortable:true,},	                 
		    	         {name:'created',index:'created', align:'left',search:false,sortable:true},
		    	         {name:'createdon',index:'createdon', align:'center',search:false,sortable:true},
		    	         ],
		    	        
		    	         rowNum:20,
		  viewrecords:true,
		   onSelectRow: function(id){
			   var bcode = $(this).getRowData(id)['barcode'];
			   angular.element($("#productName")).scope().updateDetail(bcode);
		  }
		});
	
});

var webAttendance = angular.module('pricerApp', [ ]);

webAttendance.controller('productDetailController', function ($scope,$http) {
	 $scope.product = {};
	 $scope.updateDetail = function (barcode){
		 $http({
			    url: productDetailUrl, 
			    method: "GET",
			    params:{
			    	"barcode" : barcode
			    }
			 }).success(function(data, status, headers, config) {
				 $scope.product =data;
			    }).
			    error(function(data, status, headers, config) {
			      // called asynchronously if an error occurs
			      // or server returns response with an error status.
			    });
	 }
	 $scope.$watch(function(){         
		    return $("#barcode").attr('value');    // Set a watch on the actual DOM value
		}, function(newVal){
			console.log(newVal)
		    $scope.barcode = newVal;
		});
});
