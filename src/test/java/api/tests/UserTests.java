package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests {
	
	
	Faker faker;
	User userPayLoad;
	
	String username;
	@BeforeClass
	public void setUserData()
	{
		faker=new Faker();
		userPayLoad=new User();
		
		userPayLoad.setId(faker.idNumber().hashCode());
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstname(faker.name().firstName());
		userPayLoad.setLastname(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().emailAddress());
		userPayLoad.setPassoword(faker.internet().password(5,10));
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
		
		
	}
	
	
	@Test (priority = 1)
	public void testPostUser() {
		Response res= UserEndPoints.createUser(userPayLoad);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		username=res.getBody().jsonPath().getString("username");
	}
	
	@Test (priority = 2)
	public void getUser() {
		Response res=UserEndPoints.getUser(userPayLoad.getUsername());
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void updateUser() {
		
		userPayLoad.setFirstname(faker.name().firstName());
		userPayLoad.setLastname(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().emailAddress());
		
		Response res=UserEndPoints.updateUser(userPayLoad.getUsername(), userPayLoad);
		
		Response res1=UserEndPoints.getUser(userPayLoad.getUsername());
		
		System.out.println("This is the username :"+userPayLoad.getUsername());
		

	}
	


}
