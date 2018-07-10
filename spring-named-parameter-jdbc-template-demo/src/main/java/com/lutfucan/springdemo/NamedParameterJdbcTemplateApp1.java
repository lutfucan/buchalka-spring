package com.lutfucan.springdemo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.lutfucan.springdemo.dao.OrganizationDao;
import com.lutfucan.springdemo.domain.Organization;

@Component // Autowired kullanacaðýmýz için bunu da bean haline dönüþtürmemiz gerek. Bunun
			// için @Component ekledik.
public class NamedParameterJdbcTemplateApp1 {

	@Autowired
	private OrganizationDao dao;
	@Autowired
	private DaoUtils daoUtils;

	public void actionMethod() {

		daoUtils.createSeedData(dao);

		List<Organization> orgs = dao.getAllOrganizations();

		daoUtils.printOrganizations(orgs, daoUtils.readOperation);

		Organization org = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org);
		daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.readOperation);

		Organization org2 = dao.getOrganization(1);
		daoUtils.printOrganization(org2, daoUtils.readOperation);

		Organization org3 = dao.getOrganization(2);
		org3.setSlogan("Web build *awesome* driving machines");
		boolean isUpdated = dao.update(org3);
		daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);
		daoUtils.printOrganization(dao.getOrganization(2), daoUtils.updateOperation);

		boolean isDeleted = dao.delete(dao.getOrganization(3));
		daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);
		daoUtils.printOrganizations(dao.getAllOrganizations(), daoUtils.deleteOperation);

		dao.cleanup();
		daoUtils.printOrganizationCount(dao.getAllOrganizations(), daoUtils.cleanupOperation);
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		NamedParameterJdbcTemplateApp1 mainApp = ctx.getBean(NamedParameterJdbcTemplateApp1.class); // Managed Bean
		mainApp.actionMethod();

		((ClassPathXmlApplicationContext) ctx).close();

	}

}
