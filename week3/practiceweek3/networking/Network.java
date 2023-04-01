package week3.practiceweek3.networking;

//create a `Network` class that keeps track of all the devices and routers 
//and allows users to connect and disconnect devices from the network

//public class Network {
  public class Network {
    private List<Device> devices = new ArrayList<Device>();
    private List<Router> routers = new ArrayList<Router>();

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void addRouter(Router router) {
        routers.add(router);
    }

    public void connectDevice(Device device, Router router) {
        if (router.isConnected()) {
            router.routeTraffic();
            device.connect();
        }
    }

    public void disconnectDevice(Device device, Router router) {
        device.disconnect();
    }
}
