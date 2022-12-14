package com.Exceptions;

public class DAOException extends RuntimeException {
    public DAOException(String mes) {
        super(mes);  //构造一个RuntimeException并将之抛出
    }
}
