package PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ApplicationFormPageMap extends BasePageMap {
    public ApplicationFormPageMap(WebDriver webDriver)
    {
        super(webDriver);
    }

    // Selectors
    @FindBy(how = How.CSS,using = "input[id*='_data_mapping_form_web_portlet_DDMFormPortlet_INSTANCE_CIMcxpSZQT1z_ddm$$text$']")
    public static WebElement TextBox ;

    @FindBy(how = How.CSS,using = "button.lfr-ddm-form-submit")
    public static WebElement SubmitBtn ;



}
