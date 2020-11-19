package userServise.userService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.stream.Stream;

import models.USER;



@RestController
public class UserController {
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(path = "/createUser", method=RequestMethod.POST)
	public ResponseEntity<ArrayList<USER>> createUser(@RequestBody USER user) {
		USER newUser = new USER();	
		newUser.setUserName(user.getUserName());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setDareOfBirth(user.getDareOfBirth());
		newUser.setPhone(user.getPhone());
		newUser.setGender(user.getGender());
		App.dummyData.add(newUser);
		return new ResponseEntity<ArrayList<USER>>(App.dummyData,HttpStatus.OK);
	}
	@RequestMapping("/getUser")
	public USER getUser(@RequestParam(value="name", defaultValue="World") String name) {
		return new USER();
	}
	//getAllUser
	@RequestMapping(path = "/getAllUser", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<USER>> createUser(){
		return new ResponseEntity<ArrayList<USER>>(App.dummyData,HttpStatus.OK);
	}
	
	///groupByGender/
	@RequestMapping(path = "/groupByGender", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<USER>> groupByGender(@RequestParam(value="gender", defaultValue="Male") String gender){
		ArrayList<USER> genderFilter = new ArrayList<USER>();
		
		return new ResponseEntity<ArrayList<USER>>(genderFilter,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/groupByAge/<age_range>", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<USER>> groupByAge(@RequestParam(value="gender", defaultValue="Male") String gender){
		ArrayList<USER> genderFilter = new ArrayList<USER>();
		
		return new ResponseEntity<ArrayList<USER>>(genderFilter,HttpStatus.OK);
	}
	
	///createAddress/
	@RequestMapping(path = "/createAddress", method=RequestMethod.POST)
	public ResponseEntity<ArrayList<USER>> createAddress(@RequestParam(value="gender", defaultValue="Male") String gender){
		ArrayList<USER> genderFilter = new ArrayList<USER>();
		
		return new ResponseEntity<ArrayList<USER>>(genderFilter,HttpStatus.OK);
	}
	
	///getAddress/
	@RequestMapping(path = "/getAddress", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<USER>> getAddress(@RequestParam(value="gender", defaultValue="Male") String gender){
		ArrayList<USER> genderFilter = new ArrayList<USER>();
		
		return new ResponseEntity<ArrayList<USER>>(genderFilter,HttpStatus.OK);
	}
	
	///updateAddress/<my_address_id>
	@RequestMapping(path = "/updateAddress", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<USER>> updateAddress(@RequestParam(value="gender", defaultValue="Male") String gender){
		ArrayList<USER> genderFilter = new ArrayList<USER>();
		
		return new ResponseEntity<ArrayList<USER>>(genderFilter,HttpStatus.OK);
	}
	
	//deleteAddress/<my_address_id>
	@RequestMapping(path = "/deleteAddress", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<USER>> deleteAddress(@RequestParam(value="gender", defaultValue="Male") String gender){
		ArrayList<USER> genderFilter = new ArrayList<USER>();
		
		return new ResponseEntity<ArrayList<USER>>(genderFilter,HttpStatus.OK);
	}
	
}
