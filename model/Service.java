package model;


import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Service {
    private BookOfNotes bookOfNotes;

    public Service() {
        this.bookOfNotes = new BookOfNotes();
    }

    public void addNote(String title, String context) {
        Note note = new Note(title, context);
        ArrayList<Note> list = bookOfNotes.getList();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() > bookOfNotes.getId()) bookOfNotes.setId(list.get(i).getId());
            }
        }
        bookOfNotes.setId(bookOfNotes.getId() + 1);
        note.setId(bookOfNotes.getId());
        LocalDate date = LocalDate.now();
        note.setDate(date.toString());
        list.add(note);
        bookOfNotes.setList(list);
    }

    public boolean save(String path) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(bookOfNotes);
            out.write(jsonString);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean read(String path) {
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(path));
            this.bookOfNotes = gson.fromJson(br, BookOfNotes.class);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String readAll(boolean reverse) {
        ArrayList<Note> list = bookOfNotes.getList();
        BookOfNotes temp = new BookOfNotes();
        if (((list.get(0).getId() < list.get(1).getId()) && reverse) ||
                ((list.get(0).getId() > list.get(1).getId()) && !reverse)) {
            Collections.reverse(list);
        }
        temp.setList(list);
        return temp.toString();
    }

    public String showNote(int number) {
        ArrayList<Note> list = bookOfNotes.getList();
        for (Note el: list){
            if (el.getId() == number) {
                return el.toString();
            }
        }
        return null;
    }

    public boolean editByNumber(int number, String title, String content) {
        ArrayList<Note> list = bookOfNotes.getList();
        Note note;
        for (Note el: list){
            if (el.getId() == number) {
                note = el;
                if (!title.isEmpty()) note.setTitle(title);
                if (!content.isEmpty()) note.setContent(content);
                return true;
            }
        }
        return false;
    }

    public boolean deleteByNumber(int number) {
        ArrayList<Note> list = bookOfNotes.getList();
        if (numberCheck(number, list)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == number){
                    list.remove(list.get(i));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean numberCheck(int number, ArrayList<Note> list) {
        if (number <= 0) return false;
        for (Note el: list){
            if (el.getId() == number) return true;
        }
        return false;
    }

    private void sortByData(ArrayList<Note> list) {
        Collections.sort(list, new NoteComparatorByData<>());
    }

    private void sortByID(ArrayList<Note> list) {
        Collections.sort(list, new NoteComparatorByID<>());
    }
}
