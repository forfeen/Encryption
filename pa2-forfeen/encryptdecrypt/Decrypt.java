package encryptdecrypt;
import java.lang.StringBuffer;
import java.lang.Math;
import java.lang.Character;

public class Decrypt implements CryptStrategy {
    private static String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";

    private static String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String text;

    private int key;

    private String alg;

    @Override
    public StringBuffer execute(String text, int key, String alg) {

        StringBuffer decrypt = new StringBuffer();

        if (alg.equals("shift")) {

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
            }
        } else if (alg.equals("unicode")){
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
            }
        } return decrypt;
    }
}