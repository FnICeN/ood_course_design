package com.Exceptions;

public class DAOException extends RuntimeException {
    public DAOException(String mes) {
        super(mes);  //����һ��RuntimeException����֮�׳�
    }
}
