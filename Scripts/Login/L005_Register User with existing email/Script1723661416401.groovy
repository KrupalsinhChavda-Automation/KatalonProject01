import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

FileInputStream file = new FileInputStream (new File(System.getProperty("user.dir")+"\\Data Files\\dataFile.xlsx"))
XSSFWorkbook workbook = new XSSFWorkbook(file);
XSSFSheet sheet = workbook.getSheetAt(0);


'Read data from excel'
String User_Email=sheet.getRow(1).getCell(0).getStringCellValue();
String PassWord=sheet.getRow(1).getCell(1).getStringCellValue();
println(User_Email)
println(PassWord)

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

'Click on "Signup / Login" button'
WebUI.click(findTestObject('Object Repository/Home Page/btn_Signup-Login'))

'Verify "New User Signup!" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Login/Verify_NewUserSignup'), 'New User Signup!')

// Verify Img home page
WebUI.verifyElementVisible(findTestObject('Object Repository/Home Page/img_Home'), FailureHandling.OPTIONAL)

'Click on "Signup / Login" button'
WebUI.click(findTestObject('Object Repository/Home Page/btn_Signup-Login'))

'Verify "New User Signup!" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Login/Verify_NewUserSignup'), 'New User Signup!')

'Enter "Name"'
WebUI.setText(findTestObject('Object Repository/Login/txt_Name'), 'KBC Automation')

'Enter "Email" Address'
WebUI.setText(findTestObject('Object Repository/Login/txt_Email'), User_Email)
 
'Click "Signup" button'
WebUI.click(findTestObject('Object Repository/Login/btn_SignUp'))

'Verify Email Address already exist! validation message'
WebUI.verifyElementText(findTestObject('Object Repository/Login/verify_EmailExist'), 'Email Address already exist!',FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser();