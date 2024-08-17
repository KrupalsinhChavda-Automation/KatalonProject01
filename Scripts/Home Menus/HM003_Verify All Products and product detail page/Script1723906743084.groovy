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
WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/btn_Products'), 10)
WebUI.click(findTestObject('Object Repository/Home Page/btn_Products'))

'Verify "All Products" is visible'
WebUI.verifyElementText(findTestObject('Object Repository/Products/verify_AllProducts'), 'ALL PRODUCTS')

'Verify "All Products" is visible'
WebUI.scrollToElement(findTestObject('Object Repository/Products/btn_1stProduct'), 10)
WebUI.click(findTestObject('Object Repository/Products/btn_1stProduct'))

'Verify that detail detail is visible: product name'
WebUI.verifyElementText(findTestObject('Object Repository/Products/ProductName1'), 'Blue Top')

'Verify that detail detail is visible: category'
WebUI.verifyElementText(findTestObject('Object Repository/Products/category1'), 'Category: Women > Tops')

'Verify that detail detail is visible: price'
WebUI.verifyElementText(findTestObject('Object Repository/Products/price1'), 'Rs. 500')

'Verify that detail detail is visible: price'
WebUI.verifyElementText(findTestObject('Object Repository/Products/Availability1'), 'Availability: In Stock')

'Verify that detail detail is visible: price'
WebUI.verifyElementText(findTestObject('Object Repository/Products/Condition1'), 'Condition: New')

'Verify that detail detail is visible: price'
WebUI.verifyElementText(findTestObject('Object Repository/Products/Brand1'), 'Brand: Polo')

WebUI.closeBrowser()