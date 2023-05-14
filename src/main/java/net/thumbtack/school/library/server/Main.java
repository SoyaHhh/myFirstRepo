package net.thumbtack.school.library.server;

import com.google.gson.Gson;
import net.thumbtack.school.library.dto.request.LoginUserDtoRequest;
import net.thumbtack.school.library.dto.request.RegisterUserDtoRequest;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        Gson gson = new Gson();

        server.startServer("./Server.json");

        server.registerUser(gson.toJson(new RegisterUserDtoRequest(
                "Аубакирова", "Софья", "Sofya@gmail.com", "sofya")));

        String token = server.login(gson.toJson(new LoginUserDtoRequest("Sofya@gmail.com", "sofya")));
        System.out.println(token);

    }
}
