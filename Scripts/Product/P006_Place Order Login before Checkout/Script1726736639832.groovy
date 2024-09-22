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

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Add new User to login
WebUI.callTestCase(findTestCase('Login/L001_Register User'), [:], FailureHandling.STOP_ON_FAILURE)

FileInputStream file = new FileInputStream (new File(System.getProperty("user.dir")+"\\Data Files\\dataFile.xlsx"))
XSSFWorkbook workbook = new XSSFWorkbook(file);
XSSFSheet sheet = workbook.getSheetAt(0);


'Read data from excel'
String User_Email=sheet.getRow(1).getCell(0).getStringCellValue();
String PassWord=sheet.getRow(1).getCell(1).getStringCellValue();
println(User_Email)
println(PassWord)

'Call Login test case to run the login test'
WebUI.callTestCase(findTestCase('Login/Login'), [('userEmail') : User_Email, ('password') : PassWord], FailureHandling.STOP_ON_FAILURE)

'Verify logged in user'
WebUI.verifyElementText(findTestObject('Object Repository/Account Info/verify_loggedinUser'), 'KBC Automation')

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

'Click "Delete Account" button'
WebUI.click(findTestObject('Object Repository/Account Info/btn_Delete'))

'Verify that "ACCOUNT DELETED!" is visible and click "Continue" button'
WebUI.verifyElementText(findTestObject('Object Repository/Account Info/verify_AccDeleted'), 'ACCOUNT DELETED!')

'Click "Continue" button'
WebUI.click(findTestObject('Object Repository/Account Info/btn_Continue'))

WebUI.closeBrowser()




