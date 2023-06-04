import java.io.File;
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
                continue;
            } else System.out.println("Файла не существует");
            continue;
        }
    }
}


