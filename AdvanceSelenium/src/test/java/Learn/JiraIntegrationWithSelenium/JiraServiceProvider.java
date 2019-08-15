package Learn.JiraIntegrationWithSelenium;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {
	
	public JiraClient jira;
	public String project;
	public JiraServiceProvider(String jiraUrl,String username, String password,String project)
	{
		
		BasicCredentials creds=new BasicCredentials(username, password);
		
		jira=new JiraClient(jiraUrl, creds);
		this.project=project;
		
	}
	
	public void createJiraTicket(String issueType,String summary,String description,String reporterName)
	{
		try {
			FluentCreate fluentcreat=jira.createIssue(project, issueType);
			fluentcreat.field(Field.SUMMARY, summary);
			fluentcreat.field(Field.DESCRIPTION, description);
			Issue   newIssue=fluentcreat.execute();
			System.out.println("New Issue created in Jira with ID :"+newIssue);
			
		} catch (JiraException e) {
			
			e.printStackTrace();
		}
		
	}

}
