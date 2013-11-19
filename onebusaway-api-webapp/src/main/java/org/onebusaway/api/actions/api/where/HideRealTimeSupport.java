package org.onebusaway.api.actions.api.where;

public class HideRealTimeSupport {
	private static boolean _hidePredictions = System.getProperties().containsKey(
		      HideRealTimeSupport.class.getName());

		  public static boolean isEnabled() {
		    return _hidePredictions;
		  }
}
