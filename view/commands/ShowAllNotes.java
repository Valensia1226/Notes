package view.commands;

import view.Console;

public class ShowAllNotes extends Command{

    public ShowAllNotes(Console console) {
        super(console);
        description = "Показать все заметки";
    }

    @Override
    public void execute() {
        console.showAllNotes();
    }
}
