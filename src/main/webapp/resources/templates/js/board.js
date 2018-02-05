//앵귤라 모듈 만들기
var app = angular.module("Board",[]);

app.controller("board", function($rootScope, $scope, $http, $filter, $location, $cookies){
	$rootScope.loginCheck();
	$rootScope.navEvent();
	$scope.viewRow = 5;
	$scope.search = $cookies.get('search');
	$scope.dataSource = [];
	$scope.pageNum = $cookies.get('pageNum');
	$scope.onload = false;
	
	$scope.$watch('search', function() {
		if($scope.search){
			$scope.pageNum = 1;
			$cookies.put('pageNum', $scope.pageNum);
			$cookies.put('search', $scope.search);
			$scope.totCnt = $filter('filter')($scope.dataSource, $scope.search).length;
            $scope.page = $scope.totCnt / $scope.viewRow;  /* 상품1 리스트의 페이징 될 갯수 데이터 생성 */
   		 	$scope.returnFnc();
		} else {
			$cookies.put('search', "");
			if($scope.onload){
				$scope.list();
			}
		}
	  });
	
	$scope.list = function(){
		$scope.onload = false;
		$http.post("listBoard")
		     .then(function(result){
		    	 $scope.dataSource = result.data.list;
		    	 $scope.totCnt = $filter('filter')($scope.dataSource, $scope.search).length;
	             $scope.page = $scope.totCnt / $scope.viewRow;  /* 상품1 리스트의 페이징 될 갯수 데이터 생성 */
	    		 $scope.returnFnc();
	    		 $scope.onload = true;
		});
	}
	
	
	$scope.returnFnc = function() {
	    $scope.end = ($scope.viewRow * $scope.pageNum); /* 리스트에 보여줄 끝 번호 생성 */
	    $scope.start = ($scope.end - $scope.viewRow);   /* 리스트에 보여줄 시작 번호 생성 */
        $scope.pageArry = [];                           /* 페이징으로 보여 줄 리스트 데이터 생성  */
        for(var i = 0; i < $scope.page; i++){
        	$scope.pageArry[i] = i;
        }
	}
	
	$scope.detail = function(row){
		$rootScope.no=row.no;
		location.href="#!/detail/" + row.no;
	}
	
	$scope.pageEvent = function(index){
		$scope.pageNum = index + 1;
		$cookies.put('pageNum', $scope.pageNum);
		$scope.list();
	}
	
	$scope.list();
});
