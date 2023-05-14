package net.thumbtack.school.library.dto.request;
import java.util.List;

public class GetBoorByAuthorDtoRequest {
    private List<String> author;
    private String token;

    public GetBoorByAuthorDtoRequest(){}

    public GetBoorByAuthorDtoRequest(List<String> author, String token){
        this.author = author;
        this.token = token;
    }

    public List<String> getAuthor() {
        return author;
    }

    public String getToken() {
        return token;
    }
}
