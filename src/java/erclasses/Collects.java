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
public class Collects {
    
    private String userID;
    private String movieID;
    private String listID;
    
    public Collects(String userID, String movieID, String listID) {
        this.userID = userID;
        this.movieID= movieID;
        this.listID = listID;
    }
    
    public String getUserID() {return this.userID;}
    
    public String getMovieID() {return this.movieID;}    
    
    public String getListID() {return this.listID;}
    
}
