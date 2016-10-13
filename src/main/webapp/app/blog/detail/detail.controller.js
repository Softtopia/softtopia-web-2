(function() {
    'use strict';

    angular
        .module('softtopiawebApp')
        .controller('BlogDetailController', Controller);

    Controller.$inject = ['Blog', 'blogDetailData', '$scope', '$timeout'];

    function Controller (Blog, blogDetailData, $scope, $timeout) {
        var vm = this;
        blogDetailData.$promise.then(function() {
                $timeout(function() {
                    runPretty();
                }, 600);
        });
        vm.blogDetail = blogDetailData;
        vm.elementLoaded = elementLoaded;

        vm.runPretty = runPretty;


        function elementLoaded() {
            console.log("elementLoaded");
        }

        function runPretty() {
            prettyPrint();
        }

        //$scope.$watch('vm.blogDetail', function() {
        //    console.log("Running pretty");
        //    $timeout(function() {
        //        runPretty();
        //    }, 600);
        //
        //});

        $scope.$on('$viewContentLoaded', function(){
            //runPretty();
        });
    }



})();
