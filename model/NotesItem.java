package model;

import java.time.LocalDate;

public interface NotesItem {
    String getTitle();

    void setTitle(String title);

    String getContent();

    void setContent(String content);

    int getId();

    void setId(int id);

    String getDate();

    void setDate(String date);

}
