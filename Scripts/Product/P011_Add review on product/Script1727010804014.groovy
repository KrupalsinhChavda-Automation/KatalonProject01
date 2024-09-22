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

'Click on "Products" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Products'), 10)
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Products'))

'Click on view Product'
WebUI.scrollToElement(findTestObject('Object Repository/Products/btn_viewProduct1'), 10)
WebUI.click(findTestObject('Object Repository/Products/btn_viewProduct1'))

'Verify title'
WebUI.verifyElementText(findTestObject('Object Repository/Products/verify_reviews'), "WRITE YOUR REVIEW")

'Enter "Email" Address'
int random = Math.random() * 1000

LocalDateTime myDateObj = LocalDateTime.now()
System.out.println('Before formatting: ' + myDateObj)
DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern('ddMMyyyy')
String formattedDate = myDateObj.format(myFormatObj)

'Enter Name'
WebUI.scrollToElement(findTestObject('Object Repository/Products/txt_Name'), GlobalVariable.Long_Timeout)
WebUI.setText(findTestObject('Object Repository/Products/txt_Name'),'KBC Automation')

'Enter Email'
WebUI.setText(findTestObject('Object Repository/Products/txt_Email'),'Test' +formattedDate + '@' + random +'.com')

'Write Review'
WebUI.setText(findTestObject('Object Repository/Products/textarea_Review'),"I recently purchased this girl’s top, and I couldn't be happier! The fabric is incredibly soft and breathable, perfect for all-day wear. The vibrant colors and fun patterns really stand out, making it a versatile addition to any wardrobe. It pairs beautifully with jeans or skirts, and the fit is just right—not too tight, yet flattering. My daughter loves it, and it’s quickly become one of her favorites! Highly recommend for anyone looking to add a stylish and comfortable piece to their collection.")

'Click on Submit Button'
WebUI.scrollToElement(findTestObject('Object Repository/Products/btn_Submit'), 10)
WebUI.click(findTestObject('Object Repository/Products/btn_Submit'))

'Verify success message "Thank you for your review."'
WebUI.verifyElementText(findTestObject('Object Repository/Products/Submited_Review'), "Thank you for your review.")

WebUI.closeBrowser()