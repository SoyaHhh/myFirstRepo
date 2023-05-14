package net.thumbtack.school.library.dto.request;

import java.util.List;

public class AddBooksDtoRequest {
    private String bookName;
    private List<String> author;
    private List<String> chapter;
    //section list

    public AddBooksDtoRequest() {
    }

    public AddBooksDtoRequest(String bookName, List<String> author, List<String> chapter) {
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

