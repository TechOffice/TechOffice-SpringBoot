<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

	<head>
		<script type="text/javascript" src="webjars/angularjs/1.7.5/angular.js"></script>
		<script type="text/javascript">
			var app = angular.module("app", []);
			app.controller("appController",function($scope, $http){
				
				$scope.editing = false;
				
				// search 
				$scope.search = function(){
					$http.post("./customer/findAll"
					).then(function(response){
						$scope.customerList = response.data;
					});
				}
				
				// select
				$scope.select = function(customer){
					$scope.customer = customer;
					$scope.editing = true;
				};
				
				// submit
				$scope.submit = function(){
					$http.post("./customer/update", 
						$scope.customer
					).then(function(response){
						if ($scope.customer.id){
							alert($scope.customer.id + " Updated.");
						}else {
							alert(response.data.id + " Created.");
						}
						$scope.search();
					});	
				};
				
				// create
				$scope.create = function(){
					$scope.editing = true;
					$scope.customer = {};
				}
				
				
			});
		</script>
	</head>

	<body ng-app="app" ng-controller="appController">
		<button ng-click="search()">Search</button>
		<button ng-click="create()">Create</button>
		<table border="1">
			<tr ng-repeat="customer in customerList" ng-click="select(customer)">
				<td>{{customer.id}}</td>
				<td>{{customer.firstName}}</td>
				<td>{{customer.lastName}}</td>
			</tr>
		</table>
	
		<form ng-submit="submit()" ng-if="editing">
			<table>
				<tr>
					<td><span>User Name: </span></td>
					<td><input type="text" ng-model="customer.firstName"/></td>
				</tr>
				<tr>
					<td><span>Password: </span></td>
					<td><input type="text" ng-model="customer.lastName"/></td>
				</tr>
				<tr colspan="2">
					<td><button type="submit" >Submit</button></td>
				</tr>
			</table>
		</form>
	</body>

</html>