package net.thumbtack.school.library.dto.response;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterUserDtoResponse {
    private String token;

    RegisterUserDtoResponse() {}

    public RegisterUserDtoResponse(String token) {
        this.token = token;
    }
}
