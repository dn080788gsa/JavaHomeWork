package com.pb.gorban.hw8;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }
    public WrongPasswordException(String msg) {
        super(msg);
    }
}
