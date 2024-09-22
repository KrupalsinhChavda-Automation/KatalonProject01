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

'Click on "Products" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Menu_Products'), 10)
WebUI.click(findTestObject('Object Repository/Home Page/Menu_Products'))

'Click on Category "Women"'
WebUI.waitForElementVisible(findTestObject('Object Repository/Products/cat_Women'), 10)
WebUI.click(findTestObject('Object Repository/Products/cat_Women'))

'Click on Category "Women" - "Tops"'
WebUI.scrollToElement(findTestObject('Object Repository/Products/Tops'), 10)
WebUI.click(findTestObject('Object Repository/Products/Tops'))

'Verify title'
WebUI.verifyElementText(findTestObject('Object Repository/Products/Category_Title'), "WOMEN - TOPS PRODUCTS")

'Click on Category "Men"'
WebUI.waitForElementVisible(findTestObject('Object Repository/Products/cat_Men'), 10)
WebUI.click(findTestObject('Object Repository/Products/cat_Men'))

'Click on Category "Men" - "Tshirts"'
WebUI.scrollToElement(findTestObject('Object Repository/Products/Tshirts'), 10)
WebUI.click(findTestObject('Object Repository/Products/Tshirts'))

'Verify title'
WebUI.verifyElementText(findTestObject('Object Repository/Products/Category_Title'), "MEN - TSHIRTS PRODUCTS")

WebUI.closeBrowser();