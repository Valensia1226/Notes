package view.commands;

import view.Console;

public class ShowAllNotesWithFirst extends Command{
    public ShowAllNotesWithFirst(Console console) {
        super(console);
        description = "Показать все заметки, начиная с первой записи";
    }

    @Override
    public void execute() {
        console.showAllNotes(false);
    }
}
