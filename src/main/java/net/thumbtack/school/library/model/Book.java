package net.thumbtack.school.library.model;
import java.util.List;
public class Book {
    private String bookName;
    private List<String> author;
    private List<String> chapter;

    public Book(String bookName, List<String> author, List<String> chapter) {
        this.bookName = bookName;
        this.author = author;
        this.chapter = chapter;
    }

    public String getBookName() {
        return bookName;
    }

    public List<String> getAuthor() {
        return author;
    }

    public List<String> getChapter() {
        return chapter;
    }

}
