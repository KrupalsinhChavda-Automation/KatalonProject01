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

'Launch browser'
WebUI.openBrowser('')

'Navigate to url http://automationexercise.com'
WebUI.navigateToUrl('http://automationexercise.com/')

'Verify that home page is visible successfully'
WebUI.waitForElementVisible(findTestObject('Object Repository/Login/Menu_Home'), GlobalVariable.Long_Timeout)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Login/Menu_Home'), 'style', 'color: orange;', GlobalVariable.Short_Timeout)

// Verify Img home page
WebUI.verifyElementVisible(findTestObject('Object Repository/Login/img_Home'), FailureHandling.OPTIONAL)

'Click on "Signup / Login" button'
WebUI.click(findTestObject('Object Repository/Login/btn_Signup-Login'))

'Verify "Login to your account" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Login/Verify_Logintoyouraccount'), 'Login to your account')

'Enter correct email address'
WebUI.setText(findTestObject('Object Repository/Login/txt_EmailAddress'), userEmail)

'Enter correct email address'
WebUI.setText(findTestObject('Object Repository/Login/txt_password'), password)

'Click on "Login" button'
WebUI.click(findTestObject('Object Repository/Login/btn_Login'))

'Verify logged in user'
WebUI.verifyElementText(findTestObject('Object Repository/Account Info/verify_loggedinUser'), "KBC Automation")

'Click "Delete Account" button'
WebUI.click(findTestObject('Object Repository/Account Info/btn_Delete'))

'Verify that "ACCOUNT DELETED!" is visible and click "Continue" button'
WebUI.verifyElementText(findTestObject('Object Repository/Account Info/verify_AccDeleted'), 'ACCOUNT DELETED!')

'Click "Continue" button'
WebUI.click(findTestObject('Object Repository/Account Info/btn_Continue'))
WebUI.closeBrowser();