package testCase;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.Tag;
import ru.iteco.fmhandroid.ui.AppActivity;
import steps.AuthorizationSteps;
import steps.MainSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
public class MainCases {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorization() {
        AuthorizationSteps.login();
    }

    @Test
    @Tag("12")
    @Story("Переход ко всем новостям по нажатию на ALL News")
    public void gotoAllNewsPage() {
        MainSteps.clickButtonAllNews();
        MainSteps.newsPage();
    }


    @Test
    @Tag("14")
    @Story("Переход ко всем претензиям по нажатию на ALL Claims")
    public void buttonAllClaims() {
        MainSteps.clickButtonClaims();
        MainSteps.claimsPage();
    }
    @Test
    @Tag("15")
    @Story("Скрыть показать  ALL Claims при нажатии на пиктограмму")
    public void clickDDListClaims() {
        MainSteps.clickDDListClaims();
        MainSteps.clickDDListClaims();
        MainSteps.checkDDListClaims();
    }

}
