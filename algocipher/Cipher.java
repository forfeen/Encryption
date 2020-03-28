package algocipher;
public interface Cipher {

    StringBuffer encrypt(String text, int key);
    StringBuffer decrypt(String text, int key);

}