import com.controller.Controller;
import com.model.Model;
import com.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View("Hoteles de ecoturismo");
        Controller controller = new Controller(model, view);

        controller.start();
        view.setVisible(true);
    }
}
