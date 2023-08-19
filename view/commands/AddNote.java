package view.commands;

import view.Console;

public class AddNote extends Command{
    public AddNote(Console console) {
        super(console);
        description = "Создать заметку";
    }

    @Override
    public void execute() {
        console.addNote();
    }
}
