package algocipher;
import java.lang.StringBuffer;
import java.lang.Character;
import java.lang.String;
import java.lang.Math;

public class UnicodeCipher implements Cipher {

    private static String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";

    private static String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private int key;

    public UnicodeCipher(int key) {
        this.key = key;
    }

    @Override
    public StringBuffer encrypt(String text) {
        StringBuffer encrypt = new StringBuffer();
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
        } return encrypt;
    }

    @Override
    public StringBuffer decrypt(String text) {
        StringBuffer decrypt = new StringBuffer();

        if (key == 0){
            int newKey = 1;
            for (int i = 0; i < text.length(); i++) {
                int charPosition = Character.codePointAt(text, i);
                String unicodeDecrypt = Character.toString(charPosition + newKey);
                decrypt.append(unicodeDecrypt);
            }
        } else if (key > 0) {
            for (int i = 0; i < text.length(); i++) {
                int charPosition = Character.codePointAt(text, i);
                String unicodeDecrypt = Character.toString(charPosition + key);
                decrypt.append(unicodeDecrypt);
            }
        } return decrypt;
    }
}