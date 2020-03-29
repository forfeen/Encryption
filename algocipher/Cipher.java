package algocipher;

/** The Cipher interface to ues a string for encrypt or decrypt */

public interface Cipher {

    /**
     * The method to encrypt the string.
    @param String text the string to encrypt.
    */
    StringBuffer encrypt(String text);

    /**
     * The method to decrypt the string/
    @param String text the string to decrypt.
    */
    StringBuffer decrypt(String text);

}