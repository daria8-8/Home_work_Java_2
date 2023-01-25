import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.util.Scanner;
public class Ex4 {
    public static void main(String[] args) throws IOException{
        Logger log = Logger.getLogger(Ex4.class.getName());
        FileHandler fh = new FileHandler("Calculator.log", true);
        log.addHandler(fh);
        fh.setFormatter(new SimpleFormatter());
        System.out.println("Введите первое число: ");
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("First number = " + num1));
        System.out.println("Введите оператор: -, +, *, /");
        String operations = scan.next();
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Operations = " + operations));
        System.out.println("Введите второе число: ");
        int num2 = scan.nextInt();
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("Second number = " + num2));
        int result = 0;
        switch (operations) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
        }
        System.out.printf("%d %s %d = %d", num1, operations, num2, result);
        log.setLevel(Level.INFO);
        log.log(Level.INFO, String.format("%d %s %d = %d", num1, operations, num2, result));
        scan.close();
        }
    }
