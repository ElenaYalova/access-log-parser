import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = 0;
        while (true) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            System.out.println("Файл " + fileExists);
            System.out.println("Директоря " + isDirectory);
            if (isDirectory == true) {
                System.out.println("Указана директория");
                continue;
            } else if (fileExists == true) {
                System.out.println("Путь указан верно");
                number++;
                System.out.println("Это файл номер " + number);
                try {
                    FileReader fileReader = new FileReader(path);
                    BufferedReader reader =
                            new BufferedReader(fileReader);
                    String line;
                    int totalLines = 0;
                    int maxLength = 0;
                    int minLength = Integer.MAX_VALUE;
                    while ((line = reader.readLine()) != null) {
                        totalLines++;
                        int length = line.length();
                        if (length > maxLength) {
                            maxLength = length;
                        }
                        if (length < minLength) {
                            minLength = length;
                        }
                        if (line.length() > 1024) {
                            throw new FileProcessingException("Строка в файле превышает 1024 символа: " + line);
                        }
                    }
                    System.out.println("Общее количество строк в файле: " + totalLines);
                    System.out.println("Длина самой длинной строки в файле: " + maxLength);
                    System.out.println("Длина самой короткой строки в файле: " + minLength);
                    reader.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                continue;
            } else System.out.println("Файла не существует");
            continue;
        }
    }
}


