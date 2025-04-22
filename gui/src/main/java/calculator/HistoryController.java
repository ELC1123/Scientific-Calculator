package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class HistoryController {

    @FXML private TextArea historyTextArea;

    private static StringBuilder history = new StringBuilder();

    public void initialize() {
        historyTextArea.setText(history.toString());
    }

    public static void addToHistory(String entry) {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = current.format(formatter);

        history.append("[").append(time).append("] ").append(entry).append("\n");
    }

    @FXML private void handleClearHistory() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Clear All History?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Confirm History Clear");
        alert.setHeaderText("Are you sure you want to clear the history?");

        alert.showAndWait().ifPresent(response -> {
            if(response == ButtonType.YES) {
                history.setLength(0);
                historyTextArea.clear();
            }
        });
    }
}