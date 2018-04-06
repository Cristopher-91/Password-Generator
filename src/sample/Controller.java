package sample;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import java.util.Random;


public class Controller {

    @FXML private TextField FXAmount;
    @FXML private TextField FXResult;
    @FXML private CheckBox FXisDigits;
    @FXML private CheckBox FXisUpper;
    @FXML private CheckBox FXisSpecial;
    @FXML private Label FXError;

    String alphabet = "abcdefghijklmnopqrstuwxyz";
    String uppers = "ABCDEFGHIJKLMNOPQRSTUWXYZ"; //default 3
    String digits = "0123456789";  //default 3
    String specials = "!@#$%^&*<>?/";  //default 2

    Random r = new Random();

    private Main main;

    public void setMain(Main main){
        this.main = main;
    }

    public void GeneratePassword(){
        try {
            FXError.setText("");
            int additional = 0;
            String result = "";
            char[] characters;

            int length = Integer.parseInt(FXAmount.getText());
            if (length > 25) length = 25;     //limit for <25 chars
            if (length < 8) length = 8;       //limit for >8 chars

            for (int i = 0; i <= length; i++) {
                result += (alphabet.charAt(r.nextInt(alphabet.length())));
            }
            if (FXisDigits.isSelected()) {
                for (int i = 0; i < 3; i++) {
                    result += (digits.charAt(r.nextInt(digits.length())));
                    additional++;
                }
            }
            if (FXisUpper.isSelected()) {
                for (int i = 0; i < 3; i++) {
                    result += (uppers.charAt(r.nextInt(uppers.length())));
                    additional++;
                }
            }
            if (FXisSpecial.isSelected()) {
                for (int i = 0; i < 2; i++) {
                    result += (specials.charAt(r.nextInt(specials.length())));
                    additional++;
                }
            }
            //full string
            result = result.substring(additional + 1);
            //string shuffle
            characters = result.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                int randomIndex = (int) (Math.random() * characters.length);
                char temp = characters[i];
                characters[i] = characters[randomIndex];
                characters[randomIndex] = temp;
            }
            //characters again become string
            result = new String(characters);

            FXResult.setText(result);
        }
        catch(Exception e){
            FXError.setText("Wrong input!");
        }
    }
}
