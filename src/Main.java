import java.util.Arrays;
import java.util.Scanner;
public class Main {
    private static String log;
    private static String pass;
    private static int shift;
    public static void main(String[] args) {
        System.out.println("Зарегестрируйтесь или залогиньтесь в системе");
        System.out.println("Введите \"Login\" для входа или \"Reg\" для регистрации");
        Scanner scanner = new Scanner(System.in);
        String newLogin = scanner.nextLine();
        if (newLogin.equalsIgnoreCase("login")) Login();
        if (newLogin.equalsIgnoreCase("reg")) Registration();
    }
    public static void Login(){

    }
    public static void Registration(){
        Scanner scanner = new Scanner(System.in);
                boolean logcy = true;
                while (logcy) {
                    System.out.print("Придумайте и введите ваш логин (До 10 символов): ");
                    log = scanner.nextLine();
                    if (log.length() > 10) {
                        System.out.println("Слишком длинный логин, попробуйте еще раз");
                        log = null;}
                    else
                    break;
            }
                boolean passcy = true;
                while (passcy) {
                    System.out.print("Придумайте и введите пароль (До 20 символов) пока поддерживает только латиницу:( ");
                    pass = scanner.nextLine();
                    if (pass.length() > 20) {
                        System.out.println("Слишком длинный пароль, попробуйте еще раз");
                        pass = null;
                    }
                    else
                    break;
            }
        boolean shiftwork = true;
        while (shiftwork) {
            System.out.print("Введите значение от 1 до 10 для подтверждения регистрации: ");
            shift = scanner.nextInt();
            if (shift > 10) {
                System.out.println("Неверное значение, попробуйте еще раз");
                pass = null;
            } else
                break;
        }
    }
    private static StringBuilder Encrypt (String login, String password, int ciphershift){
        String enAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder fullencrypt = new StringBuilder(pass.toUpperCase());
        for (int i = 0; i < fullencrypt.length(); i++){
            if(enAlphabet.lastIndexOf(fullencrypt.charAt(i))+shift >= enAlphabet.length()) enAlphabet = enAlphabet.concat(enAlphabet);
            fullencrypt.setCharAt(i, enAlphabet.charAt(enAlphabet.indexOf(String.valueOf(fullencrypt.charAt(i)))+shift));
        }
        return fullencrypt;
    }
}
