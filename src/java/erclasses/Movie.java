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
public class Movie {
    
    private String movieID;
    private String title;
    private String year;
    private String rating;
    private String language;
    private String duration;
    private String releaseDate;
    private String region;
    private String genres;
    private String tags;
    private String plot;
    private String posterFilename;
    
    public Movie(String movieID, String title, String year, String rating, 
            String language, String duration, String releaseDate, String region, 
            String genres, String tags, String plot, String posterFilename) {
        this.movieID    = movieID;
        this.title      = title;
        this.year       = year;
        this.rating     = rating;
        this.language   = language;
        this.duration   = duration;
        this.releaseDate= releaseDate;
        this.region     = region;
        this.genres     = genres;
        this.tags       = tags;
        this.plot       = plot;
        this.posterFilename = posterFilename;
    }
    
    public String getMovieID() {return this.movieID;}
    
    public String getTitle() {return this.title;}
    
    public String getYear() {return this.year;}
    
    public String getRating() {return this.rating;}
    
    public String getLanguage() {return this.language;}
    
    public String getDuration() {return this.duration;} 
    
    public String getReleaseDate() {return this.releaseDate;}
    
    public String getRegion() {return this.region;}    
    
    public String getGenres() {return this.genres;}
    
    public String getTags() {return this.tags;}
    
    public String getPlot() {return this.plot;}
    
    public String getPosterFilename() {return this.posterFilename;}
    
}
