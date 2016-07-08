(function() {
    'use strict';

    angular
        .module('softtopiawebApp')
        .config(hljsConfig)
        .config(themeConfig);


    hljsConfig.$inject = ['hljsServiceProvider'];
    function hljsConfig(hljsServiceProvider) {
        hljsServiceProvider.setOptions({
            // replace tab with 4 spaces
            tabReplace: '    '
        });
    }

    themeConfig.$inject = ['$mdThemingProvider'];
    function themeConfig($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('light-green')
            .accentPalette('amber');

    }

})();
