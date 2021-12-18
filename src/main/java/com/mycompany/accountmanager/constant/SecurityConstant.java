package com.mycompany.accountmanager.constant;

public class SecurityConstant {
    public static final long EXPIRATION_TIME = 432_000_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token Cannot be verified";
    public static final String MY_COMPANY = "My company";
    public static final String MY_COMPANY_ADMINISTRATION = "User Management portal";
    public static final String AUTHORITIES = "authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to access this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    public static final String USERS_LOGIN = "/users/login";
    public static final String USERS_REGISTER = "/users/register";
    public static final String USERS_RESET_PASSWORD = "/users/resetpassword/**";
    public static final String USERS_IMAGE = "/users/image/**";
    public static final String[] PUBLIC_URLS = {USERS_LOGIN, USERS_REGISTER, USERS_RESET_PASSWORD, USERS_IMAGE};
}
