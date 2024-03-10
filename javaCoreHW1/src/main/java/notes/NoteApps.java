package notes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
import utils.DateTimeUtils;

public class NoteApps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Создаем сканер
        System.out.println("Введите заметку: ");  //Приглашение на ввод в консоле пользователю
        String note = scanner.nextLine(); //забераем то что написал пользователь в консоль (заметка)

        String formattedDateTime = DateTimeUtils.getFormattedCurrentDateTime(); //получаем время
        String entry = formattedDateTime + " -> " + note; //собираем то что отправим на запись в файл (время + заметка)

        File file = new File("Notes.txt"); //Создаем файл Notes.txt

        try {
            FileWriter writer = new FileWriter(file, true); //Пишем в файл
            writer.write(entry + "n"); //Передаем что писать
            writer.close(); //Закрываем writer

            System.out.println("Заметка успешно добавлена в файл!"); // сообщение об успешном добавлении в файл
        } catch (IOException e) { //ловим исключение если что-то пошло не так
            System.out.println("Возникла ошибка записи в файл!");
            e.printStackTrace();
        }

    }
}
