import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String word = args.length > 0 ? args[0] : "";
        System.out.println(word);

        final File[] files = new File("./").listFiles();
        Arrays.stream(files)
                // txt拡張子のファイルのみ取得
                .filter(file -> checkExtension(file, "txt"))
                // ファイル名表示とテキスト検索
                .forEach(file -> {
                    final String fileName = file.getName();
                    System.out.println("ファイル名: " + fileName);
                    try {
                        // 行数
                        int index = 1;

                        // テキスト全行取得
                        List<String> texts = Files.readAllLines(Paths.get(fileName));
                        for (String text : texts) {
                            if (text.contains(word)) {
                                System.out.println(String.format("%3d: %s", index, text));
                            }
                            index++;
                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                });
    }

    /**
     * ファイルの拡張子が指定のものかチェックする
     * 
     * @param file
     * @param extension
     * @return
     */
    static private boolean checkExtension(File file, String extension) {
        String fileName = file.getName();
        return fileName.endsWith("." + extension);
    }
}