package algocipher;
import java.lang.StringBuffer;
import java.lang.Character;
import java.lang.String;
import java.lang.Math;

public class AlphabetShiftCipher implements Cipher {

    private static String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";

    private static String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private int key;

    public AlphabetShiftCipher(int key) {
        this.key = key;
    }

    @Override
    public StringBuffer encrypt(String text) {
        StringBuffer encrypt = new StringBuffer();
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
        } return encrypt;
    }

    @Override
    public StringBuffer decrypt(String text) {
        StringBuffer decrypt = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            char inputChar = text.charAt(i);
            int indexLowerCase = (byte) alphabetLowerCase.indexOf(inputChar);
            int indexUpperCase = (byte) alphabetUpperCase.indexOf(inputChar);
            int positionLowerCase = indexLowerCase - Math.abs(key);
            int positionUppercase = indexUpperCase - Math.abs(key);
            if (Character.isUpperCase(inputChar)) {
                if (positionUppercase < 0) {
                    decrypt.append((alphabetUpperCase.charAt( 26 + ((indexUpperCase - Math.abs(key)) % 26))));
                } else {
                    decrypt.append((alphabetUpperCase.charAt((indexUpperCase - Math.abs(key)) % 26)));
                }
            } else if (Character.isLowerCase(inputChar)) {
                if (positionLowerCase < 0) {
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