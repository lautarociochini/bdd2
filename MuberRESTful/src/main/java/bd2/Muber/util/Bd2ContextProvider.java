package bd2.Muber.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Bd2ContextProvider implements ApplicationContextAware {

	public Bd2ContextProvider() {
		super();
	}

	@Override
	public void setApplicationContext(ApplicationContext aContext) throws BeansException {
		Bd2ApplicationContext.setApplicationContext(aContext);
	}

}
