package view.commands;

import view.Console;

public class ShowAllNotesWithLast extends Command{

    public ShowAllNotesWithLast(Console console) {
        super(console);
        description = "Показать все заметки, начиная с последней записи";
    }

    @Override
    public void execute() {
        console.showAllNotes(true);
    }
}
