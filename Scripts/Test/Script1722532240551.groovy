import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

int random = Math.random() * 1000
LocalDateTime myDateObj = LocalDateTime.now()
System.out.println('Before formatting: ' + myDateObj)
DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern('ddMMyyyy')
String formattedDate = myDateObj.format(myFormatObj)

println('Test' +formattedDate + '@' + random +'.com')

// Seletc Day
WebUI.selectOptionByValue(findTestObject('Object Repository/Account Info/drp_days'), 21, false)
	
	