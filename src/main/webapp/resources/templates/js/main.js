//앵귤라 모듈 만들기
var app = angular.module("Main",[]);
app.controller("main", function($rootScope, $scope){
	$rootScope.loginCheck();
	$rootScope.navEvent();
	
	$scope.carouselData = [
		{url:"resources/templates/img/슬라이드.jpg", type: true},
		{url:"resources/templates/img/슬라이드1.jpg"},
		{url:"resources/templates/img/슬라이드2.jpg"},
		{url:"resources/templates/img/슬라이드3.jpg"},
		{url:"resources/templates/img/슬라이드4.jpg"}
	];
	$scope.hash = "#!/main";
	
	$scope.projectInfoData = {
		data1 : [{
					url:"resources/templates/img/149923712091001.jpg",
					p:"카밀리에 힐",
					p2:"제주도"
				},{
					url:"resources/templates/img/20151001170838166_8AO5Z65N.jpg",
					p:"동피랑 마을",
					p2:"통영"
				},{
					url:"resources/templates/img/DSC_6141.jpg",
					p:"감천문화마을",
					p2:"부산"
				}]
	};
	
	$scope.slideEvent = (type) => {
		$("#myCarousel").carousel(type).carousel("pause");
	};
});

app.directive("carousel", function(){

	return {
		restrict : "E",
		templateUrl : 'resources/views/directive/carousel.html'
	}
});

