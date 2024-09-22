import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

List<WebElement> productstoAddCarts = WebUiBuiltInKeywords.findWebElements(findTestObject('Object Repository/Products/AddToCarts'), 30)

for (WebElement productaddtocart : productstoAddCarts) {

	try {
	println(productaddtocart)
	'Hover over on "Products 1" button'
	
	productaddtocart.click()
	
	'Click on "Continue Shopping" button'
	WebUI.waitForElementVisible(findTestObject('Object Repository/Products/btn_ContinueShopping'), 10)
	WebUI.click(findTestObject('Object Repository/Products/btn_ContinueShopping'))
	}catch(Exception ex){
		
		println(productaddtocart)
	}
}

