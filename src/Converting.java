import java.util.Arrays;
import java.util.Objects;

public class Converting {

    int leftNumber;
    int rightNumber;
    char operator;
    String inputString;
    boolean isRome;
    String[] rome = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    String[] symbols = {"+", "/", "-", "*"};

    public Converting(String input){
        inputString = input;
        Split();
    }

    public String RomeNumbers(String splitString){
        StringBuilder newString = new StringBuilder();
        for (int j = 0; j < rome.length; j++) {
            if (Objects.equals(splitString, rome[j])) {
                newString.append(j);
                isRome = true;
                break;
            }
        }
        if(newString.isEmpty()){
            newString = new StringBuilder(splitString);
            isRome = false;
        }
        return newString.toString();
    }

    public void Split(){
        int indexOfSymbol = 0;
        int indexLastSymbol = 0;
        int countOperators = 0;

        for (String symbol : symbols) {
            indexOfSymbol = inputString.indexOf(symbol);
            indexLastSymbol = inputString.lastIndexOf(symbol);
            if(indexOfSymbol != indexLastSymbol){
                throw new IllegalArgumentException("Invalid format");
            }
            if (indexOfSymbol > 0) {
                operator = inputString.charAt(indexOfSymbol);
                countOperators++;
            }
        }
        if(countOperators != 1){
            throw new IllegalArgumentException("Invalid format");
        }
        if(operator == '\0'){
            throw new IllegalArgumentException("Wrong operation");
        }
        String[] splitting = inputString.split(String.valueOf("\\" + operator));
        if(Arrays.toString(rome).contains(splitting[0]) && !Arrays.toString(rome).contains(splitting[1])){
            throw new IllegalArgumentException("Numbers refer to different number systems");
        }
        if(!Arrays.toString(rome).contains(splitting[0]) && Arrays.toString(rome).contains(splitting[1])){
            throw new IllegalArgumentException("Numbers refer to different number systems");
        }
        leftNumber = Integer.parseInt(RomeNumbers(splitting[0]));
        rightNumber = Integer.parseInt(RomeNumbers(splitting[1]));
        if(leftNumber > 10 || rightNumber > 10){
            throw new IllegalArgumentException("Numbers shouldn't be more than 10");
        }
    }
}
