package Lab2;

import Jama.Matrix;
import Lab2.graphs.CreateGraphs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    final ToggleGroup polinomGroup = new ToggleGroup();
    final ToggleGroup targetFunc = new ToggleGroup();
    final ToggleGroup graph = new ToggleGroup();
    private File in1;
    private File in2;
    private File out;
    private double[][] allDataX;
    private double[][] allDataXnorma;
    private double[][] allDataY;
    private double[][] allDataYnorma;

    public double[][] getAllDataY() {
        return allDataY;
    }

    @FXML ComboBox<Integer> sampleSize;
    @FXML TextField inputData;
    @FXML Button chooiseInputData;
    @FXML TextField inputData2;
    @FXML Button chooiseInputData2;
    @FXML RadioButton chebisheva;
    @FXML RadioButton lezhandra;
    @FXML RadioButton laggera;
    @FXML RadioButton ermita;
    @FXML CheckBox lambda;
    @FXML ComboBox<Integer> sizeX1;
    @FXML ComboBox<Integer> sizeX2;
    @FXML ComboBox<Integer> sizeX3;
    @FXML ComboBox<Integer> sizeY;
    @FXML ComboBox<Integer> powerX1;
    @FXML ComboBox<Integer> powerX2;
    @FXML ComboBox<Integer> powerX3;
    @FXML Button start;
    @FXML TextArea console;
    @FXML Button struct;
    private Solution y1;
    private Solution y2;
    private Solution y3;
    private Solution y4;

    @FXML
    public void initialize() {
        chebisheva.setToggleGroup(polinomGroup);
        lezhandra.setToggleGroup(polinomGroup);
        laggera.setToggleGroup(polinomGroup);
        ermita.setToggleGroup(polinomGroup);
        polinomGroup.selectToggle(chebisheva);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i=1;i<=100;i++)
            list.add(i);
        for (int i=1;i<=15;i++)
            list2.add(i);
        ObservableList<Integer> oList = FXCollections.observableArrayList(
                new Integer(1),
                new Integer(2),
                new Integer(3)
        );

        ObservableList<Integer> oList2 = FXCollections.observableArrayList(
                new Integer(1),
                new Integer(2),
                new Integer(3),
                new Integer(4),
                new Integer(5)
        );
        ObservableList<Integer> oList3 = FXCollections.observableArrayList();

        sizeX1.setItems(oList);
        sizeX1.setValue(2);
        sizeX2.setItems(oList);
        sizeX2.setValue(2);
        sizeX3.setItems(oList);
        sizeX3.setValue(3);
        powerX1.setItems(FXCollections.observableList(list2));
        powerX1.setValue(3);
        powerX2.setItems(FXCollections.observableList(list2));
        powerX2.setValue(3);
        powerX3.setItems(FXCollections.observableList(list2));
        powerX3.setValue(3);
        sizeY.setItems(oList2);
        sizeY.setValue(4);
        sampleSize.setItems(FXCollections.observableList(list));
        sampleSize.setValue(45);
        lambda.setSelected(true);
    }

    @FXML
    private File setInputData() {

        FileChooser fileChooser = new FileChooser();
        Stage input = new Stage();
        fileChooser.setTitle("Файл вхідних даних (X)");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files","*.txt"));
        in1 = fileChooser.showOpenDialog(input);
        if (in1 != null) {
            inputData.setText(in1.getAbsolutePath());

        }
        return in1;
    }

    @FXML
    private File setInputData2() {

        FileChooser fileChooser = new FileChooser();
        Stage input = new Stage();
        fileChooser.setTitle("Файл значень (Y)");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files","*.txt"));
        in2 = fileChooser.showOpenDialog(input);
        if (in2 != null) {
            inputData2.setText(in2.getAbsolutePath());

        }
        return in2;
    }

    @FXML
    private void start() {
        if (in1 != null && in2 != null) {
            allDataX = Files.parseFile(in1, sizeX1.getValue() + sizeX2.getValue() + sizeX3.getValue());
            allDataXnorma = MyMath.norma(allDataX, sizeX1.getValue() + sizeX2.getValue() + sizeX3.getValue());
            allDataY = Files.parseFile(in2, sizeY.getValue());
            allDataYnorma = MyMath.norma(allDataY, sizeY.getValue());
            //MyMath.output(allDataYnorma,4);
            int polinomType;
            if (polinomGroup.getSelectedToggle() == lezhandra)
                polinomType = 2;
            else if (polinomGroup.getSelectedToggle() == laggera)
                polinomType = 3;
            else if (polinomGroup.getSelectedToggle() == ermita)
                polinomType = 4;
            else
                polinomType = 1;


            y1 = new Solution(allDataXnorma, allDataYnorma, allDataX, allDataY, sizeX1.getValue(), sizeX2.getValue(), sizeX3.getValue(), powerX1.getValue(),
                    powerX2.getValue(), powerX3.getValue(), 0, polinomType,true);
            StringBuilder sb = new StringBuilder();
            sb.append("--------------------------------i=1--------------------------------");
            sb.append(y1.getStringInterimResult());
            y2 = new Solution(allDataXnorma, allDataYnorma, allDataX, allDataY, sizeX1.getValue(), sizeX2.getValue(), sizeX3.getValue(), powerX1.getValue(),
                    powerX2.getValue(), powerX3.getValue(), 1, polinomType,true);
            sb.append("\n--------------------------------i=2--------------------------------");
            sb.append(y2.getStringInterimResult());

            if (sizeY.getValue()>2){
            y3 = new Solution(allDataXnorma, allDataYnorma, allDataX, allDataY, sizeX1.getValue(), sizeX2.getValue(), sizeX3.getValue(), powerX1.getValue(),
                    powerX2.getValue(), powerX3.getValue(), 2, polinomType,true);
            sb.append("\n--------------------------------i=3--------------------------------");
            sb.append(y3.getStringInterimResult());
            }

            if (sizeY.getValue()>3) {
                y4 = new Solution(allDataXnorma, allDataYnorma, allDataX, allDataY, sizeX1.getValue(), sizeX2.getValue(), sizeX3.getValue(), powerX1.getValue(),
                        powerX2.getValue(), powerX3.getValue(), 3, polinomType,true);
                sb.append("\n--------------------------------i=4--------------------------------");
                sb.append(y4.getStringInterimResult());
            }
            console.setText(sb.toString());
        }
    }

/*    @FXML
    public void struct() throws InterruptedException {
        Solution y5;
        int yJ=0;
        int k=1;
        double minError = 1.0;
        int conPower1=0;
        int conPower2=0;
        int conPower3=0;
        int conType=0;
        for (int power1=1;power1<11;power1++){
            for (int power2=1;power2<11;power2++){
                for (int power3=1;power3<11;power3++){
                    for (int type=1;type<5;type++){
                        y5 = new Solution(allDataXnorma,allDataYnorma,allDataX,allDataY,2,2,3,power1,power2,power3,yJ,type,false);
                        System.out.println((k++)+": "+y5.getMaxError()+" Power1: "+power1+" Power2: "+power2+" Power3: "+power3+" "+" Type: "+type);
                        if (y5.getMaxError()<minError&&y5.getMaxError()>0){
                            minError=y5.getMaxError();
                            conPower1 = power1;
                            conPower2 = power2;
                            conPower3 = power3;
                            conType = type;
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String poliType = "";
        switch (conType){
            case 1: {
                poliType = "Чебишева";
                break;
                }
            case 2:{
                poliType = "Лежандра";
                break;
            }
            case 3:{
                poliType = "Лагера";
                break;
            }
            case 4:{
                poliType = "Ерміта";
                break;
            }

        }
        stringBuilder.append("Power1 = "+conPower1+"\nPower2 = "+conPower2+"\nPower3 = "+conPower3+
                "\nType poli = "+poliType+"\nmin(MaxError) = "+minError);
        console.setText(stringBuilder.toString());
        System.out.println(stringBuilder);

    }*/

        @FXML
        public void graph(javafx.event.ActionEvent event)  {
            try {
                int i =0;
                if (y1!=null) i++;
                if (y2!=null) i++;
                if (y3!=null) i++;
                if (y4!=null) i++;
                new CreateGraphs(event,y1,y2,y3,y4,i).start(Main.primaryStage);
            } catch (Exception e) {
            }
        }
    }

