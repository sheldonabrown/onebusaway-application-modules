package org.onebusaway.api.actions.api.where;

public class HidePredictionSupport {
	private static boolean _hidePredictions = System.getProperties().containsKey(
		      HidePredictionSupport.class.getName());

		  public static boolean isEnabled() {
		    return _hidePredictions;
		  }
}
