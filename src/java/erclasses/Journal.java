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
public class Journal {
    
    private String userID;
    private String issueTime;
    private String diary;
    private String imageFilename;    
    
    public Journal(String userID, String issueTime, String diary, String imageFilename) {
        this.userID         = userID;
        this.issueTime      = issueTime;
        this.diary          = diary;
        this.imageFilename  = imageFilename;
    }

    public String getUserID() {return this.userID;}
    
    public String getIssueTime() {return this.issueTime;}
    
    public String getDiary() {return this.diary;}
    
    public String getImageFilename() {return this.imageFilename;}    
    
}
