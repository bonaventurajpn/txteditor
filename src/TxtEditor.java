import java.io.*;

public class TxtEditor {
    public static void main(String[] args) {
        String[] folderPaths = {
            "D:/label baru vod/mangga/labels/train",
            "D:/label baru vod/mangga/labels/test",
            "D:/label baru vod/mangga/labels/valid"
        };

        for (String folderPath : folderPaths) {
            File folder = new File(folderPath);
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        processFile(file);
                    }
                }
            } else {
                System.out.println("No files found in the specified folder: " + folderPath);
            }
        }
    }

    public static void processFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.replace("97 ", "0 ");
                content.append(line).append(System.lineSeparator());
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content.toString());
            writer.close();

            System.out.println("Processed: " + file.getName());
        } catch (IOException e) {
            System.out.println("Error processing " + file.getName() + ": " + e.getMessage());
        }
    }
}
