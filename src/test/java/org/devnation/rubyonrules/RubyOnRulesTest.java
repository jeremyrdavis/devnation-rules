package org.devnation.rubyonrules;

import java.math.BigDecimal;

import junit.framework.TestCase;

import org.devnation.rubyonrules.model.Withdrawl;
import org.devnation.rubyonrules.utils.AccountAlertService;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RubyOnRulesTest extends TestCase{

	protected KieSession kieSession;

	KieRuntimeLogger logger;

	@Test
	public void test() {
		Withdrawl withdrawl = new Withdrawl(ACCOUNT.account1.accountNumber, new BigDecimal(501));
		AccountAlertService svc = new AccountAlertService();
		kieSession.insert(withdrawl);
		kieSession.setGlobal("alertSvc", svc);
		kieSession.fireAllRules();
		assertNotNull("The list of account numbers with an alert should not be null", svc.getAccounts());
		assertEquals("There should be one account number with an alert", 1, svc.getAccounts().size());
	}

	@Override
	public void setUp() {
		kieSession = getKieSession();
		assertNotNull(kieSession);

		logger = KieServices.Factory.get().getLoggers()
				.newFileLogger(kieSession, "logdir/mylogfile");
		assertNotNull(logger);
	}

	protected KieSession getKieSession() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();

		KieSession kSession = kContainer.newKieSession("rubyonrules-ksession");
		assertNotNull("KieSession should not be null", kSession);
		return kSession;
	}

}
