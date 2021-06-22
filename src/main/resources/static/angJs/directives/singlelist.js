app.directive("singlelist", function(){
  return{
    restrict: 'E',
    scope: {
      mylist: '='
    },
    templateUrl: '../angJs/directives/singlelist.html'
  }
})