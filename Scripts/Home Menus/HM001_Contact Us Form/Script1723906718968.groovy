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

WebUI.maximizeWindow()

'Navigate to url http://automationexercise.com'
WebUI.navigateToUrl('http://automationexercise.com/')

'Verify that home page is visible successfully'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Home'), GlobalVariable.Long_Timeout)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Home Page/Menu_Home'), 'style', 'color: orange;', GlobalVariable.Short_Timeout)

// Verify Img home page 
WebUI.verifyElementVisible(findTestObject('Object Repository/Home Page/img_Home'), FailureHandling.OPTIONAL)

'Click on Contact Us button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_contact_us'), 10)
WebUI.click(findTestObject('Object Repository/Home Page/Menu_contact_us'))

'Verify "GET IN TOUCH" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/ContactUs/Verify_GetInTouch'), 'GET IN TOUCH')

'Enter Name'
WebUI.setText(findTestObject('Object Repository/ContactUs/txt_Name'), 'KBC Automation')

'Enter Email'
WebUI.setText(findTestObject('Object Repository/ContactUs/txt_Mail'), 'Test123@test.com')

'Enter Subject'
WebUI.setText(findTestObject('Object Repository/ContactUs/txt_Subject'), 'Testing Automation')

'Enter Message'
WebUI.setText(findTestObject('Object Repository/ContactUs/txtarea_Message'), 'Your Message Here')

'Upload file'
WebUI.uploadFile(findTestObject('Object Repository/ContactUs/UploadFile'), System.getProperty("user.dir") + "\\test image.jpg")

'Click on Submit button'
WebUI.scrollToElement(findTestObject('Object Repository/ContactUs/btn_Submit'), 10)
WebUI.click(findTestObject('Object Repository/ContactUs/btn_Submit'))

'Accept Alert with ok'
WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Verify success message "Success! Your details have been submitted successfully." is visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/ContactUs/verify_ContactUs'))
WebUI.verifyElementText(findTestObject('Object Repository/ContactUs/verify_ContactUs'), 'Success! Your details have been submitted successfully.')

'Verify that home page is visible successfully'
WebUI.scrollToElement(findTestObject('Object Repository/Home Page/Menu_Home'), 10)
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Home'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Home'), GlobalVariable.Long_Timeout)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Home Page/Menu_Home'), 'style', 'color: orange;', GlobalVariable.Short_Timeout)

WebUI.closeBrowser()





