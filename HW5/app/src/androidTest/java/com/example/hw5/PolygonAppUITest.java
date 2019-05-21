package com.example.hw5;


import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4.class)

@LargeTest
public class PolygonAppUITest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testChangeSidesUI(){

        onView(withId(R.id.numberSides)).perform(typeText("4"));
        onView(withId(R.id.display_angles)).check(matches(withText(90)));
    }

    @Test
    public void testChangeLengthsUI(){

        onView(withId(R.id.sideLengthInput)).perform(typeText("3"));
        onView(withId(R.id.feet)).perform(click());
        onView(withId(R.id.display_angles)).check(matches(withText("9 Feet")));
    }



}
