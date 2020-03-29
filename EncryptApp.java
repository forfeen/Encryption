import algocipher.Cipher;
import algocipher.CipherFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  Encrypt Application to encrypt - decrypt characters from an InputStream or string.
 */
public class EncryptApp {

    public static void main(String[] args) {

        /** A mode to used for encryption or decryption */
        String mode = "enc";
        /** Algorithm to use for encryption and decryption. */
        String alg = "shift";
        /** A string to encrypt or decrypt */
        String data = " ";
        /** A string from InputStream to encrypt or decrypt */
        String dataFromFile = " ";
        /** Name of file input */
        String nameFileInput = " ";
        /** Name of file output */
        String nameFileOutput  =  " " ;
        /** A key to used for encryption and decrypttion.*/
        int key = 0;

        for (int i = 0; i < args.length; i++) {
            if ( (args[i]).equals("-mode")) {     // To get the mode to used for encryption or decryption
                if ((args[i+1]).equals("dec")) {
                    mode = "dec";
                }
                else {
                    mode = "enc";
                }
            } else if ((args[i]).equals("-key")) { // To get the key to used for encryption or decryption
                key = Integer.parseInt(args[i + 1]);
                if (key < 0) {
                    mode = "dec";
                }
            } else if ((args[i]).equals("-data")) {  // To get the data to used for encryption or decryption.
                data  =  (String) args[i+1];
            } else if ((args[i]).equals("-alg")) { // To get the algorithm to used for encryption or decryption.
                if ((args[i + 1]).equals("unicode")) {
                    alg = "unicode";
                } else {
                    alg = "shift";
                }
            } else if ((args[i]).equals("-in")) {  // To get the file input to used for encryption or decryption.
                nameFileInput = args[i+1];
                File file = new File(nameFileInput);
                Path filePath = Paths.get(nameFileInput);
                if ( !file.isFile() && !file.canRead() ) { // Check that file input is exists.
                    System.out.println("Can't find a source file.");
                }
                else {
                    try {
                        dataFromFile = Files.readString(filePath);
                    } catch (FileNotFoundException c) {
                        System.out.println("File not found.");
                    } catch (IOException e) {
                        System.out.println("File not found");
                    }
                }
            } else if ((args[i]).equals("-out")) { // To get the file output to used after encryption or decryption.
                nameFileOutput = args[i + 1];
                File file = new File(nameFileOutput);
                if ( file.exists()) {  // Check that file output is exists.
                    nameFileOutput = " ";
                    System.out.println("Destination already exists.");
                }
            }
        }

        Cipher cipher =  CipherFactory.getCipher(alg,key);
        if (mode.equals("dec")) {
            // Check that if the user decrypt the data by using file input and they didn't name the destination file.
            if ( !dataFromFile.equals(" ") && nameFileOutput.equals(" ") && data.equals(" ")) {
                System.out.println("Please name destination file.");
                // Check that if the user decrypt the data by using file input.
            } else if ( !dataFromFile.equals(" ") && !nameFileOutput.equals(" ") && data.equals(" ")){
                try {
                    File outputFile = new File(nameFileOutput);
                    FileWriter outputFileWriter = new FileWriter(outputFile);
                    BufferedWriter writer = new BufferedWriter(outputFileWriter);
                    writer.write((cipher.decrypt(data).toString()));
                    writer.close();
                    System.out.println("Completed!");
                } catch (IOException e) {
                    System.out.println("Please name destination file.");
                }
            } else {
                System.out.println(cipher.decrypt(data));
            }
        } else if (mode.equals("enc")) {
            // Check that if the user encrypt the data by using file input and they didn't name the destination file.
            if ( !dataFromFile.equals(" ") && nameFileOutput.equals(" ") && data.equals(" ")) {
                System.out.println("Please name destination file.");
                // Check that if the user encrypt the data by using file input.
            } else if ( !dataFromFile.equals(" ") && !nameFileOutput.equals(" ") && data.equals(" ")){
                try {
                    File outputFile = new File(nameFileOutput);
                    FileWriter outputFileWriter = new FileWriter(outputFile);
                    BufferedWriter writer = new BufferedWriter(outputFileWriter);
                    writer.write((cipher.encrypt(data).toString()));
                    writer.close();
                    System.out.println("Completed!");
                } catch (IOException e) {
                    System.out.println("Please name destination file.");
                }
            } else {
                System.out.println(cipher.encrypt(data));
            }
        }
    }
}