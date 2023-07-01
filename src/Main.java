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

                        String ipAddress = parts[0];
                        String property1 = parts[1];
                        String property2 = parts[2];
                        String dateTime = parts[3].substring(1, parts[3].length() - 1);
                        String method = parts[5].substring(1);
                        String pathInfo = parts[6];
                        String responseCode = parts[8];
                        String dataSize = parts[9];
                        String referer = parts[10].substring(1, parts[10].length() - 1);
                        String userAgent = line.substring(line.indexOf("\"", line.indexOf("\"") + 1) + 1, line.lastIndexOf("\""));

                       /* System.out.println("IP-адрес: " + ipAddress);
                        System.out.println("Свойство 1: " + property1);
                        System.out.println("Свойство 2: " + property2);
                        System.out.println("Дата и время запроса: " + dateTime);
                        System.out.println("Метод запроса: " + method);
                        System.out.println("Путь: " + pathInfo);
                        System.out.println("Код HTTP-ответа: " + responseCode);
                        System.out.println("Размер данных в байтах: " + dataSize);
                        System.out.println("Referer: " + referer);
                        System.out.println("User-Agent: " + userAgent);
                        System.out.println("-----------------------");*/

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


