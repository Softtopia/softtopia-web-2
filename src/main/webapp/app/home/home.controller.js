(function() {
    'use strict';

    angular
        .module('softtopiawebApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'Principal', 'LoginService', '$state', 'CodeSearch', '$timeout'];

    function HomeController ($scope, Principal, LoginService, $state, CodeSearch, $timeout) {
        var vm = this;

        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.searchCode = searchCode;
        vm.register = register;
        $scope.$on('authenticationSuccess', function() {
            getAccount();
        });

        getAccount();

        function getAccount() {
            Principal.identity().then(function(account) {
                vm.account = account;
                vm.isAuthenticated = Principal.isAuthenticated;
            });
        }
        function register () {
            $state.go('register');
        }

        function searchCode(query) {
            CodeSearch.get({"q":query}, function(data) {
                console.log(data);
                vm.searchResult = prepareData(data);
                $timeout(function() {
                    prettyPrint();
                }, 400);

            })
        }

        function prepareData(data) {
            data.results.forEach(prepareResult);
            return data;
        }

        function prepareResult(result) {
            result.linesString = "";
            Object.keys(result.lines).forEach(function(key) {
                result.linesString += key + " - " + result.lines[key] + "\n";
            })
        }
    }
})();
