<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

	<head>
		<script src="webjars/angularjs/1.7.7/angular.min.js"></script>
		<script>
			var app = angular.module('app', []);
			app.controller("appController", function($scope, $http){
				$scope.submit = function(){
					$http.post(
						"./save", 
						$scope.customer
					).then(function(res){
						$scope.customer = res.data;
					}, function(err){
						alert(JSON.stringify(err));
					});
				}
			});
		</script>
	</head>
	<body ng-app="app">
		Hello World! This is Spring Boot JSP Page!!!
		<form ng-controller="appController" ng-submit="submit()">
			<div>First Name: <input ng-model="customer.firstName"/></div>
			<div>Last Name: <input ng-model="customer.lastName"/></div>
			<div><button type="submit">Submit</button></div>
			<div>{{customer}}</div>
		</form>
	</body>

</html>