package com.postoffice.postofficemanagement.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.postoffice.postofficemanagement.dao.PostDao;
import com.postoffice.postofficemanagement.exception.DuplicationOfMobileException;
import com.postoffice.postofficemanagement.exception.InvalidAddressException;
import com.postoffice.postofficemanagement.exception.InvalidEmailException;
import com.postoffice.postofficemanagement.exception.InvalidMobileNoException;
import com.postoffice.postofficemanagement.exception.InvalidPasswordException;
import com.postoffice.postofficemanagement.exception.InvalidReceiverNameException;
import com.postoffice.postofficemanagement.exception.UserNameException;
import com.postoffice.postofficemanagement.model.AdminModel;
import com.postoffice.postofficemanagement.model.RecurringDepositModel;
import com.postoffice.postofficemanagement.model.RecurringPayment;
import com.postoffice.postofficemanagement.model.UserModel;
import com.postoffice.postofficemanagement.model.RegisteredPostModel;
import com.postoffice.postofficemanagement.model.RegisteredPostPaymentModel;
import com.postoffice.postofficemanagement.model.SeniorCitizenModel;
import com.postoffice.postofficemanagement.model.SeniorCitizenPayment;
import com.postoffice.postofficemanagement.model.SpeedPostModel;
import com.postoffice.postofficemanagement.model.SpeedPostPaymentModel;
import com.postoffice.postofficemanagement.model.TimeDepositModel;
import com.postoffice.postofficemanagement.model.TimeDepositPayment;
import com.postoffice.postofficemanagement.model.TrackingModel;
import com.postoffice.postofficemanagement.service.PostService;
import com.postoffice.postofficemanagement.validation.DepositValidation;
import com.postoffice.postofficemanagement.validation.ParcelValidation;
import com.postoffice.postofficemanagement.validation.RegisterValidation;

@Controller
public class PostController1 {

	
	PostDao registerDao = new PostDao();
	PostService postService = new PostService();
	UserModel register = new UserModel();
	AdminModel admin = new AdminModel();
	RecurringDepositModel recurringDeposit = new RecurringDepositModel();
	TimeDepositModel timeDeposit = new TimeDepositModel() ;
	SeniorCitizenModel seniorCitizen = new SeniorCitizenModel();
	RegisteredPostModel registerPost = new RegisteredPostModel();
	SpeedPostModel speedPost = new SpeedPostModel();
	RecurringPayment recuringPayment = new RecurringPayment();
	TimeDepositPayment timePayment = new TimeDepositPayment();
	SeniorCitizenPayment seniorPayment = new SeniorCitizenPayment();
	RegisteredPostPaymentModel  registerPayment = new RegisteredPostPaymentModel();
	DepositValidation depositValidation = new DepositValidation();
	RegisterValidation registerValidation = new RegisterValidation();
	ParcelValidation parcelValid = new ParcelValidation();
	
	
	Integer obj = null;
	
	Logger logger = LoggerFactory.getLogger(PostController1.class);

	String adminDashboard="/JspFiles1/AdminDashBoard..jsp";
	String payment="/JspFiles1/PaymentSuccess.jsp";
	
	@GetMapping("/")
	public String dash() {
		logger.info("Through Controller");
		return "Dashboard";
	}

	
	@GetMapping("/userRegister")
	public String userRegister(@ModelAttribute("register")UserModel register, HttpSession session)
			 {

		return "Register.html";
	}
	
	
	@GetMapping("/register")
	public String register(@ModelAttribute("register")UserModel register, HttpSession session,Model model) throws UserNameException, InvalidPasswordException, InvalidMobileNoException, DuplicationOfMobileException, InvalidAddressException, InvalidEmailException {
		logger.info("Saving Register Details");
		
		for (int i = 1; i <=18; i++) {
            session.removeAttribute("errorMessage1" + i);
        }
        if (Boolean.FALSE.equals(registerValidation.userNameValidation(register.getUserName(), model))
   || Boolean.FALSE.equals(registerValidation.mobileNoValidation(register.getMobileNo(), model))
   || Boolean.FALSE.equals(registerValidation.emailValidation(register.getMailId(),model))
      
   || Boolean.FALSE.equals(registerValidation.addressValidation(register.getAddress(), model))
   || Boolean.FALSE.equals (registerDao.existingMailIdCheck(register.getMailId(),model))
   || Boolean.FALSE.equals(registerValidation.passwordValidation(register.getPassword(),model))
   || Boolean.FALSE.equals(registerDao.existingMobileNoCheck(register.getMobileNo(), model)))

         {
            
            for (int j = 1; j <=8; j++) {
                if (model.getAttribute("errorMessage" + j) != null) {
                    String errorMessage = (String) model.getAttribute("errorMessage" + j);
                    model.addAttribute("ErrorMessage", errorMessage);
                }
            }
            return "ErrorPopup.html";
        }
       postService.userRegister(register, session);
    return "RegisterSuccessfull.html";

}
		

	@GetMapping("/listOfRegisterPostUser")
	public String getRegisterPostUser(@ModelAttribute("registeredPost")RegisteredPostModel registeredPostModel,Model model, HttpSession session) throws JsonProcessingException, DataAccessException {
		postService.listOfRegisteredPostUser(model);
		return "RegisteredPostList.html";
	}
	@GetMapping("/listOfSpeedPostUser")
	public String getSpeedPostUser(@ModelAttribute("speedPost")SpeedPostModel speedPostModel,Model model, HttpSession session) throws JsonProcessingException {
		postService.listOfSpeedPostUser(model);
		return "SpeedPostList.html";
	}

	@GetMapping("/listOfRecurringDepositUser")
	public String getRecurringDepositUser(Model model, HttpSession session) throws JsonProcessingException {
		postService.listOfRecurringDepositUser(model,session);
		return "RecurringDepositList.html";
	}

	@GetMapping("/listOfTimeDepositUser")
	public String getTimeDepositUser(Model model, HttpSession session) throws JsonProcessingException {
		postService.listOfTimeDepositUser(model,session);
		return "TimeDepositList.html";
	}

	@GetMapping("/listOfSeniorCitizenDepositUser")
	public String getSeniorCitizenDepositUser(Model model, HttpSession session) throws JsonProcessingException {
		postService.listOfSeniorCitizenUser(model,session);
		return "SeniorCitizenList.html";
	}

	@RequestMapping("/loginUser")
	public String loginUser(@ModelAttribute("login")UserModel register,HttpSession session) {
		return "User.html";

	}
	
	@GetMapping("/loginpostUser")
	public String loginpostUser(@ModelAttribute("login")UserModel register,HttpSession session,Model model) {

		if(Boolean.TRUE.equals(postService.login1(register, session))) {
		return "LoginSuccessfull.html";

	}
		else if(Boolean.FALSE.equals(postService.login1(register, session))) {
			
		return "User.html";
	}
		return "User.html";
	}
	
	@GetMapping("/userDashBoard")
	public String userDashBorad() {
		return "UserDashboard.html";
	}
	@GetMapping("/depositDashBoard")
	public String depositDashBorad() {
		return "DepositDashBoard.html";
	}
	@GetMapping("/parcelDashBoard")
	public String parcelDashBorad() {
		return "ParcelDashBoard.html";
	}
	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "AboutUs.html";
	}
	@GetMapping("/contact")
	public String contactUs() {
		return "ContactUs.html";
	}
	@GetMapping("/contactUs")
	public String contactUsPage() {
		return "Dashboard.html";
	}
	@GetMapping("/adminDashBoard")
	public String adminDashBoard() {
		return "AdminDashBoard.html";
	}
	
	@RequestMapping("/loginAdminModel")
	public String loginadmiModel(@ModelAttribute("adminLogin") AdminModel admin,Model model) {
     return "Admin.html";
	}
	
	
	@GetMapping("/loginAdmin")
	public String loginadmin(@ModelAttribute("adminLogin") AdminModel admin,@ModelAttribute("registeredPost")RegisteredPostModel registeredPostModel,@ModelAttribute("speedPost")SpeedPostModel speedPostModel,Model model) {

		logger.info("Recurring Deposit Count");
		Integer recurringCount = registerDao.totalRecurringCount();
		model.addAttribute("recurring_count", recurringCount);

		logger.info("Time Deposit Count");
		Integer timeCount = registerDao.totalTimeCount();
		model.addAttribute("time_count", timeCount);

		logger.info("Senior Deposit Count");
		Integer seniorCount = registerDao.totalSeniorCount();
		model.addAttribute("senior_count", seniorCount);
		
		logger.info("Registered Post Count");
		Integer registerCount = registerDao.totalRegisteredCount();
		model.addAttribute("registered_count", registerCount);
		
		logger.info("Speed Post Count");
		Integer speedCount = registerDao.totalSpeedCount();
		model.addAttribute("speed_count", speedCount);	
		return "AdminDashBoard.html";
	}
	
	@GetMapping("/recurring")
	public String recurringDeposit(@ModelAttribute("recurring")RecurringDepositModel recurringDeposit, HttpSession session,Model model) {
		logger.info("Saving Recurring Records");
		registerDao.recurringCount( session, model);
        int c=(int)model.getAttribute("count");
		return "RecurringDeposit.html";
	}
	
	@GetMapping("/recurringDeposit")
	public String recurringDepositInsert(@ModelAttribute("recurring")RecurringDepositModel recurringDeposit, HttpSession session,Model model)  {
		
		for (int i = 1; i <=18; i++) {
            session.removeAttribute("errorMessage1" + i);
        }
        if (Boolean.FALSE.equals(depositValidation.mobileNoValidation1(recurringDeposit.getDepositUserMobileNo(), model))
   || Boolean.FALSE.equals(depositValidation.amountValidation(recurringDeposit.getDepositAmount(),model))
      
   || Boolean.FALSE.equals(depositValidation.monthValidation(recurringDeposit.getNoOfMonths(), model)))
    {
            
            for (int j = 1; j <=8; j++) {
                if (model.getAttribute("errorMessage" + j) != null) {
                    String errorMessage = (String) model.getAttribute("errorMessage" + j);
                    model.addAttribute("ErrorMessage", errorMessage);
                }
            }
            return "ErrorPopup.html";
        }
       
        
	postService.recurringDepositDetails(recurringDeposit, session);
	return "RecurringPayment.html";
	}
	
	@GetMapping("/timeDepositModel")
	public String timeDepositModel(@ModelAttribute("timeDeposit")TimeDepositModel timeDeposit, HttpSession session,Model model)  {
		
	return "TimeDeposit.html";
	}
	
	@GetMapping("/timeDeposit")
	public String timeDeposit(@ModelAttribute("timeDeposit")TimeDepositModel timeDeposit, HttpSession session,Model model)   {
		logger.info("Saving Time Deposit Records");
		for (int i = 1; i <=18; i++) {
            session.removeAttribute("errorMessage1" + i);
        }
        if (Boolean.FALSE.equals(depositValidation.mobileNoValidation1(timeDeposit.getPhoneNo(), model))
   || Boolean.FALSE.equals(depositValidation.amountValidation(timeDeposit.getAmount(),model))
      
   || Boolean.FALSE.equals(depositValidation.monthValidation(timeDeposit.getPeriods(), model)))
   
         {
            
            for (int j = 1; j <=8; j++) {
                if (model.getAttribute("errorMessage" + j) != null) {
                    String errorMessage = (String) model.getAttribute("errorMessage" + j);
                    model.addAttribute("ErrorMessage", errorMessage);
                }
            }
            return "ErrorPopup.html";
        }
       
	postService.timeDepositDetails(timeDeposit, session);
		return "TimeDepositPayment.html";
	}
	
	@GetMapping("/seniorCitizenModel")
	public String seniorCitizenDepositModel(@ModelAttribute("seniorCitizen")SeniorCitizenModel seniorCitizen, HttpSession session,Model model)  {
		return "SeniorCitizen.html";
	}

	@GetMapping("/seniorCitizen")
	public String seniorCitizenDeposit(@ModelAttribute("seniorCitizen")SeniorCitizenModel seniorCitizen, HttpSession session,Model model)   {
		logger.info("Saving Senior Records");
		for (int i = 1; i <=18; i++) {
            session.removeAttribute("errorMessage1" + i);
        }
        if (Boolean.FALSE.equals(depositValidation.mobileNoValidation1(seniorCitizen.getCustomermobileNo(), model))
   || Boolean.FALSE.equals(depositValidation.amountValidation(seniorCitizen.getDepositAmount(),model))
      
   || Boolean.FALSE.equals(depositValidation.ageValidation(seniorCitizen.getAge(), model)))
   
         {
            
            for (int j = 1; j <=8; j++) {
                if (model.getAttribute("errorMessage" + j) != null) {
                    String errorMessage = (String) model.getAttribute("errorMessage" + j);
                    model.addAttribute("ErrorMessage", errorMessage);
                }
            }
            return "ErrorPopup.html";
         }
	postService.seniorDepositDetails(seniorCitizen, session);
		return "SeniorPayment.html";

	}
	
	@GetMapping("/registeredPostModel")
	public String registerPostModel(@ModelAttribute("registeredPost")RegisteredPostModel registerPost, HttpSession session) {
		return "RegisteredPost.html";
	}

	@GetMapping("/registeredPost")
	public String registerPost(@ModelAttribute("registeredPost")RegisteredPostModel registerPost, HttpSession session,Model model) throws InvalidMobileNoException, InvalidAddressException, InvalidReceiverNameException {
		logger.info("Saving Registered Post Records");
		for (int i = 1; i <=18; i++) {
            session.removeAttribute("errorMessage1" + i);
        }
        if (Boolean.FALSE.equals(parcelValid.mobileNoValidation(registerPost.getSendUserMobileNo(), model))
   || Boolean.FALSE.equals(parcelValid.senderAddressValidation(registerPost.getSendUserAddress(),model))
      
   //|| Boolean.FALSE.equals(parcelValid.parcelWeightValidation(registerPost.getParcelWeight(), model))
   || Boolean.FALSE.equals(parcelValid.receiverNameValidation(registerPost.getReceiveUserName(),model))
   
   || Boolean.FALSE.equals(parcelValid.receiverMobileNoValidation(registerPost.getReceiveUserMobileNo(), model))
   || Boolean.FALSE.equals(parcelValid.senderAddressValidation(registerPost.getReceiveUserAddress(), model)))

   
         {
            
            for (int j = 1; j <=8; j++) {
                if (model.getAttribute("errorMessage" + j) != null) {
                    String errorMessage = (String) model.getAttribute("errorMessage" + j);
                    model.addAttribute("ErrorMessage", errorMessage);
                }
            }
            return "ErrorPopup.html";
         }
		
	postService.registeredPostDetails(registerPost, session);
		return "RegisteredPostPayment.html";
	}
	
	@GetMapping("/registerCheck")
	public String registerPostCheck(@ModelAttribute("registeredPost")RegisteredPostModel registeredPostModel,Model model) {
	postService.registeredPostReached(registeredPostModel);
		return "AdminDashBoard.html";
	}
	
	@GetMapping("/registerProcess")
	public String registerPostProcessing(@ModelAttribute("registeredPost")RegisteredPostModel registeredPostModel,Model model) {
		postService.registerProcessing(registeredPostModel);
		return "AdminDashBoard.html";
	}
	
	@GetMapping("/speedReach")
	public String speedPostCheck(@ModelAttribute("speedPost") SpeedPostModel speedPostModel,Model model) {
		postService.speedPostReached(speedPostModel);
		return "AdminDashBoard.html";
		
	}
	
	@GetMapping("/speedProcess")
    public String speedPostProcessing(@ModelAttribute("speedPost") SpeedPostModel speedPostModel,Model model) {
		registerDao.speedProcessing(speedPostModel);
		return "AdminDashBoard.html";
		
   }	


	@PostMapping("/track")
	public String tracking(@RequestParam("TrackingId") Integer trackingId, HttpSession session) {
		registerPost.setTrackingNo(trackingId);
		registerDao.trackView(registerPost, session);
		if (obj != null) {
			String tracking = registerDao.tracking(trackingId);
			obj = Integer.parseInt(tracking);
			session.setAttribute("trcakingId", obj);
		}
		return "/JspFiles1/UserView.jsp";

	}

	@PostMapping("/view")
	public String statusView(@ModelAttribute("registeredView")RegisteredPostModel registeredPostModel, Model model, HttpSession session) throws JsonProcessingException  {
		logger.info("Getting Status");
		 registerDao.listRegisterPostUser(model);
		List<RegisteredPostModel> status = registerDao.view(registeredPostModel,model);
		session.setAttribute("status_List", status);
		return "Dashboard";
	}

	@PostMapping("/speedView")
	public String speedStatusView(@ModelAttribute("registeredView")SpeedPostModel speedPost, Model model, HttpSession session) throws JsonProcessingException  {
		logger.info("Getting Status");
		 registerDao.listspeedPostUser(model);
		String status = registerDao.speedview(speedPost);
		session.setAttribute("status1_List", status);
		return "/JspFiles1/SpeedUserView.jsp";

	}
	
	@GetMapping("/speedPostModel")
	public String speedPostModel(@ModelAttribute("speedPost")SpeedPostModel speedPost, HttpSession session) throws InvalidMobileNoException, InvalidAddressException, InvalidReceiverNameException {
		return "SpeedPost.html";
	}

	@GetMapping("/speedPost")
	public String speedPost(@ModelAttribute("speedPost")SpeedPostModel speedPost, HttpSession session,Model model) throws InvalidMobileNoException, InvalidAddressException, InvalidReceiverNameException {
		logger.info("Saving Speed Post Records");
		
		for (int i = 1; i <=18; i++) {
            session.removeAttribute("errorMessage1" + i);
        }
        if (Boolean.FALSE.equals(parcelValid.mobileNoValidation(speedPost.getSenderMobileNo(), model))
   || Boolean.FALSE.equals(parcelValid.senderAddressValidation(speedPost.getSenderAddress(),model))
      
  // || Boolean.FALSE.equals(parcelValid.parcelWeightValidation(speedPost.getKms(), model))
   || Boolean.FALSE.equals(parcelValid.receiverNameValidation(speedPost.getReceiverName(),model))
   
   || Boolean.FALSE.equals(parcelValid.receiverMobileNoValidation(speedPost.getReceiverMobileNo(), model))
   || Boolean.FALSE.equals(parcelValid.senderAddressValidation(speedPost.getReceiverAddress(), model)))

   
         {
            
            for (int j = 1; j <=8; j++) {
                if (model.getAttribute("errorMessage" + j) != null) {
                    String errorMessage = (String) model.getAttribute("errorMessage" + j);
                    model.addAttribute("ErrorMessage", errorMessage);
                }
            }
            return "ErrorPopup.html";
         }
		
		
		postService.speedPostDetails(speedPost, session);
		return "SpeedPostPayment.html";
	}

	@PostMapping("/tracking")
	public String tracking(@RequestParam("TrackingNo") String trackingNo, @RequestParam("Status") String status) {
		TrackingModel tracking = new TrackingModel();
		tracking.setTrackingNo(trackingNo);
		tracking.setStatus(status);
		registerDao.saveTrcakingDetails(tracking);
		return "/JspFiles1/Admin.jsp";
	}

	
	@GetMapping("/recurringPayment")
	public String recurringPayment( @ModelAttribute("recurringPayment")RecurringPayment recurringPayment,HttpSession session) {
		return "RecurringPayment.html";
	}
	
	@GetMapping("/recurringPaymentMethod")
	public String recurringPaymentMethod( @ModelAttribute("recurringPayment")RecurringPayment recurringPayment,HttpSession session) {
		RecurringPayment rp=new RecurringPayment();
		
		rp.setDepositUserName(recurringPayment.getDepositUserName());
		rp.setRecurPrincipleAmount(recurringPayment.getRecurPrincipleAmount());
		postService.recurringPaymentDetails(rp,session);
		return "PaymentSuccessful.html";
	}
	
	 @GetMapping("/timePaymentModel")
		public String timePaymentModel( @ModelAttribute("timePayment") TimeDepositPayment timePayment) {
          return "TimeDepositpayment.html";
	 }
	
	
    @GetMapping("/timePayment")
	public String timePayment( @ModelAttribute("timePayment") TimeDepositPayment timePayment) {

		postService.timePaymentDetails(timePayment);
		return "TimePaymentSuccess.html";
	}

    @GetMapping("/seniorPaymentModel")
	public String seniorPaymentModel( @ModelAttribute("seniorPayment")SeniorCitizenPayment seniorPayment) {	
	
    return "SeniorPayment.html";
    }
    
	@GetMapping("/seniorPayment")
	public String seniorPayment( @ModelAttribute("seniorPayment")SeniorCitizenPayment seniorPayment) {	
		
		SeniorCitizenPayment senior = new SeniorCitizenPayment();
		
		senior.setCustomerName(seniorPayment.getCustomerName());
		senior.setDepositAmount1(seniorPayment.getDepositAmount1());
		senior.setPaidDate(seniorPayment.getPaidDate());
		postService.seniorPaymentDetails(seniorPayment);
		return "SeniorPaymentSuccess.html";
	}
	
	@GetMapping("/listOfRecurringPaymentUserModel")
	public String getRecurringDepositPaymentUserModel(Model model, HttpSession session) {
		postService.recurringDepositPaidUserList(model, session);
		return "RecurringDepositList.html";
	}
		

	@GetMapping("/listOfTimeDepositPaymentUser")
	public String getTimeDepositPaymentUser(Model model, HttpSession session) {
		postService.timeDepositPaidUserList(model,session);
		return "TimeDepositList.html";
	}

	@GetMapping("/listOfSeniorCitizenDepositPaymentUser")
	public String getSeniorCitizenDepositPaymentUser(Model model, HttpSession session) {
		postService.seniorDepositPaidUserList(model, session);
		return "SeniorCitizenList.html";

	}
	

	@RequestMapping("/registeredPaymentModel")	
	public String registeredPaymentModel( @ModelAttribute("registeredPayment")RegisteredPostPaymentModel registeredPayment) {	
	return "RegisteredpostPayment.html";
	}
	
	
	@GetMapping("/registeredPayment")	
	public String registeredPayment( @ModelAttribute("registeredPayment")RegisteredPostPaymentModel registeredPayment) {	
		RegisteredPostPaymentModel rs=new RegisteredPostPaymentModel();
		rs.setRegisteredPostUserName(registeredPayment.getRegisteredPostUserName());
		rs.setRegisteredPostParcelCharge(registeredPayment.getRegisteredPostParcelCharge());
		postService.registeredPostPaymentDetails(rs);
		return "paymentSuccessfull1.html";
	}
	
	@GetMapping("/speedPaymentModel")	
	public String speedPaymentModel( @ModelAttribute("speedpayment")SpeedPostPaymentModel speedpayment) {
		return "SpeedPostpayment.html";
	
	}
	
	@GetMapping("/speedPayment")	
	public String speedPayment( @ModelAttribute("speedpayment")SpeedPostPaymentModel speedpayment) {
		
		postService.speedPostPaymentdetails(speedpayment);
		return "SpeedPaymentSuccess";
	}
	
	@GetMapping("/listOfRegisteredPaymentUser")
	public String getRegisteredPaymentUser(@ModelAttribute("register")RegisteredPostPaymentModel registeredPayment,Model model, HttpSession session) throws JsonProcessingException {
		postService.listOfRegisteredPostPaymentList(model);
		return "RegisteredPostPaymentList.html";
	}
	
	@GetMapping("/listOfSpeedPostPaymentUser")
	public String getSpeededPaymentUser(@ModelAttribute("speed")SpeedPostPaymentModel speedPostPaymentModel,Model model, HttpSession session) throws JsonProcessingException {
		postService.listOfSpeedPostPaymentList(model);
		return "SpeedPostPaymentList.html";
	}
	@GetMapping("/forgetModel")
	public String forgetPasswordModel(@ModelAttribute("forget")UserModel register) {
	return "ForgetPassword.html";
	}
	
	@GetMapping("/forget")
	public String forgetPassword(@ModelAttribute("forget")UserModel register) {
		postService.forPassword(register);
		return  "User.html";
	}
	
	@GetMapping("/passBook")
	public String getUserPassbook(@ModelAttribute("recurring")RecurringDepositModel recurringDepositModel,HttpSession session,Model model) throws JsonProcessingException {
		String userName=recurringDepositModel.getDeposituserName();
		recuringPayment.setDepositUserName(userName);
		registerDao.listRecurringDepositPassbook(model,session);
		registerDao.listTimeDepositPassbook(model,session);
		registerDao.listSeniorCitizenDepositPassbook(model,session);
		return "Passbook.html";	
		
	}
	
	@GetMapping("/parcelPassBook")
	public String getUserParcelPassbook(@ModelAttribute("parcel")RegisteredPostModel registeredPostModel,HttpSession session,Model model) {
		String userName = registeredPostModel.getSendUserName();
		registeredPostModel.setSendUserName(userName);
		registerDao.listRegisterPostUserProfile(model, session);
		registerDao.listspeedPostUserProfile(model, session);
		
		return "RegisteredPassbook.html";
				
	}
	
	@RequestMapping("/regSearch")
	public String searchRegistered(@RequestParam("Search") String search,Model model) {
		List<RegisteredPostModel> registeredSearch=postService.registeredSearchBar(search);
		model.addAttribute("registeredSearch_list", registeredSearch);
		return "/JspFiles1/RegisteredSearchList.jsp";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Dashboard.html";
		
	}
	
	@GetMapping("/registerProfileModel")
	public String registerProfileMethod(@ModelAttribute("regProfile")UserModel register,HttpSession session) {
		registerDao.getProfileDetails( session);
		return "RegisterProfile.html";
	}
	@GetMapping("/registerProfile")
	public String registerProfile(@ModelAttribute("regProfile")UserModel register,HttpSession session) {
		registerDao.registerUserProfile(register,session);
		return "UserDashboard.html";
	}
	@GetMapping("/recurringSlip")
	public String recurringSlip(@ModelAttribute("recurSlip")RecurringDepositModel recurringDepositModel,HttpSession session) {
		return "RecurringSlip.html";
	}
	@GetMapping("/timeSlip")
	public String timeSlip(@ModelAttribute("timeSlip")TimeDepositModel timeDepositModel,HttpSession session) {
		return "TimePaymentSlip.html";
	}
	@GetMapping("/seniorSlip")
	public String seniorSlip(@ModelAttribute("seniorSlip")SeniorCitizenModel seniorCitizenModel,HttpSession session) {
		return "SeniorPaymentSlip.html";
	}
	@GetMapping("/registerSlip")
	public String registerSlip(@ModelAttribute("registerSlip")RegisteredPostModel registeredPostModel,HttpSession session) {
		return "registerPaymentSlip.html";
	}
	@GetMapping("/speedSlip")
	public String speedSlip(@ModelAttribute("speedSlip")SpeedPostModel speedPostModel,HttpSession session) {
		return "SpeedPaymentSlip.html";
	}
}
