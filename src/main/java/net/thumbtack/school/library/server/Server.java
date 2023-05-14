package net.thumbtack.school.library.server;

import com.google.gson.Gson;
import net.thumbtack.school.library.service.BookService;
import net.thumbtack.school.library.service.UserService;

public class Server {

    private final BookService bookService = new BookService();
    private final net.thumbtack.school.library.service.UserService userService = new UserService();
    private final Gson gson = new Gson();

    public void startServer(String savedDataFileName) {
        userService.startServer(savedDataFileName);
        bookService.startServer(savedDataFileName);
    }

    public void stopServer(String savedDataFileName) {

    }

    public void registerUser(String toJson) {

    }

    public String login(String json) {
        return json;
    }
}
