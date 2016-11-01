package Lab2.graphs;

import Lab2.Solution;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by andrejbojcuk on 04.05.16.
 */
public class CreateGraphs extends Application {

    private ActionEvent actionEvent;


    public CreateGraphs(ActionEvent actionEvent, Solution y1,Solution y2,Solution y3,Solution y4,int i) {
        this.actionEvent = actionEvent;
        Model.y1 = y1;
        Model.y2 = y2;
        Model.y3 = y3;
        Model.y4 = y4;
        Model.i = i;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            FXMLLoader loadere = new FXMLLoader(getClass().getResource("View.fxml"));
            Pane loade = loadere.load();
            Stage stage = new Stage();
            stage.setTitle("Графики");
            stage.setScene(new Scene(loade, 600, 400));
            //stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
}
