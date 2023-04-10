package com.postoffice.postofficemanagement.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.postoffice.postofficemanagement.exception.DuplicationOfMailIdException;
import com.postoffice.postofficemanagement.exception.DuplicationOfMobileException;
import com.postoffice.postofficemanagement.exception.InvalidAccountNoException;
import com.postoffice.postofficemanagement.exception.InvalidLoginException;
import com.postoffice.postofficemanagement.exception.InvalidUserLoginException;
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

public interface PostInterface {

	public  void saveDetails(UserModel register,HttpSession session) ;
		
	public void mobileNoExist(Long mobileNo)throws DuplicationOfMobileException;
	
	public void mailIdExist(String mailId )throws DuplicationOfMailIdException;
	
	public void listRegisterPostUser(Model model) throws JsonProcessingException;
	
	public void listspeedPostUser(Model model) throws JsonProcessingException ;
	
	public List<RecurringDepositModel> listRecurringDepositUser(Model model) throws JsonProcessingException;
	
	public List<TimeDepositModel> listTimeDepositUser(Model model) throws JsonProcessingException;
	
	public List<SeniorCitizenModel> listSeniorCitizenDepositUser(Model model) throws JsonProcessingException;
	
	public boolean userLogin(UserModel register,HttpSession session) throws InvalidUserLoginException, InvalidAccountNoException;
	
	public void adminLogin(AdminModel admin ) throws InvalidLoginException;
	
	public Integer totalRecurringCount();
	
	public Integer totalTimeCount();
	
	public Integer totalSeniorCount();
	
	public Integer totalRegisteredCount();
	
	public Integer totalSpeedCount();
	
	public Integer totalUserCount();
	
	public void saveRecurringDepositDetails(RecurringDepositModel recurringDeposit,HttpSession session);
	
	public void reccuringInterest(RecurringDepositModel recurringDeposit) ;
	
	public void saveTimeDepositDetails(TimeDepositModel timeDeposit,HttpSession session) ;
	
	public void saveSeniorCitizenDetail(SeniorCitizenModel seniorCitizen,HttpSession session) ;
	
	public void saveRegisterPostDetail(RegisteredPostModel registerPost,HttpSession session) ;
    
	public void reached(RegisteredPostModel registeredPostModel);
	
	public void processing(RegisteredPostModel registeredPostModel);
	
	public void userView(RegisteredPostModel reg ,HttpSession session);
	
	public void trackView(RegisteredPostModel reg,HttpSession session);
	
	public List<RegisteredPostModel> view(RegisteredPostModel registeredPost,Model model) ;
		 
	public String speedview(SpeedPostModel speedPost);
	
	public String tracking(Integer trackingId);
	
	public void speedReached(SpeedPostModel speedPostModel);
	
	public void speedProcessing(SpeedPostModel speedPostModel);
	
	public void chargeCalculation(RegisteredPostModel register);
	
	public void saveSpeedPostDetail(SpeedPostModel speedPost ,HttpSession session) ;
	
	public void speedChargeCalculation(SpeedPostModel speedPost);
	
	public void saveTrcakingDetails(TrackingModel tracking);
	
	
	public void timePayment(TimeDepositPayment timePayment);
	
	public void seniorPayment(SeniorCitizenPayment seniorPayment);
	
	public List<RecurringPayment> listRecurringDepositPaidUser(Model model);
	
	public List<TimeDepositPayment> listTimeDepositPaidUser(Model model);
	
	public List<SeniorCitizenPayment> listSeniorCitizenDepositPaidUser(Model model);
	
	public void registerPostPayment(RegisteredPostPaymentModel registerPayment);
	
	public void speedPostPayment(SpeedPostPaymentModel speedPayment);
	
	public void listRegisteredPostPaidUser(Model model) throws JsonProcessingException ;
	
	public void listSpedPostPaidUser(Model model) throws JsonProcessingException;

	public void recurringPayment(RecurringPayment recurringPayment, HttpSession session);
}
