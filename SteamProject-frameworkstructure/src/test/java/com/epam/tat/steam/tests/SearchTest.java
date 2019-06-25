package com.epam.tat.steam.tests;

import com.epam.tat.steam.base.pages.SearchPage;
import com.epam.tat.framework.webdriver.utils.Browser;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test()
    public void testSearch() {
        SearchPage searchPage = new SearchPage();
        Browser.openPage(steamPageUrl);
        searchPage.search("Bolek i Lolek");
    }

}
