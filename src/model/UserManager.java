/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author deekshyarai
 */
public class UserManager {
    private ArrayList<User> users = new ArrayList<>();
    
    public UserManager(){
        users.add(new User("admin", "admin123", "ADMIN"));
        users.add(new User("user", "user123", "USER"));
    }
    
    public User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username)
                    && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null; // invalid login
    }
}
