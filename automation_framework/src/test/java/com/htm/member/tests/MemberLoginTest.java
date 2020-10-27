package com.htm.member.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.htm.base.TestBase;
import com.htm.utils.HTMWebTestData;
import com.htm.web.common.actions.HtmWebCommonActions;

public class MemberLoginTest extends TestBase {

	HtmWebCommonActions comminActions;

	@BeforeClass
	public void setUp() {
		comminActions = new HtmWebCommonActions();
	}

	@Test
	public void memberLogin() throws Exception {
		
		comminActions.memberLogin(HTMWebTestData.memberUsername, HTMWebTestData.memberPassword);

	}
}
