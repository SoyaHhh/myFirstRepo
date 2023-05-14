package net.thumbtack.school.library.dao;

import net.thumbtack.school.library.model.Book;

import java.util.List;

public interface BookDao {
    String addBook (Book book);
    List<String> addBooks(List<Book> book);
    List<Book> getBooks();
}
