import java.lang.StringBuffer;

public class Encrypt {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static StringBuffer Crypt(String text, byte key) {

        StringBuffer decrypt = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char inputChar = text.toLowerCase().charAt(i);
            byte index = (byte) alphabet.indexOf(inputChar);
            if (inputChar == ' ' || inputChar == '!') {
                decrypt.append(inputChar);
            } else {
                decrypt.append(alphabet.charAt((index + key) % 26));
            }
        }
        return decrypt;
    }
}