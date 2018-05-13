package in.automationtest.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class RunTestNG {

	public static void main(String[] args) {

		RunTestNG rtng = new RunTestNG();
		
		rtng.runXmlSuite("RegressionSuite");
	}
	
	// Run a virtual XML Suite
	public void runXmlSuite(String suiteName){
		
		TestNG TNG = new TestNG(); // Create a testng object
		
		List<Class<? extends ITestNGListener>> listenerClasses= new ArrayList<Class<? extends ITestNGListener>>();

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		List<XmlClass> classes = new ArrayList<XmlClass>();

		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName(suiteName);
		
		XmlTest xmlTest = new XmlTest(xmlSuite); // Create a test and add it to the suite
		xmlTest.setName("RegressionTest");

		// Add Classes
		// TODO Add classes from a DataBase or Excel Sheet 
		//classes.add(new XmlClass("in.automationtest.tests.AutomationTestingRegister"));
		classes.add(new XmlClass("in.automationtest.tests.AutomationTestingGrid"));
		//classes.add(new XmlClass("in.automationtest.tests.AutomationTestingCKEditor"));
		// Link classes to the test
		xmlTest.setClasses(classes);
		
		// Add suite to the list of suites 
		suites.add(xmlSuite);
		TNG.setXmlSuites(suites);

		//Add the AutomationTestingListener  class to the list of Listener Classes 
		// TNG.addListener(AutomationTestingListener.class);	<== Deprecated
		listenerClasses.add(AutomationTestingListener.class);
		TNG.setListenerClasses(listenerClasses);
		TNG.setVerbose(10);
		
		TNG.run();
		
	}

}
