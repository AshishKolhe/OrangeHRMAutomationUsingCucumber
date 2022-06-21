set projectLocation=D:\Learning\git\TestAutomationBDDFramework
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\TestNG\*
java org.testng.TestNG %projectLocation%\test_testng.xml
pause