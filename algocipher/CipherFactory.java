package algocipher;
public class CipherFactory {

    public static Cipher getCipher(String alg, int key){
        if (alg.equals("shift")) {
            return new AlphabetShiftCipher(key);
        } else if (alg.equals("unicode")) {
            return new UnicodeCipher(key);
        } return null;
    }
}