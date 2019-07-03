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
public class Cast {
    
    private String movieID;
    private String director;
    private String starring;
    
    public Cast(String movieID, String director, String starring) {
        this.movieID        = movieID;
        this.director       = director;
        this.starring       = starring;
    }
    
    public String getMovieID() {return this.movieID;}
    
    public String getDirector() {return this.director;}    
        
    public String getStarring() {return this.starring;}  
    
}
