/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author jacob
 */
public class RetrieveData extends Application {
    
    private static final double SCENE_WIDTH  = 700.0;
    private static final double SCENE_HEIGHT = SCENE_WIDTH;
    
    private static ImageView imageView;
    private static Pagination pagination;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        pagination = new Pagination(20, 0);
        pagination.setStyle("-fx-border-color:black");
        pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                try {
                    return retrieveMovies(pageIndex+2);
                } catch (Exception ex) {
                    Logger.getLogger(RetrieveData.class.getName()).log(Level.SEVERE, null, ex);
                }
                return new Pane();
            }
        });

        Scene scene = new Scene(pagination, SCENE_WIDTH,SCENE_HEIGHT);
	primaryStage.setTitle("Movie Posters");
	primaryStage.setScene(scene);
	primaryStage.centerOnScreen();
	primaryStage.show();
        
        scene.widthProperty().addListener(ov -> imageView.setFitWidth(scene.getWidth()));
        scene.heightProperty().addListener(ov -> imageView.setFitHeight(scene.getHeight()));        
    }        

    private static Pane retrieveMovies(int pageIndex) throws Exception {
        StackPane pane = new StackPane();
        
        String sql = "select poster from movie where movie_id = " + pageIndex + ";";
        ResultSet rs = DBConnection.executeQuery(sql);
        
        if (rs.next()) {
            Blob blob = rs.getBlob(1);
            ByteArrayInputStream in = new ByteArrayInputStream
                (blob.getBytes(1, (int)blob.length()));
            
            Image image = new Image(in);
            imageView = new ImageView(image);
            
            imageView.setFitWidth(SCENE_WIDTH);
            imageView.setFitHeight(SCENE_HEIGHT);            
            
            pane.getChildren().add(imageView);
        }
        
        return pane;
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }    
    
}
