var wineapp = angular.module('wineapp', ['ngRoute']);

var score = 0;
var result = null;


wineapp.config(function($routeProvider){
	$routeProvider
	.when('/resume', {
		templateUrl : 'resume.html'
	})
	.when('/wineQuiz', {
		templateUrl : 'wineQuiz.html',
		controller : 'wineQuizController'
	})
	.when('/create', {
		templateUrl : 'create.html',
		controller : 'wineCreateController'
	})
	.when('/wineSearch', {
		templateUrl : 'wineSearch.html'
	})
	.when('/adminSearch', {
		templateUrl : 'adminSearch.html',
		controller : 'wineFancyController'
	})
	.when('/stack', {
		templateUrl : 'stack.html'
	})
	.otherwise({
		redirectTo : 'wine.html'
	})

});


wineapp.controller('wineQuizController', function($scope, $http){
	$scope.qOneAnswer = function(answer){
		score = answer;
		console.log(score);
	}
	
	$scope.getWinesByAnswer = function(){
		console.log(score);
		
		$scope.showQuiz = false;
		
		console.log('getWines');
		$scope.wine = [{"name" : "retrieving wines..."}];
		
		$scope.showSearch = true;
		$scope.showEditDelete = false;
		
		$http.get("/project/webapi/wines/" + score)
		.then(function(response){
			$scope.wines = response.data;
			
			console.log('number of wines: ' + $scope.wines[0].name);
		}, function(response) {
			console.log('error HTTP GET wines: ' + respone.status);
			});
		
		
			
		}
	
})


wineapp.controller('winecontroller', function($scope, $http){
	$scope.appName= 'Wine Quiz, by Scott Arbuckle';
	
	$scope.address = '216 chalamont lane, Little Rock, AR';
	$scope.phone = '501-749-4033';
	$scope.email = 'csarbuckle@outlook.com';
	$scope.showSearch = true;
	$scope.showEditDelete = false;
	$scope.chocolate = ['1','2','3','4','5','6'];
	$scope.season = ['1','2','3','4'];
	$scope.dinner = ['1','2','3','4','5','6'];
	$scope.coffee = ['1','2','3','4'];
	$scope.cheese = ['1','2','3','4','5','6'];
	


	
	$scope.getWines = function(){
		
		console.log('getWines');
		$scope.wine = [{"name" : "retrieving wines..."}];
		
		$scope.showSearch = true;
		$scope.showEditDelete = false;
		
		$http.get("/project/webapi/wines/")
		.then(function(response){
			$scope.wines = response.data;
			console.log('number of wines: ' + $scope.wines.length);
		}, function(response) {
			console.log('error HTTP GET wines: ' + respone.status);
			});
		
		
			
		}
	$scope.updateWine = function(wineToUpdate) {
		console.log('wineToUpdate title: ' + angular.toJson(wineToUpdate));
		$scope.wineToUpdate = angular.copy(wineToUpdate);
		$scope.showEditDelete = true;
		$scope.showSearch = false;
		$scope.isUpdateDisabled = false;
	$scope.isDeleteButtonDisabled = false;
		$scope.updateStatus = '';
		
		
		
	}
	
	

	$scope.returnToSearch = function() {
		$scope.showEditDelete = false;
		$scope.showSearch = true;
		$scope.getWines();
	}
	
	$scope.deleteWine = function(wineID) {
		console.log('delete wine: ' + wineID);
		
		$http.delete("/project/webapi/wines/" + wineID)
		.then(function(response){
			$scope.isUpdateButtonDisabled = true;
			$scope.isDeleteButtonDisabled = true;
			$scope.updateStatus = 'delete successful';
			console.log('number of wines deleted: ' + response.data.length);
		}, function(response) {
			console.log('error HTTP DELETE wines: ' + respone.status);
			$scope.updateStatus = 'delete error, ' + response.data.message;
			
		});
		
	}
	
	$scope.putWine = function(wineToUpdate) {
		$scope.jsonObject = angular.toJson(wineToUpdate,false);
		console.log('update wine: ' + $scope.jsonObject);
		
		$http.put("/project/webapi/wines", $scope.jsonObject)
		.then(
				function success(response) { 
					$scope.isUdateButtonDisabled = true;
					console.log('status: ' + response.status);
					$scope.updateStatus = 'update successful';
				},
				function error(response) { 
					console.log('error, return status: ' + response.status);
					$scope.updateStatus = 'update error, ' + response.data.message;
					
				}
			);
	};


});
		




wineapp.controller('wineFancyController', function ($scope, $http){
	
	$scope.getFancySearch = function() {		
		console.log('fancy wine search');
		$scope.data = angular.toJson($scope.fancysearch, false);	
		console.log('json query strin data: ' + $scope.data);

		var config = { params: $scope.fancysearch }
		
		$http.get("/project/webapi/wines/fancysearch", config)
			.then(
					function(response) {
						$scope.searchResults = response.data;			
					},
					function error(response) {
						console.log('error, return status: ' + response.status);					
					}
			);			
	};
	
	
	
	$scope.clearFancySearch = function(){
		$scope.fancysearch.english = false;
		$scope.fancysearch.french = false;
		$scope.fancysearch.german = false;
		$scope.fancysearch.spanish = false;
		
		$scope.fancysearch.media = '';
		
		$scope.fancysearch.startdate = '';
		$scope.fancysearch.enddate = '';
		
		$scope.searchResults = '';
	}
	
});

wineapp.controller('wineCreateController', function($scope, $http ) {	
	
	$scope.postWine = function() {	
		$scope.jsonObject = angular.toJson($scope.newWine, false);
		console.log('new Wine: ' + $scope.jsonObject);		
		
		$http.post("/project/webapi/wines", $scope.jsonObject)
		.then(
				function success(response) {					
					console.log('status: ' + response.status);
					$scope.createStatus = 'successful insert of new Wine';
					$scope.successfulInsert = true;
					$scope.getWines();
				},
				function error(response) {
					console.log('error, return status: ' + response.status);
					$scope.createStatus = 'insert error, ' + response.data.message;
				}
			
		);	
		$scope.showSearch = true;
		$scope.showEditDelete = false;
		
	};
	
	$scope.clearWine = function() {
		$scope.createStatus = 'Enter new Wine information';
		$scope.successfulInsert = false;		
		$scope.newWine = {
				name : '',
				chocolate : '',
				season : '',
				dinner : '',
				coffee : '',
				cheese : '',
				
				
		};
	}
	
});