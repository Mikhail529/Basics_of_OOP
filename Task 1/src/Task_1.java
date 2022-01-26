import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CLS {
    public static void main(String[] args) {

        // Task 1. Создать объект класса Текстовый файл, используя класы Файл, Директория.
        // Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.

        Directory directory = new Directory("New folder");     // создание новой директории
        directory.create();                                                 // добавление файла с иминем New File
        directory.create();                                                 // добавление второго файла с иминем New File
        directory.toString();                                               // список всех файлов
        directory.fileArrayList.get(0).rename();                            // переименовать второй файл
        directory.toString();                                               // список файлов обновлён
        directory.fileArrayList.get(0).setContent();                        // записать текст в файл
        directory.fileArrayList.get(0).supplement();                        // добавить текст в файл
        directory.fileArrayList.get(0).printContentToConsole();             // вывод содержимого текстового файла
        directory.delete();                                                 // удалить второй файл
        directory.toString();                                               // список всех файлов
    }
}

abstract class File {
    abstract public String getNameFile();
    abstract public void rename();
}

class Directory {
    private String nameDirectory;
    private TextFile textFile = new TextFile();
    ArrayList<TextFile> fileArrayList = new ArrayList<>();

    public Directory(String nameDirectory) {
        this.nameDirectory = nameDirectory;
        ArrayList<TextFile> fileArrayList = new ArrayList<>();
    }

    public String getNameDirectory() {
        return nameDirectory;
    }
    public void setNameDirectory(String nameDirectory) {
        this.nameDirectory = nameDirectory;
    }

    @Override
    public String toString() {
        for (File file : fileArrayList) {
            System.out.println(file.getNameFile());
        }
        return "Directory: " + nameDirectory;
    }

    public void create() {
        fileArrayList.add(new TextFile());
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("   message: Enter delete file name");
        String name = scanner.nextLine();
        for (int i=0; i<fileArrayList.size(); i++) {
            if (Objects.equals(fileArrayList.get(i).getNameFile(), name)) {
                fileArrayList.remove(i);
                System.out.println("   notification: file delete");
            }
        }
    }
}

class TextFile extends File {
    private String nameFile;
    private String content;

    public TextFile() {
        this.nameFile = "New File";
    }

    public void printContentToConsole() {
        System.out.println(content.toString());
    }

    public void supplement() {
        StringBuilder sb = new StringBuilder(this.content);
        Scanner scanner = new Scanner(System.in);
        System.out.println("   message: Enter supplement text");
        sb.append(" ").append(scanner.nextLine());
        this.content = String.valueOf(sb);
    }

    public void setContent() {
        System.out.println("   message: Enter text");
        Scanner scanner = new Scanner(System.in);
        this.content = scanner.nextLine();
    }

    @Override
    public String getNameFile() {
        return nameFile;
    }

    @Override
    public void rename() {
        System.out.println("   message: Enter a new filename");
        Scanner scanner = new Scanner(System.in);
        this.nameFile = scanner.nextLine();
    }
}