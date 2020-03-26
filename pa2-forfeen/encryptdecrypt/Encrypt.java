package encryptdecrypt;
import java.lang.StringBuffer;
import java.lang.Character;
import java.lang.String;

public class Encrypt {
    private static String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";

    private static String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String text;

    private int key;

    private String alg;

    public Encrypt(String text, int key, String alg){
        this.text = text;
        this.key = key;
        this.alg = alg;
    }

    public static StringBuffer encrypt(String text,int key,String alg) {

        StringBuffer encrypt = new StringBuffer();

        if (alg.equals("shift")) {

            for (int i = 0; i < text.length(); i++) {
                char inputChar = text.charAt(i);
                int indexLowerCase = (byte) alphabetLowerCase.indexOf(inputChar);
                int indexUpperCase = (byte) alphabetUpperCase.indexOf(inputChar);

                if (Character.isUpperCase(inputChar)) {
                    encrypt.append((alphabetUpperCase.charAt((indexUpperCase + key) % 26)));
                } else if (Character.isLowerCase(inputChar)) {
                    encrypt.append(alphabetLowerCase.charAt((indexLowerCase + key) % 26));
                } else {
                    encrypt.append(inputChar);
                }
            }
        } else if (alg.equals("unicode")) {
            if (key == 0){
                int newKey = 1;
                for (int i = 0; i < text.length(); i++) {
                    int charPosition = Character.codePointAt(text, i);
                    String unicodeEncrypt = Character.toString(charPosition + newKey);
                    encrypt.append(unicodeEncrypt);
                }
            } else if (key > 0){
                for (int i = 0; i < text.length(); i++) {
                    int charPosition = Character.codePointAt(text, i);
                    String unicodeEncrypt = Character.toString(charPosition + key);
                    encrypt.append(unicodeEncrypt);
                }
            }
        } return encrypt;
    }
}
