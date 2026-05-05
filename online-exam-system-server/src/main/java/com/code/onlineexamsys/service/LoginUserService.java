package com.code.onlineexamsys.service;

public interface LoginUserService {
    void saveUser(Long userId,Object user,long expire);

    <T> T getUser(Long userId);

    void removeUser(Long userId);
}
