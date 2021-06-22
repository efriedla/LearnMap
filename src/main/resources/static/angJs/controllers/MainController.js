app.controller('MainController', ['$scope', '$http', function($scope, $http){
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


    //check if id/number
    function isNumber(item){
    return /^[1-9]*$/.test(item);
    }

//  modular add to any list
  $scope.addItem = function(itemList, item){
  if(isNumber(item)){
//    $http.get(" https://pokeapi.co/api/v2/pokemon/" + item).success(function(data){
//           itemList.push("name: " + data.forms[0].name);
//           console.log(data.forms[0].name)
//    });

      $http.get("http://localhost:8080/learner/find/" + item).success(function(data){
            itemList.push("Username: " + data.username);
            console.log(data);
            console.log("jdskjsfjsfj");
      });
      console.log("is number");
  }else{
    itemList.push(item);
  }

  }
}])