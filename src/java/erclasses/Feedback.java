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
public class Feedback {
    
    private String userID;
    private String content;
    private String submitTime;
    
    public Feedback(String userID, String content, String submitTime) {
        this.userID     = userID;
        this.content    = content;
        this.submitTime = submitTime;
    }
    
    public String getUserID() {return this.userID;}
    
    public String getContent() {return this.content;}
    
    public String getSubmitTime() {return this.submitTime;}
    
}
