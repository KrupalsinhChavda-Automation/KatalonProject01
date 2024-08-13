import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Call Login test case to run the login test'
WebUI.callTestCase(findTestCase('Login/Login'), [('userEmail') : userEmail, ('password') : password], FailureHandling.STOP_ON_FAILURE)

// Verify incorrect credentials
'Verify invalid creds validation message'
WebUI.verifyElementText(findTestObject('Object Repository/Login/verify_invalidcreds'), 'Your email or password is incorrect!',FailureHandling.CONTINUE_ON_FAILURE)

'Click on "Login" button'
WebUI.click(findTestObject('Object Repository/Login/btn_Login'))

'Verify invalid creds validation message'
WebUI.verifyElementText(findTestObject('Object Repository/Login/verify_invalidcreds'), 'Your email or password is incorrect!',FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser();