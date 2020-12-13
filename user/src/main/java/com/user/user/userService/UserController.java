package com.user.user.userService;
import com.user.user.models.MY_ADDRESS;
import com.user.user.models.USER;
import com.user.user.service.FirebaseInitializer;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.storage.Acl.User;
//import com.google.firestore.v1.WriteResult;
import com.sun.el.stream.Stream;
import com.google.cloud.firestore.WriteResult;



@CrossOrigin
@RestController
public class UserController {
	@Autowired
	FirebaseInitializer db;
	MY_ADDRESS address1;
	MY_ADDRESS address2;
	USER demoUser;
	Integer num = 9;
	public UserController() {
		demoUser = new USER();	
		demoUser.setId(1);
		demoUser.setUserName("testUser");
		demoUser.setFirstName("กิตติวัชร");
		demoUser.setLastName("เอี่ยมกิจการ");
		demoUser.setEmail("64070001@it.kmitl.ac.th");
		demoUser.setDareOfBirth(new Date(10, 10, 2020));
		demoUser.setPhone("0889979667");
		demoUser.setGender("Male");
		App.dummyData.add(demoUser);
		
		address1 = new MY_ADDRESS();
		address2 = new MY_ADDRESS();
		address1.setUSER_id(1);
		address1.setMy_address_id(1);
		address1.setNumber("0632128395");
		address1.setPostal_code("10160");
		address1.setDistrict("ปากช่อง");
		address1.setProvince("กรุงดทพ");
		address1.setRoad("พัฒนาการ");
		address1.setSub_district("คันนายาว");
		
		address2.setUSER_id(1);
		address2.setMy_address_id(2);
		address2.setNumber("0631235435");
		address2.setPostal_code("10000");
		address2.setDistrict("ปากเกร็ต");
		address2.setProvince("กรุงดทพ");
		address2.setRoad("อ่อนนุช");
		address2.setSub_district("บางเขน");
		App.dummyDataAddress.add(address1);
		App.dummyDataAddress.add(address2);
		// TODO Auto-generated constructor stub
	}
//	@CrossOrigin
	@RequestMapping(path = "/createUser", method=RequestMethod.POST)
	public String createUser(@RequestBody USER user) throws InterruptedException, ExecutionException {
//		USER newUser = new USER();	
//		newUser.setUserName(user.getUserName());
//		newUser.setFirstName(user.getFirstName());
//		newUser.setLastName(user.getLastName());
//		newUser.setEmail(user.getEmail());
//		newUser.setDareOfBirth(user.getDareOfBirth());
//		newUser.setPhone(user.getPhone());
//		newUser.setGender(user.getGender());
//		App.dummyData.add(newUser);
		// Create a Map to store the data we want to set
		num++;
		
		Map<String, Object> docData = new HashMap<>();
//		docData.put("id", num);
		docData.put("email", user.getEmail());
		docData.put("userName",user.getUserName());
		docData.put("firstName",user.getFirstName());
		docData.put("lastName",user.getLastName());
		docData.put("phone", user.getPhone());
		docData.put("dateOfBirth", user.getDareOfBirth());
		docData.put("gender", user.getGender());
		String userID2 = num.toString();
		// Add a new document (asynchronously) in collection "cities" with id "LA"
//		ApiFuture<QuerySnapshot> querySnapshot = db.getFirebase().collection("user").get();
		
		ApiFuture<WriteResult> future = db.getFirebase().collection("user").document(userID2).set(docData);
		// ...
		// future.get() blocks on response
//		System.out.println("Update time : " + future.get().getUpdateTime());
//		System.out.println(user.getEmail());
		return "Create Success";
	}
	
	
//	ได้แล้ว http://localhost:8888/getUserByUsername?username=testUser
	@RequestMapping(path = "/getUserByUsername", method=RequestMethod.GET)
	public List<USER> getUserByUsername(@RequestParam(value="username", defaultValue="") String username) throws InterruptedException, ExecutionException {
//		db get user by userName
		List<USER> userList = new ArrayList<USER>();
		//asynchronously retrieve multiple documents
		ApiFuture<QuerySnapshot> querySnapshot = db.getFirebase().collection("user").whereEqualTo("userName", username) .get();
//		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
		for (DocumentSnapshot document : documents) {
		  System.out.println(" => " + document.toObject(USER.class));
		  USER emp = document.toObject(USER.class);
		  userList.add(emp);
		}

		return userList;

	}
	//ได้แล้ว http://localhost:8888/getUserByID?id=1 idของdocument 
	@RequestMapping(path = "/getUserByID", method=RequestMethod.GET)
	public List<USER> getUserByID(@RequestParam(value="id", defaultValue="") Integer id) throws InterruptedException, ExecutionException {
//		db get user by userName
		List<USER> userList = new ArrayList<USER>();
		//asynchronously retrieve multiple documents
		ApiFuture<QuerySnapshot> querySnapshot = db.getFirebase().collection("user").whereEqualTo("id", id) .get();
//		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
		for (DocumentSnapshot document : documents) {
		  System.out.println(" => " + document.toObject(USER.class));
		  USER emp = document.toObject(USER.class);
		  userList.add(emp);
		}

		return userList;

	}

	//ได้แล้ว getAllUser
	@RequestMapping(path = "/getAllUser", method=RequestMethod.GET)
//	@GetMapping("/getAllUser")  
	public List<USER> getAllUser() throws InterruptedException, ExecutionException {
		
		List<USER> empList = new ArrayList<USER>();
		CollectionReference userRef= db.getFirebase().collection("user");
		ApiFuture<QuerySnapshot> querySnapshot= userRef.get();
		for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
			USER emp = doc.toObject(USER.class);
			empList.add(emp);
		}
		return empList;
	}

	///groupByGender/
//	@RequestMapping(path = "/groupByGender", method=RequestMethod.GET)
//	public ResponseEntity<ArrayList<USER>> groupByGender(@RequestParam(value="gender", defaultValue="Male") String gender) throws InterruptedException, ExecutionException{
//		List<USER> userList = new ArrayList<USER>();
//		ApiFuture<QuerySnapshot> querySnapshot= db.getFirebase().collection("user").whereEqualTo("gender", gender.toLowerCase()) .get();
//
//		List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
//		for (DocumentSnapshot document : documents) {
//			 System.out.println(" => " + document.toObject(USER.class));
//			  USER emp = document.toObject(USER.class);
//			  userList.add(emp);
//		}
//		
//		return (ResponseEntity<ArrayList<USER>>) userList;
//	}
	
	//ยังไม่เสร็จ
//	@RequestMapping(path = "/groupByAge", method=RequestMethod.GET)
//	public ResponseEntity<ArrayList<USER>> groupByAge(Integer minAge, Integer maxAge) throws InterruptedException, ExecutionException{
//		List<USER> userList = new ArrayList<USER>();
//		
//		ApiFuture<QuerySnapshot> querySnapshot= db.getFirebase().collection("user").whereEqualTo("dateOfBirth", minAge) .get();
//
//		List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
//		for (DocumentSnapshot document : documents) {
//			 System.out.println(" => " + document.toObject(USER.class));
//			  USER emp = document.toObject(USER.class);
//			  userList.add(emp);
//		}
//		
//		return (ResponseEntity<ArrayList<USER>>) userList;
//	}
//	
	///createAddress/
	@RequestMapping(path = "/createAddress", method=RequestMethod.POST)
	public String createAddress(@RequestBody MY_ADDRESS newAddress){
num++;
		
		Map<String, Object> docData = new HashMap<>();
//		docData.put("id", num);
		docData.put("USER_id", newAddress.getUSER_id());
		docData.put("my_address_id", num.toString());
		docData.put("number", newAddress.getNumber());
		docData.put("district", newAddress.getDistrict());
		docData.put("postal_code", newAddress.getPostal_code());
		docData.put("province", newAddress.getProvince());
		docData.put("road", newAddress.getRoad());
		docData.put("sub_district", newAddress.getSub_district());
		String addressID2 = num.toString();
		// Add a new document (asynchronously) in collection "cities" with id "LA"
//		ApiFuture<QuerySnapshot> querySnapshot = db.getFirebase().collection("user").get();
		
		ApiFuture<WriteResult> future = db.getFirebase().collection("user").document(addressID2).set(docData);
		return "create success";
//		List<MY_ADDRESS> address = new List<MY_ADDRESS>();
//		ApiFuture<QuerySnapshot> querySnapshot = db.getFirebase().collection("my_address").whereEqualTo("userName", username) .get();
////		// future.get() blocks on response
//		List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
//		for (DocumentSnapshot document : documents) {
//		  System.out.println(" => " + document.toObject(USER.class));
//		  USER emp = document.toObject(USER.class);
//		  userList.add(emp);
//		}
//
//		genderFilter.add(newAddress);
//		return address;
	}
	
	///getAddress/  ไม่แน่ใจว่ามีคนใช้มั้ย
//	@RequestMapping(path = "/getAddress", method=RequestMethod.GET)
//	public ResponseEntity<ArrayList<USER>> getAddress(@RequestParam(value="gender", defaultValue="Male") String gender){
//		ArrayList<USER> genderFilter = new ArrayList<USER>();
//		
//		return new ResponseEntity<ArrayList<USER>>(genderFilter,HttpStatus.OK);
//	}
	
	///getAddressByID/
		@RequestMapping(path = "/getAddressByUserID", method=RequestMethod.GET)
		public ArrayList<MY_ADDRESS>  getAddressByUserID(@RequestParam(value="id", defaultValue="") Integer id) throws InterruptedException, ExecutionException{

			ArrayList<MY_ADDRESS>  addressList = new ArrayList<MY_ADDRESS>();
			//asynchronously retrieve multiple documents
			ApiFuture<QuerySnapshot> querySnapshot = db.getFirebase().collection("my_address").whereEqualTo("USER_id", id).get();
//			// future.get() blocks on response
			List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
			for (DocumentSnapshot document : documents) {
			  System.out.println(" => " + document.toObject(MY_ADDRESS.class));
			  MY_ADDRESS emp = document.toObject(MY_ADDRESS.class);
			  addressList.add(emp);
	
			}

			return addressList;
		}
	
	///updateAddress/<my_address_id>
	@RequestMapping(path = "/updateAddress", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<MY_ADDRESS>> updateAddress(@RequestBody MY_ADDRESS updateAddress){
		ApiFuture<WriteResult> future = db.getFirebase().collection("my_address").document(updateAddress.getMy_address_id().toString()).set(updateAddress);
		//		App.dummyDataAddress.set(App.dummyDataAddress.indexOf(updateAddress), updateAddress);
		return new ResponseEntity<ArrayList<MY_ADDRESS>>(App.dummyDataAddress,HttpStatus.OK);
	}
	
	//deleteAddress/<my_address_id>
	@RequestMapping(path = "/deleteAddress", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<MY_ADDRESS>> deleteAddress(@RequestParam(value="addressID", defaultValue="") Integer addressID){
//		ArrayList<MY_ADDRESS> addressFilter = new ArrayList<MY_ADDRESS>();
//		MY_ADDRESS[] arr = App.dummyDataAddress.stream().filter(e -> e.getMy_address_id().equals(addressID)).toArray(MY_ADDRESS[]::new);
//		Collections.addAll(addressFilter, arr);
//		App.dummyDataAddress.remove(addressFilter.get(0));
		db.collection("my_address").document(addressID.toString()).delete();

		return new ResponseEntity<ArrayList<MY_ADDRESS>>(App.dummyDataAddress,HttpStatus.OK);
	}
	
}
