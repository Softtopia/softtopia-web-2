(function() {
    'use strict';

    angular
        .module('softtopiawebApp')
        .directive('activeLink', activeLink)

    //.directive('prettyprintrun', function() {
    //    return {
    //        restrict: 'C',
    //        link: function($scope, element, attrs) {
    //            // Trigger when number of children changes,
    //            // including by directives like ng-repeat
    //            var watch = $scope.$watch(function () {
    //                return element.children().length;
    //            }, function () {
    //                // Wait for templates to render
    //                $scope.$evalAsync(function () {
    //                    // Finally, directives are evaluated
    //                    // and templates are renderer here
    //                    var children = element.children();
    //                    console.log(children);
    //                    prettyPrint();
    //                });
    //            });
    //        }, };
    //        //link: function postLink(scope, element, attrs) {
    //        //    console.log("PrettyPrinting", element);
    //        //    prettyPrint();
    //        //    //element.html(prettyPrintOne(element));
    //        //}
    //});

    function activeLink() {
        var directive = {
            restrict: 'A',
            link: linkFunc
        };

        return directive;

        function linkFunc(scope, element, attrs) {
            var clazz = attrs.activeLink;
            var path = attrs.href;
            path = path.substring(1); //hack because path does bot return including hashbang
            scope.location = location;
            scope.$watch('location.path()', function(newPath) {
                if (path === newPath) {
                    element.addClass(clazz);
                } else {
                    element.removeClass(clazz);
                }
            });
        }
    }
})();
