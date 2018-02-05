//앵귤라 모듈 만들기
var app = angular.module("Login",[]);

app.controller("login", function($rootScope, $scope, FileService,$http){
	$rootScope.navEvent();

	$scope.login = function(){
		$http.post("login","",{params:$rootScope.user})
		.then(function(data){
			console.log(data);
			if(data.data.status==1){
				alert("로그인성공!");
				$rootScope.user = data.data;
				location.href = "#!/main";
			}else{
				alert("아이디 혹은 비밀번호를 확인해주세요.");
				$rootScope.user_reset();
			}
	});
};
/*	$scope.login = () => {
		if($rootScope.user.id != "" && $rootScope.user.pw !=""){
			FileService.async("login", "", $rootScope.user).then(function(){
				var data = FileService.data();
				console.log(data);
				console.log(data.data.status);
				if(data.data.status==1){
					alert("로그인성공!");
					location.href = "#!/main";
				}else{
					alert("로그인 실패");
					$rootScope.user_reset();
				}
//				console.log(data);
//				console.log(data.data.login);
			});
		}else{
			alert("아이디 혹은 비밀번호를 입력해주세요.");
		}
	};
	
});*/

});
