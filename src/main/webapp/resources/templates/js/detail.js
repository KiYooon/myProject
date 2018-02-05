//앵귤라 모듈 만들기
var app = angular.module("Detail",['angularUtils.directives.dirPagination']);

app.controller("detail", function($rootScope, $scope, $http, $routeParams){
	$rootScope.loginCheck();
	
	$scope.detailNo = $routeParams.param;
	$rootScope.navEvent();
	$rootScope.detaillist = {
								days:"",
								no:"",
								contents:"",
								picName:"",
								picPath:"",
								title:"",
								name:""		
							};
	$scope.picName = {"background-image": "url("+$rootScope.detaillist.picPath + $rootScope.detaillist.picName+")"};
	
	var d = [];
	var i = 0;
	//코스더보기
	$scope.btnmore = function(){
		var end = i + 3;
		
		
		for(; i < end; i++){
			if(i>=$scope.course.length){
				$(".btnmore").hide();
				break;
			}else{
				d.push($scope.course[i]);
			}
		}
//		console.log(d);
		$scope.zxc = d;	
	}   
	
	$scope.qwe = {no : $rootScope.no};
	//게시판 상세보기
	$scope.asd = function(){
		console.log($scope.detailNo);
		console.log($rootScope.detaillist)
		$http.post("oneBoard","",{params : {no : $scope.detailNo}}).then(function(result){
			
			$rootScope.detaillist = result.data.one;
			$scope.course = result.data.list;
			$scope.comment = result.data.reviewList;
//			console.log($scope.comment);
			$scope.picName = {"background-image": "url("+$rootScope.detaillist.picPath + $rootScope.detaillist.picName+")"};
//			console.log($scope.picName);
			$scope.btnmore();

		});
	}
	$scope.asd();
	
	//리뷰작성
	
	$scope.aa="";
	$scope.textclear = function(){
		$scope.aa="";
	}
	$scope.review = function(){	
		
		var reviewBox = $(".reviewForm textarea").val();
		if(reviewBox == ""){
			alert("리뷰를 작성해 주세요~");
			return false;
		}
		
		$http.post("review","",{params : {"content" : $scope.aa, "no" : $rootScope.detaillist.no}})		
		
			.then(function(result){
				alert("소중한 리뷰 감사합니다 '-'");
				$scope.textclear();
				console.log("성공");
				$scope.asd();
			}, function(result){
				console.log("실패");
			});
	}
	
	
	$scope.sendMail = function(){
		console.log($rootScope.user);
		var mail = {
				toMailAddr : $rootScope.detaillist.email,
				title      : $rootScope.detaillist.title,
				contents   : $rootScope.user.id + "님이 가이드 신청 하셨습니다."
		};
		$http.post("mail","",{params : mail}).then(function(result){
			console.log(result.data);
			if(result.data.status == 1){
				alert("정상적으로 접수 되셨습니다.");
			} else {
				alert("접수 중 오류가 발생하여 관리자에게 문의하시기 바랍니다.");
			}
		});
	}
});