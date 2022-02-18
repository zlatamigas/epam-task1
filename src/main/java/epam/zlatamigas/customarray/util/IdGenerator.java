package epam.zlatamigas.customarray.util;

public class IdGenerator {

    private static IdGenerator instance;

    private static final int START_ID = 100_000_000;
    private static final int END_ID = 999_999_999;

    private static int currentId;

    private IdGenerator() {
        currentId = START_ID;
    }

    public static IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public int generateId() {
        int id = currentId;
        currentId++;

        if (currentId == END_ID) {
            currentId = START_ID;
        }

        return id;
    }
}
