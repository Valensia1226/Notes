package presenter;

import model.Service;


public class Presenter {
    Service service = new Service();
    public void addNote(String title, String content) {
        service.add(title, content);
    }

    public boolean deleteNote(int number) {
       return service.deleteByNumber(number);
    }

    public boolean editNote(int number, String title, String content) {
        return service.editByNumber(number, title, content);
    }

    public String readAll() {
        return service.readAll();
    }

    public boolean save(String name) {
        return service.save(name);
    }

    public String showAllNotes() {
        return service.readAll();
    }
}
