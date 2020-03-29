package algocipher;

/** CipherFactor to call the algorithm and key. */
public class CipherFactory {

    /**
     * Create a cipher between the application and the specific ciphers.
     * @param String alg  the algorithm to use for encryption and decryption.
     * @param int key the key to used for encryption and decrypttion.
     * @return  The new AlphabetShiftCipher(key) if the algorithm is shift ,
     *  the new UnicodeCipher(key) if the algorithm is unicode and
     *  two method will get the same parameter is key.
     * */

    public static Cipher getCipher(String alg, int key){
        if (alg.equals("shift")) {
            return new AlphabetShiftCipher(key);
        } else if (alg.equals("unicode")) {
            return new UnicodeCipher(key);
        } return null;
    }
}