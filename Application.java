public class Application {


    public static void main(String[] args) {
        // Instance of this class
        VehicleModel model = new VehicleModel();
        VehicleView view = new VehicleView("PlaceHolder");
        VehicleController cc = new VehicleController(view, model);

        model.addVehicle(new Volvo240());
        model.addVehicle(new Saab95());
        model.addVehicle(new Scania());

        // Start a new view and send a reference of self


        // Start the timer
        cc.timer.start();
    }
}
