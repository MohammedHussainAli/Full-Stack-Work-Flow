package com.workflow.springboot.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workflow.springboot.model.Category;
import com.workflow.springboot.model.HelpDesk;
import com.workflow.springboot.model.User;
import com.workflow.springboot.model.WorkFlow;
import com.workflow.springboot.repository.CategoryRepository;
import com.workflow.springboot.repository.HelpDeskRepository;
import com.workflow.springboot.repository.WorkFlowRepository;
import com.workflow.springboot.service.RegistrationService;


@RestController
//@RequestMapping("api/v1/") //Standard end point for Rest API
@CrossOrigin(origins="http://localhost:4200")
public class WorkFlowController {
  
	@Autowired
	private WorkFlowRepository workflowRepo;
	
	@Autowired
	private RegistrationService userService;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private HelpDeskRepository helpDeskRepo;
	
	//Save Users (Register//SignUp)
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userObj = userService.fetchUserByEmailId(tempEmailId);
			if(userObj != null) {
				throw new Exception("User with "+tempEmailId+ " is already exists");
			} 
		}
		User userObj=null;
		userObj = userService.saveUser(user);
		return userObj;
	}
	
	
	//Login User
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail= user.getEmailId();
		String tempPass= user.getPassword();
		User userObj = null;
		if(tempEmail != null && tempPass != null) {
			userObj = userService.fetchUserByEmailIdAndPassword(tempEmail, tempPass);
		}
		if(userObj == null) {
			throw new Exception ("User with "+tempEmail+ " does not exists");
		}
		return userObj;
	}

///-------------------------------||-----------------------------------------------///
	
	//Get All Category's
	@GetMapping("/category")
	public List<Category> getAllCategory(){
		return categoryRepo.findAll();
	}
	
	//Add Category
	
	@PostMapping("/addcategory")
	public Category addCategory(@RequestBody Category add) {
		return categoryRepo.save(add);
	} 
	
	//Get Name
	@GetMapping("/categoryName/{category}")
	 public List<WorkFlow> getWorkFlowByCategory(@PathVariable String category) {
	    return workflowRepo.findByCategory(category);
	 }
	
	//Get Category Name by Category List (For validation purpose)
	@GetMapping("/categoryListByCategoryName/{categoryName}")
	 public Category getByCategoryName(@PathVariable String categoryName) {
	    return categoryRepo.findByCategoryName(categoryName);
	 }
	
	//Delete Category By Id
	  @DeleteMapping("deleteCategory/{id}")
	  public void deleteCategoryById(@PathVariable int id) {
	    String result = "";
	    try {  
	    	categoryRepo.deleteById(id);
	      result = "Category record deleted";
	    }
	    catch(Exception e) {
	      result = "error occurred";
	    }
	    
	  } 
	
	  //Delete Assisgnments by category Name
	//Transactional is used while delete mapping was not working-- Ref
	@Transactional
	 @DeleteMapping("/deleteByCategory/{category}")
	 public void deleteWorkFlowByCategory(@PathVariable String category) {
		 String result = "";
		 try {
			 workflowRepo.deleteByCategory(category);
			 result = "Assignment records Deleted";
		 }
		 catch(Exception e) {
			 result = e.getMessage();
		 }
//		 return result;
	 }
	 //Get Category by Id
	 @GetMapping("/category/{id}")
	 public Optional<Category> getCategoryById(@PathVariable int id) {
	    return categoryRepo.findById(id);
	 }
	 
//	 //Update By category Id
	 
	 @PutMapping("/updatecategory/{id}")
	 public Category updateCategory(@RequestBody Category wf, @PathVariable int id) {
	     return categoryRepo.save(wf);
	 }
	 	 
	 
//-------------------------------------------------||--------------------------------------------//
	
	//Get All WorkFlow
	
	@GetMapping("/workflows")
	public List<WorkFlow> getAllWorkflows(){
		return workflowRepo.findAll();
	}
	
	//Add WorkFlow
	
	@PostMapping("/addworkflow")
	public WorkFlow addWorkFlow(@RequestBody WorkFlow add) {
		return workflowRepo.save(add);
	} 
	
	//Get WorkFlow By ID
	
	 @GetMapping("/workflow/{id}")
	 public Optional<WorkFlow> getWorkFlowById(@PathVariable int id) {
	    return workflowRepo.findById(id);
	 }
	 
	 //Update WorkFlow
	 
	 @PutMapping("/editworkflow/{id}")
	 public WorkFlow updateWorkFlow(@RequestBody WorkFlow wf, @PathVariable int id) {
	     return workflowRepo.save(wf);
	 }
	 
	 //Delete WorkFlows
	 
	  @DeleteMapping("deleteworkflow/{id}")
	  public void deleteWorkFlowById(@PathVariable int id) {
	    String result = "";
	    try {  
	    	workflowRepo.deleteById(id);
	      result = "Assignment record deleted";
	    }
	    catch(Exception e) {
	      result = "error occurred";
	    }
	    
//	    return result;
	  } 
	  
	  //-------------------------------------||------------------------------------//
	  
	  //Help Desk
	  
	//Add Message
		
		@PostMapping("/helpDesk")
		public HelpDesk addMessage(@RequestBody HelpDesk add) {
			return helpDeskRepo.save(add);
		} 
	 
}

