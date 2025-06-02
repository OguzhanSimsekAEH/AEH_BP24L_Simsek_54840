/* import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class myTwelfthApp {
    public static void main(String[] args) {
        // Very useful - indicates the current directory in which we are working and from which the main() code was executed
        String userDirectory = System.getProperty("user.dir");
        System.out.println("The current directory is:");
        System.out.println(userDirectory);

        // File in the current directory
        Path pathToFile = Paths.get("sample_text.txt");

        // try - catch - finally syntax (error handling: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/try...catch?retiredLocale=pl)
        try {

            byte[] bytes = Files.readAllBytes(pathToFile);
            String fileContent = new String(bytes, Charset.defaultCharset());

            System.out.println("The file content is: ");
            System.out.println(fileContent);

            // you can append something to the file (every time the program is run, what is below will be appended)
            fileContent += " more text ..."; // we append something to the file
            fileContent += " even more text ..."; // we append something to the file

            Files.write(pathToFile, fileContent.getBytes(Charset.defaultCharset()));

            // The file can also be read as a list of text lines
            List<String> lines = Files.readAllLines(pathToFile);

            System.out.println("Current file content: ");
            System.out.println(lines);

            lines.add(" more text added IN THE LIST..."); // we append something to the file

            Files.write(pathToFile, lines);

            // THE ABOVE METHODS HAVE A BASIC FLAW - THEY LOAD THE WHOLE FILE INTO RAM (in short - with large files you can hang the system)
            // THEREFORE, LOW-LEVEL READING FUNCTIONS ARE USED: FileInputStream, FileReader (reading bytes, character by character)
            // AND BufferedReader, Scanner (reading whole lines or words)

            String path = "sample_text.txt";
            System.out.println("Example #1 - FileInputStream");
            try (FileInputStream inputStream = new FileInputStream(path)) {
                int character = inputStream.read();
                while (character != -1) {
                    System.out.print((char) character);
                    character = inputStream.read();
                }
                System.out.println(); // we end the line and start a new one
            } catch (IOException e) {
                System.out.println("Problem reading the file");
                e.printStackTrace();
            }

            System.out.println("Example #2 - FileReader");
            try (FileReader fileReader = new FileReader(path)) {
                int character = fileReader.read();
                while (character != -1) {
                    System.out.print((char) character);
                    character = fileReader.read();
                }
                System.out.println(); // we end the line and start a new one
            } catch (IOException io) {
                System.out.println("Problem reading the file");
                io.printStackTrace();
            }

            System.out.println("Example #3 - BufferedReader");
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = bufferedReader.readLine();
                }
            } catch (IOException io) {
                System.out.println("Problem reading the file");
                io.printStackTrace();
            }

            System.out.println("Example #4 - Scanner");
            try (Scanner in = new Scanner(new FileReader(path))) {
                while (in.hasNext()) {
                    String next = in.next();
                    System.out.print(next + " ");
                }
            } catch (IOException io) {
                System.out.println("Problem reading the file");
                io.printStackTrace();
            }


        } catch (Exception e){
            // this code will only work if an exception occurs
            System.out.println("We got a file handling error: " + e.getMessage());
        } finally {
            // here we do something at the end
        }

    }


}
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class myTwelfthApp {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Path inputPath = null;

        // 1. Prompt user for an existing input file path
        while (true) {
            System.out.print("Enter path of the input text file: ");
            String inputString = console.nextLine().trim();
            inputPath = Paths.get(inputString);
            if (Files.exists(inputPath) && Files.isRegularFile(inputPath)) {
                break;
            } else {
                System.out.println("The file \"" + inputString + "\" does not exist. Please try again.");
            }
        }

        // 2. Prompt user for the output file path (no existence check required;
        //    if it does not exist, it will be created when we write to it)
        System.out.print("Enter path of the output text file: ");
        String outputString = console.nextLine().trim();
        Path outputPath = Paths.get(outputString);

        // 3. Read the input file and count the number of lines
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Error reading from input file: " + e.getMessage());
            e.printStackTrace();
            console.close();
            return;
        }

        // 4. Display the line count on the console
        System.out.println("Total number of lines in \""
                + inputPath.getFileName() + "\": " + lineCount);

        // 5. Write to the output file: "<input-file-name>: <number-of-lines>"
        String outputLine = inputPath.getFileName().toString() + ": " + lineCount;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath.toFile()))) {
            writer.write(outputLine);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to output file: " + e.getMessage());
            e.printStackTrace();
            console.close();
            return;
        }

        System.out.println("Result has been saved to \"" + outputPath.toString() + "\".");
        console.close();
    }
}
