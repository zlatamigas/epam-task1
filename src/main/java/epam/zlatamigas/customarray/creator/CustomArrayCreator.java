package epam.zlatamigas.customarray.creator;

import epam.zlatamigas.customarray.entity.CustomArray;
import epam.zlatamigas.customarray.exception.CustomArrayException;
import epam.zlatamigas.customarray.util.IdGenerator;

import java.util.Random;

public class CustomArrayCreator {

    private static final IdGenerator ID_GENERATOR = IdGenerator.getInstance();

    public CustomArray createCustomArray(int... array) {
        return new CustomArray(ID_GENERATOR.generateId(), array);
    }

    public CustomArray createCustomArrayWithId(int id, int... array) {
        return new CustomArray(id, array);
    }

    public CustomArray createEmptyCustomArray() {
        return new CustomArray(ID_GENERATOR.generateId());
    }

    public CustomArray createEmptyCustomArrayWithId(int id) {
        return new CustomArray(id);
    }

    public CustomArray createRandomCustomArray(long size) throws CustomArrayException {
        if (size < 0) {
            throw new CustomArrayException("Invalid array size: " + size);
        }

        int id = ID_GENERATOR.generateId();
        int[] array = new Random().ints(size).toArray();

        return new CustomArray(id, array);
    }

    public CustomArray createRandomCustomArrayWithId(int id, long size) throws CustomArrayException {
        if (size < 0) {
            throw new CustomArrayException("Invalid array size: " + size);
        }

        int[] array = new Random().ints(size).toArray();

        return new CustomArray(id, array);
    }
}
