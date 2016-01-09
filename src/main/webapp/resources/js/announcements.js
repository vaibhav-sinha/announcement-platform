var AnnouncementApp = angular.module('AnnouncementApp', []);

var AnnouncementController = AnnouncementApp.controller('AnnouncementController', function($scope, $http) {
    $scope.announcements= [];
    $scope.page = 0;
    $scope.user_id = 1;

    $scope.loadAnnouncements = function() {
        $http.get(loadAnnouncementUrl + '/' + $scope.user_id + '/?page=' + $scope.page + '&limit=1')
            .then(function(response) {
                $scope.announcements = $scope.announcements.concat(response.data);
                $scope.page = $scope.page + 1;

                setTimeout(function(){
                    var ids = [];
                    for(var i = 0; i < $scope.announcements.length; i++) {
                        ids.push($scope.announcements[i].id);
                    }
                    $http.post(loadAnnouncementUrl + '/' + $scope.user_id + '/read', ids)
                        .then(function(response) {
                            console.log('Marked read');
                        });
                }, 3000);
            });
    };

    $scope.loadAnnouncements($scope.user_id, 0);

});