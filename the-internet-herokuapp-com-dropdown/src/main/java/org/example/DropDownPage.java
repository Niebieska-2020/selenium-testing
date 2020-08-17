package org.example;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;

public class DropDownPage extends AbstractPage {

    @FindBy (id = "dropdown")
    private WebElement dropdown;
    private Select select;

    public DropDownPage(WebDriver webDriver) {
        super(webDriver);

        select = new Select(dropdown);
    }

    public DropDownPage selectOption1() {
        select.selectByIndex(1);
        return this;
    }

    public DropDownPage selectOption2() {
        select.selectByIndex(2);
        return this;
    }

    public DropDownPage assertThatOption1IsSelected() {
        WebElement option = select.getFirstSelectedOption();
        assertThat(option.getText()).isEqualTo("Option 1");
        return this;
    }

    public DropDownPage assertThatOption2IsSelected() {
        WebElement option = select.getFirstSelectedOption();
        assertThat(option.getText()).isEqualTo("Option 2");
        return this;
    }
}
