/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package kalkulator;

import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //mulai coding
        
        VBox vbox = new VBox();

        Label judul = new Label ("CALCULATOR");
        judul.setFont(Font.font("Arial", 23));
        vbox.getChildren().add(judul);
        vbox.setSpacing(12.5);

        Button tombol = new Button("start");
        tombol.getStyleClass().add("tombol");
        vbox.getChildren().add(tombol);
        vbox.setAlignment(Pos.CENTER);

        tombol.setOnAction(action -> {
            layarOpsi(stage);
        });

        // VBox secRight = new VBox (judul, tombol);
        // secRight.setSpacing(8);
        // secRight.setAlignment(Pos.CENTER);
        // secRight.setPrefWidth(320);
        // secRight.setId("s");

        ImageView ivBanner = new ImageView("/bgkalkul.jpg");
        ivBanner.setFitWidth(320);
        ivBanner.setFitHeight(512);
        ivBanner.setPreserveRatio(true);
     
        StackPane backg = new StackPane(ivBanner, vbox);
        // VBox rootNode = new VBox (ivBanner, vbox);

        // Scene gmbr = new Scene(rootNode, 320, 512);
        // return gmbr;

        Scene scene = new Scene(backg, 320, 512);
        stage.setScene(scene);
        stage.setTitle("Kalkul");
        stage.show();
    }

    public void layarOpsi (Stage stage){
        VBox vbox = new VBox();
        vbox.setId("section-right");
        Label opsiLabel = new Label("MENU");
        opsiLabel.setFont(Font.font("Arial",23));
        vbox.getChildren().add(opsiLabel);
        vbox.setSpacing(12.5);

        Button kalkulSuhu = new Button ("Kalkulator Suhu");
        kalkulSuhu.getStyleClass().add("kalkulSuhu");
        vbox.getChildren().add(kalkulSuhu);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(12.5);

        kalkulSuhu.setOnAction(action -> {
            kalkulSuhu(stage);
        });

        Button kalkulJarak = new Button ("Kalkulator Jarak");
        kalkulJarak.getStyleClass().add("kalkulJarak");
        vbox.getChildren().add(kalkulJarak);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(12.5);

        kalkulJarak.setOnAction(action ->{
            kalkulJarak(stage);
        });

        Scene scene = new Scene(vbox, 320, 512);
        scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void kalkulSuhu (Stage stage){
        Label judulSuhu = new Label ("KALKULATOR SUHU CELCIUS ke REAMUR");
        judulSuhu.setFont(Font.font("Arial", 15));

        TextField tfCelcius = new TextField();
        tfCelcius.setPromptText("Celcius");

        Button tombolProses = new Button ("COUNT");

        Label lHasil = new Label();
        Button back = new Button("RETURN");
        back.setOnAction(v ->{
            layarOpsi(stage);
        });

        tombolProses.setOnAction(v ->{
            double celcius = Double.parseDouble(tfCelcius.getText());
            double hasil = (0.8)*celcius;

            lHasil.setText(String.format("%.0f Reamur", hasil));
        });

        VBox vbox = new VBox(judulSuhu, tfCelcius, tombolProses, lHasil, back);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(12.5);

        Scene scene = new Scene(vbox, 320, 512);
        stage.setScene(scene);
        stage.show();
    }

    public void kalkulJarak (Stage stage){
        Label judulJarak = new Label ("KALKULATOR JARAK CM ke M");
        judulJarak.setFont(Font.font("Arial", 15));

        TextField tfCentiMeter = new TextField();
        tfCentiMeter.setPromptText("Centimeter");

        Button tombolProses = new Button ("COUNT");

        Label lJumlah = new Label();
        Button back = new Button("RETURN");
        back.setOnAction(v ->{
            layarOpsi(stage);
        });

        tombolProses.setOnAction(v ->{
            double cm = Double.parseDouble(tfCentiMeter.getText());
            double jumlah = cm/100;

            lJumlah.setText(String.format("%.2f", jumlah,"Meter"));
        });

        VBox vbox = new VBox(judulJarak, tfCentiMeter, tombolProses, lJumlah, back);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(12.5);

        // ImageView ivBanner = new ImageView("/bgkalkul.jpg");
        // ivBanner.setFitWidht(320);
        // ivBanner.setFitHeight(512);
        // ivBanner.setPrerveRatio(true);

        Scene scene = new Scene(vbox, 320, 512);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { // untuk run
        launch();
    }

}