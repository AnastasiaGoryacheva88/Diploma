package steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isFocusable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static pages.Claims.getClaimsElementsButtonAddClaim;
import static pages.Claims.getClaimsElementsButtonCancelClaim;
import static pages.Claims.getClaimsElementsButtonClaims;
import static pages.Claims.getClaimsElementsButtonFilter;
import static pages.Claims.getClaimsElementsButtonMainMenu;
import static pages.Claims.getClaimsElementsButtonOk;
import static pages.Claims.getClaimsElementsButtonOkDate;
import static pages.Claims.getClaimsElementsButtonOkError;
import static pages.Claims.getClaimsElementsButtonOkNotification;
import static pages.Claims.getClaimsElementsButtonOkTime;
import static pages.Claims.getClaimsElementsButtonSave;
import static pages.Claims.getClaimsElementsCheckBoxCancelled;
import static pages.Claims.getClaimsElementsCheckBoxExecuted;
import static pages.Claims.getClaimsElementsDateField;
import static pages.Claims.getClaimsElementsDescriptionField;
import static pages.Claims.getClaimsElementsExecutorField;
import static pages.Claims.getClaimsElementsRemoveCheckBoxInProgress;
import static pages.Claims.getClaimsElementsRemoveCheckBoxOpen;
import static pages.Claims.getClaimsElementsTimeField;
import static pages.Claims.getClaimsElementsTitleField;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class ClaimsSteps {


    public static void clickButtonMainMenu() {
        Allure.step("Нажать на кнопку Main");
        onView(getClaimsElementsButtonMainMenu())
                .perform(click());
    }

    public static void clickButtonClaims() {
        Allure.step("Нажать на кнопку Claims");
        onView(getClaimsElementsButtonClaims())
                .perform(click());
    }

    public static void clickButtonFilter() {
        Allure.step("Нажать на кнопку Filtering");
        onView(getClaimsElementsButtonFilter())
                .perform(click());
    }

    public static void clickRemoveCheckBoxOpen() {
        Allure.step("Снять флажок с чекбокса Open");
        onView(getClaimsElementsRemoveCheckBoxOpen())
                .perform(click());
    }

    public static void clickButtonOk() {
        Allure.step("Нажать кнопку ОК");
        onView(getClaimsElementsButtonOk())
                .perform(click());
    }

    public static void clickRemoveCheckBoxInProgress() {
        Allure.step("Снять флажок с чекбокса In progress");
        onView(getClaimsElementsRemoveCheckBoxInProgress())
                .perform(click());
    }

    public static void clickCheckBoxExecuted() {
        Allure.step("Отметить в чек-боксах критерий Cancelled");
        onView(getClaimsElementsCheckBoxExecuted())
                .perform(click());
    }

    public static void clickCheckBoxCancelled() {
        Allure.step("Отметить в чек-боксах критерий  Executed");
        onView(getClaimsElementsCheckBoxCancelled())
                .perform(click());
    }

    public static void clickButtonAddClaim() {
        Allure.step("Нажать кнопку +");
        onView(getClaimsElementsButtonAddClaim())
                .perform(click());
    }

    public static void clickTitleField(String value) {
        Allure.step("Ввести в поле Title название на английском языке");
        onView(getClaimsElementsTitleField())
                .perform(replaceText(value), closeSoftKeyboard());
    }

    public static void clickCheckBoxExecutorField(String value) {
        Allure.step("В поле Executor выбрать ФИО из выпадающего списка");
        onView(getClaimsElementsExecutorField())
                .perform(replaceText(value), closeSoftKeyboard());
    }

    public static void clickDateField() {
        Allure.step("В поле Date выбрать дату из календаря");
        onView(getClaimsElementsDateField())
                .perform(click());
    }

    public static void clickButtonOkDate() {
        Allure.step("Нажать кнопку ОК");
        onView(getClaimsElementsButtonOkDate())
                .perform(click());
    }

    public static void clickTimeField() {
        Allure.step("В поле Time выбрать необходимое время");
        onView(getClaimsElementsTimeField())
                .perform(click());
    }

    public static void clickButtonOkTime() {
        Allure.step("Нажать кнопку ОК");
        onView(getClaimsElementsButtonOkTime())
                .perform(click());
    }

    public static void clickDescriptionField(String value) {
        Allure.step("Ввести в поле Description описание на английском языке");
        onView(getClaimsElementsDescriptionField())
                .perform(replaceText(value), closeSoftKeyboard());
    }

    public static void clickButtonSave() {
        Allure.step("Нажать кнопку Save");
        onView(getClaimsElementsButtonSave())
                .perform(click());
    }

    public static void clickButtonOkError() {
        Allure.step("Нажать кнопку ОК в всплывающем окне ошибки");
        onView(allOf(withId(R.id.message), isFocusable()));
        onView(getClaimsElementsButtonOkError())
                .perform(click());
    }

    public static void errorIconInField() {
        Allure.step(" Система выдает ошибку Fill empty fields");
        onView(allOf(withId(R.id.text_input_end_icon), isFocusable()));
    }


    public static void clickButtonCancelClaim() {
        Allure.step("Нажать кнопку cancel");
        onView(getClaimsElementsButtonCancelClaim())
                .perform(click());
    }

    public static void clickButtonOkNotification() {
        Allure.step("Нажать кнопку ОК Уведомления");
        onView(getClaimsElementsButtonOkNotification())
                .perform(click());
    }
}
