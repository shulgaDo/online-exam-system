package com.code.onlineexamsys.service;

public interface TokenService {

    void blacklist(String token, long expire);

    boolean isBlackListed(String token);

}
