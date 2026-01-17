package lab.xml.pp_ekr;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class HelloController {

    @FXML
    private TextArea inputTextArea;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private TextField shiftField;

    private final CaesarCipher cipher = new CaesarCipher();

    @FXML
    protected void onEncryptClick() {
        processText(true);
    }

    @FXML
    protected void onDecryptClick() {
        processText(false);
    }

    private void processText(boolean isEncrypt) {
        String text = inputTextArea.getText();
        String shiftText = shiftField.getText();

        if (text == null || text.isEmpty()) {
            showAlert("Ошибка", "Введите текст для обработки.");
            return;
        }

        try {
            int shift = Integer.parseInt(shiftText);
            String result;

            if (isEncrypt) {
                result = cipher.encrypt(text, shift);
            } else {
                result = cipher.decrypt(text, shift);
            }

            outputTextArea.setText(result);

        } catch (NumberFormatException e) {
            showAlert("Ошибка", "Сдвиг должен быть целым числом.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}