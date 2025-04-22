package calculator;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class PrimaryController {

    // Initialization of Textfields and Labels
    @FXML private TextField inputA;
    @FXML private TextField inputB;
    @FXML private TextField inputBase;
    @FXML private TextField inputExponent;
    @FXML private TextField inputFactorial;
    @FXML private TextField inputTrigo;
    @FXML private TextField inputMisc;
    @FXML private TextField inputConversion;

    @FXML private ChoiceBox<String> fromBaseChoice;
    @FXML private ChoiceBox<String> toBaseChoice;
    @FXML private ToggleButton angleToggle;
    @FXML private ToggleButton themeToggle;
    
    @FXML private TabPane tabPane;

    @FXML private Label resultLabel;

    // Initialize functions 
    private Functions functions = new Functions();
    private Scene scene;

    // Initialize/Refresh the GUI
    // Also initialize number base conversions stuff
    @FXML public void initialize() {
        tabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            handleClear();
        });

        angleToggle.setText("Degrees");
        inputConversion.clear();

        fromBaseChoice.getItems().addAll("Binary", "Decimal", "Octal", "Hex");
        toBaseChoice.getItems().addAll("Binary", "Decimal", "Octal", "Hex");

        fromBaseChoice.setValue("Decimal");  // default selection
        toBaseChoice.setValue("Binary");
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void displayResult(double result) {
        if(result == (int) result) {
            resultLabel.setText("Result: " + (int) result);
        }
        else {
            resultLabel.setText(String.format("Result: %.4f", result));
        }
    }

    // Function to add 2 numbers
    public void handleAdd() {
        try {
            double a = Double.parseDouble(inputA.getText().trim());
            double b = Double.parseDouble(inputB.getText().trim());
            double result = functions.add(a, b);
            
            displayResult(result);
            HistoryController.addToHistory(a + " + " + b + " = " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    // Function to subtract 2 numbers
    public void handleSubtract() {
        try {
            double a = Double.parseDouble(inputA.getText().trim());
            double b = Double.parseDouble(inputB.getText().trim());
            double result = functions.subtract(a, b);
            
            displayResult(result);
            HistoryController.addToHistory(a + " - " + b + " = " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    // Function to multiply 2 numbers
    public void handleMultiply() {
        try {
            double a = Double.parseDouble(inputA.getText().trim());
            double b = Double.parseDouble(inputB.getText().trim());
            double result = functions.multiply(a, b);

            displayResult(result);
            HistoryController.addToHistory(a + " * " + b + " = " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }
    
    // Function to divide 2 numbers
    public void handleDivide() {
        try {
            double a = Double.parseDouble(inputA.getText().trim());
            double b = Double.parseDouble(inputB.getText().trim());
            double result = functions.divide(a, b);
            
            displayResult(result);
            HistoryController.addToHistory(a + " / " + b + " = " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        } catch (ArithmeticException e) {
            resultLabel.setText("Cannot divide by zero");
        }
    }

    // Function to get the modulo of 2 numbers
    public void handleModulo() {
        try {
            double a = Double.parseDouble(inputA.getText().trim());
            double b = Double.parseDouble(inputB.getText().trim());
            double result = functions.modulus(a, b);

            displayResult(result);
            HistoryController.addToHistory(a + " % " + b + " = " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        } catch (ArithmeticException e) {
            resultLabel.setText("Cannot divide by zero");
        }
    }

    // Function to calculate result given an exponent and a base value
    public void handleExponent() {
        try {
            double a = Double.parseDouble(inputBase.getText().trim());
            double b = Double.parseDouble(inputExponent.getText().trim());
            double result = functions.exponent(a, b);

            displayResult(result);
            HistoryController.addToHistory(a + "^" + b + " = " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    // Function to get the factorial of a number
    public void handleFactorial() {
        try {
            int a = Integer.parseInt(inputFactorial.getText().trim());
            double result = functions.factorial(a);

            resultLabel.setText("Result: " + result);
            HistoryController.addToHistory(a + "! = " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    // Function to get sine of given degree/radian
    public void handleSine() {
        try {
            double a = Double.parseDouble(inputTrigo.getText().trim());
            if (!angleToggle.isSelected()) { // Convert to radians if in Degrees mode
                a = functions.degToRad(a);
            }
            double result = functions.sine(a);

            resultLabel.setText("Result: " + result);
            if(!angleToggle.isSelected()) {
                HistoryController.addToHistory("sine(" + a + "rad) = " + result);
            }
            else {
                HistoryController.addToHistory("sine(" + a + "deg) = " + result);
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    // Function to get cosine of given degree/radian
    public void handleCosine() {
        try {
            double a = Double.parseDouble(inputTrigo.getText().trim());
            if (!angleToggle.isSelected()) { 
                a = functions.degToRad(a);
            }
            double result = functions.cosine(a);

            resultLabel.setText("Result: " + result);
            if(!angleToggle.isSelected()) {
                HistoryController.addToHistory("cosine(" + a + "rad) = " + result);
            }
            else {
                HistoryController.addToHistory("cosine(" + a + "deg) = " + result);
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    // Function to get tangent of given degree/radian
    public void handleTangent() {
        try {
            double a = Double.parseDouble(inputTrigo.getText().trim());
            if (!angleToggle.isSelected()) { 
                a = functions.degToRad(a);
            }
            double result = functions.tangent(a);

            resultLabel.setText("Result: " + result);
            if(!angleToggle.isSelected()) {
                HistoryController.addToHistory("tangent(" + a + "rad) = " + result);
            }
            else {
                HistoryController.addToHistory("tangent(" + a + "deg) = " + result);
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }
    
    // Function to get the inverse sine of given degree/radian
    public void handleInvSine() {
        try {
            double a = Double.parseDouble(inputTrigo.getText().trim());
            if (a < -1 || a > 1) {
                resultLabel.setText("Invalid Input.");
                return;
            }
            double radians = functions.invSine(a);
            double degrees = functions.radToDeg(radians);

            resultLabel.setText("Result: " + radians + " rad | " + degrees + "°");
            HistoryController.addToHistory("invSine(" + a + ") = " + radians + "rad | " + degrees + "°");
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    // Function to get the inverse cosine of given degree/radian
    public void handleInvCosine() {
        try {
            double a = Double.parseDouble(inputTrigo.getText().trim());
            if (a < -1 || a > 1) {
                resultLabel.setText("Invalid Input.");
                return;
            }
            double radians = functions.invCosine(a);
            double degrees = functions.radToDeg(radians);

            resultLabel.setText("Result: " + radians + " rad | " + degrees + "°");
            HistoryController.addToHistory("invCosine(" + a + ") = " + radians + "rad | " + degrees + "°");
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    // Function to get the inverse tangent of given degree/radian
    public void handleInvTangent() {
        try {
            double a = Double.parseDouble(inputTrigo.getText().trim());
            double radians = functions.invTangent(a);
            double degrees = functions.radToDeg(radians);

            resultLabel.setText("Result: " + radians + " rad | " + degrees + "°");
            HistoryController.addToHistory("invTangent(" + a + ") = " + radians + "rad | " + degrees + "°");
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    // Function to switch between degree and radian input 
    @FXML public void handleAngleToggle() {
        if (angleToggle.isSelected()) {
            angleToggle.setText("Radians");
        } else {
            angleToggle.setText("Degrees");
        }
    }

    // Function to get the absolute value of the input
    public void handleAbsValue() {
        try {
            double a = Double.parseDouble(inputMisc.getText().trim());
            double result = functions.absValue(a);

            resultLabel.setText("Result: " + result);
            HistoryController.addToHistory("|" + a + "| = " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    // Function to get the square root of the input
    public void handleSquareRoot() {
        try {
            double a = Double.parseDouble(inputMisc.getText().trim());
            double result = functions.nthRoot(a, 2);

            resultLabel.setText("Result: " + result);
            HistoryController.addToHistory("sqrt(" + a + ") = " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }
    
    // Function to get the log10 of an input
    public void handleLog10() {
        try {
            double a = Double.parseDouble(inputMisc.getText().trim());
            if(a > 0) {
                double result = functions.logarithm(a, 10);
                resultLabel.setText("Result: " + result);
                HistoryController.addToHistory("log10(" + a + ") = " + result);
            }
            else {
                resultLabel.setText("Invalid Input");
            }

        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    // Function to get the natural logarithm of an input
    public void handleNLog() {
        try {
            double a = Double.parseDouble(inputMisc.getText().trim());
            double result = functions.naturalLogarithm(a);

            resultLabel.setText("Result: " + result);
            HistoryController.addToHistory("ln(" + a + ") = " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Input");
        }
    }

    // Function to get the base suffix of a number system
    private String getBaseSuffix(String baseName) {
        switch (baseName) {
            case "Binary":
                return "b";
            case "Octal":
                return "o";
            case "Decimal":
                return "d";
            case "Hexadecimal":
                return "h";
            default:
                return "";
        }
    }

    // Function to do the number conversions
    public void handleConversions() {
        try {
            String input = inputConversion.getText().trim();
            String fromBase = fromBaseChoice.getValue();
            String toBase = toBaseChoice.getValue();
            String result = "";

            String fromSuffix = getBaseSuffix(fromBase);
            String toSuffix = getBaseSuffix(toBase);

            // Input Validation
            if(fromBase.equals("Binary") && !functions.isValidBinary(input)) {
                resultLabel.setText("Invalid binary input.");
                return;
            }
            if(fromBase.equals("Octal") && !functions.isValidOctal(input)) {
                resultLabel.setText("Invalid octal input.");
                return;
            }
            if(fromBase.equals("Hex") && !functions.isValidHex(input)) {
                resultLabel.setText("Invalid hex input.");
                return;
            }

            if(fromBase.equals("Decimal")) {
                int decimal = Integer.parseInt(input);

                switch(toBase) {
                    case "Binary":
                        result = functions.decToBin(decimal);
                        HistoryController.addToHistory(decimal + "d = " + result + "b");
                        break;
                    case "Octal":
                        result = functions.decToOct(decimal);
                        HistoryController.addToHistory(decimal + "d = " + result + "o");
                        break;
                    case "Hex":
                        result = functions.decToHex(decimal);
                        HistoryController.addToHistory(decimal + "d = " + result + "h");
                        break;
                    default:
                        result = input;
                }
            }
            else {
                int decimal = 0;
                switch(fromBase) {
                    case "Binary":
                        decimal = functions.binToDec(input);
                        break;
                    case "Octal":
                        decimal = functions.octToDec(input);
                        break;
                    case "Hex":
                        decimal = functions.hexToDec(input);
                        break;
                }

                switch(toBase) {
                    case "Decimal":
                        result = String.valueOf(decimal);
                        break;
                    case "Binary":
                        result = functions.decToBin(decimal);
                        break;
                    case "Octal":
                        result = functions.decToOct(decimal);
                        break;
                    case "Hex":
                        result = functions.decToHex(decimal);
                        break;
                }

                HistoryController.addToHistory(input + fromSuffix + " = " + result + toSuffix);
            }
            
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
        resultLabel.setText("Invalid number format.");
        } catch (Exception e) {
            resultLabel.setText("Error: " + e.getMessage());
        }
    }

    // Function to clear displays
    public void handleClear() {
        inputA.clear();
        inputB.clear();
        inputBase.clear();
        inputExponent.clear();
        inputFactorial.clear();
        inputTrigo.clear();
        inputConversion.clear();
        inputMisc.clear();

        fromBaseChoice.setValue("Decimal");  // default selection
        toBaseChoice.setValue("Binary");

        angleToggle.setSelected(false);
        angleToggle.setText("Degrees");

        resultLabel.setText("Result is displayed here");
    }

    // Function to show history logs
    @FXML private void handleViewHistory() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("history.fxml"));
            Parent root = loader.load();

            Scene historyScene = new Scene(root);

            if(themeToggle.isSelected()) {
                historyScene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
            }

            Stage historyStage = new Stage();
            historyStage.setTitle("Calculation History");
            historyStage.setScene(historyScene);
            historyStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void handleThemeToggle() {
        if(themeToggle.isSelected()) {
            themeToggle.setText("Light Mode");
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
        }
        else {
            themeToggle.setText("Dark Mode");
            scene.getStylesheets().clear();
        }
    }
}
