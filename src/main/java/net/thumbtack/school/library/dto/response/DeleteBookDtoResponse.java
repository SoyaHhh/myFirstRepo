package net.thumbtack.school.library.dto.response;

public class DeleteBookDtoResponse {
    private String idBook;

    public DeleteBookDtoResponse(String idBook){
        this.idBook = idBook;
    }

    public String getIdBook() {
        return idBook;
    }
}
