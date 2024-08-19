/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import model.UserSession;

/**
 *
 * @author Carlos Fabricio
 */
public class SignUpController {
    
    DatabaseConnection connection;
    Connection cn;
    PreparedStatement ps2;
    ResultSet rs2;

    public SignUpController() {
        DatabaseConnection connection = new DatabaseConnection();    
        //cn = connection.connectToDatabase();
    }
    
    public void CreateUser(String name, String email,String password){
        Boolean status = true;
        int rol = 1;
        
        try {
            //con = cn;
            Connection conn = connection.connectToDatabase();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO user (UserName,Email,Password,Status,Rol) VALUES (?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setBoolean(4, status);
            ps.setInt(5, rol);
            
            ps.executeUpdate();
            conn.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: The email address is already in use.");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Boolean loginUser(String email, String password){
            try (Connection conn = connection.connectToDatabase()) {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                stmt.setString(2, password);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int userId = rs.getInt("userid");
                        String username = rs.getString("username");
                        int role = rs.getInt("rol");
                        
                        UserSession.setUserSession(userId, username, email, role);
                        System.out.println("Inicio de sesión exitoso.");
                        return true;
                    } else {
                        System.out.println("Usuario o contraseña incorrectos.");
                        return false;
                        //JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al iniciar sesión.");
            return false;
        }
    }
}
