app.controller('MainController', ['$scope', function($scope){
  $scope.list = ["learn Angular", "understand Controllers", "build out app",
  "connect to database"];
  $scope.addItem = function(){
    $scope.list.push($scope.addToDo);
  }
}])