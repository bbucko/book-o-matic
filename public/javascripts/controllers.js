function BookListController($scope, Book) {
    $scope.books = Book.query();
}
