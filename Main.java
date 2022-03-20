import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String word = args.length > 0 ? args[0] : "abc";
        System.out.println(word);

        File[] files = new File("./").listFiles();
        for (File file : files) {
            String fileName = file.toString();
            int fileNameNumber = fileName.length();
            String extension = fileName.substring(fileNameNumber - 4, fileNameNumber);
            if (extension.equals(".txt")) {
                System.out.println(fileName);

                Path pathOfFile = Paths.get(fileName);

                int index = 1;

                try {
                    List<String> texts = Files.readAllLines(pathOfFile);
                    boolean flug = false;
                    for (String text : texts) {
                        if (text.contains(word)) {
                            if (!flug) {
                                System.out.println(fileName);
                            }
                            System.out.println(String.valueOf(index) + ":" + text);
                        }
                        index++;
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
}