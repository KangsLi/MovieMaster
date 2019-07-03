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
public class Developer {
    
    private String developerID;
    private String developerPass;
    
    public Developer(String developerID, String developerPass) {
        this.developerID    = developerID;
        this.developerPass  = developerPass;
    }
    
    public String getDeveloperID() {return this.developerID;}
    
    public String getDeveloperPass() {return this.developerPass;}
    
}
