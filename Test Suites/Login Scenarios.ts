<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>Login Scenarios</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>false</rerunImmediately>
   <testSuiteGuid>8c0b85eb-ccf3-4198-88cd-fb561dbab033</testSuiteGuid>
   <testCaseLink>
      <guid>e87ea0e9-bf78-4068-8c41-d5962c2c3022</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/L001_Register User</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>54d6a102-3cc9-4ef9-a371-bd28a25731f5</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/L002_Login User with correct email and password</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>4a71f9b0-5676-4d74-9a59-9228b2fdcee1</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/L003_Login User with incorrect email and password</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>bc2196ee-e0b0-4b2b-932b-0fc5f86e5520</id>
         <iterationEntity>
            <iterationType>SPECIFIC</iterationType>
            <value>2</value>
         </iterationEntity>
         <testDataId>Data Files/Login Creds</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>bc2196ee-e0b0-4b2b-932b-0fc5f86e5520</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>User Name</value>
         <variableId>2b0e435c-848c-4e3c-aa47-677de2daf041</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>bc2196ee-e0b0-4b2b-932b-0fc5f86e5520</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>3bccaadf-12c1-4b76-a881-d02756f451a1</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>8f16dd41-297b-486a-a0ab-2981baf626ad</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/L001_Register User</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>ad3e9e8e-9cf5-4d9f-8206-b49ec0d038bb</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/L004_Logout</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
</TestSuiteEntity>
