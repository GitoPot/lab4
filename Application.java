public class Application {




    public static void main(String[] args) {
        // Instance of this class
        VehicleModel model = initVehicleModel();
        VehicleView view = initVehicleView(model);
        VehicleController cc = new VehicleController(view, model);

        // Start a new view and send a reference of self
        // Start the timer
    }

    private static VehicleModel initVehicleModel(){
        VehicleModel model = new VehicleModel();
        model.addVehicle();
        model.addVehicle();
        model.addVehicle();
        return model;
    }
    private static VehicleView initVehicleView(VehicleModel model){
        VehicleView view = new VehicleView("Frame", model);
        model.addListener(view);
        return view;
    }
}
