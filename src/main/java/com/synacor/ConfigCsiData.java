/**
 * 
 */
package com.synacor;

/**
 * @author scott.gardner
 *
 */
public class ConfigCsiData {
	private final String primaryProfileUri = "http://abc.com/primary";
	private final String secondaryProfileUri = "http://abc.com/secondary";
	private final String primaryVideoUri = "http://xyz.com/primary";
	private final String secondaryVideoUri = "http://xyz.com/secondary";
	
	public String getPrimaryProfileUri() {
		return primaryProfileUri;
	}
	public String getSecondaryProfileUri() {
		return secondaryProfileUri;
	}
	public String getPrimaryVideoUri() {
		return primaryVideoUri;
	}
	public String getSecondaryVideoUri() {
		return secondaryVideoUri;
	}
	
	
}
