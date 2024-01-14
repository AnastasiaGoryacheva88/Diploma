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
import steps.ClaimsSteps;
import steps.MainSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsCases {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authorization() {
        AuthorizationSteps.login();
    }

    @Test
    @Tag("16")
    @Story("Создание новой претензии с полным заполнением валидными значениями")
    public void addNewClaim() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickTitleField("A new representative's call to the house");
        ClaimsSteps.clickCheckBoxExecutorField("Иванов Сергей Викторович");
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField("The patient asked to be taken to the park");
        ClaimsSteps.clickButtonSave();
        MainSteps.claimsPage();
    }
    @Test
    @Tag("19")
    @Story("Создание новой претензии с пустым полем Title")
    public void titleFieldIsEmpty() {
        ClaimsSteps.clickButtonMainMenu();
        ClaimsSteps.clickButtonClaims();
        ClaimsSteps.clickButtonAddClaim();
        ClaimsSteps.clickCheckBoxExecutorField("Иванов Сергей Викторович");
        ClaimsSteps.clickDateField();
        ClaimsSteps.clickButtonOkDate();
        ClaimsSteps.clickTimeField();
        ClaimsSteps.clickButtonOkTime();
        ClaimsSteps.clickDescriptionField("The patient asked to be taken to the park");
        ClaimsSteps.clickButtonSave();
        ClaimsSteps.clickButtonOkError();
        ClaimsSteps.errorIconInField();
        ClaimsSteps.clickButtonCancelClaim();
        ClaimsSteps.clickButtonOkNotification();
    }

    @Test
    @Tag("29")
    @Story("Фильтрация заявок при выборе всех чек -боксов критериев сортировки")
    public void applicationAllFilter() {
        MainSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickCheckBoxExecuted();
        ClaimsSteps.clickCheckBoxCancelled();
        ClaimsSteps.clickButtonOk();
        MainSteps.claimsPage();
    }
    @Test
    @Tag("30")
    @Story("Фильтрация заявок при выборе чек-бокса Open")
    public void applicationFilterOpen() {
        MainSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxOpen();
        ClaimsSteps.clickButtonOk();
        MainSteps.claimsPage();
    }

    @Test
    @Tag("31")
    @Story("Фильтрация заявок при выборе чек-бокса InProgress")
    public void applicationFilterInProgress() {
        MainSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickRemoveCheckBoxInProgress();
        ClaimsSteps.clickButtonOk();
        MainSteps.claimsPage();
    }

    @Test
    @Tag("32")
    @Story("Фильтрация заявок при выборе чек-бокса Executed")
    public void applicationFilterExecuted() {
        MainSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickCheckBoxExecuted();
        ClaimsSteps.clickButtonOk();
        MainSteps.claimsPage();
    }

    @Test
    @Tag("33")
    @Story("Фильтрация заявок при выборе чек-бокса Cancelled")
    public void applicationFilterCancelled() {
        MainSteps.clickButtonClaims();
        ClaimsSteps.clickButtonFilter();
        ClaimsSteps.clickCheckBoxCancelled();
        ClaimsSteps.clickButtonOk();
        MainSteps.claimsPage();
    }
}

