package com.project.tfg.dto;


public class PermissionDto {

    public static String USER = "USER";
    public static String USER_ADMIN = "USER_ADMIN";
    public static String USER_SELLER_ADMIN = "USER_SELLER_ADMIN";
    public static String USER_SELLER = "USER_SELLER";
    public static String USER_BUYER = "USER_BUYER";

    private String code;

    public String getCode() {
        return this.code;
    }

    public void setCode(String name) {
        this.code = name;
    }

}
