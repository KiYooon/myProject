//앵귤라 모듈 만들기
var app = angular.module("Site", [ "ngRoute","ngCookies","Main","Board","Detail","Login","Signup"]);
// 라우터 처리 부분 (싱글페이지 적용)
app.config(function($routeProvider) {
	$routeProvider.when("/main", {
		templateUrl : "resources/views/main.html",
		controller : "main"
	}).when("/board",{
		templateUrl : "resources/views/board.html",
		controller : "board"
	}).when("/detail/:param",{
		templateUrl : "resources/views/detail.html",
		controller : "detail"
	}).when("/login",{
		templateUrl : "resources/views/login.html",
		controller : "login"
	}).when("/signup",{
		templateUrl : "resources/views/signup.html",
		controller : "signup"
	}).otherwise({redirectTo: "/main"});
	
	
});

app.run(function($rootScope ,$http, $location, $cookies){
	$rootScope.nav = 'resources/views/nav.html';
	
	$rootScope.navEvent = function(){
		$rootScope.navDis = location.hash;
	};
	
	$rootScope.user ={
			id : "",
			pw : ""
	}
	
	$rootScope.user_reset = function(){
		$rootScope.user ={
				id : "",
				pw : ""
		}
	}
	$rootScope.signUpinfo = {
			id :"",
			pw : "",
			name : "",
			email : ""
	}
	
	$rootScope.loginFlag = true;
	
	$rootScope.loginCheck = function(){
		$http.post("LoginCheck").then(function(result){
//			console.log(result);
			if(result.data.status == 0){
//				alert("로그인을 하세요.");
				location.href = "#!/login";
			}else{
				$rootScope.loginFlag = false;
			}
			
		});
		
		if($location.path() != "/board"){
			$cookies.put('search', "");
			$cookies.put('pageNum', "1");
		}
	};
	
	$rootScope.logout = function(){      
	      $http.post("logout")
	       .then(function(response) {
	          alert("이용해 주셔서 감사합니다.");
	          $rootScope.loginFlag = true;
	         location.href="#!/main";
	       }),function(result){
	         alert("로그아웃 실패.");
	      }
	};
	
	
});
app.controller("public", function($rootScope, $scope){
	$rootScope.navEvent();
});

app.factory("FileService", function($q, $http){
	var deffered = $q.defer();
	var result = [];
	var fileService = {};
	
	fileService.async = function(url, formData, param) {
		$http.post(url, formData, {
			headers : {"Content-Type" : undefined},
			params : param
		}).then(data => {
			result = data;
			deffered.resolve();
		}, data => {
			result = data;
			deffered.resolve();
		});
		return deffered.promise;
	}
	fileService.data = function(){
		return result;
	}
	return fileService;
});
app.directive("modal", function(){

	return {
		restrict : "E",
		templateUrl : 'resources/views/directive/modal.html'
	}
});
