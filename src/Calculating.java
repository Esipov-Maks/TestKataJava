public class Calculating {

    int leftNumber;
    int rightNumber;
    char operator;
    boolean isRome;
    String[] rome = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public Calculating(String input){
        Converting convert = new Converting(input);
        leftNumber = convert.leftNumber;
        rightNumber = convert.rightNumber;
        operator = convert.operator;
        isRome = convert.isRome;
    }

    public String Calculate(){
        int result;
        String stringResult = "0";
        switch (operator){
            case '+':
                result = leftNumber + rightNumber;
                break;
            case '-':
                result = leftNumber - rightNumber;
                break;
            case '*':
                result = leftNumber * rightNumber;
                break;
            case '/':
                try{
                    result = leftNumber / rightNumber;
                } catch (ArithmeticException e) {
                    throw new ArithmeticException("Division by zero");
                }
                break;
            default:
                throw new IllegalArgumentException("Wrong operation");
        }
        if(isRome && result < 0){
            throw new ArithmeticException("Result for calculating roman numbers less then 0");
        }
        if(!isRome){
            stringResult = Integer.toString(result);
        }
        else{
            stringResult = rome[result];
        }
        return stringResult;
    }
}
