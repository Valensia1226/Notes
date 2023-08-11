package view.commands;

import view.Console;

public class EditNote extends  Command{

    public EditNote(Console console) {
        super(console);
        description = "Редактировать заметку";
    }

    @Override
    public void execute() {
        console.editNote();
    }
}
