angular.module('booksServices', ['ngResource']).
    factory('Book', function ($resource) {
        return $resource('books/:bookId.json', {}, {
            query: {method: 'GET', params: {bookId: 'books'}}
        });
    });
