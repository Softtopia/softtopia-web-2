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
        vm.inputKeyPressed = inputKeyPressed;

        vm.noResults = false;

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
                vm.searchResult = prepareData(data);
                vm.noResults = data.total == 0;
                runPrettyPrint();
            })
        }

        //TODO: Service to do this
        function runPrettyPrint() {
            $timeout(function() {
                prettyPrint();
            }, 400);
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

        function inputKeyPressed(event) {
            if (event.keyCode === 12 + 1 && isThereSearchQuery()) {
                searchCode(vm.query);
            }
        }

        function isThereSearchQuery() {
            return vm.query && vm.query.length > 0;
        }
    }
})();
