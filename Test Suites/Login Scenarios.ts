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
      <guid>7a813b1f-1bd3-4d58-a469-da86690df479</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>false</isRun>
      <testCaseId>Test Cases/Login/L001_Register User</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>54d6a102-3cc9-4ef9-a371-bd28a25731f5</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>false</isRun>
      <testCaseId>Test Cases/Login/L002_Login User with correct email and password</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>77ea2d35-8127-44d4-af96-cd479bbd5e83</id>
         <iterationEntity>
            <iterationType>SPECIFIC</iterationType>
            <value>1</value>
         </iterationEntity>
         <testDataId>Data Files/Login Creds</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>77ea2d35-8127-44d4-af96-cd479bbd5e83</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>User Name</value>
         <variableId>6f157887-d225-47fd-907f-b1ca17d05876</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>77ea2d35-8127-44d4-af96-cd479bbd5e83</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Password</value>
         <variableId>2cc46757-34e9-4fce-9544-3991cd38d689</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>4a71f9b0-5676-4d74-9a59-9228b2fdcee1</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login/L002_Login User with incorrect email and password</testCaseId>
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
</TestSuiteEntity>
