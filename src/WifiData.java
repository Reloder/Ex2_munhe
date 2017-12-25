
/**
 * This class represents the wifi data of a router device.
 */
public class WifiData {
	public String Name,SSID,Channel;
	public double Signal;
	
	public static final int NON_SIGNAL = -120; // if there is no signal the minimum number is this.
	
	public WifiData() {
		Signal = NON_SIGNAL;
	}
	
	public WifiData(String Name,String SSID,String Channel,double Signal) {
		this.Name = Name;
		this.SSID = SSID;
		this.Channel = Channel;
		this.Signal = Signal;
		
	}
	
	public WifiData(String Name,String SSID,String Channel,String Signal) {
		this.Name = Name;
		this.SSID = SSID;
		this.Channel = Channel;
		try {
			this.Signal = Double.parseDouble(Signal);
		} catch(Exception ex) {
			this.Signal = NON_SIGNAL;
		}
	}
	

}
