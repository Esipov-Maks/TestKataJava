import java.util.Scanner;

public class Start {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input math expression into a string: ");

        String str = scanner.nextLine();
        Calculating calc = new Calculating(str);
        System.out.println(calc.Calculate());
    }

}


