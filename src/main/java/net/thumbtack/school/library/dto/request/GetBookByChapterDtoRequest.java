package net.thumbtack.school.library.dto.request;
import java.util.List;

public class GetBookByChapterDtoRequest{
    private List<String> chapter;
    private String token;

    public GetBookByChapterDtoRequest(){}

    public GetBookByChapterDtoRequest(List<String> chapter, String token){
        this.chapter = chapter;
        this.token = token;
    }

    public List<String> getChapter(){
        return chapter;
    }

    public String getToken() {
        return token;
    }
}
