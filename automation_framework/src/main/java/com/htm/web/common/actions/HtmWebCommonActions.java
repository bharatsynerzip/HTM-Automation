package com.htm.web.common.actions;

import com.htm.base.TestBase;
import com.htm.member.pages.MemberLoginPage;

public class HtmWebCommonActions extends TestBase {

	MemberLoginPage loginPage;
	
	public HtmWebCommonActions () {
		loginPage = new MemberLoginPage(webDriver);
	}
	
	public void memberLogin(String username, String password) throws Exception {
		log.info("-----------------Member Login----Begin-----------------");
		loginPage.htmMemberLogin(username, password);
		log.info("-----------------Member Login----End-----------------");
	}
	
}
