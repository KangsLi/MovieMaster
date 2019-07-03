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
public class Follow {
    
    private String follower;
    private String followee;
    
    public Follow(String follower, String followee) {
        this.follower = follower;
        this.followee = followee;
    }
    
    public String getFollower() {return this.follower;}
    
    public String getFollowee() {return this.followee;}    
    
}
