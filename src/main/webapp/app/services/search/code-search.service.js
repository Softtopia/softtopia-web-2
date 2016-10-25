(function () {
    'use strict';

    angular
        .module('softtopiawebApp')
        .factory('CodeSearch', CodeSearch);

    CodeSearch.$inject = ['$resource'];

    function CodeSearch ($resource) {
        var service = $resource('api/code-search', {}, {
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET'
                //,
                //transformResponse: function (data) {
                //    return { blogString : data };
                //}
            }
            //},
            //'save': { method:'POST' },
            //'update': { method:'PUT' },
            //'delete':{ method:'DELETE'}
        });

        return service;
    }
})();
