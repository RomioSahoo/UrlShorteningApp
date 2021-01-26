package com.projectprop.test;

import com.projectprop.model.AdminCredentials;

import junit.framework.TestCase;

public class AdminLoginTest extends TestCase {

public void testValidateUser()
{
AdminCredentials f = new AdminCredentials();
f.setEmail("email");;
f.setPassword("password");
assertEquals(f,f);
}


}