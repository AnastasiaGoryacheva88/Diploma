package testCase;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import io.qameta.allure.kotlin.junit4.Tag;
import ru.iteco.fmhandroid.ui.AppActivity;
import pages.Authorization;
import steps.AuthorizationSteps
@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Авторизация")
public class AuthorizationCases {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void loginAuth() {
        try {
            AuthorizationSteps.textAuthorization();
        } catch (androidx.test.espresso.NoMatchingViewException e) {
            AuthorizationSteps.clickButtonExit();
            AuthorizationSteps.clickButtonLogOut();
        }
    }

    @Test
    @Tag("1")
    @Story("Авторизация.Вход в приложение с валидным логином и паролем")
    public void successfulAuthorization() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("password2");
        Authorization.clickButtonSingIn();
        Authorization.clickButtonExit();
        AuthorizationSteps.clickButtonLogOut();
    }

    @Test
    @Tag("2")
    @Story("Вход в приложение с не валидным логиным и валидным паролем")
    public void loginFieldLogin() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login");
        AuthorizationSteps.clickPasswordField("password2");
        Authorization.clickButtonSingIn();
        Authorization.textErrorWrong();
    }
    @Test
    @Tag("3")
    @Story("Вход в приложение с валидным логиным и не валидным паролем")
    public void loginFieldPassword() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("password");
        Authorization.clickButtonSingIn();
        Authorization.textErrorWrong();
    }

    @Test
    @Tag("4")
    @Story("Вход в приложение с не валидными логиным и паролем")
    public void loginField() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField("login");
        AuthorizationSteps.clickPasswordField("password");
        Authorization.clickButtonSingIn();
        Authorization.textErrorWrong();
    }
    @Test
    @Tag("5")
    @Story("Вход в приложение когда логин или пароль не заполнен")
    public void loginFieldIsEmpty() {
        AuthorizationSteps.textAuthorization();
        AuthorizationSteps.clickLoginField(" ");
        AuthorizationSteps.clickPasswordField("");
        Authorization.clickButtonSingIn();
        Authorization.textErrorEmpty();
    }
    }

