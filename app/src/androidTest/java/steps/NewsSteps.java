package steps;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static pages.News.editNewsInNewsPage;
import static pages.News.getNewsControlPanelElementsAddNews;
import static pages.News.getNewsControlPanelElementsButtonCategoryCreatingNews;
import static pages.News.getNewsControlPanelElementsButtonDateCreatingNews;
import static pages.News.getNewsControlPanelElementsButtonOkDateCreatingNews;
import static pages.News.getNewsControlPanelElementsButtonOkTimeCreatingNews;
import static pages.News.getNewsControlPanelElementsButtonSaveCreatingNews;
import static pages.News.getNewsControlPanelElementsButtonTimeCreatingNews;
import static pages.News.getNewsControlPanelElementsButtonTitleCreatingNews;
import static pages.News.getNewsControlPanelElementsDescriptionCreatingNews;

import io.qameta.allure.kotlin.Allure;

public class NewsSteps {

    public static void clickEditNewsInNewsPage(){
        Allure.step("Нажать на кнопку редактирование необходимой новости");
        onView(editNewsInNewsPage())
                .perform(click());
    }

    public static void clickAddNews(){
        Allure.step("Нажать на кнопку + создать новость");
        onView(getNewsControlPanelElementsAddNews())
                .perform(click());
    }

    public static void clickButtonCategoryCreatingNews(){
        Allure.step("Выбрать значение  из выпадающего списка в поле Category");
        onView(getNewsControlPanelElementsButtonCategoryCreatingNews())
                .perform(click());
    }

    public static void clickButtonTitleCreatingNews(){
        Allure.step("Ввести значения на Английском языке в поле Title");
        onView(getNewsControlPanelElementsButtonTitleCreatingNews())
                .perform(click(), clearText(), replaceText("Actual news for today"), closeSoftKeyboard());
    }

    public static void clickButtonDateCreatingNews(){
        Allure.step(" Выбрать дату публикации");
        onView(getNewsControlPanelElementsButtonDateCreatingNews())
                .perform(click());
    }

    public static void clickButtonOkDateCreatingNews(){
        Allure.step("Нажать кнопку ОК Дата");
        onView(getNewsControlPanelElementsButtonOkDateCreatingNews())
                .perform(click());
    }

    public static void clickButtonTimeCreatingNews(){
        Allure.step("Выбрать время публикации");
        onView(getNewsControlPanelElementsButtonTimeCreatingNews())
                .perform(click());
    }
    public static void clickButtonOkTimeCreatingNews(){
        Allure.step("Нажать кнопку ОК Время");
        onView(getNewsControlPanelElementsButtonOkTimeCreatingNews())
                .perform(click());
    }
    public static void clickDescriptionCreatingNews(){
        Allure.step("Добавить описание в поле Description");
        onView(getNewsControlPanelElementsDescriptionCreatingNews())
                .perform(replaceText("new event"), closeSoftKeyboard());
    }



    public static void clickButtonSaveCreatingNews(){
        Allure.step("Нажать кнопку Save");
        onView(getNewsControlPanelElementsButtonSaveCreatingNews())
                .perform(scrollTo(), click());
    }
}
