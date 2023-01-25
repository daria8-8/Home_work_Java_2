import java.util.*;
public class Ex3 {
    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        System.out.printf("Введите текст: ");
        String word = f.nextLine();
        String[] Chars = word.split("");
        boolean result = CheckWord(Chars);
        if(result == true){
            System.out.println("Это палиндром.");
        }else{
            System.out.println("Это не палиндом.");
        }
        f.close();
    }
    private static boolean CheckWord(String[] word) {
        String[] Check = new String[word.length];
        int count = 0;
        for(int i = word.length - 1; i >= 0; i--){
            Check[count] = word[i];
            count++;
        }
        String word1 = String.join("",word);
        String Check1 = String.join("", Check);
        boolean result = new String(Check1).equals(word1);
        return result;           
    }
}