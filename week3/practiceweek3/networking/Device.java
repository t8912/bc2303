package week3.practiceweek3.networking;

//creating a program for managing a network of devices. 
//We can start by creating a `Device` class that represents a generic network device:

//then have our `Device` class implement the `NetworkDevice` interface

//public class Device {
    
  public class Device implements NetworkDevice {
  
  private String name;
  private String ipAddress;
  private String macAddress;
  private int port;

  public Device(String name, String ipAddress, String macAddress, int port) {
      this.name = name;
      this.ipAddress = ipAddress;
      this.macAddress = macAddress;
      this.port = port;
  }
  
  private boolean connected = false;

  public void connect() {
      connected = true;
  }

  public void disconnect() {
      connected = false;
  }




  public String getName() {
      return name;
  }

  public String getIpAddress() {
      return ipAddress;
  }

  public String getMacAddress() {
      return macAddress;
  }

  public int getPort() {
      return port;
  }
}
