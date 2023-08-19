package view.commands;

import view.Console;

public class ShowNote extends Command{
    public ShowNote(Console console) {
        super(console);
        description = "Просмотреть заметку";
    }

    @Override
    public void execute() {
        console.showNote();
    }
}
