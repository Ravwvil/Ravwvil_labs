import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            StringBuilder data = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                writer.write(data.toString());
                System.out.println("Data from '" + inputFileName + "' has been successfully copied to '" + outputFileName + "'.");
            } catch (IOException e) {
                System.err.println("Error: No write-permission for the output file '" + outputFileName + "'.");
            }
        } catch (IOException e) {
            System.err.println("Error: Input file '" + inputFileName + "' does not exist.");
        }
    }
}
