package com.projectprop.queryconstants;

public class AdminConstants {
	public static final String ADMINREGISTER= "insert into admin values(?,?,?,?,?)";
	public static final String ADMINLOGIN="select first_name from admin where email=? and password=?";
}
