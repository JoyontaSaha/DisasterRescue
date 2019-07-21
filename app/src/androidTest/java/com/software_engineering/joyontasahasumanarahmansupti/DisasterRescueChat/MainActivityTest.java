package com.software_engineering.joyontasahasumanarahmansupti.DisasterRescueChat;


import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.app.PendingIntent.getActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateUserName() {
        onView(withId(R.id.userName)).perform(typeText("John")).check(matches(withText("John")));
    }
    @Test
    public void validateChatName() {
        onView(withId(R.id.chatName)).perform(typeText("Chat Room")).check(matches(withText("Chat Room")));
    }
}
