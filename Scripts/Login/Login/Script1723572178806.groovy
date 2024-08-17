import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Open Browser'
WebUI.openBrowser("")

WebUI.maximizeWindow()

'Navigate to url http://automationexercise.com'
WebUI.navigateToUrl('http://automationexercise.com/')

'Verify that home page is visible successfully'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Home'), GlobalVariable.Long_Timeout)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Home Page/Menu_Home'), 'style', 'color: orange;', GlobalVariable.Short_Timeout)

// Verify Img home page
WebUI.verifyElementVisible(findTestObject('Object Repository/Home Page/img_Home'), FailureHandling.OPTIONAL)

'Click on "Signup / Login" button'
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Signup-Login'))

'Verify "Login to your account" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Login/Verify_Logintoyouraccount'), 'Login to your account')

'Enter correct email address'
WebUI.setText(findTestObject('Object Repository/Login/txt_EmailAddress'), userEmail)

'Enter correct email address'
WebUI.setText(findTestObject('Object Repository/Login/txt_password'), password)

'Click on "Login" button'
WebUI.click(findTestObject('Object Repository/Login/btn_Login'))

//WebUI.closeBrowser();