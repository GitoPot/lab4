import java.util.List;

public interface GenericGarage<T> {
    void handInVehicle(T vehicle);
    List<T> getGarageVehicle();

    void collectVehicle(T vehicle);
}

