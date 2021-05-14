import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String enAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String log = "Alex";
        String pass = "Gel1995e";
        int shift = 3;
        StringBuilder fullencrypt = new StringBuilder(log.concat(pass).length());
        for (int i = 0; i < fullencrypt.length(); i++){
            fullencrypt.setCharAt(i, enAlphabet.charAt(enAlphabet.charAt(Arrays.binarySearch)));
            System.out.println(fullencrypt);
        }
    }
}
