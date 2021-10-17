package ui;

import domain.CaesarCoding;
import domain.CodingContext;
import domain.CodingStrategy;
import domain.MirrorCoding;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CodingUi extends Application {
    CodingContext codingContext;

    public CodingUi() {
        this.codingContext = new CodingContext();
    }

    public CodingContext getCodingContext() {
        return codingContext;
    }

    public void setCodingContext(CodingContext codingContext) {
        this.codingContext = codingContext;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Coding Application");

        GridPane gridPane = new GridPane();

        Label textLabel = new Label("Text to encrypt/decrypt:");
        TextField textInput = new TextField();
        gridPane.add(textLabel, 0, 0);
        gridPane.add(textInput, 1, 0);

        Label outputLabel = new Label("Encrypted/Decrypted text:");
        TextField textOutput = new TextField();
        textOutput.setEditable(false);
        gridPane.add(outputLabel, 0, 1);
        gridPane.add(textOutput, 1, 1);

        Label caesarLabel = new Label("Caesar number:");
        TextField caesarNumber = new TextField();
        caesarNumber.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("\\d*")) codingContext.setCaesarNumber(caesarNumber.getText());
            else caesarNumber.setText(newValue.replaceAll("[^\\d]", ""));
        });
        gridPane.add(caesarLabel, 0, 4);
        gridPane.add(caesarNumber, 1, 4);
        Label strategyLabel = new Label("Strategy to encrypt/decrypt:");
        ComboBox<CodingStrategy> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                new CaesarCoding(),
                new MirrorCoding()
        );
        comboBox.getSelectionModel().selectFirst();
        codingContext.setCodingStrategy(comboBox.getValue());
        caesarNumber.setText(String.valueOf(codingContext.getCaesarNumber()));
        comboBox.setOnAction(e -> {
            codingContext.setCodingStrategy(comboBox.getValue());
            if (comboBox.getValue().toString().equals("Caesar")) {
                caesarNumber.setText(String.valueOf(codingContext.getCaesarNumber()));
                caesarLabel.setVisible(true);
                caesarNumber.setVisible(true);
            } else {
                caesarLabel.setVisible(false);
                caesarNumber.setVisible(false);
            }
        });
        gridPane.add(strategyLabel, 0, 2);
        gridPane.add(comboBox, 1, 2);

        Button encode = new Button("Encode");
        Button decode = new Button("Decode");
        encode.setOnAction(e -> {
            getCodingContext().setText(textInput.getText());
            textOutput.setText(getCodingContext().encode());
        });
        decode.setOnAction(e -> {
            getCodingContext().setText(textInput.getText());
            textOutput.setText(getCodingContext().decode());
        });
        gridPane.add(encode, 1, 3);
        gridPane.add(decode, 2, 3);

        Scene scene = new Scene(gridPane, 600, 600);
        stage.setScene(scene);
        stage.show();
    }
}
