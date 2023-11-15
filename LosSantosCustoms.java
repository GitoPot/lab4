import java.util.ArrayList;
import java.util.List;

public class LosSantosCustoms implements GenericGarage<Cars>{//uppgift 3
    // Detta är vår bilverkstads fil

    // Det behövs skapa en gemensam fil som olika verkstäder kan "ärva" från genom composition, det går inte att ärva normalt.
    private final HelperGarage<Cars> parent;  // Composition

    public LosSantosCustoms(int capacity){
        parent = new HelperGarage<Cars>(capacity);
    }


    @Override
    public void handInCar(Cars car) {
        parent.handInCar(car);        // Delegation
    }

    @Override
    public List<Cars> getGarageCars() {
        return parent.getGarageCars();
    }
}
