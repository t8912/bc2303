package week3.practiceweek3.networking;

//to have a `Router` class that extends the `Device` class 
//and also implements the `NetworkDevice` interface. 
//We can make `Router` an abstract class that 
//extends `Device` and overrides the `connect()` and 
//`disconnect()` methods to add additional functionality:

//public class Router {
  public abstract class Router extends Device implements NetworkDevice {
    private List<Device> connectedDevices = new ArrayList<Device>();

    public Router(String name, String ipAddress, String macAddress, int port) {
        super(name, ipAddress, macAddress, port);
    }

    public void connect() {
        // Connect to the network
        super.connect();

        // Add connected devices to list
        connectedDevices.add(/*...*/);
    }

    public void disconnect() {
        // Disconnect from the network
        super.disconnect();

        // Remove connected devices from list
        connectedDevices.remove(/*...*/);
    }

    public void routeTraffic() {
        // Route network traffic
    }
  
}
