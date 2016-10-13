(function() {
    'use strict';

    angular
        .module('softtopiawebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('blog-detail', {
                parent: 'app',
                url: '/blog-detail/:blogId',
                data: {
                    authorities: []
                },
                views: {
                    'content@': {
                        templateUrl: 'app/blog/detail/detail.html',
                        controller: 'BlogDetailController',
                        controllerAs: 'vm'
                    }
                },
                resolve: {
                    blogDetailData: ['Blog', '$stateParams', function(Blog, $stateParams) {
                        return Blog.get({id: $stateParams.blogId});
                    }]
                }

            });
    }
})();
