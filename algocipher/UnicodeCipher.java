package algocipher;
import java.lang.StringBuffer;
import java.lang.Character;
import java.lang.String;
import java.lang.Math;

/** To shift all characters using the Unicode character sequence. */
public class UnicodeCipher implements Cipher {

    /** The lower alphabet of English letters. */
    private static String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
    /** The upper alphabet of English letters. */
    private static String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /** A key to used for encryption and decrypttion.*/
    private int key;

    /**
     * To set the value of key.
     * @param int key the key to used for encryption and decrypttion.
     * */
    public UnicodeCipher(int key) {
        this.key = key;
    }

    /** To encrypt the string
     * @param  String text  the string to encrypt.
     * @return StringBuffer encrypt the string after encrypted.
     * */
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

    /** To decrypt the string
     * @param  String text  the string to decrypt.
     * @return StringBuffer decrypt the string after decrypted.
     * */
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