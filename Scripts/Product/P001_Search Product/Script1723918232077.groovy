import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

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

'Verify "All Products" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Products/verify_AllProducts'), 'ALL PRODUCTS')

'Enter product name in search input'
WebUI.setText(findTestObject('Object Repository/Products/txt_Search'), 'Winter')

'Click search button'
WebUI.click(findTestObject('Object Repository/Products/btn_Search'))

'Verify "SEARCHED PRODUCTS" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Products/serachedProductOne'), 'Winter Top')

'Clear text from search bar'
WebUI.clearText(findTestObject('Object Repository/Products/txt_Search'))

'Click search button'
WebUI.click(findTestObject('Object Repository/Products/btn_Search'))

'Enter product name in search input'
WebUI.setText(findTestObject('Object Repository/Products/txt_Search'), 'Women')

'Click search button'
WebUI.click(findTestObject('Object Repository/Products/btn_Search'))

List<WebElement> products = WebUiBuiltInKeywords.findWebElements(findTestObject('Object Repository/Products/SearchResults'), 30)

for (WebElement product : products) {

	def productName;
	productName = product.getText()
	if(productName.contains("Women")) {
		KeywordUtil.markPassed("Searched products are the same as searched keyword")
	}else { 
		KeywordUtil.markFailed("Searched products are not the same as searched keyword") }
	// Print or log the product details
	WebUI.comment('Product Name: ' + productName)
}
WebUI.closeBrowser()