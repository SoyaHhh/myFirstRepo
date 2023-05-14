package net.thumbtack.school.library.dao;

import net.thumbtack.school.library.model.User;

public interface UserDao {
    String login(String login, String password);
    String register(User user);
    String deleteUser(String token);
    String logout(String token);
}
