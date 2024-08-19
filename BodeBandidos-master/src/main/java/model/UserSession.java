
package model;

import lombok.*;


public class UserSession {
    private static int userId;
    private static String username;
    private static String email;
    private static int role;
    
    public static void setUserSession(int userId, String username, String email, int role) {
        UserSession.userId = userId;
        UserSession.username = username;
        UserSession.email = email;
        UserSession.role = role;
    }

    public static int getUserId() {
        return userId;
    }

    public static String getUsername() {
        return username;
    }

    public static String getEmail() {
        return email;
    }

    public static int getRole() {
        return role;
    }
}
