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
public class Review {
    
    private String userID;
    private String movieID;
    private String rating;
    private String tag;
    private String comment;
    
    public Review(String userID, String movieID, String rating,
            String tag, String comment) {
        this.userID     = userID;
        this.movieID    = movieID;
        this.rating     = rating;
        this.tag        = tag;
        this.comment    = comment;
    }
    
    public String getUserID() {return this.userID;}
    
    public String getMovieID() {return this.movieID;}
    
    public String getRating() {return this.rating;}     
    
    public String getTag() {return this.tag;}
    
    public String getComment() {return this.comment;}    
    
}
