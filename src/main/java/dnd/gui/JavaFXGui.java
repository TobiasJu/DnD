package dnd.gui;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Kuwe on 28.07.2016.
 */
public class JavaFXGui extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        Label label1 =  new Label("Welcome to Dungeon and Dragons.");
        Button button1 = new Button("Enter the Dungeon...");
        Button alertbutton = new Button("Test Alert!!!!!1111Elf!");
        alertbutton.setOnAction(e -> AlertBox.display("Attention!", "ZOMG! Irgendwas ist schief gegangen."));
        button1.setOnAction(e -> window.setScene(scene2));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1, alertbutton);
        scene1 = new Scene(layout1, 200, 200);

        Button button2 = new Button("Leave the Dungeon...");
        button2.setOnAction(e -> window.setScene(scene1));

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2,600,600);

        window.setScene(scene1);
        window.setTitle("DnD");
        window.show();

    }

    private void closeProgram(){
        Boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
        if (answer){
            window.close();
        }
    }

}
