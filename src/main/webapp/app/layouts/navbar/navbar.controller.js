(function() {
    'use strict';

    angular
        .module('softtopiawebApp')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$state', '$mdSidenav', 'Auth', 'Principal', 'ProfileService', 'LoginService'];

    function NavbarController ($state, $mdSidenav, Auth, Principal, ProfileService, LoginService) {
        var vm = this;
        var states = [{label: "home", state: "home"}, { label: "blog", state: "blog" }, { label: "about", state: "about"}]

        vm.isAuthenticated = Principal.isAuthenticated;
        vm.toggleSidenav = toggleSidenav;
        vm.goToState = goToState;

        ProfileService.getProfileInfo().then(function(response) {
            vm.inProduction = response.inProduction;
            vm.swaggerDisabled = response.swaggerDisabled;
        });

        vm.login = login;
        vm.logout = logout;
        vm.isCurrentState = isCurrentState;
        //vm.$state = $state;
        vm.states = states;


        function login() {
            collapseSidenav();
            LoginService.open();
        }

        function logout() {
            collapseSidenav();
            Auth.logout();
            $state.go('home');
        }


        function collapseSidenav() {
            $mdSidenav('right').close();
        }

        function toggleSidenav() {
            $mdSidenav('right').toggle();
        }

        function goToState(destinationState) {
            collapseSidenav();
            console.log("goToState", destinationState)
            $state.go(destinationState);
        }

        function isCurrentState(state) {
            return $state.is(state);
        }
    }

})();
