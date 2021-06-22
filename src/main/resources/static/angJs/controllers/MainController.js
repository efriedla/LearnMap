app.controller('MainController', ['$scope', function($scope){
  $scope.course =
   {
    title: "Courses",
    list: ["Java", "Angulare", "Testing", "Microservices"]
  }
  $scope.courseTemplate =
     {
      title: "Courses Template Structure",
      list: ["Step 1", "Step 2", "Step 3", "Step 4"]
    }
//  modular add to any list
  $scope.addItem = function(itemList, item){
    itemList.push(item);
  }
}])