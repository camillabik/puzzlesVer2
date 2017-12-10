package ru.innopolis.service;

import ru.innopolis.pojo.User;

public interface AuthorizationUserService {
     User authorization(String login, String password) throws Exception;


}
