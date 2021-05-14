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
                    System.out.print("Придумайте и введите пароль (До 20 символов): ");
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
            Encrypt(log, pass, shift);
        }
    }
    private static String Encrypt (String login, String password, int ciphershift){
//        copyOfRange(array, from, to) - спользовать это, что бы всё заработало.
        String encriptPass;
        String enAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        encriptPass = password.concat(log).toUpperCase().trim();
        String noEncriptpass = encriptPass;
        for (int i = 0; i < encriptPass.length(); i++){
            if (encriptPass.charAt(i) != noEncriptpass.charAt(i)) continue;
            for (int g = 0; i < noEncriptpass.length(); i++){
                char replase = encriptPass.charAt(i); //Вычислили первый символ нешифрованного пароля.
                int index = enAlphabet.indexOf(replase) + ciphershift; // Нашли индекс этого символа в Англ Алфавите и зашифровали его.
                char enRep = enAlphabet.charAt(index); //Запомнили символ английского алфавита
                encriptPass = encriptPass.replace(replase, enRep);
                break;
            }
        }
//        System.out.println(encriptPass);
        return encriptPass;
    }
}
