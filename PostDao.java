package com.postoffice.postofficemanagement.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postoffice.postofficemanagement.exception.DuplicationOfMailIdException;
import com.postoffice.postofficemanagement.exception.DuplicationOfMobileException;
import com.postoffice.postofficemanagement.exception.InvalidLoginException;
import com.postoffice.postofficemanagement.mapper.AccountNoMapper;
import com.postoffice.postofficemanagement.mapper.AdminLoginMapper;
import com.postoffice.postofficemanagement.mapper.CheckExistingMailIdMapper;
import com.postoffice.postofficemanagement.mapper.CheckExistingMobileNoMapper;
import com.postoffice.postofficemanagement.mapper.DateViewMapper;
import com.postoffice.postofficemanagement.mapper.MailIdMapper;

import com.postoffice.postofficemanagement.mapper.PassBookMapper;
import com.postoffice.postofficemanagement.mapper.ProfileMapper;
import com.postoffice.postofficemanagement.mapper.RecurringMapper;
import com.postoffice.postofficemanagement.mapper.RecurringPaymentMapper;
import com.postoffice.postofficemanagement.mapper.RegisterDateViewMapper;
import com.postoffice.postofficemanagement.mapper.RegisterViewMapper;
import com.postoffice.postofficemanagement.mapper.UserMapper;
import com.postoffice.postofficemanagement.mapper.RegisteredPaymentMapper;
import com.postoffice.postofficemanagement.mapper.RegisteredPostMapper;
import com.postoffice.postofficemanagement.mapper.RegisteredSearchMapper;
import com.postoffice.postofficemanagement.mapper.SeniorCitizenMapper;
import com.postoffice.postofficemanagement.mapper.SeniorCitizenPaymentMapper;
import com.postoffice.postofficemanagement.mapper.SeniorDateViewMapper;
import com.postoffice.postofficemanagement.mapper.SpedPaymentMapper;
import com.postoffice.postofficemanagement.mapper.SpeedDateViewMapper;
import com.postoffice.postofficemanagement.mapper.SpeedMapper;
import com.postoffice.postofficemanagement.mapper.TimeDateViewMapper;
import com.postoffice.postofficemanagement.mapper.TimeMapper;
import com.postoffice.postofficemanagement.mapper.TimePaymentMapper;
import com.postoffice.postofficemanagement.mapper.UserLoginMapper;
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
import com.postoffice.postofficemanagement.util.ConnectionUtil;


public class PostDao implements PostInterface {

	
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();

	Logger logger = LoggerFactory.getLogger(PostDao.class);

	public void saveDetails(UserModel register,HttpSession session) {
		logger.info("Insert Register");
		String userName=register.getUserName();
		String save = "insert into UserModel(user_name,password,mobile_no,mail_id,account_no,address)values(?,?,?,?,?,?)";
		Object[] params = {register.getUserName(), register.getPassword(),
				register.getMobileNo(), register.getMailId(),register.getAccountNo(), register.getAddress() };
		Integer row=jdbcTemplate.update(save, params); 
		if(row==1) {
		session.setAttribute("UserName", register.getUserName());
		session.setAttribute("AccountNo", register.getAccountNo());
		String query = "select user_name,account_no from UserModel where user_name=?";
		List<UserModel> userList = jdbcTemplate.query(query, new AccountNoMapper(), userName);
		for (UserModel userli : userList) {
			Long accNo = userli.getAccountNo();
			session.setAttribute("AccountNo", accNo);
		}
		}else
			logger.error("not inserted");
		
	  }
	
	public void mobileNoExist(Long mobileNo) throws DuplicationOfMobileException {
		String query = "select mobile_no from Registers";
		List<UserModel> regList = jdbcTemplate.query(query, new UserMapper());
		for (UserModel registers : regList) {
			Long mobNo = registers.getMobileNo();
			if (mobNo.equals(mobileNo)) {
				throw new DuplicationOfMobileException();
			} else {
				logger.info("Continue");
			}
		}
	}
	public void mailIdExist(String mailId ) throws  DuplicationOfMailIdException {	
		String query = "select mail_id from Registers";
		List<UserModel> regList = jdbcTemplate.query(query, new MailIdMapper());
		for (UserModel registers : regList) {
			String email = registers.getMailId();
			if (email.equals(mailId)) {
				throw new DuplicationOfMailIdException();	
			} else {
				logger.info("Continue");
			}
		}
	}

	public void listRegisterPostUserProfile(Model model,HttpSession session)  {
		String userName=session.getAttribute("UserName").toString();
		String sql = "select sender_name,sender_mobile_no,sender_address,parcel_weight,receiver_name,receiver_mobile_no,receiver_address,booking_date,tracking_no,status,parcel_charge from RegisteredPost where sender_name=?";
		List<RegisteredPostModel>registerList=jdbcTemplate.query(sql,new RegisteredPostMapper(),userName);
		   List<Map<String,Object>>registeredUserList=new ArrayList<>();
		   for(RegisteredPostModel registered:registerList) {
				 Map<String,Object>registerMap=new HashMap<>();
				 registerMap.put("sender_name",registered.getSendUserName());
				 registerMap.put("sender_mobile_no", registered.getSendUserMobileNo());
				 registerMap.put("sender_address",registered.getSendUserAddress());
				 registerMap.put("parcel_weight",registered.getParcelWeight() );
				 registerMap.put("receiver_name", registered.getReceiveUserName());
				 registerMap.put("receiver_mobile_no",registered.getReceiveUserMobileNo());
				 registerMap.put("receiver_address",registered.getReceiveUserAddress());
				 registerMap.put("booking_date", registered.getBookingDate());
				 registerMap.put("tracking_no", registered.getTrackingNo());
				 registerMap.put("parcelStatus",registered.getTrackingStatus());
				 registerMap.put("parcelCharge",registered.getParcelCharge());
				 registeredUserList.add(registerMap);
		}
		   
		  
		   
		   model.addAttribute("registeredPostUserList",registeredUserList);
			 
		
	}
	
	public void listspeedPostUserProfile(Model model,HttpSession session) {
		String userName=session.getAttribute("UserName").toString();

		String sql = "select sender_name,sender_mobile_no,sender_address,kms,receiver_name,receiver_mobile_no,receiver_address,booking_date,tracking_no,status,parcel_Charge  from SpeedPost where sender_name=?";
		List<SpeedPostModel>speedList=jdbcTemplate.query(sql,new SpeedMapper(),userName);
		   List<Map<String,Object>>speedUserList=new ArrayList<>();
		   for(SpeedPostModel speed:speedList) {
				 Map<String,Object>speedMap=new HashMap<>();
				 speedMap.put("senderName",speed.getSenderName() );
				 speedMap.put("senderMobileNo", speed.getSenderMobileNo());
				 speedMap.put("senderUserAddress",speed.getSenderAddress());
				 speedMap.put("kms",speed.getKms());
				 speedMap.put("receiveUserName", speed.getReceiverName());
				 speedMap.put("receiveUserMobileNo",speed.getReceiverMobileNo());
				 speedMap.put("receiverUserAddress",speed.getReceiverAddress() );
				 speedMap.put("bookDate", speed.getBookingDate());
				 speedMap.put("trackingCode", speed.getTrackingNo());
				 speedMap.put("parcel_status",speed.getStatus());
				 speedMap.put("charge",speed.getCharge());
				 speedUserList.add(speedMap);       
		}
		   
		   
			
		   model.addAttribute("speedPostUserList",speedUserList);
			
		
	}

	public List<RecurringDepositModel> listRecurringDepositPassbook(Model model,HttpSession session) throws JsonProcessingException {
		String userName=session.getAttribute("UserName").toString();
		
		String sql = "select user_name,mobile_no,account_no,principle_amount,no_of_months,deposit_date,return_date,interest,maturity_amount,total_amount from RecurringDeposit where user_name=? ";
		 List<RecurringDepositModel>recuringList=jdbcTemplate.query(sql,new  RecurringMapper(),userName);
	       List<Map<String,Object>>recurringDepositList=new ArrayList<>();
	       for(RecurringDepositModel recurringDepositModel:recuringList) {
	           Map<String,Object>recurringMap=new HashMap<>();
	           recurringMap.put("customerName",recurringDepositModel.getDeposituserName() );
	           recurringMap.put("contactNo", recurringDepositModel.getDepositUserMobileNo());
	           recurringMap.put("accountNumber",recurringDepositModel.getUserAccountNumber());
	           recurringMap.put("principleAmount",recurringDepositModel.getDepositAmount());
	           recurringMap.put("noOfMonths",recurringDepositModel.getNoOfMonths());
	           recurringMap.put("depositDate",recurringDepositModel.getDepositDate());
	           recurringMap.put("amountReturnDate",recurringDepositModel.getDepositReturnDate());

	           recurringMap.put("Interest",recurringDepositModel.getInterest());
	           recurringMap.put("maturityAmount",recurringDepositModel.getMaturityAMount());
	           recurringMap.put("totalAmount",recurringDepositModel.getTotalAmount());
	           recurringDepositList.add(recurringMap);
	          
	       }
	       ObjectMapper recurMapper = new ObjectMapper();
	        String recurAction = recurMapper.writeValueAsString(recurringDepositList);	
			
	       
	       List<Map<String, Object>> recur=recurringDepositList.stream().toList();
	       model.addAttribute("recurringDepositList",recur);
		return recuringList;
	}
    
	public List<TimeDepositModel> listTimeDepositPassbook(Model model,HttpSession session) {
		String userName=session.getAttribute("UserName").toString();
		
		String sql = "select user_name,mobile_no,account_no,principle_amount,periods,deposit_date,return_date,interest,maturity_amount,total_amount from TimeDeposit where user_name=?";
		 List<TimeDepositModel>timeList=jdbcTemplate.query(sql,new  TimeMapper(),userName);
	       List<Map<String,Object>>timeDepositList=new ArrayList<>();
	       for(TimeDepositModel timeDepositModel:timeList) {
	           Map<String,Object>timeMap=new HashMap<>();
	           timeMap.put("depositUserName",timeDepositModel.getName() );
	           timeMap.put("mobNo", timeDepositModel.getPhoneNo());
	           timeMap.put("acctNumber",timeDepositModel.getAccountNo());
	           timeMap.put("initialAmount",timeDepositModel.getAmount());
	           timeMap.put("periods",timeDepositModel.getPeriods());
	           timeMap.put("paymentDate",timeDepositModel.getDepositDate());
	           timeMap.put("depsoitReturnDate",timeDepositModel.getCompletedate());
	           timeMap.put("simple_interest",timeDepositModel.getSimpleInterest());
	           timeMap.put("paymentMaturity",timeDepositModel.getMaturity());
	           timeMap.put("totalPayment",timeDepositModel.getTotal());
	           timeDepositList.add(timeMap);
		
 }
	       List<Map<String, Object>> time=timeDepositList.stream().toList();
	       model.addAttribute("timeDepositUsersList",time);
		return timeList;
		
		
		
	}

	public List<SeniorCitizenModel> listSeniorCitizenDepositPassbook(Model model,HttpSession session) {
		String userName=session.getAttribute("UserName").toString();
		
		String sql = "select  user_name,mobile_no,account_no,principle_amount,age,deposit_date,return_date,interest,maturity_amount,total_amount from SeniorCitizenDeposit where user_name=?";
		List<SeniorCitizenModel>seniorList=jdbcTemplate.query(sql,new  SeniorCitizenMapper(),userName);
	       List<Map<String,Object>>seniorDepositList=new ArrayList<>();
	       for(SeniorCitizenModel seniorCitizenModel:seniorList) {
	           Map<String,Object>seniorMap=new HashMap<>();
	           seniorMap.put("accountHolderName",seniorCitizenModel.getCustomerName() );
	           seniorMap.put("mobNumber", seniorCitizenModel.getCustomermobileNo());
	           seniorMap.put("accountNum",seniorCitizenModel.getCustomeraccountNo());
	           seniorMap.put("money",seniorCitizenModel.getDepositAmount());
	           seniorMap.put("age",seniorCitizenModel.getAge());
	           seniorMap.put("amountPaymentDate",seniorCitizenModel.getAmountDepositDate());
	           seniorMap.put("amountReDate",seniorCitizenModel.getReturnDate());

	           seniorMap.put("interestAmount",seniorCitizenModel.getSimpleInterest());
	           seniorMap.put("maturity_amount",seniorCitizenModel.getPaymentMaturity());
	           seniorMap.put("total_amount",seniorCitizenModel.getAmountTotal());
	           
	           
	           seniorDepositList.add(seniorMap);
	           
}			
	       List<Map<String, Object>> senior=seniorDepositList.stream().toList();
	       model.addAttribute("SeniorUsersList",senior);
		return seniorList;
		
			
	}

	public boolean userLogin(UserModel register,HttpSession session ) {	
		String userName = register.getUserName();
	    String password = register.getPassword();

		logger.info("To Login User");
		String query = "select user_name,password,account_no from UserModel where user_name=?";
		List<UserModel> userList = jdbcTemplate.query(query, new UserLoginMapper(), userName);
		
		session.setAttribute("UserName", userName);
		
		for (UserModel userli : userList) {
			String pass = userli.getPassword();
			if (pass.equals(password)) {
				logger.info("Login Successully");
				Long accNo =  userli.getAccountNo();
				session.setAttribute("AccountNo", accNo);
				return true;
			} 
				
		}
		return false;
	}

	public void adminLogin(AdminModel admin ) throws InvalidLoginException {
		logger.info("To Login Admin");
		
		String adminId=admin.getMailId();
		String adminPass=admin.getPassword();
		
		
		String query = "select mail_id,password from Admin where mail_id=?";
		List<AdminModel> adminList = jdbcTemplate.query(query, new AdminLoginMapper(), adminId);
			logger.info("Hello");
			
			for(AdminModel adminli : adminList) {
				
				String adMail=adminli.getMailId();
				if (adMail.equals(adminId)) {
				String adPass=adminli.getPassword();	
			
				if (adPass.equals(adminPass)) {
					logger.info("Login Successfully!!!...");
				}
				}
			 else {

				throw new InvalidLoginException();
			}
			}	
			throw new InvalidLoginException();
	}
	
	public Integer totalRecurringCount() {
		String sql="select count (*) from RecurringDeposit";
		return jdbcTemplate.queryForObject(sql,Integer.class);	
	}
	
	public Integer totalTimeCount() {
		String sql="select count (*) from TimeDeposit";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public Integer totalSeniorCount() {
		String sql="select count (*) from SeniorCitizenDeposit";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public Integer totalRegisteredCount() {
		String sql="select count (*) from RegisteredPost";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public Integer totalSpeedCount() {
		String sql="select count (*) from SpeedPost";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
    public void recurringCount(HttpSession session,Model model) {
    	Long acctNo=(Long)session.getAttribute("AccountNo");
		String sql="  select count (*) from RecurringDeposit where account_no=?" ;
		int count=jdbcTemplate.queryForObject(sql, Integer.class,acctNo);
		model.addAttribute("count", count);
		session.setAttribute("Count", count);
    }
	public void saveRecurringDepositDetails(RecurringDepositModel recurringDeposit,HttpSession session) {
		

		String save = "insert into RecurringDeposit(user_name,mobile_no,account_no,principle_amount,no_of_months,deposit_date,return_date,interest,maturity_amount,total_amount)values(?,?,?,?,?,localtimestamp,add_months(sysdate,?),?,?,?)";
		Object[] params = {  recurringDeposit.getDeposituserName(),
		recurringDeposit.getDepositUserMobileNo() ,recurringDeposit.getUserAccountNumber(),
		recurringDeposit.getDepositAmount(),recurringDeposit.getNoOfMonths(),recurringDeposit.getNoOfMonths(),recurringDeposit.getInterest(),recurringDeposit.getMaturityAMount(),recurringDeposit.getTotalAmount()};
		jdbcTemplate.update(save, params);
		
		session.setAttribute("UserName",recurringDeposit.getDeposituserName());
		session.setAttribute("accountNo",recurringDeposit.getUserAccountNumber());
		session.setAttribute("paidAmount",recurringDeposit.getDepositAmount() );
		session.setAttribute("mobileNo", recurringDeposit.getDepositUserMobileNo());
		session.setAttribute("months", recurringDeposit.getNoOfMonths());
		session.setAttribute("interest", recurringDeposit.getInterest());
		session.setAttribute("maturity", recurringDeposit.getMaturityAMount());
		session.setAttribute("total", recurringDeposit.getTotalAmount());
		
		String sql1="select deposit_date,return_date from RecurringDeposit where account_no=?";
		  
		  List<RecurringDepositModel>registerView=jdbcTemplate.query(sql1,new DateViewMapper(),recurringDeposit.getUserAccountNumber());
		  List<Map<String,Object>>viewList=new ArrayList<>();
		  for(RecurringDepositModel register:registerView) {
				 Map<String,Object>regMap=new HashMap<>();
				 
					session.setAttribute("date",register.getDepositDate());
					session.setAttribute("reDate", register.getDepositReturnDate() );

				
		          
			}
	
	}
	
	public void reccuringInterest(RecurringDepositModel recurringDeposit) {
		logger.info("Interest");     
	}

	 public void saveTimeDepositDetails(TimeDepositModel timeDeposit,HttpSession session) {
		logger.info("Insert Time Deposit Details");
		String save = "insert into TimeDeposit(user_name,mobile_no,account_no,principle_amount,periods,deposit_date,return_date,interest,maturity_amount,total_amount)values(?,?,?,?,?,localtimestamp,add_months(sysdate,?),?,?,?)";
		Integer period=timeDeposit.getPeriods()*12;
		Object[] params = { timeDeposit.getName(), timeDeposit.getPhoneNo(),
				timeDeposit.getAccountNo(), timeDeposit.getAmount(),timeDeposit.getPeriods(),period,timeDeposit.getSimpleInterest(),timeDeposit.getMaturity(),timeDeposit.getTotal() };
		jdbcTemplate.update(save, params);
		
		session.setAttribute("UserName",timeDeposit.getName());
		session.setAttribute("mobileNo", timeDeposit.getPhoneNo());
		session.setAttribute("accountNo",timeDeposit.getAccountNo());
		session.setAttribute("depositAmount",timeDeposit.getAmount() );
		session.setAttribute("period", timeDeposit.getPeriods());
		session.setAttribute("interest", timeDeposit.getSimpleInterest());
		session.setAttribute("maturity", timeDeposit.getMaturity());
		session.setAttribute("total", timeDeposit.getTotal());
		
		String sql="select deposit_date,return_date from TimeDeposit where account_no=?";
		  
		  List<TimeDepositModel>registerView=jdbcTemplate.query(sql,new TimeDateViewMapper(),timeDeposit.getAccountNo());
		  List<Map<String,Object>>viewList=new ArrayList<>();
		  for(TimeDepositModel time:registerView) {
				 Map<String,Object>regMap=new HashMap<>();
				 
					session.setAttribute("date",time.getDepositDate());
					session.setAttribute("returnDate", time.getCompletedate() );

				
		          
			}
	

	}
	
	public void saveSeniorCitizenDetail(SeniorCitizenModel seniorCitizen,HttpSession session) {
		logger.info("Insert Senior Citizen Details");
		String save = "insert into SeniorCitizenDeposit(user_name,mobile_no,account_no,principle_amount,age,deposit_date,return_date,interest,maturity_amount,total_amount)values(?,?,?,?,?,localTimeStamp,add_months(sysdate,60),?,?,?)";
		Object[] params = {  seniorCitizen.getCustomerName(), seniorCitizen.getCustomermobileNo(),
				seniorCitizen.getCustomeraccountNo(),seniorCitizen.getDepositAmount(),seniorCitizen.getAge(),seniorCitizen.getSimpleInterest(),seniorCitizen.getPaymentMaturity(),seniorCitizen.getAmountTotal() };
		jdbcTemplate.update(save, params);	
		session.setAttribute("UserName",seniorCitizen.getCustomerName());
		session.setAttribute("mobNo", seniorCitizen.getCustomermobileNo());
		session.setAttribute("acctNo",seniorCitizen.getCustomeraccountNo());
		session.setAttribute("PaymentAmount",seniorCitizen.getDepositAmount() );
		session.setAttribute("age", seniorCitizen.getAge());
		session.setAttribute("simepleInterest", seniorCitizen.getSimpleInterest());
		session.setAttribute("totalMaturity", seniorCitizen.getPaymentMaturity());
		session.setAttribute("totalAmount", seniorCitizen.getAmountTotal());
		
		String sql="select deposit_date,return_date from SeniorCitizenDeposit where account_no=?";
		  
		  List<SeniorCitizenModel>registerView=jdbcTemplate.query(sql,new SeniorDateViewMapper(),seniorCitizen.getCustomeraccountNo());
		  List<Map<String,Object>>viewList=new ArrayList<>();
		  for(SeniorCitizenModel senior:registerView) {
				 Map<String,Object>regMap=new HashMap<>();
				 
					session.setAttribute("startdate",senior.getAmountDepositDate());
					session.setAttribute("completeDate", senior.getReturnDate() );

				
		          
			}
	
	}

	public void saveRegisterPostDetail(RegisteredPostModel registerPost,HttpSession session) {
		logger.info("Insert Registered Post Details");
		String save = "insert into RegisteredPost(sender_name,sender_mobile_no,sender_address,parcel_weight,receiver_name,receiver_mobile_no,receiver_address,booking_date,status,parcel_charge)values(?,?,?,?,?,?,?,localtimestamp,'sending',?)";
		
		Object[] params = { registerPost.getSendUserName(), registerPost.getSendUserMobileNo(),
		registerPost.getSendUserAddress(), registerPost.getParcelWeight(),registerPost.getReceiveUserName(),registerPost.getReceiveUserMobileNo(), registerPost.getReceiveUserAddress(),registerPost.getParcelCharge()};
		jdbcTemplate.update(save, params);
		session.setAttribute("userName",registerPost.getSendUserName());
		
		session.setAttribute("senderMobile",registerPost.getSendUserMobileNo());
		
		session.setAttribute("senderAddress",registerPost.getSendUserAddress());
		
		session.setAttribute("parcelWeight",registerPost.getParcelWeight());	
		
		session.setAttribute("receiverName",registerPost.getReceiveUserName());
		
		session.setAttribute("receiverMobileNo",registerPost.getReceiveUserMobileNo());	
		
		session.setAttribute("receiverAddress",registerPost.getReceiveUserAddress());	
		
		session.setAttribute("ChargeAmount", registerPost.getParcelCharge());
		
		
		String sql="select tracking_no,booking_date from RegisteredPost  where sender_name=?";
		  
		  List<RegisteredPostModel>registerView=jdbcTemplate.query(sql,new RegisterDateViewMapper(),registerPost.getSendUserName());
		  List<Map<String,Object>>viewList=new ArrayList<>();
		  for(RegisteredPostModel senior:registerView) {
				 Map<String,Object>regMap=new HashMap<>();
				 
				 session.setAttribute("bookingDate", senior.getBookingDate());
					
					session.setAttribute("trackingNo", senior.getTrackingNo());
					
					
		  }	
	}
	
	public void reached(RegisteredPostModel registeredPostModel) {
		
		Integer trackingNo=registeredPostModel.getTrackingNo();
		String save="update RegisteredPost set status ='Delivered' where tracking_no=?";
		
		Object[] params= {trackingNo};
		jdbcTemplate.update(save,params);
	
	 }
	
     public void processing(RegisteredPostModel registeredPostModel) {	
    	Integer trackNo=registeredPostModel.getTrackingNo();
		String save="update RegisteredPost set status ='Processing' where tracking_no=?";
		Object[] params= {trackNo};
		jdbcTemplate.update(save,params);
	  }
     

    public void speedReached(SpeedPostModel speedPostModel) {
 	  Integer trackingNo=speedPostModel.getTrackingNo();
      String save="update SpeedPost set status ='Delivered' where tracking_no=?";
 	  Object[] params= {trackingNo};
 	  jdbcTemplate.update(save,params);
     }

    public void speedProcessing(SpeedPostModel speedPostModel) {
    	Integer trackNo=speedPostModel.getTrackingNo();
 	  String save="update SpeedPost set status ='Processing' where tracking_no=?";
 	  Object[] params= { trackNo};
 	  jdbcTemplate.update(save,params);
    } 

    public void trackView(RegisteredPostModel reg,HttpSession session) {
	  String save="select status from RegisteredPost where tracking_id=?";
	  Object[] params  = {reg.getTrackingNo()};
	  session.setAttribute("status",reg.getTrackingStatus() );
	  jdbcTemplate.update(save, params);	
    }

    public List<RegisteredPostModel> view(RegisteredPostModel registeredPost,Model model)   {
    	
      Integer trackingNo=registeredPost.getTrackingNo();
	  String sql="select status from RegisteredPost where tracking_no=?";
	  
	  List<RegisteredPostModel>registerView=jdbcTemplate.query(sql,new RegisterViewMapper(),trackingNo);
	  List<Map<String,Object>>viewList=new ArrayList<>();
	  for(RegisteredPostModel register:registerView) {
			 Map<String,Object>regMap=new HashMap<>();
			 regMap.put("status",register.getTrackingStatus() );
	  
			 viewList.add(regMap);
	          
		}
		   model.addAttribute("registerView",viewList);
			 return registerView;
	 
	}

    public String speedview(SpeedPostModel speedPost)  {
    	
    	Integer trackingNo=speedPost.getTrackingNo();
	  String sql="select status from SpeedPost where tracking_no=?";
	
	  String queryForObject=null;
	
	try {
		queryForObject=jdbcTemplate.queryForObject(sql, String.class,trackingNo);
		logger.info(queryForObject);
	} catch
	
	(EmptyResultDataAccessException e) {
		logger.info("view");
	}
	return queryForObject;			
	}

   public String tracking(Integer trackingNo) {
	 String sql = "select  status from RegisteredPost where trackingId=?";
     String queryForObject = null;
     queryForObject = jdbcTemplate.queryForObject(sql, String.class, trackingNo);
     return queryForObject;
     }

   public void chargeCalculation(RegisteredPostModel register) {
	 logger.info("cahrge Calculation");
    
    }

	public void saveSpeedPostDetail(SpeedPostModel speedPost ,HttpSession session) {
		logger.info("Insert Speed Post Details");
		String save = "insert into SpeedPost(sender_name,sender_mobile_no,sender_address,kms,receiver_name,receiver_mobile_no,receiver_address,booking_date,status,parcel_charge)values(?,?,?,?,?,?,?,localtimestamp,'sending',?)";	
		Object[] params = {  speedPost.getSenderName(), speedPost.getSenderMobileNo(),
		speedPost.getSenderAddress(), speedPost.getKms(),
		speedPost.getReceiverName(), speedPost.getReceiverMobileNo(), speedPost.getReceiverAddress(),speedPost.getCharge()};
		jdbcTemplate.update(save, params);	
		session.setAttribute("UserName",speedPost.getSenderName() );
		session.setAttribute("charge",speedPost.getCharge() );		
        session.setAttribute("senderMobileNumber", speedPost.getSenderMobileNo());   
		session.setAttribute("senderAddress",speedPost.getSenderAddress());
		
		session.setAttribute("kms",speedPost.getKms());	
		
		session.setAttribute("receiverName",speedPost.getReceiverName());
		
		session.setAttribute("receiverMobileNo",speedPost.getReceiverMobileNo());	
		
		session.setAttribute("receiverAddress",speedPost.getReceiverAddress());	
		
		session.setAttribute("ChargeAmount", speedPost.getCharge());
		
		
		String sql="select tracking_no,booking_date from SpeedPost  where sender_name=?";
		  
		  List<SpeedPostModel>registerView=jdbcTemplate.query(sql,new SpeedDateViewMapper(),speedPost.getSenderName());
		  List<Map<String,Object>>viewList=new ArrayList<>();
		  for(SpeedPostModel senior:registerView) {
				 Map<String,Object>regMap=new HashMap<>();
				 
				 session.setAttribute("bookingDate", senior.getBookingDate());
					
					session.setAttribute("trackingNo",senior.getTrackingNo());
					
		  }	
	}
	
	public void speedChargeCalculation(SpeedPostModel speedPost) {
       logger.info("speed Calculation");
    }

	public void saveTrcakingDetails(TrackingModel tracking) {
		String save = "insert into UserTracking(tracking_id,booking_date,status)values(?,localtimestamp,?)";
		Object[] params = { tracking.gettrackingNo(), tracking.getStatus() };
		jdbcTemplate.update(save, params);
      }
	

	@Override
	public void recurringPayment(RecurringPayment recurringPayment,HttpSession session) {
       logger.info("recurring Payment");
	   String save="insert into RecurringPayment(user_name,amount,payment_date)values(?,?,localtimestamp)";
	   recurringPayment.getDepositUserName();
	   recurringPayment.getRecurPrincipleAmount();
	   Object[] params  = {recurringPayment.getDepositUserName(),recurringPayment.getRecurPrincipleAmount()};
	   jdbcTemplate.update(save, params);
	   
		session.setAttribute("paidAmount",recurringPayment.getRecurPrincipleAmount() );
      }

	public void timePayment(TimeDepositPayment timePayment) {
		String save="insert into TimeDepositPayment(user_name,amount,payment_date)values(?,?,localtimestamp)";
		Object[] params  = { timePayment.getUserName(),timePayment.getAmount() };
		jdbcTemplate.update(save, params);
	}
	
	public void seniorPayment(SeniorCitizenPayment seniorPayment) {
		String save="insert into SeniorCitizenPayment(user_name,amount,payment_date)values(?,?,localtimestamp)";
		Object[] params  = { seniorPayment.getCustomerName(),seniorPayment.getDepositAmount1()};
		
		jdbcTemplate.update(save, params);
	}
	
	public List<RecurringPayment> listRecurringDepositPaidUser(Model model) {
		String sql = "select user_name,amount,payment_date from RecurringPayment";
	        List<RecurringPayment>recurList=jdbcTemplate.query(sql,new  RecurringPaymentMapper());
	       List<Map<String,Object>>recurPayList=new ArrayList<>();
	       for(RecurringPayment recurring:recurList) {
	           Map<String,Object>customerMap=new HashMap<>();
	           customerMap.put("userName",recurring.getDepositUserName() );
	           customerMap.put("depositAmount", recurring.getRecurPrincipleAmount());
	           customerMap.put("paidDate",recurring.getDepositDate());
	           recurPayList.add(customerMap);
	          
	       }
	       
	       model.addAttribute("recurringPaymentList",recurPayList);
		return recurList;

	     
	}

	public List<TimeDepositPayment> listTimeDepositPaidUser(Model model) {
		String sql = "select user_name,amount,payment_date from TimeDepositPayment";
		List<TimeDepositPayment>timeList=jdbcTemplate.query(sql,new TimePaymentMapper());
		 List<Map<String,Object>>timePayList=new ArrayList<>();
		 for(TimeDepositPayment time:timeList) {
			 Map<String,Object>userMap=new HashMap<>();
			 userMap.put("name",time.getUserName() );
			 userMap.put("depositPaidAmount", time.getAmount());
			 userMap.put("amountPaidDate",time.getPaymentDate());
			 timePayList.add(userMap);
	          
		 }
		 model.addAttribute("timePaymentList",timePayList);
		 return timeList;
	}
	
	public List<SeniorCitizenPayment> listSeniorCitizenDepositPaidUser(Model model) {
	   String sql = "select  user_name,amount,payment_date from SeniorCitizenPayment";
	   List<SeniorCitizenPayment>seniorList=jdbcTemplate.query(sql,new SeniorCitizenPaymentMapper());
	   List<Map<String,Object>>seniorPayList=new ArrayList<>();
	   for(SeniorCitizenPayment senior:seniorList) {
			 Map<String,Object>userMap=new HashMap<>();
			 userMap.put("customName",senior.getCustomerName() );
			 userMap.put("paidAmount", senior.getDepositAmount1());
			 userMap.put("paidDate",senior.getPaidDate());
			 seniorPayList.add(userMap);
	           
	}
	   model.addAttribute("seniorPaymentList",seniorPayList);
		 return seniorList;
	}
	
	public void registerPostPayment(RegisteredPostPaymentModel registerPayment) {
		String save="insert into registeredPayment(sender_name,amount,status,paid_date)values(?,?,'Sending',localtimestamp)";
		String name=registerPayment.getRegisteredPostUserName();
		float amount=registerPayment.getRegisteredPostParcelCharge();
		Object[] params  = {name,amount};
		jdbcTemplate.update(save, params);	
	}
	
	public void speedPostPayment(SpeedPostPaymentModel speedPayment) {
		String save="insert into SpeedPayment(sender_name,amount,status,paid_date)values(?,?,'sending',localtimestamp)";
		Object[] params  = { speedPayment.getPostSenderName(),speedPayment.getCharge() };
		jdbcTemplate.update(save, params);
	}
	
	public void listRegisteredPostPaidUser(Model model) throws JsonProcessingException {
		String sql = "select sender_name,amount,trcaking_no,status,paid_date from registeredPayment";
		List<RegisteredPostPaymentModel>registerPaymentList=jdbcTemplate.query(sql, new RegisteredPaymentMapper());
		List<Map<String,Object>>regPay=new ArrayList<>();
		for(RegisteredPostPaymentModel registered:registerPaymentList) {
			Map<String,Object>regPayMap=new HashMap<>();
			
			regPayMap.put("user_name",registered.getRegisteredPostUserName() );
			regPayMap.put("amount", registered.getRegisteredPostParcelCharge());
			regPayMap.put("trackCode", registered.getRegistertrackNo());
			regPayMap.put("status1", registered.getRegisteredPostStatus());
			regPayMap.put("payment_date",registered.getParcelPaidDate());
			regPay.add(regPayMap);
			
		}
		
		ObjectMapper registeredMapper = new ObjectMapper();
        String registeredAction = registeredMapper.writeValueAsString(regPay);
		
		model.addAttribute("registeredPaymentList",registeredAction);
		
	}
	
	public void listSpedPostPaidUser(Model model) throws JsonProcessingException {
		String sql = "select sender_name,amount,tracking_no,status,paid_date from SpeedPayment";
		List<SpeedPostPaymentModel>speedPaymentList=jdbcTemplate.query(sql, new SpedPaymentMapper());
		List<Map<String,Object>>regPay=new ArrayList<>();
		for(SpeedPostPaymentModel speed:speedPaymentList) {
			Map<String,Object>speedPayMap=new HashMap<>();
			speedPayMap.put("user_name",speed.getPostSenderName() );
			speedPayMap.put("amount", speed.getCharge());
			speedPayMap.put("track_no", speed.getTrackingNo());
			speedPayMap.put("status2", speed.getSpeedPostStatus());
			speedPayMap.put("payment_date",speed.getPayDate());
			regPay.add(speedPayMap);
			
		}
		
		ObjectMapper spedMapper = new ObjectMapper();
        String speedAction = spedMapper.writeValueAsString(regPay);
		model.addAttribute("speedPaymentList",speedAction);
		
				
	}

	@Override
	public Integer totalUserCount() {
		logger.info("TotalUserCount");
		return null;
	}

	@Override
	public void userView(RegisteredPostModel reg, HttpSession session) {
		logger.info("user");
	}
    public void passwordChange(UserModel register ) {
	  String sql="update UserModel set password=? where user_name=?";
	  
	  Object[] params= {register.getPassword(),register.getUserName()};
	  jdbcTemplate.update(sql, params);
    }
    public List<RecurringPayment> passBookDetails() {
	  String sql="select user_name,amount,payment_date from RecurringPayment where user_name=?";
	  return jdbcTemplate.query(sql, new PassBookMapper());
    }
  
    public  List<RegisteredPostModel> registerPostSearch(String search)  {
	  String query="select sender_name,sender_mobile_no,sender_address,parcel_weight,receiver_name,receiver_mobile_no,receiver_address,booking_date,tracking_no,status from RegisteredPost where status like ? or booking_date like ? or sender_name like ?";
	  return jdbcTemplate.query(query,new RegisteredSearchMapper(),search,search,search);
    }
    
    public List<RecurringDepositModel> listRecurringDepositUser(Model model) throws JsonProcessingException {
		String sql = "select user_name,mobile_no,account_no,principle_amount,no_of_months,deposit_date,return_date,interest,maturity_amount,total_amount from RecurringDeposit";
		 List<RecurringDepositModel>recuringList=jdbcTemplate.query(sql,new  RecurringMapper());
	       List<Map<String,Object>>recurringDepositList=new ArrayList<>();
	       for(RecurringDepositModel recurringDepositModel:recuringList) {
	           Map<String,Object>recurringMap=new HashMap<>();
	           recurringMap.put("customerName",recurringDepositModel.getDeposituserName() );
	           recurringMap.put("contactNo", recurringDepositModel.getDepositUserMobileNo());
	           recurringMap.put("accountNumber",recurringDepositModel.getUserAccountNumber());
	           recurringMap.put("principleAmount",recurringDepositModel.getDepositAmount());
	           recurringMap.put("noOfMonths",recurringDepositModel.getNoOfMonths());
	           recurringMap.put("depositDate",recurringDepositModel.getDepositDate());
	           recurringMap.put("depositReturnDate", recurringDepositModel.getDepositReturnDate());
	           recurringMap.put("InterestAmount",recurringDepositModel.getInterest());
	           recurringMap.put("maturityAmount",recurringDepositModel.getMaturityAMount());
	           recurringMap.put("amountTotal",recurringDepositModel.getTotalAmount());
	           recurringDepositList.add(recurringMap);
	          
	       }
	       ObjectMapper recurMapper = new ObjectMapper();
	        String recurAction = recurMapper.writeValueAsString(recurringDepositList);	
			       
	       model.addAttribute("recurringDepositList",recurAction);
		   return recuringList;
	}
    
    public List<TimeDepositModel> listTimeDepositUser(Model model) throws JsonProcessingException {
		String sql = "select user_name,mobile_no,account_no,principle_amount,periods,deposit_date,return_date,interest,maturity_amount,total_amount from TimeDeposit";
		 List<TimeDepositModel>timeList=jdbcTemplate.query(sql,new  TimeMapper());
	       List<Map<String,Object>>timeDepositList=new ArrayList<>();
	       for(TimeDepositModel timeDepositModel:timeList) {
	           Map<String,Object>timeMap=new HashMap<>();
	           timeMap.put("depositUserName",timeDepositModel.getName() );
	           timeMap.put("phoneNo", timeDepositModel.getPhoneNo());
	           timeMap.put("acctNumber",timeDepositModel.getAccountNo());
	           timeMap.put("initialAmount",timeDepositModel.getAmount());
	           timeMap.put("periods",timeDepositModel.getPeriods());
	           timeMap.put("paymentDate",timeDepositModel.getDepositDate());
	           timeMap.put("return_date",timeDepositModel.getCompletedate());
	           timeMap.put("simple_interest",timeDepositModel.getSimpleInterest());
	           timeMap.put("amountMaturity",timeDepositModel.getMaturity());
	           timeMap.put("totalPayment",timeDepositModel.getTotal());
	           timeDepositList.add(timeMap);
		
 }
	       ObjectMapper timeMapper = new ObjectMapper();
	        String timeAction = timeMapper.writeValueAsString(timeDepositList);	
	       model.addAttribute("timeDepositUsersList",timeAction);
		return timeList;
		
		
		
	}
    public List<SeniorCitizenModel> listSeniorCitizenDepositUser(Model model) throws JsonProcessingException {
		String sql = "select  user_name,mobile_no,account_no,principle_amount,age,deposit_date,return_date,interest,maturity_amount,total_amount from SeniorCitizenDeposit";
		List<SeniorCitizenModel>seniorList=jdbcTemplate.query(sql,new  SeniorCitizenMapper());
	       List<Map<String,Object>>seniorDepositList=new ArrayList<>();
	       for(SeniorCitizenModel seniorCitizenModel:seniorList) {
	           Map<String,Object>seniorMap=new HashMap<>();
	           seniorMap.put("accountHolderName",seniorCitizenModel.getCustomerName() );
	           seniorMap.put("mobNumber", seniorCitizenModel.getCustomermobileNo());
	           seniorMap.put("accountNum",seniorCitizenModel.getCustomeraccountNo());
	           seniorMap.put("money",seniorCitizenModel.getDepositAmount());
	           seniorMap.put("age",seniorCitizenModel.getAge());
	           seniorMap.put("amountPaymentDate",seniorCitizenModel.getAmountDepositDate());
	           seniorMap.put("returnDate",seniorCitizenModel.getReturnDate());
	           seniorMap.put("interestAmount",seniorCitizenModel.getSimpleInterest());
	           seniorMap.put("maturity_amount",seniorCitizenModel.getPaymentMaturity());
	           seniorMap.put("total_amount",seniorCitizenModel.getAmountTotal());
	           
	           seniorDepositList.add(seniorMap);
	           
}			
	       ObjectMapper seniorMapper = new ObjectMapper();
	        String seniorAction = seniorMapper.writeValueAsString(seniorDepositList);	
	   
	       model.addAttribute("SeniorUsersList",seniorAction);
		return seniorList;
		
			
	}
    public void listRegisterPostUser(Model model) throws JsonProcessingException, DataAccessException {
		String sql = "select sender_name,sender_mobile_no,sender_address,parcel_weight,receiver_name,receiver_mobile_no,receiver_address,booking_date,tracking_no,status,parcel_charge from RegisteredPost";
		List<RegisteredPostModel>registerList=jdbcTemplate.query(sql,new RegisteredPostMapper());
		   List<Map<String,Object>>registeredUserList=new ArrayList<>();
		   for(RegisteredPostModel registered:registerList) {
				 Map<String,Object>registerMap=new HashMap<>();
				 registerMap.put("sender_name",registered.getSendUserName());
				 registerMap.put("sender_mobile_no", registered.getSendUserMobileNo());
				 registerMap.put("sender_address",registered.getSendUserAddress());
				 registerMap.put("parcel_weight",registered.getParcelWeight() );
				 registerMap.put("receiver_name", registered.getReceiveUserName());
				 registerMap.put("receiver_mobile_no",registered.getReceiveUserMobileNo());
				 registerMap.put("receiver_address",registered.getReceiveUserAddress());
				 registerMap.put("parcelDate", registered.getBookingDate());
				 registerMap.put("trackNo", registered.getTrackingNo());
				 registerMap.put("parcelStatus",registered.getTrackingStatus());
				 registerMap.put("chargeBalance",registered.getParcelCharge());
				 registeredUserList.add(registerMap);
		         
		}
		   
		   ObjectMapper registeredMapper = new ObjectMapper();
	        String registeredAction = registeredMapper.writeValueAsString(registeredUserList);
			
			
		   
		   model.addAttribute("registeredPostUserList",registeredAction);
			 
		
	}
    public void listspeedPostUser(Model model) throws JsonProcessingException {
		String sql = "select sender_name,sender_mobile_no,sender_address,kms,receiver_name,receiver_mobile_no,receiver_address,booking_date,tracking_no,status,parcel_charge  from SpeedPost";
		List<SpeedPostModel>speedList=jdbcTemplate.query(sql,new SpeedMapper());
		   List<Map<String,Object>>speedUserList=new ArrayList<>();
		   for(SpeedPostModel speed:speedList) {
				 Map<String,Object>speedMap=new HashMap<>();
				 speedMap.put("senderName",speed.getSenderName() );
				 speedMap.put("senderMobileNo", speed.getSenderMobileNo());
				 speedMap.put("senderUserAddress",speed.getSenderAddress());
				 speedMap.put("kms",speed.getKms());
				 speedMap.put("receiveUserName", speed.getReceiverName());
				 speedMap.put("receiveUserMobileNo",speed.getReceiverMobileNo());
				 speedMap.put("receiverUserAddress",speed.getReceiverAddress() );
				 speedMap.put("parcelDate", speed.getBookingDate());
				 speedMap.put("trackNo", speed.getTrackingNo());
				 speedMap.put("parcel_status",speed.getStatus());
				 speedMap.put("parcelCharge",speed.getCharge());
				 speedUserList.add(speedMap);       
		}
		   
		   ObjectMapper speedMapper = new ObjectMapper();
	        String speedAction = speedMapper.writeValueAsString(speedUserList);	
			
		   model.addAttribute("speedPostUserList",speedAction);
			
		
	}

	public void registerUserProfile(UserModel register,HttpSession session) {
		String userName=session.getAttribute("UserName").toString();
		
		String sql = "update UserModel set password=?,mobile_no=?,account_no=?,mail_id=?,address=? where user_name=?";
		Object[] params= { register.getPassword(),register.getMobileNo(),register.getAccountNo(),register.getMailId(),register.getAddress(),userName};
	 	  jdbcTemplate.update(sql,params);
	    }

	public void getProfileDetails(HttpSession session) {
		Long acctNum=(Long)session.getAttribute("AccountNo");
		String sql="select user_name,password,mobile_no,account_no,mail_id,address from UserModel where account_no=?";
		List<UserModel> userProfile=jdbcTemplate.query(sql, new ProfileMapper(),acctNum);
		
		for(UserModel profile : userProfile ) {
			
			String uName = profile.getUserName();
			session.setAttribute("UserName", uName);
			
			String pass = profile.getPassword();
			session.setAttribute("Password", pass);
			
			Long mobNo = profile.getMobileNo();
			session.setAttribute("MobileNo", mobNo);
			
			Long acctNo = profile.getAccountNo();
			session.setAttribute("AccountNo", acctNo);
			
			String mail = profile.getMailId();
			session.setAttribute("Email", mail);
			
			String add = profile.getAddress();
			session.setAttribute("Address", add);
			
		}
		
	} 
	public Boolean existingMailIdCheck(String mailId, Model model) {
        String query = "Select mail_id from UserModel where mail_id =?";
        List<UserModel> emailIdList = jdbcTemplate.query(query, new CheckExistingMailIdMapper(), mailId);
        for (UserModel checkMailId : emailIdList) {
            String mail = checkMailId.getMailId();
            if (mail.equals(mailId)) {
                String existingMail = "Error!";
                model.addAttribute("ExistingMailId7", existingMail);
                model.addAttribute("MailId", mail);
                return false;
            }
        }
        return true;
    }
	
	public Boolean existingMobileNoCheck(Long mobileNo, Model model) {
		String mobNumber=Long.toString(mobileNo);
        String query = "Select mobile_no from UserModel where mobile_no =?";
        
        List<UserModel> userMobileNoList= jdbcTemplate.query(query, new CheckExistingMobileNoMapper(), mobNumber);
        for (UserModel checkMobileNo : userMobileNoList) {
           String mobNo = checkMobileNo.getMobileNo().toString();
            if (mobNo.equals(mobNumber)) {
                String existingAMobileNo = "Error!";
                model.addAttribute("ExistingMobileNo8", existingAMobileNo);
                model.addAttribute("MobileNo", mobileNo);
                return false;
            }
        }
        return true;
    }

}
