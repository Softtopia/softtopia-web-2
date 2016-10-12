(function() {
    'use strict';

    angular
        .module('softtopiawebApp')
        .controller('BlogController', Controller);

    Controller.$inject = ['Blog', '$state'];

    function Controller (Blog, $state) {
        var vm = this;
        vm.showBlog = showBlog;
        loadAll();

        function loadAll () {
            Blog.query({}, function (result, headers) {
                vm.blogs = result;
            });
        }

        function showBlog(blogDescriptor) {
            console.log("Showing...", blogDescriptor.id)
            $state.go('blog-detail', { blogId:  blogDescriptor.id });
        }

    }



})();
