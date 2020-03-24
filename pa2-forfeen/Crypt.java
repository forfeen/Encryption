//package encryptdecrypt;
import java.util.Scanner;
//import encryptdecrypt.*;


public class Crypt{


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        byte key = scanner.nextByte();
//        for (int i = 0; i < args.length; i++) {
//            System.out.print(args[i]);
//        }
        Encrypt x = new Encrypt(args, key);
        //System.out.println(Encrypt(args, key));
        System.out.println(x);
//        }
    }
}
