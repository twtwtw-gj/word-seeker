import java.io.File;

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
            }
        }
    }
}