package org.example;

import org.junit.Test;

public class DropDownPageTest extends SeleniumBaseTest {

    private DropDownPage dropDownPage;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        webDriver.get("http://the-internet.herokuapp.com/dropdown");
        dropDownPage = new DropDownPage(webDriver);
    }

    @Test
    public void givenOption1IsSelectedThenOption1IsSelected() {
        dropDownPage.selectOption1().assertThatOption1IsSelected();
    }

    @Test
    public void givenOption2IsSelectedThenOption2IsSelected() {
        dropDownPage.selectOption2().assertThatOption2IsSelected();
    }
}
