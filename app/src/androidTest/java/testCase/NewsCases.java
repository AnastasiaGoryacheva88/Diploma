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
import steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
public class NewsCases {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorization() {
        AuthorizationSteps.login();
    }

    @Test
    @Tag("44")
    @Story("Создание новости")
    public void creationNewsInControlPanel() {
        MainSteps.clickButtonAllNews();
        NewsSteps.clickEditNewsInNewsPage();
        NewsSteps.clickAddNews();
        NewsSteps.clickButtonCategoryCreatingNews();
        NewsSteps.clickButtonTitleCreatingNews();
        NewsSteps.clickButtonDateCreatingNews();
        NewsSteps.clickButtonOkDateCreatingNews();
        NewsSteps.clickButtonTimeCreatingNews();
        NewsSteps.clickButtonOkTimeCreatingNews();
        NewsSteps.clickDescriptionCreatingNews();
        NewsSteps.clickButtonSaveCreatingNews();
        MainSteps.checkDDListNewInBlock();
    }
}
