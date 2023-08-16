package model;


import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Service {
    BookOfNotes bookOfNotes;

    public Service() {
        this.bookOfNotes = new BookOfNotes();
    }

    public void add(String title, String context) {
        Note note = new Note(title, context);
        ArrayList<Note> list = bookOfNotes.getList();
        note.setId(list.size() + 1);
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
        if (!reverse) {
            sortByData(list);
            bookOfNotes.setList(list);
        } else {
            sortByID(list);
            bookOfNotes.setList(list);
        }
        return bookOfNotes.toString();
    }

    public String showNote(int number) {
        ArrayList<Note> list = bookOfNotes.getList();
        if (!numberCheck(number, list)) return null;
        Note note = list.get(number - 1);
        return note.toString();
    }

    public boolean editByNumber(int number, String title, String content) {
        ArrayList<Note> list = bookOfNotes.getList();
        if (!numberCheck(number, list)) return false;
        Note note = list.get(number - 1);
        if (!title.isEmpty()) note.setTitle(title);
        if (!content.isEmpty()) note.setContent(content);
        return true;
    }

    public boolean deleteByTitle(String title) {
        ArrayList<Note> list = bookOfNotes.getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean deleteByNumber(int number) {
        ArrayList<Note> list = bookOfNotes.getList();
        if (numberCheck(number, list)) {
            list.remove(number - 1);
            return true;
        }
        return false;
    }

    private boolean numberCheck(int number, ArrayList list) {
        if (number <= 0) return false;
        else if (number > list.size()) return false;
        return true;
    }

    private void sortByData(ArrayList<Note> list) {
        Collections.sort(list, new NoteComparatorByData<>());
    }

    private void sortByID(ArrayList<Note> list) {
        Collections.sort(list, new NoteComparatorByID<>());
    }
}
