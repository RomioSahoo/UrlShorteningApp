package com.projectprop.queryconstants;

public class ProposalConstants {

	public static final String PROPOSALFETCH="select * from proposal";
	public static final String PROPOSALSTATUS="select name,duration,budget,skills,status from projectdata  where status='Completed'";
	public static final String PROPOSALPAYMENT="insert into paymentdetails(name,email,cardnumber) values(?,?,?)";
	public static final String PROPOSALPAYDETAILS="select * from paymentdetails";
}
