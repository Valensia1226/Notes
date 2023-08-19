package view.commands;

import view.Console;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    Console console;
    public MainMenu(Console console){
        this.console = console;
        commandList = new ArrayList<>();
        commandList.add(new AddNote(console)); //добавить заметку
        commandList.add(new ShowAllNotesWithLast(console)); //показать все заметки с последней
        commandList.add(new ShowAllNotesWithFirst(console)); //показать все заметки с первой
        commandList.add(new ShowNote(console)); //показать содержимое конкретной заметки
        commandList.add(new EditNote(console)); //редактировать заметку
        commandList.add(new DeleteNote(console)); //удалить заметку
        commandList.add(new Finish(console)); //завершить работу

    }
    public String getMenu(){
        StringBuilder sb = new StringBuilder("Выберите действие:\n");
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }
    public void execute(int choice){
        Command command = commandList.get(choice - 1);
        command.execute();
    }
    public int getSize(){
        return commandList.size();
    }
}
