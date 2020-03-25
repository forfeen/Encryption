package encryptdecrypt;
import java.lang.StringBuffer;

public class Encrypt {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private String text;

    private int key;

    public Encrypt(String text, int key){
        this.text = text;
        this.key = key;
    }

    public static StringBuffer encrypt(String text,int key) {

        StringBuffer encrypt = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char inputChar = text.toLowerCase().charAt(i);
            int index = (byte) alphabet.indexOf(inputChar);
            if (inputChar == ' ' || inputChar == '!') {
                encrypt.append(inputChar);
            } else {
                encrypt.append(alphabet.charAt((index + key) % 26));
            }
        }
        return encrypt;
    }
}