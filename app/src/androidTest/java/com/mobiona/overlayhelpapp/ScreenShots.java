package com.mobiona.overlayhelpapp;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.locale.LocaleTestRule;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(JUnit4.class)
public class ScreenShots {
    @ClassRule
    public static final LocaleTestRule localeTestRule = new LocaleTestRule();

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testTakeScreenshot() {
        Screengrab.screenshot("BeforeText");

        // Your custom onView...
        Espresso.onView(withId(R.id.textview)).perform(click());
        Screengrab.screenshot("AfterText");
    }
    @Test
    public void clickButtonTest(){
        Screengrab.screenshot("NoClick");

        Espresso.onView(withId(R.id.button)).perform(click());

        Screengrab.screenshot("OnClicked");
    }
}
