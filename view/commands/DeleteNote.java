package view.commands;

import view.Console;

public class DeleteNote extends Command{
    public DeleteNote(Console console) {
        super(console);
        description = "Удалить заметку";
    }

    @Override
    public void execute() {
        console.deleteNote();
    }
}
