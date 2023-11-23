import java.util.List;

public interface GenericGarage<T> {
    void handInCar(T car);
    List<T> getGarageCars();

    void collectCar(T car);
}

