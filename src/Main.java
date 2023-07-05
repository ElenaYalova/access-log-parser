import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = 0;
        int googlebotRequests = 0;
        int yandexbotRequests = 0;

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
                    while ((line = reader.readLine()) != null) {
                        int length = line.length();
                        if (line.length() > 1024) {
                            throw new FileProcessingException("Строка в файле превышает 1024 символа: " + line);
                        }
                        String[] parts = line.split(" ");
                        String userAgent = line.substring(line.indexOf("\"", line.indexOf("\"") + 1) + 1, line.lastIndexOf("\""));

                        String[] userAgentParts = userAgent.split("\\(");
                        if (userAgentParts.length >= 2) {
                            String firstBrackets = userAgentParts[1];
                            String[] partsNew = firstBrackets.split(";");
                            if (partsNew.length >= 2) {
                                String fragment = partsNew[1].replaceAll("\\s", "");
                                String[] subparts = fragment.split("/");
                                if (subparts.length >= 2) {
                                    String userAgentFragment = subparts[0];
                                    if (userAgentFragment.equalsIgnoreCase("GoogleBot")) {
                                        googlebotRequests++;
                                    } else if (userAgentFragment.equalsIgnoreCase("YandexBot")) {
                                        yandexbotRequests++;
                                    }
                                }
                            }
                        }
                    }
                    reader.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Количество запросов от GoogleBot: " + googlebotRequests);
                System.out.println("Количество запросов от YandexBot: " + yandexbotRequests);
                continue;
            } else System.out.println("Файла не существует");
            continue;
        }
    }

}


