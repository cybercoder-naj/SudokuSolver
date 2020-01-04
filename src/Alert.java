import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Alert {

    public void display(Stage stage) {
        Stage window = new Stage();
        window.setTitle("No solution");
        window.setWidth(300);
        window.setHeight(400);
        window.initModality(Modality.APPLICATION_MODAL);
        Label title = new Label("There is no solution for the given problem.");
        Button ok = new Button("OKAY");
        VBox vBox = new VBox(40);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(title, ok);
        window.setScene(new Scene(vBox));

        ok.setOnAction(actionEvent -> {
            window.close();
            stage.close();
        });

        window.showAndWait();
    }
}
