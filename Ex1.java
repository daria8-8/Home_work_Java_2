import java.util.Arrays;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.*;
import java.util.Scanner;
public class Ex1 {
    private static Logger LOGGER = Logger.getLogger(Ex1.class.getName());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Введите длину массива: ");
        int size = scanner.nextInt(); 
        int array[] = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt(); 
        }
        scanner.close();
        int temp;
        for (int i = array.length - 1; i > 0; i--) { 
            for (int j = 0; j < i; j++) { 
                if (array[j] > array[j + 1]) { 
                    temp = array[j]; 
                    array[j] = array[j + 1]; 
                    array[j + 1] = temp;
                }
            }
        }
    LOGGER.setLevel(Level.ALL);
    try {   FileHandler fhandler = new FileHandler("Logfile.txt", true);
            SimpleFormatter sformatter = new SimpleFormatter();
            fhandler.setFormatter(sformatter);
            LOGGER.addHandler(fhandler);
    } catch (IOException ex) {
        LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
    } catch (SecurityException ex) {
        LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
    }
        System.out.println(Arrays.toString(array)); 
        LOGGER.log(Level.INFO, (Arrays.toString(array)));
    }
}