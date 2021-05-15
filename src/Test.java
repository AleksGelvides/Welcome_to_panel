import java.util.Arrays;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        String enAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String log = "abc";
        String pass = "sdfsdfsdf";
        int shift = 3;
        StringBuilder fullencrypt = new StringBuilder(pass.toUpperCase());
        for (int i = 0; i < fullencrypt.length(); i++){
                fullencrypt.setCharAt(i, enAlphabet.charAt(enAlphabet.indexOf(String.valueOf(fullencrypt.charAt(i)))+shift));
        }
        System.out.println(fullencrypt);
    }
}
