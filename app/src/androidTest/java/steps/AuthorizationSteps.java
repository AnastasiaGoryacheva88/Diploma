package steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.Matchers.allOf;
import static standby.WaitingMode.waitUntilElement;
import static pages.Authorization.exitBtn;
import static pages.Authorization.logOut;
import static pages.Authorization.loginButton;
import static pages.Authorization.loginField;
import static pages.Authorization.loginFieldAsTextField;
import static pages.Authorization.passwordField;
import static pages.Authorization.passwordFieldAsTextField;
import static pages.Authorization.titleTextElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import pages.Authorization;

public class AuthorizationSteps {
    public static void login() {
        try {
            AuthorizationSteps.textAuthorization();
            AuthorizationSteps.clickLoginField("login2");
            AuthorizationSteps.clickPasswordField("password2");
            Authorization.clickButtonSingIn();
        } catch (androidx.test.espresso.NoMatchingViewException e) {
            System.out.println("Already login");
        }}

    public static void clickButtonSingIn() {
        Allure.step("Нажать на кнопку Sing in");
        waitUntilElement(R.id.enter_button);
        loginButton.perform(click());
    }

    public static void clickLoginField(String login) {
        Allure.step("В поле Login ввести login");
        waitUntilElement(R.id.login_text_input_layout);
        loginFieldAsTextField.perform(click());
        loginFieldAsTextField.perform(replaceText(login), closeSoftKeyboard());
        loginField.check(matches(isDisplayed()));
    }

    public static void clickPasswordField(String password) {
        Allure.step("В поле Password ввести password");
        waitUntilElement(R.id.password_text_input_layout);
        passwordFieldAsTextField.perform(click());
        passwordFieldAsTextField.perform(replaceText(password), closeSoftKeyboard());
        passwordField.check(matches(isDisplayed()));
    }

    public static void clickButtonExit() {
        Allure.step("Нажать на кнопку Sing in");
        waitUntilElement(R.id.authorization_image_button);
        exitBtn.check(matches(isDisplayed()));
        exitBtn.perform(click());
    }

    public static void clickButtonLogOut() {
        Allure.step("Нажать на кнопку для выхода из приложения");
        waitUntilElement(android.R.id.title);
        logOut.perform(click());
    }

    public static void textAuthorization() {
        Allure.step("Отобразилаcь страница Авторизации");
        waitUntilElement(R.id.nav_host_fragment);
        titleTextElement.check(matches(isDisplayed()));
    }

    public static void textErrorWrong() {
        Allure.step("Отобразилаcь ошибка Wrong login or password");
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    public static void textErrorEmpty() {
        Allure.step("Отобразилаcь ошибка Login and password cannot be empty");
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }
}
