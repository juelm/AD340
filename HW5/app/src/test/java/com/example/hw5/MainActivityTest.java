package com.example.hw5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowToast;

import static junit.framework.TestCase.assertEquals;

@RunWith(RobolectricTestRunner.class)

public class MainActivityTest {

    @Test
    public void testNotEnoughDataProvided(){
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        activity.findViewById(R.id.button).performClick();

        assertEquals("Sides Can't be Blank", ShadowToast.getTextOfLatestToast());

        activity.findViewById(R.id.button2).performClick();

        assertEquals("Length Can't be Blank", ShadowToast.getTextOfLatestToast());
    }
}
