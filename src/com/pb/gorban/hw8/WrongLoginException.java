package com.pb.gorban.hw8;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }
    public WrongLoginException(String msg) {
        super(msg);
    }
}
