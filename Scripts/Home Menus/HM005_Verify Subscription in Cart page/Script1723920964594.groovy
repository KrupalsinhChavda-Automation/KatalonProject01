import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

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

'Scroll down to footer'
WebUI.scrollToElement(findTestObject('Object Repository/Home Page/Subscription'), GlobalVariable.Short_Timeout)

'Click "Cart" button'
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Cart'))

'Verify text "SUBSCRIPTION" '
WebUI.verifyElementText(findTestObject('Object Repository/Home Page/Subscription'), 'SUBSCRIPTION')

'Enter email address in input and click arrow button'
int random = Math.random() * 1000

LocalDateTime myDateObj = LocalDateTime.now()
System.out.println('Before formatting: ' + myDateObj)
DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern('ddMMyyyy')
String formattedDate = myDateObj.format(myFormatObj)
WebUI.setText(findTestObject('Object Repository/Home Page/txt_Subscription'), 'Test' +formattedDate + '@' + random +'.com')

'click arrow button'
WebUI.click(findTestObject('Object Repository/Home Page/btn_subscribe'))

'Verify success message "You have been successfully subscribed!" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Home Page/verify_Subscription'), 'You have been successfully subscribed!')

WebUI.closeBrowser()

