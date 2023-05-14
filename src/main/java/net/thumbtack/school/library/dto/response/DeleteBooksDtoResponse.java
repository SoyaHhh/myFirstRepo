package net.thumbtack.school.library.dto.response;

import java.util.List;

public class DeleteBooksDtoResponse {
    private List<String> idBooks;

    public DeleteBooksDtoResponse (List<String> idBooks){
        this.idBooks = idBooks;
    }

    public List<String> getIdBooks() {
        return idBooks;
    }
}
