package algocipher;
public interface Cipher {

    StringBuffer encrypt(String text);
    StringBuffer decrypt(String text);

}