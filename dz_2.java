import java.nio.file.Files;
import java.nio.file.Path;

public class dz_2 {
    public static void main(String[] args) {
        System.out.println(buildString(7, 'a', 'b'));
        writeIntoFile("TEXT");
        System.out.println(readFromFile());
    }

    // Дано четное число N (>0) и символы c1 и c2.
    // Написать метод, который вернет строку длины N, которая состоит из
    // чередующихся символов c1 и c2, начиная с c1.
    // Пример. (n = 6, c1='a', c2='b') -> "ababab"
    // (n = 8, c1='x', c2='y') -> "xyxyxyxy"
    static String buildString(int n, char c1, char c2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i % 2 == 0 ? c1 : c2);
        }
        return sb.toString();
    }

    // Создать файл file.txt. Если файл уже создан, ничего делать не надо. Записать
    // в файл слово TEXT 100 раз: TEXTTEXTTEXTTEXTTEXTTEXT...
    static void writeIntoFile(String msg, String fileName, int count) {
        Path path = Path.of(fileName);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (Exception e) {
                System.out.println("При создание файла произошла ошибка: " +
                        e.getMessage() + " " + e.getClass().getName());
            } 
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(msg);
        }
        try {
            Files.writeString(path, sb.toString());
        } catch (Exception e) {
            System.out.println("При записи текста в файл произошла ошибка: " +
                    e.getMessage() + " " + e.getClass().getName());
        }
    }

    static void writeIntoFile(String msg) {
        writeIntoFile(msg, "file.txt", 100);
    }

    static String readFromFile(String fileName) {
        String result = "Файл " + fileName + " не создан";
        Path path = Path.of(fileName);
        if (Files.exists(path)) {
            try {
                result = Files.readString(path);
            } catch (Exception e) {
                System.out.println("При чтение файла произошла ошибка: " +
                        e.getMessage() + " " + e.getClass().getName());
            }
        } 
        return result;
    }

    static String readFromFile() {
        return readFromFile("file.txt");
    }

}