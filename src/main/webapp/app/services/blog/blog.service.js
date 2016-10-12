(function () {
    'use strict';

    angular
        .module('softtopiawebApp')
        .factory('Blog', Blog);

    Blog.$inject = ['$resource'];

    function Blog ($resource) {
        var service = $resource('api/blogs/:id', {}, {
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    return { blogString : data };
                }
            }
            //},
            //'save': { method:'POST' },
            //'update': { method:'PUT' },
            //'delete':{ method:'DELETE'}
        });

        return service;
    }
})();
