import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
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

'Verify "All Products" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Products/verify_AllProducts'), 'ALL PRODUCTS')

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

WebUI.delay(5)

List<WebElement> productstoAddCarts = WebUiBuiltInKeywords.findWebElements(findTestObject('Object Repository/Products/AddToCarts'), 30)

for (WebElement productaddtocart : productstoAddCarts) {

	try {
	println(productaddtocart)
	'Hover over on "Products 1" button'
	WebUI.scrollToElement(findTestObject('Object Repository/Products/txt_Search'), 10)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Products/txt_Search'), 10)
	productaddtocart.click()
	
	'Click on "Continue Shopping" button'
	WebUI.waitForElementVisible(findTestObject('Object Repository/Products/btn_ContinueShopping'), 10)
	WebUI.click(findTestObject('Object Repository/Products/btn_ContinueShopping'))
	}catch(Exception ex){
		
		println(productaddtocart)
	}
}

'Get Product Name 1'
def product01=  "Madame Top For Women"

'Get Product Name 2'
def product02= "Lace Top For Women"

'Click on "View Cart" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Cart'), 10)
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Cart'))

'Get Product Name 1'
def verifyproduct01= WebUI.getText(findTestObject('Object Repository/Cart/Product01'))

'Get Product Name 2'
def verifyproduct02= WebUI.getText(findTestObject('Object Repository/Cart/Product02'))

WebUI.verifyMatch(product01, verifyproduct01, false)
WebUI.verifyMatch(product02, verifyproduct02, false)

'Verify Price of Product 01'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Price01'), 'Rs. 1000')

'Verify Price of Product 02'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Price02'), 'Rs. 1400')

'Verify Quantity of Product 01'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Quantity01'), '1')

'Verify Quantity of Product 02'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Quantity02'), '1')

'Verify Total of Product 01'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Total01'), 'Rs. 1000')

'Verify Total of Product 02'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Total02'), 'Rs. 1400')


// Login and verify items in cart
FileInputStream file = new FileInputStream (new File(System.getProperty("user.dir")+"\\Data Files\\dataFile.xlsx"))
XSSFWorkbook workbook = new XSSFWorkbook(file);
XSSFSheet sheet = workbook.getSheetAt(0);


'Read data from excel'
String User_Email=sheet.getRow(1).getCell(0).getStringCellValue();
String PassWord=sheet.getRow(1).getCell(1).getStringCellValue();
println(User_Email)
println(PassWord)

'Verify that home page is visible successfully'
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Home'))

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Home Page/Menu_Home'), 'style', 'color: orange;', GlobalVariable.Short_Timeout)

// Verify Img home page
WebUI.verifyElementVisible(findTestObject('Object Repository/Home Page/img_Home'), FailureHandling.OPTIONAL)

'Click on "Signup / Login" button'
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Signup-Login'))

'Verify "Login to your account" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Login/Verify_Logintoyouraccount'), 'Login to your account')

'Enter correct email address'
WebUI.setText(findTestObject('Object Repository/Login/txt_EmailAddress'), User_Email)

'Enter correct email address'
WebUI.setText(findTestObject('Object Repository/Login/txt_password'), PassWord)

'Click on "Login" button'
WebUI.click(findTestObject('Object Repository/Login/btn_Login'))

'Click on "View Cart" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Cart'), 10)
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Cart'))

'Get Product Name 1'
verifyproduct01= WebUI.getText(findTestObject('Object Repository/Cart/Product01'))

'Get Product Name 2'
verifyproduct02= WebUI.getText(findTestObject('Object Repository/Cart/Product02'))

WebUI.verifyMatch(product01, verifyproduct01, false)
WebUI.verifyMatch(product02, verifyproduct02, false)

'Verify Price of Product 01'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Price01'), 'Rs. 1000')

'Verify Price of Product 02'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Price02'), 'Rs. 1400')

'Verify Quantity of Product 01'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Quantity01'), '1')

'Verify Quantity of Product 02'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Quantity02'), '1')

'Verify Total of Product 01'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Total01'), 'Rs. 1000')

'Verify Total of Product 02'
WebUI.verifyElementText(findTestObject('Object Repository/Cart/Total02'), 'Rs. 1400')

WebUI.closeBrowser()