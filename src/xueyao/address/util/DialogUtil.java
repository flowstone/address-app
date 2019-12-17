package xueyao.address.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * @author Simon.Xue
 * @date 2019-12-17 21:11
 **/
public class DialogUtil {

    /**
     * 创建Dialog
     * @param title
     * @param content
     */
    public static void createInformation(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        Optional<ButtonType> result = alert.showAndWait();
        alert.close();
    }

    public static void createWarningg(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(content);
        Optional<ButtonType> result = alert.showAndWait();
        alert.close();
    }
}
