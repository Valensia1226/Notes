package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Service {
    BookOfNotes bookOfNotes;
    private SaveInFile save;

    public Service() {
        this.bookOfNotes = new BookOfNotes();
        this.save = new SaveInFile();
    }

    public void add(String title, String context){
        Note note = new Note(title, context);
        ArrayList<Note> list = bookOfNotes.getList();
        note.setId(list.size() + 1);
        note.setDate(LocalDate.now());
        list.add(note);
        bookOfNotes.setList(list);
    }
    public boolean save(String path){
        try{
            save.write(path, bookOfNotes);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public String readAll(){
        return bookOfNotes.getList().toString();
    }
    public String showNote(int number){
        ArrayList<Note> list = bookOfNotes.getList();
        if (!numberCheck(number, list)) return null;
        Note note = list.get(number - 1);
        return note.toString();
    }
    public boolean editByNumber(int number, String title, String content){
        ArrayList<Note> list = bookOfNotes.getList();
        if (!numberCheck(number, list)) return false;
        Note note = list.get(number - 1);
        if (!title.isEmpty()) note.setTitle(title);
        if (!content.isEmpty()) note.setContent(content);
        return true;
    }
    public boolean deleteByTitle(String title){
        ArrayList<Note> list = bookOfNotes.getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean deleteByNumber(int number){
        ArrayList<Note> list = bookOfNotes.getList();
        if(numberCheck(number, list)){
            list.remove(number - 1);
            return true;
        }
        return false;
    }
    private boolean numberCheck(int number, ArrayList list){
        if (number <= 0) return false;
        else if (number > list.size()) return false;
        return true;
    }
}
