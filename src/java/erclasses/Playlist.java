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
public class Playlist {
    
    public static final String VISIBILITY_SELF      = "SELF";
    public static final String VISIBILITY_FOLLOWERS = "FOLLOWERS";
    public static final String VISIBILITY_ALL       = "ALL";    
    
    private String userID;
    private String listID;
    private String visibility;    
    
    public Playlist(String userID, String listID, String visibility) {
        this.userID = userID;
        this.listID = listID;
        this.visibility = visibility;
    }
    
    public String getUserID() {return this.userID;}    
    
    public String getListID() {return this.listID;}    
 
    public String getVisibility() {return this.visibility;}    
    
}
