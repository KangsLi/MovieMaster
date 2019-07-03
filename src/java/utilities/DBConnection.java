/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import erclasses.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jacob
 */
public class DBConnection {
    
    private static String DRIVER_NAME	= "com.mysql.jdbc.Driver";
    private static String CONNECTION_URL= "jdbc:mysql://localhost/MovieMaster?useSSL=false";
    private static String USERNAME      = "jacob";
    private static String PASSWAORD	= "Wed$1059PM";
	
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
	
    private static PreparedStatement psInsertDeveloper;
    private static PreparedStatement psInsertUser;
    private static PreparedStatement psInsertFeedback;
    private static PreparedStatement psInsertJournal;
    private static PreparedStatement psInsertJournalWithImage;    
    private static PreparedStatement psInsertMovie;
    private static PreparedStatement psInsertCast;
    private static PreparedStatement psInsertPlaylist;    
    
    private static PreparedStatement psInsertFollow;
    private static PreparedStatement psInsertCollects;
    private static PreparedStatement psInsertReview;
    
    
    public static Connection getJdbcConnection() throws SQLException {
	if(connection == null || connection.isClosed()) {
            try{
		Class.forName(DRIVER_NAME);
		connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWAORD);
            }catch(ClassNotFoundException e){
		System.err.println("Load JDBC Driver Program failed.");
		e.printStackTrace();
            }catch(SQLException e){
		System.err.println("Can not connect database.");
		e.printStackTrace();
            }
	}
	return connection;
    }
 	
    public static ResultSet executeQuery(String sql) {
	try {
            statement = getJdbcConnection().createStatement();
            resultSet = statement.executeQuery(sql);
	}catch(SQLException e){
            System.out.println(e);
	}
	return resultSet;
    }

    public static int executeUpdate(String sql) {
    	int affected = 0;
    	try {
            statement = getJdbcConnection().createStatement();
            affected  = statement.executeUpdate(sql);
    	}
	catch(SQLException e){
            System.out.println(e);
	}
	return affected;
    }

    public static int insertDeveloper(Developer d) throws SQLException {
    	if (psInsertDeveloper == null) {
            String insertString = "insert into developer values(?, ?);";
            psInsertDeveloper = getJdbcConnection().prepareStatement(insertString);
    	}
    	psInsertDeveloper.setString(1, d.getDeveloperID());
    	psInsertDeveloper.setString(2, d.getDeveloperPass());

    	return psInsertDeveloper.executeUpdate();
    }
    
    public static int insertUser(User u) throws SQLException {
    	if (psInsertUser == null) {
            String insertString = "insert into user values(?, ?, ?, ?, ?, ?);";
            psInsertUser = getJdbcConnection().prepareStatement(insertString);
    	}
    	psInsertUser.setString(1, u.getUserID());
    	psInsertUser.setString(2, u.getUserPass());
    	psInsertUser.setString(3, u.getNickname());
    	psInsertUser.setString(4, u.getPhone());
    	psInsertUser.setString(5, u.getEmail());    
    	psInsertUser.setString(6, u.getTags());             

    	return psInsertUser.executeUpdate();
    }
    
    public static int insertFeedback(Feedback f) throws SQLException {
    	if (psInsertFeedback == null) {
            String insertString = "insert into feedback values(?, ?, ?);";
            psInsertFeedback = getJdbcConnection().prepareStatement(insertString);
    	}
    	psInsertFeedback.setString(1, f.getUserID());
    	psInsertFeedback.setString(2, f.getContent());
    	psInsertFeedback.setString(3, f.getSubmitTime());

    	return psInsertFeedback.executeUpdate();
    }
    
    public int insertJournal(Journal j, boolean hasImage) throws SQLException, IOException {
        if (hasImage) {
            if (psInsertJournalWithImage == null) {
                String insertString = "insert into journal values(?, ?, ?, ?);";
                psInsertJournalWithImage = getJdbcConnection().prepareStatement(insertString);
            }
            psInsertJournalWithImage.setString(1, j.getUserID());
            psInsertJournalWithImage.setString(2, j.getIssueTime());
            psInsertJournalWithImage.setString(3, j.getDiary());     
            
            // Store image to the table cell
            java.net.URL url = this.getClass().getResource(j.getImageFilename());
            InputStream inputImage = url.openStream();
            psInsertJournalWithImage.setBinaryStream(4, inputImage,(int)(inputImage.available())); 
            
            return psInsertJournalWithImage.executeUpdate();
        } else {
            if (psInsertJournal == null) {
                String insertString = "insert into journal(user_id, diary, issue_time) values(?, ?, ?);";
                psInsertJournal = getJdbcConnection().prepareStatement(insertString);
            }
            psInsertJournal.setString(1, j.getUserID());
            psInsertJournal.setString(2, j.getIssueTime());
            psInsertJournal.setString(3, j.getDiary());
            
            return psInsertJournal.executeUpdate();
        }
    }
    
    public int insertMovie(Movie m) throws SQLException, IOException {
    	if (psInsertMovie == null) {
            String insertString = "insert into movie " + 
    				"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            psInsertMovie = getJdbcConnection().prepareStatement(insertString);
    	}
    	psInsertMovie.setInt(1, Integer.parseInt(m.getMovieID()));
    	psInsertMovie.setString(2, m.getTitle());
        psInsertMovie.setString(3, m.getYear());
    	psInsertMovie.setString(4, m.getRating());
    	psInsertMovie.setString(5, m.getLanguage());
    	psInsertMovie.setShort(6, (short) Integer.parseInt(m.getDuration().replace(".0", "")));
    	psInsertMovie.setString(7, m.getReleaseDate());
    	psInsertMovie.setString(8, m.getRegion());
    	psInsertMovie.setString(9, m.getGenres());
        psInsertMovie.setString(10, m.getTags());
        psInsertMovie.setString(11, m.getPlot());
        
        // Store image to the table cell
        java.net.URL url = this.getClass().getResource(m.getPosterFilename());
        InputStream inputImage = url.openStream();
        psInsertMovie.setBinaryStream(12, inputImage,(int)(inputImage.available()));
        
        return psInsertMovie.executeUpdate();
    }
    
    public static int insertCast(Cast c) throws SQLException {
    	if (psInsertCast == null) {
            String insertString = "insert into cast values(?, ?, ?);";
            psInsertCast = getJdbcConnection().prepareStatement(insertString);
    	}
    	psInsertCast.setString(1, c.getMovieID());
    	psInsertCast.setString(2, c.getDirector());
        psInsertCast.setString(3, c.getStarring());

    	return psInsertCast.executeUpdate();
    }

    public static int insertFollow(Follow f) throws SQLException {
    	if (psInsertFollow == null) {
            String insertString = "insert into follow values(?, ?);";
            psInsertFollow = getJdbcConnection().prepareStatement(insertString);
    	}
    	psInsertFollow.setString(1, f.getFollower());
    	psInsertFollow.setString(2, f.getFollowee());

    	return psInsertFollow.executeUpdate();
    }    
    
    public static int insertPlaylist(Playlist p) throws SQLException {
    	if (psInsertPlaylist == null) {
            String insertString = "insert into playlist values(?, ?, ?);";
            psInsertPlaylist = getJdbcConnection().prepareStatement(insertString);
    	}
    	psInsertPlaylist.setString(1, p.getUserID());
    	psInsertPlaylist.setString(2, p.getListID());
        psInsertPlaylist.setString(3, p.getVisibility());

    	return psInsertPlaylist.executeUpdate();
    }  
    
    public static int insertCollects(Collects c) throws SQLException {
    	if (psInsertCollects == null) {
            String insertString = "insert into collects values(?, ?, ?);";
            psInsertCollects = getJdbcConnection().prepareStatement(insertString);
    	}
    	psInsertCollects.setString(1, c.getUserID());
    	psInsertCollects.setInt(2, Integer.parseInt(c.getMovieID()));
        psInsertCollects.setString(3, c.getListID());

    	return psInsertCollects.executeUpdate();
    }

    public static int insertReview(Review r) throws SQLException {
    	if (psInsertReview == null) {
            String insertString = "insert into review values(?, ?, ?, ?, ?);";
            psInsertReview = getJdbcConnection().prepareStatement(insertString);
    	}
    	psInsertReview.setString(1, r.getUserID());
    	psInsertReview.setInt(2, Integer.parseInt(r.getMovieID()));
        psInsertReview.setString(3, r.getRating());
        psInsertReview.setString(4, r.getTag());
        psInsertReview.setString(5, r.getComment());
        
    	return psInsertReview.executeUpdate();
    }

}