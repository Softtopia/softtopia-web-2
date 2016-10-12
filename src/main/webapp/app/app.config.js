(function() {
    'use strict';

    angular
        .module('softtopiawebApp')
        .config(hljsConfig)
        .config(themeConfig);
        //.config(prettifyConfig); //TOOOODOOO: !!! ---> Update to this: https://github.com/showdownjs/ng-showdown and then use prettify extension


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


    prettifyConfig.$inject = ['markdownConverterProvider'];
    function prettifyConfig(markdownConverterProvider) {
        // options to be passed to Showdown
        // see: https://github.com/coreyti/showdown#extensions
        markdownConverterProvider.config({
            extensions: ['prettify']
        });
    }


})();
