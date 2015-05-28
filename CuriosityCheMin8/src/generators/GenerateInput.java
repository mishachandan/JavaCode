package generators;

import java.util.ArrayList;
import java.util.List;


public class GenerateInput {
	
	//In terms of Watt/hour
	 Integer powerRequired = 250;
	
	public Integer getPowerRequired(){
		return powerRequired;
	}
	
	/*
	 * 3.Primary operating period of CHEMIN is in the night because it requires cold temperature that is between -40 degree C to +20 degree C.
	 *	Values in terms of SOL. 
	 */
	public List<Integer> getPreferredWorkingTime(){
		List<Integer> preferredWorking = new ArrayList<Integer>();
		preferredWorking.add(new Integer(18));
		preferredWorking.add(new Integer(4));
		return preferredWorking;
	}
	

	/*
	 * 3.Primary operating period of CHEMIN is in the night because it requires cold temperature that is between -40 degree C to +20 degree C.
	 *	Values in terms of degree celcius
	 */
	public List<Integer> getPreferredTemperature(){
		List<Integer> preferredWorking = new ArrayList<Integer>();
		preferredWorking.add(new Integer(-40));
		preferredWorking.add(new Integer(20));
		return preferredWorking;
	}
}
