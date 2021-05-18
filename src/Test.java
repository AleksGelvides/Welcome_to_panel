import java.util.Arrays;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        StringBuilder enAlphabet = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String log = "abc";
        String pass = "aaa";
        int shift = 3;
        StringBuilder fullencrypt = new StringBuilder(pass.toUpperCase());
        for (int i = 0; i < fullencrypt.length(); i++) {
            if (enAlphabet.lastIndexOf(String.valueOf(fullencrypt.charAt(i))) + shift >= enAlphabet.length())
                enAlphabet = enAlphabet.append(enAlphabet);
            fullencrypt.setCharAt(i, enAlphabet.charAt(enAlphabet.indexOf(String.valueOf(fullencrypt.charAt(i))) + shift));
        }
        System.out.println(fullencrypt);
    }
}