package Lab2.graphs;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class Controller {

    @FXML public TabPane tabPane;
    @FXML public Tab tab1;
    @FXML public Tab tab2;
    @FXML public Tab tab3;
    @FXML public Tab tab4;
    @FXML public BorderPane borderPane1;
    @FXML public BorderPane borderPane2;
    @FXML public BorderPane borderPane3;
    @FXML public BorderPane borderPane4;
    @FXML public ComboBox comboBoxy1;
    @FXML public ComboBox comboBoxy2;
    @FXML public ComboBox comboBoxy3;
    @FXML public ComboBox comboBoxy4;
    @FXML public LineChart<Number,Number> y1;
    @FXML public LineChart<Number,Number> y2;
    @FXML public LineChart<Number,Number> y3;
    @FXML public LineChart<Number,Number> y4;

    @FXML
    public void initialize() {
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "1.Нормовані значення",
                        "2.Відтворені значення"
        );

        System.out.println(Model.i);

        switch (Model.i){
            case 2:
                tabPane.getTabs().remove(tab3);
                tabPane.getTabs().remove(tab4);
                break;
        }

        comboBoxy1.getItems().addAll(options);
        comboBoxy2.getItems().addAll(options);
        comboBoxy3.getItems().addAll(options);
        comboBoxy4.getItems().addAll(options);

        comboBoxy1.getSelectionModel().select(0);
        comboBoxy2.getSelectionModel().select(0);
        comboBoxy3.getSelectionModel().select(0);
        comboBoxy4.getSelectionModel().select(0);


        refresh();
    }

    @FXML
    public void refresh(){
        if (tab1.isSelected()) tab1Selected();
        if (tab2.isSelected()) tab2Selected();
        if (tab3.isSelected()) tab3Selected();
        if (tab4.isSelected()) tab4Selected();
    }


    @FXML
    public void tab1Selected(){
        if (comboBoxy1.getSelectionModel().getSelectedIndex() == 0)
        {
            NumberAxis x = new NumberAxis();
            NumberAxis y = new NumberAxis();

            y1 = new LineChart<Number, Number>(x,y);



            XYChart.Series series = new XYChart.Series();
            XYChart.Series series1 = new XYChart.Series();

            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            ObservableList<XYChart.Data> datas1 = FXCollections.observableArrayList();

            for(int j=0; j<Model.y1.getNormaY().getRowDimension(); j++){
                datas.add(new XYChart.Data(j,Model.y1.getNormaY().get(j,0)));
               // datas.add(new XYChart.Data(j,j*j));
            }
            for(int j=0; j<Model.y1.getFindFnorma().getRowDimension(); j++){
                datas1.add(new XYChart.Data(j,Model.y1.getFindFnorma().get(j,0)));
            }

            series.setData(datas);
            series1.setData(datas1);


            borderPane1.setCenter(y1);
            borderPane1.setBottom(comboBoxy1);
            y1.getData().add(series);
            y1.getData().add(series1);

        } else if (comboBoxy1.getSelectionModel().getSelectedIndex() == 1){
            NumberAxis x = new NumberAxis();
            NumberAxis y = new NumberAxis();

            y1 = new LineChart<Number, Number>(x,y);



            XYChart.Series series = new XYChart.Series();
            XYChart.Series series1 = new XYChart.Series();

            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            ObservableList<XYChart.Data> datas1 = FXCollections.observableArrayList();

            for(int j=0; j<Model.y1.getOriginalY().getRowDimension(); j++){
                datas.add(new XYChart.Data(j,Model.y1.getOriginalY().get(j,0)));
            }
            for(int j=0; j<Model.y1.getFindForiginal().getRowDimension(); j++){
                datas1.add(new XYChart.Data(j,Model.y1.getFindForiginal().get(j,0)));
            }

            series.setData(datas);
            series1.setData(datas1);


            borderPane1.setCenter(y1);
            borderPane1.setBottom(comboBoxy1);
            y1.getData().add(series);
            y1.getData().add(series1);
        }
    }

    @FXML
    public void tab2Selected(){
        if (comboBoxy2.getSelectionModel().getSelectedIndex() == 0)
        {
            NumberAxis x = new NumberAxis();
            NumberAxis y = new NumberAxis();

            y2 = new LineChart<Number, Number>(x,y);



            XYChart.Series series = new XYChart.Series();
            XYChart.Series series1 = new XYChart.Series();

            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            ObservableList<XYChart.Data> datas1 = FXCollections.observableArrayList();

            for(int j=0; j<Model.y2.getNormaY().getRowDimension(); j++){
                datas.add(new XYChart.Data(j,Model.y1.getNormaY().get(j,0)));
            }
            for(int j=0; j<Model.y2.getFindFnorma().getRowDimension(); j++){
                datas1.add(new XYChart.Data(j,Model.y1.getFindFnorma().get(j,0)));
            }

            series.setData(datas);
            series1.setData(datas1);


            borderPane2.setCenter(y2);
            borderPane2.setBottom(comboBoxy2);
            y2.getData().add(series);
            y2.getData().add(series1);

        } else if (comboBoxy1.getSelectionModel().getSelectedIndex() == 1){
            NumberAxis x = new NumberAxis();
            NumberAxis y = new NumberAxis();

            y2 = new LineChart<Number, Number>(x,y);



            XYChart.Series series = new XYChart.Series();
            XYChart.Series series1 = new XYChart.Series();

            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            ObservableList<XYChart.Data> datas1 = FXCollections.observableArrayList();

            for(int j=0; j<Model.y2.getOriginalY().getRowDimension(); j++){
                datas.add(new XYChart.Data(j,Model.y1.getOriginalY().get(j,0)));
            }
            for(int j=0; j<Model.y2.getFindForiginal().getRowDimension(); j++){
                datas1.add(new XYChart.Data(j,Model.y1.getFindForiginal().get(j,0)));
            }

            series.setData(datas);
            series1.setData(datas1);


            borderPane2.setCenter(y2);
            borderPane2.setBottom(comboBoxy2);
            y2.getData().add(series);
            y2.getData().add(series1);
        }
    }
    @FXML
    public void tab3Selected(){
        if (comboBoxy3.getSelectionModel().getSelectedIndex() == 0)
        {
            NumberAxis x = new NumberAxis();
            NumberAxis y = new NumberAxis();

            y3 = new LineChart<Number, Number>(x,y);



            XYChart.Series series = new XYChart.Series();
            XYChart.Series series1 = new XYChart.Series();

            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            ObservableList<XYChart.Data> datas1 = FXCollections.observableArrayList();

            for(int j=0; j<Model.y3.getNormaY().getRowDimension(); j++){
                datas.add(new XYChart.Data(j,Model.y3.getNormaY().get(j,0)));
            }
            for(int j=0; j<Model.y3.getFindFnorma().getRowDimension(); j++){
                datas1.add(new XYChart.Data(j,Model.y3.getFindFnorma().get(j,0)));
            }

            series.setData(datas);
            series1.setData(datas1);


            borderPane3.setCenter(y3);
            borderPane3.setBottom(comboBoxy3);
            y3.getData().add(series);
            y3.getData().add(series1);

        } else if (comboBoxy1.getSelectionModel().getSelectedIndex() == 1){
            NumberAxis x = new NumberAxis();
            NumberAxis y = new NumberAxis();

            y3 = new LineChart<Number, Number>(x,y);



            XYChart.Series series = new XYChart.Series();
            XYChart.Series series1 = new XYChart.Series();

            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            ObservableList<XYChart.Data> datas1 = FXCollections.observableArrayList();

            for(int j=0; j<Model.y3.getOriginalY().getRowDimension(); j++){
                datas.add(new XYChart.Data(j,Model.y3.getOriginalY().get(j,0)));
            }
            for(int j=0; j<Model.y3.getFindForiginal().getRowDimension(); j++){
                datas1.add(new XYChart.Data(j,Model.y3.getFindForiginal().get(j,0)));
            }

            series.setData(datas);
            series1.setData(datas1);


            borderPane3.setCenter(y3);
            borderPane3.setBottom(comboBoxy3);
            y3.getData().add(series);
            y3.getData().add(series1);
        }
    }
    @FXML
    public void tab4Selected(){
        if (comboBoxy4.getSelectionModel().getSelectedIndex() == 0)
        {
            NumberAxis x = new NumberAxis();
            NumberAxis y = new NumberAxis();

            y4 = new LineChart<Number, Number>(x,y);



            XYChart.Series series = new XYChart.Series();
            XYChart.Series series1 = new XYChart.Series();

            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            ObservableList<XYChart.Data> datas1 = FXCollections.observableArrayList();

            for(int j=0; j<Model.y4.getNormaY().getRowDimension(); j++){
                datas.add(new XYChart.Data(j,Model.y1.getNormaY().get(j,0)));
            }
            for(int j=0; j<Model.y4.getFindFnorma().getRowDimension(); j++){
                datas1.add(new XYChart.Data(j,Model.y1.getFindFnorma().get(j,0)));
            }

            series.setData(datas);
            series1.setData(datas1);


            borderPane4.setCenter(y4);
            borderPane4.setBottom(comboBoxy4);
            y4.getData().add(series);
            y4.getData().add(series1);

        } else if (comboBoxy1.getSelectionModel().getSelectedIndex() == 1){
            NumberAxis x = new NumberAxis();
            NumberAxis y = new NumberAxis();

            y2 = new LineChart<Number, Number>(x,y);



            XYChart.Series series = new XYChart.Series();
            XYChart.Series series1 = new XYChart.Series();

            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
            ObservableList<XYChart.Data> datas1 = FXCollections.observableArrayList();

            for(int j=0; j<Model.y4.getOriginalY().getRowDimension(); j++){
                datas.add(new XYChart.Data(j,Model.y4.getOriginalY().get(j,0)));
            }
            for(int j=0; j<Model.y4.getFindForiginal().getRowDimension(); j++){
                datas1.add(new XYChart.Data(j,Model.y4.getFindForiginal().get(j,0)));
            }

            series.setData(datas);
            series1.setData(datas1);


            borderPane4.setCenter(y4);
            borderPane4.setBottom(comboBoxy4);
            y4.getData().add(series);
            y4.getData().add(series1);
        }
    }


}
