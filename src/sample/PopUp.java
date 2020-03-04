package sample;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;
import sun.tools.jstat.Alignment;


public class PopUp {



    public static void displayError(String title, String message)
    {
        Stage popupwindow = new Stage();
        Label displayText = new Label(message);
        Text header = new Text("Dis is Header");
        Button close = new Button("Close & Try Again");
        GridPane gridPane = new GridPane();

        //VBox PopUplayout= new VBox(10);

        header.setStyle("-fx-font-weight: 700px");



        close.setOnAction(e -> popupwindow.close());

        displayText.setWrapText(true);
        displayText.setTextAlignment(TextAlignment.JUSTIFY);

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle(title);

        //PopUplayout.getChildren().addAll(displayText, close);
        //PopUplayout.setAlignment(Pos.CENTER);

        gridPane.add(header,1,0);
        gridPane.add(displayText,1,1);
        gridPane.add(close,1,2);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setPrefSize(300, 250);
        gridPane.setMinSize(300, 250);

        Scene theScene = new Scene(gridPane, 300, 250);

        popupwindow.setScene(theScene);
        popupwindow.showAndWait();

    }

    public static void retracingWindow(Retracing retrace)
    {
        int availableSteps = retrace.getRetracingArrayLength();
        Stage popupwindow = new Stage();
        Text header = new Text("Enter Steps");
        Button submit = new Button("Submit");
        GridPane gridPane = new GridPane();

        JFXComboBox<Label> selectSteps = new JFXComboBox<Label>();
        HBox steps = new HBox();

        if (availableSteps > 0) {
            for (int i = 1; i <= retrace.getRetracingArrayLength(); i++) {
                selectSteps.getItems().add(new Label(""+i));
            }

            Label stepsLabel = new Label("Steps to Retrace: ");
            steps.getChildren().add(stepsLabel);
            steps.getChildren().add(selectSteps);

        } else {
            Label stepsLabel = new Label("Hi, you need to actually run some commands to use the retracing function!");
            stepsLabel.setWrapText(true);
            stepsLabel.setTextAlignment(TextAlignment.JUSTIFY);
            steps.getChildren().add(stepsLabel);
            //steps.getChildren().add(selectSteps);
        }

        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (availableSteps > 0) {

                    // gets the index ex (0,1,2,3) then adds one ex (1,2,3,4) so then that's the amount of steps
                    retrace.use(selectSteps.getSelectionModel().getSelectedIndex() + 1);

                }
                popupwindow.close();
            }
        });




        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Retrace Steps");



        gridPane.add(header,1,0);
        gridPane.add(steps,1,1);
        gridPane.add(submit,1,2);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setPrefSize(300, 250);
        gridPane.setMinSize(300, 250);

        Scene theScene = new Scene(gridPane, 300, 250);

        popupwindow.setScene(theScene);
        popupwindow.showAndWait();

    }

}
