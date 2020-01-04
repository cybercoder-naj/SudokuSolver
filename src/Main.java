import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String TAG = "Sudoku Solver";
    private Label[][] buttons = new Label[9][9];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle(TAG);

        GridPane gridPane = getGridPane();

        Scene scene = new Scene(gridPane);
        Setup setup = new Setup(buttons, scene, stage);
        setup.setup();
        stage.setScene(scene);
        stage.show();
    }

    private GridPane getGridPane() {
        GridPane gridPane = new GridPane();

        gridPane.setGridLinesVisible(true);
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(0);
        gridPane.setHgap(0);

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                buttons[i][j] = new Label("");
                buttons[i][j].setStyle("-fx-font-weight: bold; -fx-font-size: 40");
                buttons[i][j].setAlignment(Pos.CENTER);
                buttons[i][j].setTextAlignment(TextAlignment.CENTER);
                buttons[i][j].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            }

        for (int i = 1; i <= 9; i++) {
            gridPane.getColumnConstraints().add(new ColumnConstraints(50));
            gridPane.getRowConstraints().add(new RowConstraints(50));
        }

        for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++) GridPane.setConstraints(buttons[i][j], j, i);

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) gridPane.getChildren().add(buttons[i][j]);

        GridPane.setHalignment(gridPane, HPos.CENTER);
        GridPane.setValignment(gridPane, VPos.CENTER);
        gridPane.setAlignment(Pos.CENTER);

        return gridPane;
    }
}