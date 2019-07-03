/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import erclasses.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jacob
 */
public class StoreData {
    
    private static DBConnection conn;
   
    public static void main(String[] args) throws Exception {
        conn = new DBConnection();
//        storeDevelopers();
//        storeUsers();
//        storeFeedbacks();
//        storeJournals();
       storeMovies();
//        storeCast();
//        storePlaylists();
//        storeFollows();
//        storeCollects();
//        storeReviews();
    }

    public static void storeDevelopers() {
        
    }

    public static void storeUsers() {
        
    }

    public static void storeFeedbacks() {
        
    }

    public static void storeJournals() throws Exception {
        conn.insertJournal(new Journal("adam","2019-09-01 1:00",
                "Say Something","my-journal.jpg"), true);
    }

    public static void storeMovies() throws Exception {
        double startTime = System.currentTimeMillis();
        try(
            Scanner input = new Scanner(new File(Constants.MOVIE_FILENAME));
	){
            //while(input.hasNext())
            for (int i = 0; i < Constants.TEST_PHASE_I_MOVIES; i ++){
                String[] tokens = input.nextLine().split("\t");
                conn.insertMovie(new Movie(tokens[0],tokens[1],tokens[2],
                        tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],
                        tokens[8],tokens[9],tokens[10],"./posters/" + tokens[0] + ".jpg"));
            }
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	}
        System.out.println("All movies stored ! Used : " + 
                (System.currentTimeMillis() - startTime) + " milliseconds");
    }

    public static void storeCast() {
        
    }

    public static void storePlaylists() {
        
    }    
    
    public static void storeFollows() {
        
    }

    public static void storeCollects() {
        
    }

    public static void storeReviews() {
        
    }    
    
}
