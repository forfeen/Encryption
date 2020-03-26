package encryptdecrypt;
import java.util.Scanner;
import encryptdecrypt.Encrypt;
import encryptdecrypt.Decrypt;


public class Crypt{

    public static void main(String[] args) {
        String input = " " ;
        String crypt = "enc";
        int key = 0;

        for (int i = 0; i < args.length; i++) {
            if ((args[i]).equals("-mode")){
                if ((args[i+1]).equals("dec")){
                    crypt = "dec";
                }
                else {
                    crypt = "enc";
                }
            }
            else if ((args[i]).equals("-key")){
                key = Integer.parseInt(args[i+1]);
                if (key < 0) {
                    crypt = "dec";
                }
            }
            else if ((args[i]).equals("-data")){
                input = (String) args[i+1];
            }
        }

        if (crypt == "dec"){
            System.out.println(Decrypt.decrypt(input,key));
        }
        else {
            System.out.println(Encrypt.encrypt(input,key));
        }

    }
}
