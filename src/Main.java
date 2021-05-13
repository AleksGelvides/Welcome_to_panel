import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    private static String log;
    private static String pass;
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
                    System.out.print("Придумайте и введите пароль (До 20 символов): ");
                    pass = scanner.nextLine();
                    if (pass.length() > 20) {
                        System.out.println("Слишком длинный пароль, попробуйте еще раз");
                        pass = null;
                    }
                    else
                    break;
            }
    CipherBase(log,pass,3);
    }
    private static void CipherBase(String login, String password, int schift){
        String enAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ruAlphabet = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        char [][] logPassArr = new char[log.length()][pass.length()];
        logPassArr [0] = (char) log.split("");
//        System.out.println(blockPass);
    }
}
