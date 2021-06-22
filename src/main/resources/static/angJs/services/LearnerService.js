app.factory('LearnerService', ['$http', function($http){
return $http.get("http://localhost:8080/learner/all" )

  .success(function(data){
    return data
  })

   .error(function(data){
     return err;
   })


}])