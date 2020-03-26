package encryptdecrypt;
import java.lang.StringBuffer;
import java.lang.Math;
import java.lang.Character;

public class Decrypt {
    private static String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";

    private static String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String text;

    private int key;

    public Decrypt(String text, int key){
        this.text = text;
        this.key = key;
    }

    public static StringBuffer decrypt(String text, int key) {

        StringBuffer decrypt = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char inputChar = text.charAt(i);
            int indexLowerCase = (byte) alphabetLowerCase.indexOf(inputChar);
            int indexUpperCase = (byte) alphabetUpperCase.indexOf(inputChar);
            int position = indexLowerCase - key;

            if (Character.isUpperCase(inputChar)) {
                if (position < 0 ){
                    decrypt.append((alphabetUpperCase.charAt(26 + ((indexUpperCase - key) % 26))));
                } else {
                    decrypt.append((alphabetUpperCase.charAt((indexLowerCase - key) % 26)));
                }
            } else if (Character.isLowerCase(inputChar)) {
                if (position < 0) {
                    decrypt.append((alphabetLowerCase.charAt(26 + ((indexUpperCase - key) % 26))));
                } else {
                    decrypt.append((alphabetLowerCase.charAt((indexLowerCase - key) % 26)));
                }
            } else {
                decrypt.append(inputChar);
            }
        }
        return decrypt;
    }
}