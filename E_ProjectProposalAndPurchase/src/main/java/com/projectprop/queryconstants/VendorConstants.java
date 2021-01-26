package com.projectprop.queryconstants;

public class VendorConstants {
	public static final String VENDORREGISTER= "insert into vendor values(?,?,?,?,?)";
	public static final String VENDORLOGIN="select first_name from vendor where email=? and password=?";
}
