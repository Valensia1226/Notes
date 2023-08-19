package model;

import java.time.LocalDate;
import java.util.Comparator;

public class NoteComparatorByData<T extends NotesItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        String[] date = o1.getDate().split("-");
        LocalDate d1 = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        date = o2.getDate().split("-");
        LocalDate d2 = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        return d1.compareTo(d2);
    }
}
