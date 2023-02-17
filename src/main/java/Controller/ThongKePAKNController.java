package Controller;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ThongKePAKNController implements Initializable {

    @FXML 
    PieChart pieChart;


    @FXML
    Label caption;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        try {
            Connection conn = SQLController.getConnection(SQLController.DB_URL, SQLController.USER_NAME, SQLController.PASSWORD);
            Statement stmt;
            stmt = conn.createStatement();
            String query = "SELECT COUNT(*) FROM dbo.PhanAnhKienNghi WHERE  PhanHoi IS NOT NULL;";
            // System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            int sLphanHoi;
            rs.next();
                sLphanHoi = rs.getInt(1);
            

            query = "SELECT COUNT(*) FROM dbo.PhanAnhKienNghi;";
            // System.out.println(query);
            rs = stmt.executeQuery(query);

            int sLPA;
            rs.next();
            sLPA = rs.getInt(1);
    

            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList( 
                new PieChart.Data("Đã phản hồi", sLphanHoi), 
                new PieChart.Data("Chưa phản hồi", sLPA - sLphanHoi)
            );

            pieChart.getData().addAll(pieChartData);
             
            pieChart.setLegendSide(Side.LEFT);


            caption.setVisible(false);
            caption.setTextFill(Color.RED);
            caption.setStyle("-fx-font: 24 arial;");
    

            for (final PieChart.Data data : pieChart.getData()) {
                data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
                            caption.setVisible(true);
                            System.out.println(e.getSceneY() + e.getSceneX());
                            caption.setTranslateX(e.getSceneX()-40);
                            caption.setTranslateY(e.getSceneY()-40);
                            caption.setText(String.valueOf(data.getPieValue()));
                        }
                    });
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }

}