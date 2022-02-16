package epam.zlatamigas.customarray.creator;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.exception.CustomArrayException;

import java.util.Random;

public class CustomArrayCreator {

    private static final Random RANDOM = new Random();

    public CustomArray createCustomArray(int... array) {
        return new CustomArray(RANDOM.nextInt(Integer.MAX_VALUE), array);
    }

    public CustomArray createCustomArrayWithId(int id, int... array) {
        return new CustomArray(id, array);
    }

    public CustomArray createEmptyCustomArray() {
        return new CustomArray(RANDOM.nextInt(Integer.MAX_VALUE));
    }

    public CustomArray createEmptyCustomArrayWithId(int id) {
        return new CustomArray(id);
    }

    public CustomArray createRandomCustomArray(long size) throws CustomArrayException {
        if (size < 0) {
            throw new CustomArrayException("Invalid array size: " + size);
        }

        int id = RANDOM.nextInt(Integer.MAX_VALUE);
        int[] array = RANDOM.ints(size).toArray();

        return new CustomArray(id, array);
    }

    public CustomArray createRandomCustomArrayWithId(int id, long size) throws CustomArrayException {
        if (size < 0) {
            throw new CustomArrayException("Invalid array size: " + size);
        }

        int[] array = RANDOM.ints(size).toArray();

        return new CustomArray(id, array);
    }
}
