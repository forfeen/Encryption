package algocipher;
import java.lang.StringBuffer;
import java.lang.Character;
import java.lang.String;
import java.lang.Math;

/** To shift the English letters using a rotational cipher.*/
public class AlphabetShiftCipher implements Cipher {

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
    public AlphabetShiftCipher(int key) {
        this.key = key;
    }

    /** To encrypt the string
     * @param  String text  the string to encrypt.
     * @return StringBuffer encrypt the string after encrypted.
     * */
    @Override
    public StringBuffer encrypt(String text) {
        StringBuffer encrypt = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            char inputChar = text.charAt(i);
            int indexLowerCase = (byte) alphabetLowerCase.indexOf(inputChar);
            int indexUpperCase = (byte) alphabetUpperCase.indexOf(inputChar);

            if (Character.isUpperCase(inputChar)) { // Check that the string is Upper
                encrypt.append((alphabetUpperCase.charAt((indexUpperCase + key) % 26)));
            } else if (Character.isLowerCase(inputChar)) { // Check that the string is Lower
                encrypt.append(alphabetLowerCase.charAt((indexLowerCase + key) % 26));
            } else {
                encrypt.append(inputChar);
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
        for (int i = 0; i < text.length(); i++) {
            char inputChar = text.charAt(i);
            int indexLowerCase = (byte) alphabetLowerCase.indexOf(inputChar);
            int indexUpperCase = (byte) alphabetUpperCase.indexOf(inputChar);
            int positionLowerCase = indexLowerCase - Math.abs(key);
            int positionUppercase = indexUpperCase - Math.abs(key);
            if (Character.isUpperCase(inputChar)) { // Check that the string is Upper
                if (positionUppercase < 0) { // Check the index of the character.
                    decrypt.append((alphabetUpperCase.charAt( 26 + ((indexUpperCase - Math.abs(key)) % 26))));
                } else {
                    decrypt.append((alphabetUpperCase.charAt((indexUpperCase - Math.abs(key)) % 26)));
                }
            } else if (Character.isLowerCase(inputChar)) { // Check that the string is Lower
                if (positionLowerCase < 0) { // Check the index of the character.
                    decrypt.append(alphabetLowerCase.charAt( 26 + ((indexLowerCase - Math.abs(key)) % 26 )));
                } else {
                    decrypt.append((alphabetLowerCase.charAt((indexLowerCase - Math.abs(key)) % 26)));
                }
            } else {
                decrypt.append(inputChar);
            }
        } return decrypt;
    }
}