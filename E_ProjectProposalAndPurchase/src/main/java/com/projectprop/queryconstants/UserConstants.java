package com.projectprop.queryconstants;

public class UserConstants {
	public static final String USERREGISTER="INSERT INTO user VALUES(?,?,?,?,?,?)";
	public static final String USERLOGIN="SELECT first_name FROM user WHERE email=? AND password=?";
}
