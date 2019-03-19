package PageMethods;

import PageElements.ApplicationFormPageMap;

public class ApplicationFormPageMethods extends BasePageMethods {
    //Methods
    public static void FillinTheform()
    {

        ApplicationFormPageMap.TextBox.sendKeys("any text for testing");
    }
    public static void Submit()
    {

        ApplicationFormPageMap.SubmitBtn.submit();
    }
}
