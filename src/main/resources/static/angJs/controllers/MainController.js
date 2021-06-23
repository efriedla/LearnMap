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
  $scope.learnerList =
  {
    username: "test",
    email: "test@gmail.com",
    list: []
  }
  $scope.list = [];


    //check if id/number
    function isNumber(item){
    return /^[1-9]*$/.test(item);
    }


    //show all in db
    $scope.showAll =
    function()
    {
            $http.get("http://localhost:8080/learner/" + "all").success(function(data){
                console.log(data);

                   for(var i = 0; i < data.length; i++){
                           var learner = {
                               id: data[i].id,
                               username: data[i].username,
                               email: data[i].email
                           }
//                           console.log(learner);
                           $scope.learnerList.list.push(learner);
                       }
            });
            console.log("show all!" );
    }



//  modular add to any list
  $scope.addItem = function(itemList, item){
      if(isNumber(item)){

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

  //  modular add to any list from courses
    $scope.updateLearner = function(learner, id){
        if(isNumber(id)){

            $http.get("http://localhost:8080/learner/update/" + id ).success(function(data){
//                  learner.push("Username: " + data.username + "/n test edit??" + " id "+ id);

                  console.log(data);
                  console.log("jdskjsfjsfj");
            });
            console.log("updating!!!");
        }else{
//          learner.push(id);
        }
    }
  //end of main controller




}])