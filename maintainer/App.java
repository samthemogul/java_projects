package maintainer;

import java.io.File;
import java.util.Scanner;
import java.util.HashSet;

class FileController {
    private File fileObj;
    private HashSet<String> validExtensions = new HashSet<String>();

    public FileController(String directory) {
        fileObj = new File("maintainer", directory);
        validExtensions.add(".log");
        validExtensions.add(".txt");
        validExtensions.add(".csv");
        validExtensions.add(".png");
        validExtensions.add(".jpg");
        validExtensions.add(".pdf");
    }

    public void cleanDirectory(int threshold) {
        for (String filePath : fileObj.list()) {
            File file = new File(fileObj, filePath);
            if(file.isFile()){
                String fileName = file.getName();
                int dotIndex = fileName.lastIndexOf(".");
                String extension = fileName.substring(dotIndex);
                // check if extension is in validExtensions list
                if (validExtensions.contains(extension)) {
                    String extensionText = extension.substring(1);
                    // check if file size is greater than the threshold
                    if (file.length() / 1000 > threshold) {
                        File largeFileDirectory = new File(fileObj, String.format("%s//large_%s_files/", extensionText, extensionText));
                        if(largeFileDirectory.exists()){
                            System.out.println("Directory Exists");
                            File moveFileToDir = new File(largeFileDirectory, fileName);
                            move(file.getAbsolutePath(), moveFileToDir);
                        } else {
                            largeFileDirectory.mkdir();
                            File moveFileToDir = new File(largeFileDirectory, fileName);
                            move(file.getAbsolutePath(), moveFileToDir);
                        }
                    } else {
                        File normalFileDirectory = new File(fileObj, String.format("%s", extensionText));
                        if(normalFileDirectory.exists()){
                            System.out.println("Directory Exists");
                            File moveFileToDir = new File(normalFileDirectory, fileName);
                            move(file.getAbsolutePath(), moveFileToDir);
                        } else {
                            normalFileDirectory.mkdir();
                            File moveFileToDir = new File(normalFileDirectory, fileName);
                            move(file.getAbsolutePath(), moveFileToDir);
                        }
                    }
                } else {
                    System.out.println("Invalid file type");
                }
            }
        }
    }
    private void move(String path1, File path2) {
        File formerFile = new File(path1);
        if(formerFile.renameTo(path2)) {
            System.out.println("File moved successfully");
        }
        formerFile.delete();
    }
}

public class App {
    public static void main(String args[]) {
        System.out.println("------------------------------------------");
        System.out.println("|          Directory Maintainer          |");
        System.out.println("------------------------------------------");
        System.out.println("Enter the name of directory you would like to clean: ");
        try (Scanner scanner = new Scanner(System.in)) {
            String directory = scanner.nextLine();
            System.out.println("Enter threshold in kilobytes: ");
            Integer threshold = Integer.parseInt(scanner.nextLine());
            FileController contoller = new FileController(directory);
            contoller.cleanDirectory(threshold);
        }
        ;
    };
}
