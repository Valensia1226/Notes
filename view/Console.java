package view;

import presenter.Presenter;
import view.commands.MainMenu;

import java.util.Scanner;

public class Console implements view{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;
    private Exam exam;
    private String pathRemember;

    public Console() {
        this.presenter = new Presenter();
        this.scanner = new Scanner(System.in);
        this.work = true;
        this.mainMenu = new MainMenu(this);
        this.exam = new Exam();
    }

    @Override
    public void start() {
        while (work) {
            System.out.println();
            System.out.println(mainMenu.getMenu());
            int choice = takeChoice(mainMenu.getSize());
            if (choice != -1) mainMenu.execute(choice);
            else System.out.printf("Некорректно введена команда. Введите число от 1 до %d\n", mainMenu.getSize());
        }
    }
    private int takeChoice(int size) {
        String line = scanner.nextLine();
        int choice = exam.itsNumber(line);
        if ((choice > size) || (choice <= 0)) return -1;
        return choice;
    }

    public void addNote() {
        System.out.println("Введите заголовок: ");
        String title = scanner.nextLine();
        System.out.println("Введите содержание: ");
        String content = scanner.nextLine();
        presenter.addNote(title, content);
    }

    public void deleteNote() {
        System.out.println("Введите номер заметки, которую хотите удалить: ");
        System.out.println(presenter.readAll());
        int number = scanner.nextInt();
        if (presenter.deleteNote(number)) System.out.println("Успешно!");
    }

    public void editNote() {
        System.out.println("Введите номер заметки, которую хотите редактировать: ");
        System.out.println(presenter.readAll());
        String num = scanner.nextLine();
        int number = exam.itsNumber(num);
        if (number == -1) editNote();
        //проверка на существование такой заметки
        System.out.println("Введите новый заголовок или нажмите Enter: ");
        String title = scanner.nextLine();
        System.out.println("Введите новое содержание или нажмите Enter: ");
        String content = scanner.nextLine();
        if (presenter.editNote(number, title, content)) System.out.println("Успешно!");
    }

    public void finish() {
        System.out.println("Вы хотите сохранить список?");
        String answer = scanner.nextLine();
        if (answer.equals("да") || answer.equals("yes")) {
            if (pathRemember != null) {
                if (!save(pathRemember)) System.out.println("К сожалению, не получилось сохранить файл!");
                else System.out.println("Успешно сохранили вашу работу!");
            } else {
                System.out.println("Введите имя файла на английском: ");
                String name = scanner.nextLine().toLowerCase();
                name = name + ".out";
                if (!save(name)) System.out.println("К сожалению, не получилось сохранить файл!");
                else System.out.println("Успешно сохранили вашу работу!");
            }
        }
        System.out.println("До свидания!");
        work = false;
    }

    private boolean save(String name) {
        return presenter.save(name);
    }

    public void showAllNotes() {
        System.out.println(presenter.showAllNotes());
    }
}
