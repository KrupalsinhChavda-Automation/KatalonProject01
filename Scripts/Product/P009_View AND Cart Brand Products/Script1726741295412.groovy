import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
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

def brand = "Polo"

def brandName = "//a[@href='/brand_products/" + brand +"']";

TestObject dynamicBrandName = new TestObject('dynamicObject').addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS,brandName,true)
WebUI.scrollToElement(dynamicBrandName, 10)
WebUI.click(dynamicBrandName)

'Verify title'
WebUI.verifyElementText(findTestObject('Object Repository/Products/Category_Title'), "BRAND - POLO PRODUCTS")

brand = "H&M"

brandName = "//a[@href='/brand_products/" + brand +"']";

TestObject dynamicBrandNameHM = new TestObject('dynamicObject').addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS,brandName,true)
WebUI.scrollToElement(dynamicBrandNameHM, 10)
WebUI.click(dynamicBrandNameHM)

'Verify title'
WebUI.verifyElementText(findTestObject('Object Repository/Products/Category_Title'), "BRAND - H&M PRODUCTS")



