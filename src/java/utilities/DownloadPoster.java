/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author jacob
 */
public class DownloadPoster {
    
    public static void main(String[] args) throws Exception {
        double startTime = System.currentTimeMillis();
        try(
            Scanner input = new Scanner(new File(Constants.MOVIE_FILENAME));
	){ 
            while(input.hasNext()){
                String[] tokens = input.nextLine().split("\t");
                download(tokens[tokens.length-1], Constants.POSTER_FILENAME + tokens[0] + ".jpg");
            }
	} catch (FileNotFoundException e) {
            e.printStackTrace();
	}
        System.out.println("All posters downloaded ! Used : " + 
                (System.currentTimeMillis() - startTime) + " milliseconds");        
    }    
    
    public static void download(String urlString, String saveFilename) throws Exception {
        URL url = new URL(urlString);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf))){
           out.write(buf, 0, n);
        }
        
        out.close();
        in.close();
        
        byte[] response = out.toByteArray();
        
        FileOutputStream fos = new FileOutputStream(saveFilename);
        fos.write(response);
        fos.close();        
    }   

}
