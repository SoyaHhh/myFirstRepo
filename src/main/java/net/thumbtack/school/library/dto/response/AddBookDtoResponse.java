package net.thumbtack.school.library.dto.response;

public class AddBookDtoResponse {
    private String idBook;

    public AddBookDtoResponse(String idBook){
        this.idBook = idBook;
    }

    public String getIdBook() {
        return idBook;
    }
}
