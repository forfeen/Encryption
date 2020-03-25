package encryptdecrypt;
import java.lang.StringBuffer;
import java.lang.Math;

public class Decrypt {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private String text;

    private int key;

    public Decrypt(String text, int key){
        this.text = text;
        this.key = key;
    }

    public static StringBuffer decrypt(String text, int key) {

        StringBuffer decrypt = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char inputChar = text.toLowerCase().charAt(i);
            int index = (byte) alphabet.indexOf(inputChar);
            if (inputChar == ' ' || inputChar == '!') {
                decrypt.append(inputChar);
            } else {
                int position = index - key;
                if (position < 0){
                    decrypt.append(alphabet.charAt(26+((index-key)%26)));
                }
                else {
                    decrypt.append(alphabet.charAt(Math.abs((index - key) % 26)));
                }
            }
        }
        return decrypt;
    }
}