import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

'Launch browser'
WebUI.openBrowser('')

WebUI.maximizeWindow()

'Navigate to url http://automationexercise.com'
WebUI.navigateToUrl('http://automationexercise.com/')

'Verify that home page is visible successfully'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Home'), GlobalVariable.Long_Timeout)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Home Page/Menu_Home'), 'style', 'color: orange;', GlobalVariable.Short_Timeout)

// Verify Img home page
WebUI.verifyElementVisible(findTestObject('Object Repository/Home Page/img_Home'), FailureHandling.OPTIONAL)

'Click on "Products" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Products'), 10)
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Products'))

'Verify "All Products" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Products/verify_AllProducts'), 'ALL PRODUCTS')

'Get Product Name 1'
def product01= WebUI.getText(findTestObject('Object Repository/Products/ProductName01')).trim()

'Hover over on "Products 1" button'
WebUI.scrollToElement(findTestObject('Object Repository/Products/Product01'), 10)
WebUI.mouseOver(findTestObject('Object Repository/Products/Product01'))

'Click on "Products 1" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Products/btn_AddToCart1'), 10)
WebUI.click(findTestObject('Object Repository/Products/btn_AddToCart1'))

'Click on "Continue Shopping" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Products/btn_ContinueShopping'), 10)
WebUI.click(findTestObject('Object Repository/Products/btn_ContinueShopping'))

'Click on "View Cart" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Cart'), 10)
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Cart'))

'Get Product Name 1'
def verifyproduct01= WebUI.getText(findTestObject('Object Repository/Cart/Product01'))

WebUI.verifyMatch(product01, verifyproduct01, false)

'Verify Price of Product 01'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Price01'), 'Rs. 500')

'Verify Quantity of Product 01'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Quantity01'), '1')

'Click on "Proceed To Checkout" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Cart/btn_ProceedToCheckout'), 10)
WebUI.click(findTestObject('Object Repository/Cart/btn_ProceedToCheckout'))

'Click on "Register / Login" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Cart/btn_RegisterLogin'), 10)
WebUI.click(findTestObject('Object Repository/Cart/btn_RegisterLogin'))

'Verify "New User Signup!" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Login/Verify_NewUserSignup'), 'New User Signup!')

'Enter "Name"'
WebUI.setText(findTestObject('Object Repository/Login/txt_Name'), 'KBC Automation')

'Enter "Email" Address'
int random = Math.random() * 1000

LocalDateTime myDateObj = LocalDateTime.now()
System.out.println('Before formatting: ' + myDateObj)
DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern('ddMMyyyy')
String formattedDate = myDateObj.format(myFormatObj)
WebUI.setText(findTestObject('Object Repository/Login/txt_Email'), 'Test' +formattedDate + '@' + random +'.com')
'Write data to excel for email'


'Click "Signup" button'
WebUI.click(findTestObject('Object Repository/Login/btn_SignUp'))

'Verify that "ENTER ACCOUNT INFORMATION" is visible'
// Verify Name added while SignUp
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Login/txt_Name'),'value' ,'KBC Automation', GlobalVariable.Short_Timeout)
// Verify Email added while SignUp
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Account Info/verify_Email'),'value' ,'Test' +formattedDate + '@' + random +'.com', GlobalVariable.Short_Timeout)

'Select the "Title"'
WebUI.check(findTestObject('Object Repository/Account Info/radiobtn_Title'))

'Set the "Password" for our logged in user'
WebUI.setText(findTestObject('Object Repository/Account Info/txt_Password'), 'Test' +formattedDate + '@' + random)
'Write data to excel for email'


'Set The Date of Birth'
// Seletc Day
WebUI.selectOptionByValue(findTestObject('Object Repository/Account Info/drp_days'), '21', false)
// Select Month
WebUI.waitForElementVisible(findTestObject('Object Repository/Account Info/drp_Month'), GlobalVariable.Short_Timeout)
WebUI.selectOptionByValue(findTestObject('Object Repository/Account Info/drp_Month'), '3', false)
// Select Year
WebUI.selectOptionByValue(findTestObject('Object Repository/Account Info/drp_Year'), '2002', false)

'Select checkbox "Sign up for our newsletter!"'
WebUI.scrollToElement(findTestObject('Object Repository/Account Info/checkbox_signUpNews'), GlobalVariable.Short_Timeout)
WebUI.click(findTestObject('Object Repository/Account Info/checkbox_signUpNews'))

'Select checkbox "Receive special offers from our partners!"'
WebUI.click(findTestObject('Object Repository/Account Info/checkbox_option'))

'Enter "First name"'
WebUI.scrollToElement(findTestObject('Object Repository/Account Info/txt_first_name'), GlobalVariable.Short_Timeout)
WebUI.setText(findTestObject('Object Repository/Account Info/txt_first_name'), 'KBC')

'Enter "Last name"'
WebUI.setText(findTestObject('Object Repository/Account Info/txt_last_name'), 'Automation')

'Enter "Company"'
WebUI.setText(findTestObject('Object Repository/Account Info/txt_Company'), 'Automation')

'Enter "Address"'
WebUI.setText(findTestObject('Object Repository/Account Info/txt_Address'), 'Test near test')

'Enter "Address 2"'
WebUI.setText(findTestObject('Object Repository/Account Info/txt_Address2'), 'Address 2')

'Select "Country"'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Account Info/drp_Country'), 'Australia', false)

'Enter "State"'
WebUI.scrollToElement(findTestObject('Object Repository/Account Info/txt_State'), GlobalVariable.Short_Timeout)
WebUI.setText(findTestObject('Object Repository/Account Info/txt_State'), 'ACT')

'Enter "City"'
WebUI.setText(findTestObject('Object Repository/Account Info/txt_City'), 'Melbourne')

'Enter "ZipCode"'
WebUI.setText(findTestObject('Object Repository/Account Info/txt_zipcode'), '2900')

'Enter "ZipCode"'
WebUI.setText(findTestObject('Object Repository/Account Info/num_Mobile'), '1236123612')

'Click "Create Account button"'
WebUI.scrollToElement(findTestObject('Object Repository/Account Info/btn_CreateAcc'), GlobalVariable.Short_Timeout)
WebUI.click(findTestObject('Object Repository/Account Info/btn_CreateAcc'))

'Verify that "ACCOUNT CREATED!" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Account Info/verify_AccountCreated'), 'ACCOUNT CREATED!')

'Click "Continue" button'
WebUI.click(findTestObject('Object Repository/Account Info/btn_Continue'))

'Verify that "Logged in as username" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Account Info/verify_loggedinUser'), 'KBC Automation')

'Click on "View Cart" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Cart'), 10)
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Cart'))

'Click on "Proceed To Checkout" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Cart/btn_ProceedToCheckout'), 10)
WebUI.click(findTestObject('Object Repository/Cart/btn_ProceedToCheckout'))

'Verify Address'
String address= WebUI.getText(findTestObject('Object Repository/Cart/verify_Address'))
String vaddress = "YOUR DELIVERY ADDRESS\n" +
		"Mr. KBC Automation\n" +
		"Automation\n" +
		"Test near test\n" +
		"Address 2\n" +
		"Melbourne ACT 2900\n" +
		"Australia\n" +
		"1236123612";
WebUI.verifyMatch(address, vaddress, false)

'Verify Price of Product 01'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Price01'), 'Rs. 500')

'Verify Quantity of Product 01'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Quantity01'), '1')

'Verify Total of Product 01'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Total01'), 'Rs. 500')

'Enter comment'
WebUI.setText(findTestObject('Object Repository/Cart/textarea_comment'), 'Testing the Product to place order')

'Click on "Proceed To Checkout" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Cart/btn_PlaceOrder'), 10)
WebUI.click(findTestObject('Object Repository/Cart/btn_PlaceOrder'))

'Enter Name on Card'
WebUI.setText(findTestObject('Object Repository/Payment/txt_name_on_card'), 'Testing Automation')

'Enter Card Number'
WebUI.setText(findTestObject('Object Repository/Payment/txt_CardNumber'), '1234 1245 5656 6778')

'Enter CVC'
WebUI.setText(findTestObject('Object Repository/Payment/num_cvc'), '234')

'Enter expiry_month'
WebUI.setText(findTestObject('Object Repository/Payment/num_expiry_month'), '01')

'Enter expiry_year'
WebUI.setText(findTestObject('Object Repository/Payment/num_expiry_year'), '2030')

'Click on "Pay and Confirm Order"'
WebUI.waitForElementVisible(findTestObject('Object Repository/Payment/button_Pay'), 10)
WebUI.click(findTestObject('Object Repository/Payment/button_Pay'))

'Verify success message "Your order has been placed successfully!"'
WebUI.verifyElementText(findTestObject('Object Repository/Payment/verify_Order'), 'Congratulations! Your order has been confirmed!')

'Click on Download Invoice'
WebUI.waitForElementVisible(findTestObject('Object Repository/Products/btn_DownloadInvoice'), 10)
WebUI.click(findTestObject('Object Repository/Products/btn_DownloadInvoice'))

'Click "Delete Account" button'
WebUI.click(findTestObject('Object Repository/Account Info/btn_Delete'))

'Verify that "ACCOUNT DELETED!" is visible and click "Continue" button'
WebUI.verifyElementText(findTestObject('Object Repository/Account Info/verify_AccDeleted'), 'ACCOUNT DELETED!')

'Click "Continue" button'
WebUI.click(findTestObject('Object Repository/Account Info/btn_Continue'))

