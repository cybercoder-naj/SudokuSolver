import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

class Setup {
    private Label[][] labels;
    private Scene scene;
    private Stage stage;
    private int i, j;

    Setup(Label[][] labels, Scene scene, Stage stage) {
        this.labels = labels;
        this.scene = scene;
        this.stage = stage;
        System.out.println("[i = " + i + ", j = " + j + "]");
        labels[i][j].setText("?");
    }

    void setup() {
        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.BACK_SPACE) labels[i][--j].setText("?");
            else if (!((keyEvent.getCode() == KeyCode.NUMPAD0) || (keyEvent.getCode() == KeyCode.DIGIT0))) {
                labels[i][j].setText(String.valueOf(keyEvent.getCode().getName().charAt(keyEvent.getCode().getName().length()-1)));
                labels[i][j].setTextFill(Color.BLACK);
            } else {
                labels[i][j].setText("");
                labels[i][j].setTextFill(Color.RED);
            }
            if (++j >= 9) {
                i++;
                j = 0;
            }
            System.out.println("[i = " + i + ", j = " + j + "]");
            if (i >= 9) {
                if (!new Solver().solve(labels)) {
                    new Alert().display(stage);
                }
            } else labels[i][j].setText("?");
        });
    }
}