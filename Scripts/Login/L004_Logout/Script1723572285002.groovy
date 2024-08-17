import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

FileInputStream file = new FileInputStream(new File(System.getProperty('user.dir') + '\\Data Files\\dataFile.xlsx'))

XSSFWorkbook workbook = new XSSFWorkbook(file)

XSSFSheet sheet = workbook.getSheetAt(0)

'Read data from excel'
String userEmail = sheet.getRow(1).getCell(0).getStringCellValue()

String password = sheet.getRow(1).getCell(1).getStringCellValue()

'Call Login test case to run the login test'
WebUI.callTestCase(findTestCase('Login/Login'), [('userEmail') : userEmail, ('password') : password], FailureHandling.STOP_ON_FAILURE)

//Click on signout button
WebUI.click(findTestObject('Object Repository/Login/btn_Logout'))

// Verify Img home page
WebUI.verifyElementVisible(findTestObject('Object Repository/Home Page/img_Home'), FailureHandling.OPTIONAL)

//WebUI.closeBrowser();

