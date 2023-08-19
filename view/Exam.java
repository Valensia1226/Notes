package view;

public class Exam {
    private final String NUMBER_ERROR = "Ведено не число";
    public int itsNumber(String line) {
        try {
            return Integer.parseInt(line);
        }
        catch (NumberFormatException e) {
            System.out.println(NUMBER_ERROR);
            return -1;
        }
    }
}
