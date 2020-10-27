package com.htm.pojo;

import com.htm.utils.MobileTestData;
import com.htm.utils.Utils;

/**
 * Provider POJO class to represent entity Provider
 * 
 * @author Bharat Puri
 *
 */
public class Provider {
	
	MobileTestData	testData = new MobileTestData();

	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	String password;
	String confirmPassword;
	String addressOne;
	String addressTwo;
	String zipCode;
	String yearsOfService;
	String aboutMe;
	String cardNumber;
	String cardExpireDate;
	String cardCVVNumber;
	String confirmCodeNumber;

	@SuppressWarnings("static-access")
	public void initilizeProviderFromTestData(){
//		setFirstName(testData.provider_FName);
//		setLastName(testData.provider_LName);
//		setEmail(testData.provider_Email);
//		setPhoneNumber(Utils.getDynamicNumber());
//		setPassword(testData.provider_Password);
//		setConfirmPassword(testData.provider_ConfirmPass);
//		setAddressOne(testData.provider_AddressOne);
//		setAddressTwo(testData.provider_AddressTwo);
//		setZipCode(testData.provider_ZipCode);
//		setYearsOfService(testData.provider_YearOFService);
//		setAboutMe(testData.provider_AboutMe);
//		setCardNumber(testData.provider_CardNo);
//		setCardExpireDate(testData.provider_CardExpireDate);
//		setCardCVVNumber(testData.provider_CardCVVNo);
//		setConfirmCodeNumber(testData.provider_confirmCode);
		
	}
	public String getConfirmCodeNumber() {
		return confirmCodeNumber;
	}

	public void setConfirmCodeNumber(String codeNumber) {
		this.confirmCodeNumber = codeNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getYearsOfService() {
		return yearsOfService;
	}

	public void setYearsOfService(String yearsOfService) {
		this.yearsOfService = yearsOfService;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardExpireDate() {
		return cardExpireDate;
	}

	public void setCardExpireDate(String cardExpireDate) {
		this.cardExpireDate = cardExpireDate;
	}

	public String getCardCVVNumber() {
		return cardCVVNumber;
	}

	public void setCardCVVNumber(String cardCVVNumber) {
		this.cardCVVNumber = cardCVVNumber;
	}

}