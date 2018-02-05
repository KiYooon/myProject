//앵귤라 모듈 만들기
var app = angular.module("Signup",[]);

app.controller("signup", function($rootScope, $scope, FileService, $http){
	$rootScope.navEvent();
	
//	$scope.addUser = () => {
//		console.log($scope.user);
//		FileService.async("addUser", "", $scope.user).then(function(){
//			var data = FileService.data();
//			console.log(data);
//			alert("회원가입에 성공하셨습니다!");
//			location.href = "#!/login";
//		});
//	}; 
	$scope.addUser = function(){
		var id = $("#ID").val();
        var pw = $("#PW").val();
        var name = $("#NAME").val();
        var email = $("#EMAIL").val();
        
        if(id == "" || pw == "" || name == "" || email == "") {
            alert("모든 정보를 입력해주세요.");
            return false;
        }
        
		$http.post("addUser","",{params:$rootScope.signUpinfo})
		.then(function(result){
			console.log(result);
			if(result.data.status == 0){
				alert("이미 사용중인 아이디입니다.");
				return false;
			}else{
				alert("회원가입이 성공하셨습니다!");
				location.href = "#!/login";
				
			}
		}, function(result){
			console.log("실패");
		});
			
		
	}
});
