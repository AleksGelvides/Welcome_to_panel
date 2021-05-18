import java.util.Arrays;
import java.util.Scanner;
public class Main {
    private static String log;
    private static int shift;
    private static StringBuilder savedEnPass = new StringBuilder();
    public static void main(String[] args) {
        boolean adminPanel = true;
        while (adminPanel) {
            System.out.println("Зарегистрируйтесь или залогиньтесь в системе");
            System.out.println("Введите \"Log\" для входа или \"Reg\" для регистрации");
            Scanner scanner = new Scanner(System.in);
            String newLogin = scanner.nextLine();
            if (newLogin.equalsIgnoreCase("log")) login();
            if (newLogin.equalsIgnoreCase("reg")) registration();
        }
    }
    public static void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вход в панель");
        System.out.println("Введите логин и пароль через Enter");
        for (int i = 9; i >= 0; i--) {
            String enterLogin = scanner.nextLine();
            String enterPass = scanner.nextLine();
            if (enterLogin.equals(log) && enterPass.equalsIgnoreCase(String.valueOf(decrypt(savedEnPass)))){
                System.out.println("Добро пожаловать в админку :)");
                break;
            }  else {
                System.out.println("Неверный логин или пароль, повторите попытку. Осталось попыток: " + i);
                }
        }
    }
    public static void registration(){
        Scanner scanner = new Scanner(System.in);
                String pass = null;
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
        savedEnPass = encrypt(log,pass,shift);
    }
    private static StringBuilder encrypt (String login, String password, int ciphershift){
        String enAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder fullencrypt = new StringBuilder(password.toUpperCase());
        for (int i = 0; i < fullencrypt.length(); i++){
            if(enAlphabet.lastIndexOf(fullencrypt.charAt(i))+shift >= enAlphabet.length()) enAlphabet = enAlphabet.concat(enAlphabet);
            fullencrypt.setCharAt(i, enAlphabet.charAt(enAlphabet.indexOf(String.valueOf(fullencrypt.charAt(i)))+shift));
        }
        return fullencrypt;
    }
    private static StringBuilder decrypt (StringBuilder password){
        String enAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder checkPass = new StringBuilder(password);
        for (int i = 0; i < checkPass.length(); i++){
            if(enAlphabet.lastIndexOf(checkPass.charAt(i))-shift <= 0) enAlphabet = enAlphabet.concat(enAlphabet);
            checkPass.setCharAt(i, enAlphabet.charAt(enAlphabet.indexOf(String.valueOf(checkPass.charAt(i)))-shift));
        }
        //Отрицательный выход за диапазон
        return checkPass;
    }
}
