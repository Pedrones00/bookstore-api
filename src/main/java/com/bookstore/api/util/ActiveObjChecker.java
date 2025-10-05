package com.bookstore.api.util;

public class ActiveObjChecker {
    private ActiveObjChecker(){}

    public static void isActive(Boolean active, RuntimeException ex){
        if (active == false) {
            throw ex;
        }
    }
}
