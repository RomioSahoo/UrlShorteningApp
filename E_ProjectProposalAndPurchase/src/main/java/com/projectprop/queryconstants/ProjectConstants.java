package com.projectprop.queryconstants;

public class ProjectConstants {
	public static final String PROJECTDETAILS="insert into projectdata(name,duration,budget,skills,status) values(?,?,?,?,'Default')";
	public static final String PROJECTFETCH="select * from projectdata";
	public static final String PROJECTUSER="SELECT skill FROM user WHERE email=?";
	public static final String PROJECTSKILL="select * from projectdata where FIND_IN_SET(?,skills)";
	public static final String PROJECTPROP="select user.first_name,user.last_name,user.contact_number,user.email,user.skill from user inner join proposal on user.email=proposal.email";
}
