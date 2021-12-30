import controller.CodingViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.CodingFacade;
import view.CodingView;

public class CodingApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        CodingFacade codingFacade = new CodingFacade();
        CodingView codingView = new CodingView();
        CodingViewController codingViewController = new CodingViewController(codingView, codingFacade);

    }
}
