package com.realworld.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoginPage extends AbstractWebPage {

    private static final Logger log = LogManager.getLogger(LoginPage.class);

    @Override
    protected Logger getLogger() {
        return log;
    }

    @Override
    protected String getClassPage() {
        return "auth-page";
    }
}
