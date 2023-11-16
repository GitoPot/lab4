import java.util.List;

public interface GenericGarage<T> {
    //Ta imot bilar tills parkeringen är full
    //fixa bilar?
    //hämta bilar
    void handInCar(T car);
    List<T> getGarageCars();

    void collectCar(T car);
}

