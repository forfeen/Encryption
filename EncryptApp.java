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

public class EncryptApp {

    public static void main(String[] args) {
        String mode = "enc";
        String alg = "shift";
        String data = " ";
        String dataFromFile = " ";
        String fileInput = " ";
        String nameFileOutput  =  " " ;
        int key = 1;

        for (int i = 0; i < args.length; i++) {
            if ( (args[i]).equals("-mode")) {
                if ((args[i+1]).equals("dec")) {
                    mode = "dec";
                }
                else {
                    mode = "enc";
                }
            } else if ((args[i]).equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
                if (key < 0) {
                    mode = "dec";
                }
            } else if ((args[i]).equals("-data")) {
                data  =  (String) args[i+1];
            } else if ((args[i]).equals("-alg")) {
                if ((args[i + 1]).equals("unicode")) {
                    alg = "unicode";
                } else {
                    alg = "shift";
                }
            } else if ((args[i]).equals("-in")) {
                fileInput = args[i+1];
                File file = new File(fileInput);
                Path filePath = Paths.get(fileInput);
                if ( !file.isFile() && !file.canRead() ) {
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
            } else if ((args[i]).equals("-out")) {
                nameFileOutput = args[i + 1];
                File file = new File(nameFileOutput);
                if ( file.exists()) {
                    nameFileOutput = " ";
                    System.out.println("Destination already exists.");
                }
            }
        }

        Cipher cipher =  CipherFactory.getCipher(alg,key);
        if (mode.equals("dec")) {
            if ( !dataFromFile.equals(" ") && nameFileOutput.equals(" ") && data.equals(" ")) {
                System.out.println("Please name destination file.");
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
            if ( !dataFromFile.equals(" ") && nameFileOutput.equals(" ") && data.equals(" ")) {
                System.out.println("Please name destination file.");
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