package Learn.JiraIntegrationWithSelenium;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestJiraListener implements ITestListener {

	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		JiraPolacy jiraPolacy=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolacy.class);
		boolean isTicketReady=jiraPolacy.logTicketReady();
		
		if (isTicketReady) {
			
			// Raise Jira Ticket
			
		System.out.println("Is Ticket ready for to Raise Bug :  "+isTicketReady);
		
		JiraServiceProvider jiraSP=new JiraServiceProvider("https://myjirafortest.atlassian.net", 
				"srinu.b473@gmail.com", "SWLwjCs44zz9DJYGJ0gMFDB7", "MYJ");
		
		String issueSummary=result.getMethod().getConstructorOrMethod().getMethod().getName()+" got failed due to some assertion or exception";
		String issueDescription=result.getThrowable().getMessage()+"\n";
		issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
		jiraSP.createJiraTicket("Bug", issueSummary, issueDescription, "srinu bandaru");
		
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	
}
