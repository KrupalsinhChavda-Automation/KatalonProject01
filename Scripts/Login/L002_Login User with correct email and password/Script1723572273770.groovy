import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

'Click "Delete Account" button'
WebUI.click(findTestObject('Object Repository/Account Info/btn_Delete'))

'Verify that "ACCOUNT DELETED!" is visible and click "Continue" button'
WebUI.verifyElementText(findTestObject('Object Repository/Account Info/verify_AccDeleted'), 'ACCOUNT DELETED!')

'Click "Continue" button'
WebUI.click(findTestObject('Object Repository/Account Info/btn_Continue'))

WebUI.closeBrowser()



