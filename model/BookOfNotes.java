package model;

import java.io.Serializable;
import java.util.ArrayList;

public class BookOfNotes implements Serializable {
    private ArrayList<Note> list;

    public BookOfNotes() {
        this.list = new ArrayList<>();
    }

    public ArrayList<Note> getList() {
        return list;
    }

    public void setList(ArrayList<Note> list) {
        this.list = list;
    }
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                sb.append("\n");
            }
        } else sb.append("Дерево не заполнено");
        return sb.toString();
    }
}
