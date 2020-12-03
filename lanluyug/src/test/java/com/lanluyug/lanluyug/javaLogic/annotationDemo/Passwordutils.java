package com.lanluyug.lanluyug.javaLogic.annotationDemo;

import java.util.List;

public class Passwordutils {
    @UseCase(id=47,description = "passwd must contain at least one numeric")
    public boolean validatepasswd(String passwd){
        return (passwd.matches("\\w*\\d\\w"));
    }
    @UseCase(id=48)
    public String encryptPasswd(String passwd){
        return new StringBuilder(passwd).reverse().toString();
    }
    @UseCase(id=49,description = "new Passwd can't equals previously used ones")
    public boolean checkForNewPasswd(List<String> prevPasswords, String passwd){
        return !prevPasswords.contains(passwd);
    }
}
