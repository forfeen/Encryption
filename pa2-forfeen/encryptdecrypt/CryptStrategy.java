package encryptdecrypt;
public interface CryptStrategy {

    StringBuffer execute(String text, int key, String alg);

}



