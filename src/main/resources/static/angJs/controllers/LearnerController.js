app.controller('LearnerController', ['$scope', 'LearnerService', function($scope, LearnerService){
    $scope.list = [];
  LearnerService.success(function(data){
    console.log("in learner controller");
    console.log(data[0]);
    for(var i = 0; i < data.length; i++){
        var learner = {
            username: data[i].username,
            email: data[i].email
        }
        $scope.list.push(learner);
    }
  })

}])