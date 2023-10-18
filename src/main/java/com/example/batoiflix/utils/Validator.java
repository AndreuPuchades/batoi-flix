package com.example.batoiflix.utils;

public class Validator {
    private static final String PASSWORD_REGEXP = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{5,20}$";

    private static final String EMAIL_REGEXP = "^[a-z0-9]+(\\.[a-z0-9]+)*@[a-z0-9-_]+(\\.[a-z0-9-_]+)*(\\.([a-z])+)$";

    public static boolean isValidPassword(String password) {
        return isNotEmptyOrNull(password) && password.matches(PASSWORD_REGEXP);
    }

    public static boolean isValidEmail(String email){
        return isNotEmptyOrNull(email) && email.matches(EMAIL_REGEXP);
    }
    private static boolean isNotEmptyOrNull(String param) {
        return param != null && !param.isEmpty();
    }
}