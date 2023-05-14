package net.thumbtack.school.library.dto.request;

public class GetBookByNameDtoRequest {
    private String bookName;
    private String token;

    public GetBookByNameDtoRequest(){}

    public GetBookByNameDtoRequest(String bookName, String token){
        this.bookName = bookName;
        this.token = token;
    }

    public String getBookName() {
        return bookName;
    }

    public String getToken() {
        return token;
    }
}
