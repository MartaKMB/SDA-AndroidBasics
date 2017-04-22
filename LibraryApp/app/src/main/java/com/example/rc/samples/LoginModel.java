package com.example.rc.samples;

import java.io.Serializable;

public class LoginModel implements Serializable {

    private String mail;
    private String password;

    public LoginModel(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }
}
