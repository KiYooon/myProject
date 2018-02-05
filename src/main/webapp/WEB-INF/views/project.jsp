<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-ng-app="Site">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

	 <link rel="stylesheet" href="resources/css/main.css">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
     <script type="text/javascript" src="resources/templates/js/jquery-3.2.1.min.js"></script>
<!--      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script> -->
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

     <script type="text/javascript" src="resources/angular/angular.min.js"></script>
     <script type="text/javascript" src="resources/angular/angular-route.min.js"></script>
     <script type="text/javascript" src="resources/angular/dirPagination.js"></script>
     <script type="text/javascript" src="resources/angular/angular-cookies.min.js"></script>
     
     <script type="text/javascript" src="resources/templates/js/project.js"></script>
     <script type="text/javascript" src="resources/templates/js/main.js"></script>
     <script type="text/javascript" src="resources/templates/js/board.js"></script>
     <script type="text/javascript" src="resources/templates/js/detail.js"></script>
     <script type="text/javascript" src="resources/templates/js/login.js"></script>
     <script type="text/javascript" src="resources/templates/js/signup.js"></script>
<title>Project</title>
</head>
<body>
<div data-ng-include="nav"></div>

<div data-ng-view></div>


</body>
</html>