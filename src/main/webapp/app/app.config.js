(function() {
    'use strict';

    angular
        .module('softtopiawebApp')
        .config(hljsConfig)


    hljsConfig.$inject = ['hljsServiceProvider'];
    function hljsConfig(hljsServiceProvider) {
        hljsServiceProvider.setOptions({
            // replace tab with 4 spaces
            tabReplace: '    '
        });
    }

})();
