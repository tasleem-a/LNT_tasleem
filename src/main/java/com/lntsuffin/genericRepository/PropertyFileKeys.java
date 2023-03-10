package com.lntsuffin.genericRepository;
/**
 * This enum is used to convert the keys to strings 
 * @author asus
 *
 */
public enum PropertyFileKeys {
	BROWSER ("browser"), URL ("url"), TIMEOUT ("timeout"), AD_USERNAME ("admin_username"), AD_PASSWORD ("admin_password");
	private String keys;
	//setter
	/**
	 * it is used to set property keys
	 * @param keys
	 */
	private PropertyFileKeys(String keys)
	{
		this.keys=keys;
	}
	//getter
	/**
	 * ZThis class is used to convert the keys into string
	 * @return
	 */
	public String convertToString()
	{
		return keys.toString();
	}
	

}
