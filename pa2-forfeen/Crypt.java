package encryptdecrypt;
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


public class Crypt{

    public static void main(String[] args) {
        String inputFromData = " " ;
        String inputFromFile = " ";
        String fileInput = " ";
        String nameFileOutput  =  " " ;
        String crypt = "enc";
        String alg = "shift";
        int key = 1;
        CryptStrategy s = null ;


        for (int i = 0; i < args.length; i++) {
            if ((args[i]).equals("-mode")){
                if ((args[i+1]).equals("dec")) {
                    crypt = "dec";
                    s = new Decrypt();
                }
                else {
                    crypt = "enc";
                    s = new Encrypt();
                }
            } else if ((args[i]).equals("-key")) {
                key = Integer.parseInt(args[i+1]);
                if (key < 0) {
                    crypt = "dec";
                }
            } else if ((args[i]).equals("-data")) {
                inputFromData  =  (String) args[i+1];
            } else if ((args[i]).equals("-alg")) {
                if ((args[i+1]).equals("unicode")) {
                    alg = "unicode";
                }
                else {
                    alg = "shift";
                }
            } else if ((args[i]).equals("-in")) {
                fileInput = args[i+1];
                File file = new File(fileInput);
                Path filePath = Paths.get(args[i + 1]);
                if ( !file.isFile() && !file.canRead() ) {
                    System.out.println("Can't find a source file.");
                }
                else {
                    try {
                        FileReader newFile = new FileReader(file);
                        inputFromFile = Files.readString(filePath);
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

        if ( !inputFromFile.equals(" ") && nameFileOutput.equals(" ") && inputFromData.equals(" ")) {
            System.out.println("Please name destination file.");
        } else if ( !inputFromFile.equals(" ") && !nameFileOutput.equals(" ") && inputFromData.equals(" ")){
            try {
                    File outputFile = new File(nameFileOutput);
                    FileWriter outputFileWriter = new FileWriter(outputFile);
                    BufferedWriter writer = new BufferedWriter(outputFileWriter);
                    writer.write((s.execute(inputFromFile, key, alg)).toString());
                    writer.close();
                    System.out.println("Completed!");
                } catch (IOException e) {
                    System.out.println("Please name destination file.");
                }
        }
        else {
            System.out.println(s.execute(inputFromData,key,alg));
        }
    }
}
