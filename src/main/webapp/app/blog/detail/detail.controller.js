(function() {
    'use strict';

    angular
        .module('softtopiawebApp')
        .controller('BlogDetailController', Controller);

    Controller.$inject = ['Blog', 'blogDetailData'];

    function Controller (Blog, blogDetailData) {
        var vm = this;
        vm.blogDetail = blogDetailData;
    }



})();
