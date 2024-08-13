import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

int random = Math.random() * 1000

LocalDateTime myDateObj = LocalDateTime.now()

System.out.println('Before formatting: ' + myDateObj)

DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern('ddMMyyyy')

String formattedDate = myDateObj.format(myFormatObj)

println(((('Test' + formattedDate) + '@') + random) + '.com')

// Seletc Day
WebUI.selectOptionByValue(findTestObject('Object Repository/Account Info/drp_days'), 21, false)

WebUI.acceptAlert()

WebUI.callTestCase(findTestCase('Login/Login'), [('UserEmail') : '', ('Password') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Login/Login'), [('UserEmail') : '', ('Password') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Login/Login'), [('userEmail') : '', ('password') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Login/Login'), [('userEmail') : '', ('password') : ''], FailureHandling.STOP_ON_FAILURE)

