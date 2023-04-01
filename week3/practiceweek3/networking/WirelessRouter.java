package week3.practiceweek3.networking;

//create a `WirelessRouter` class that extends `Router

//public class WirelessRouter {

  public class WirelessRouter extends Router {
    public WirelessRouter(String name, String ipAddress, String macAddress, int port) {
        super(name, ipAddress, macAddress, port);
    }

    public void enableWireless() {
        // Enable wireless network
    }

    public void disableWireless() {
        // Disable wireless network
    }
  
}
