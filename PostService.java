package com.postoffice.postofficemanagement.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.postoffice.postofficemanagement.dao.PostDao;
import com.postoffice.postofficemanagement.exception.InvalidAccountNoException;
import com.postoffice.postofficemanagement.exception.InvalidLoginException;
import com.postoffice.postofficemanagement.exception.InvalidUserLoginException;

import com.postoffice.postofficemanagement.model.AdminModel;
import com.postoffice.postofficemanagement.model.ForgetPassword;
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

@Service
public class PostService {
	
	
	PostDao registerDao = new PostDao();
	
	public void userRegister(UserModel register,HttpSession session) {
		registerDao.saveDetails(register, session);
}
	public void listOfRegisteredPostUser( Model model) throws JsonProcessingException, DataAccessException {
		registerDao.listRegisterPostUser(model);
		
	}
	public void listOfSpeedPostUser(Model model) throws JsonProcessingException {
		 registerDao.listspeedPostUser(model);
		
	}
	public void listOfRecurringDepositUser(Model model, HttpSession session) throws JsonProcessingException {
		List<RecurringDepositModel> registers = registerDao.listRecurringDepositUser(model);
		session.setAttribute("RecurringDepositUser_List", registers);
	}
	public void listOfTimeDepositUser(Model model, HttpSession session) throws JsonProcessingException {
		List<TimeDepositModel> registers = registerDao.listTimeDepositUser(model);
		session.setAttribute("TimeDepositUser_List", registers);
	}
	public void listOfSeniorCitizenUser(Model model, HttpSession session) throws JsonProcessingException {
		List<SeniorCitizenModel> registers = registerDao.listSeniorCitizenDepositUser(model);
		session.setAttribute("SeniorCitizenDepositUser_List", registers);
	}
	public boolean login1(UserModel register,HttpSession session) {
		return registerDao.userLogin(register, session);
	}
	public void login2(AdminModel admin) throws InvalidLoginException {
		registerDao.adminLogin(admin);
	}
	public void recurringDepositDetails(RecurringDepositModel recurringDeposit,HttpSession session ) {
		registerDao.saveRecurringDepositDetails(recurringDeposit, session);
	}
	public void recurringCalculation(RecurringDepositModel recurringDeposit) {
		registerDao.reccuringInterest(recurringDeposit);
	}
	public void timeDepositDetails(TimeDepositModel timeDeposit,HttpSession session ) {
		registerDao.saveTimeDepositDetails(timeDeposit, session);
	}
	public void seniorDepositDetails(SeniorCitizenModel seniorCitizen,HttpSession session ) {
		registerDao.saveSeniorCitizenDetail(seniorCitizen, session);
	}
	public void registeredPostDetails( RegisteredPostModel registerPost,HttpSession session ) {
		registerDao.saveRegisterPostDetail(registerPost, session);
	}
	public void registeredPostReached(RegisteredPostModel registeredPostModel) {
		registerDao.reached(registeredPostModel);
	}
	public void registerProcessing(RegisteredPostModel registeredPostModel) {
		registerDao.processing(registeredPostModel);
	}
	public void speedPostReached(SpeedPostModel speedPostModel) {
		registerDao.speedReached(speedPostModel);
	}
	public void speedPostProcessing(SpeedPostModel speedPostModel) {
		registerDao.speedProcessing(speedPostModel);
	}
	public void speedPostDetails(SpeedPostModel speedPost ,HttpSession session) {
		registerDao.saveSpeedPostDetail(speedPost, session);
	}
	public void recurringPaymentDetails(RecurringPayment recuringPayment,HttpSession session ) {
		registerDao.recurringPayment(recuringPayment,session);
	}
	public void timePaymentDetails(TimeDepositPayment timePayment ) {
		registerDao.timePayment(timePayment);
	}
	public void seniorPaymentDetails(SeniorCitizenPayment seniorPayment ) {
		registerDao.seniorPayment(seniorPayment);
	}
	public void recurringDepositPaidUserList(Model model,HttpSession session) {
		List<RecurringPayment> registers = registerDao.listRecurringDepositPaidUser(model);
		session.setAttribute("RecurringDepositPaidUser_List", registers);
	}
	public void timeDepositPaidUserList(Model model,HttpSession session) {
		List<TimeDepositPayment> registers = registerDao.listTimeDepositPaidUser(model);
		session.setAttribute("TimeDepositPaidUser_List", registers);
	}
	public void seniorDepositPaidUserList(Model model, HttpSession session) {
	List<SeniorCitizenPayment> registers = registerDao.listSeniorCitizenDepositPaidUser(model);
	session.setAttribute("SeniorCitizenDepositPaidUser_List", registers);
    }
	public void registeredPostPaymentDetails(RegisteredPostPaymentModel registerPayment) {
		registerDao.registerPostPayment(registerPayment);
	}
	public void speedPostPaymentdetails(SpeedPostPaymentModel speedPayment) {
		registerDao.speedPostPayment(speedPayment);
	}
	public void listOfRegisteredPostPaymentList(Model model) throws JsonProcessingException {
		 registerDao.listRegisteredPostPaidUser(model);
	
	}
	public void listOfSpeedPostPaymentList( Model model) throws JsonProcessingException {
		 registerDao.listSpedPostPaidUser(model);
	}
	public void forPassword(UserModel register) {
		registerDao.passwordChange(register);	
	}

	public List<RegisteredPostModel> registeredSearchBar(String search) {
		  
		return registerDao.registerPostSearch(search);
		
		
	}
}



















