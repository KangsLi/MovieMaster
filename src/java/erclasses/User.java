/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erclasses;

/**
 *
 * @author jacob
 */
public class User {
    
    private String userID;
    private String userPass;
    private String nickname;
    private String phone;
    private String email;
    private String tags;
    
    public User(String userID, String userPass, String nickname, 
            String phone, String email, String tags) {
        this.userID     = userID;
        this.userPass   = userPass;
        this.nickname   = nickname;
        this.phone      = phone;
        this.email      = email;
        this.tags       = tags;
    }
    
    public String getUserID() {return this.userID;}
    
    public String getUserPass() {return this.userPass;}    
    
    public String getNickname() {return this.nickname;}
    
    public String getPhone() {return this.phone;}
    
    public String getEmail() {return this.email;}
    
    public String getTags() {return this.tags;}
    
}
