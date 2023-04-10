package com.postoffice.postofficemanagement.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.ui.Model;




public class DepositValidation {
	// Validation for mobileNo
	public boolean mobileNoValidation1(long mobileNo,Model model)  {
		String regex = "\\d{10}";
		String mobileNo1 = Long.toString(mobileNo);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobileNo1);
		boolean b = m.matches();
		if (b) {
			return true;
		} else {
            String errorMessage = "Mobile Number Must Contain 10 digits Only and Not Contain Alphabets ";
            model.addAttribute("errorMessage1", errorMessage);
            return false;
        }
		}
	

	// Validation for aadharNo
	public boolean accountNoValidation(long accountNo,Model model) {
		String regex = "\\d{12}";
		String accountNo1 = Long.toString(accountNo);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(accountNo1);
		boolean b = m.matches();
		if (b) {
			return true;
		} else {
            String errorMessage = "Mobile Number Must Contain 10 digits Only and Not Contain Alphabets ";
            model.addAttribute("errorMessage1", errorMessage);
            return false;
        }
		}
	
		

	public boolean amountValidation(Integer amount,Model model) {
		String regex = "^0*?[1-9]\\d*$";
		String amount1 = Long.toString(amount);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(amount1);
		boolean b = m.matches();
		if (b) {
			return true;
		} else {
            String errorMessage = "Amount Does Not Contain Zero ";
            model.addAttribute("errorMessage1", errorMessage);
            return false;
        }
	
	}
	public boolean monthValidation(Integer noOfMonths,Model model) {
		String regex = "^0*?[1-9]\\d*$";
		String month = Long.toString(noOfMonths);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(month);
		boolean b = m.matches();
		if (b) {
			return true;
		}
		else {
            String errorMessage = "Months Cannot Enter Zero ";
            model.addAttribute("errorMessage1", errorMessage);
            return false;
        }
		}
	public boolean ageValidation(Integer age,Model model) {
		String regex = "^[\\d]{1,2}$";
		String age1 = Integer.toString(age);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(age1);
		boolean b = m.matches();
		if (b) {
			if(age>=60) {
			return true;}
			 String errorMessage = "Age Cannot be Greater than 60 years only Allowed";
	            model.addAttribute("errorMessage1", errorMessage);
	            return false;
		}
		else {
            String errorMessage = "Age Cannot be Zero and Greater than 60 years only Allowed";
            model.addAttribute("errorMessage1", errorMessage);
            return false;
        }
		}
	
	}

















