mainApp.controller('stockController', function($scope, $http) {
	$scope.getStockInfo = function(symbol){
		var url = "http://cors.io/?u=http://phisix-api.appspot.com/stocks/";
		url += symbol + ".json";
		var stockObject = new Object();
		$http.get(url).success(function(response) {
			var stock = response.stock[0];
			stockObject.symbol = symbol;
			stockObject.companyName = stock.name;
			stockObject.price = stock.price.currency + " " + stock.price.amount;
			stockObject.percentChange = stock.percent_Change;
			stockObject.volume = stock.volume;
        });
		return stockObject;
		
	}
	$scope.getTopStocks = function(){
		var topStocks = ['PX', 'BLOOM', 'PCOR', 'SMC', 'DMC', 'EDC', 'SCC', 'MEG', 'TEL', 'JFC'];
		var stockList = new Array
		for (var i=0; i < topStocks.length; i++) {
			var symbol = topStocks[i];
			var stock = $scope.getStockInfo(symbol);
			stockList.push(stock);	
			$scope.stock = {};
		}
		return stockList;
	}
});