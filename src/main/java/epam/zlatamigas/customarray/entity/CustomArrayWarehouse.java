package epam.zlatamigas.customarray.entity;

import java.util.HashMap;
import java.util.Map;

public class CustomArrayWarehouse {

    private static CustomArrayWarehouse instance;

    private Map<Integer, CustomArrayParameters> warehouse;

    private CustomArrayWarehouse() {
        warehouse = new HashMap<>();
    }

    public static CustomArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new CustomArrayWarehouse();
        }
        return instance;
    }

    public CustomArrayParameters get(int arrayId) {
        return warehouse.get(arrayId);
    }

    public CustomArrayParameters put(int arrayId, CustomArrayParameters parameter) {
        return warehouse.put(arrayId, parameter);
    }

    public CustomArrayParameters remove(int arrayId) {
        return warehouse.remove(arrayId);
    }
}
