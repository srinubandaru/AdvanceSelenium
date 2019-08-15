package Learn.JiraIntegrationWithSelenium;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface JiraPolacy {

	boolean logTicketReady();
	
}
