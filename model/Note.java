package model;

public class Note implements NotesItem{
    private int id;
    private String title;
    private String content;
    private String date;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return getInfo();
    }
    private String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(this.id);
        sb.append("\n");
        sb.append("Заголовок: ");
        sb.append(this.title);
        sb.append("\n");
        sb.append("Содержание: ");
        sb.append(this.content);
        sb.append("\n");
        sb.append("Дата создания/последнего изменения: ");
        sb.append(this.date.toString());
        sb.append("\n");
        return sb.toString();
    }
}
