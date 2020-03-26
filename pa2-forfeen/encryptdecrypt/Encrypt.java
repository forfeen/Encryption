package encryptdecrypt;
import java.lang.StringBuffer;
import java.lang.Character;

public class Encrypt {
    private static String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";

    private static String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String text;

    private int key;

    public Encrypt(String text, int key){
        this.text = text;
        this.key = key;
    }

    public static StringBuffer encrypt(String text,int key) {

        StringBuffer encrypt = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char inputChar = text.charAt(i);
            int indexLowerCase = (byte) alphabetLowerCase.indexOf(inputChar);
            int indexUpperCase = (byte) alphabetUpperCase.indexOf(inputChar);

            if (Character.isUpperCase(inputChar)) {
                encrypt.append((alphabetUpperCase.charAt((indexUpperCase + key) % 26)));
            } else if (Character.isLowerCase(inputChar)) {
                encrypt.append(alphabetLowerCase.charAt((indexLowerCase +key) % 26));
            } else {
                encrypt.append(inputChar);
            }
        }
        return encrypt;
    }
}
