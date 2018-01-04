package com.zigzag.whar.ui.login

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.zigzag.whar.R
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import com.zigzag.whar.ui.dashboard.DashboardActivity

/**
 * Created by salah on 30/12/17.
 */

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule @JvmField
    val loginActivityTestRule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java, true, true)


    @Test
    public fun checkIfSubmitButtonIsEnablingWhenNumberIsValid() {
        onView(withId(R.id.et_number)).perform(typeText("9895"))
        onView(withId(R.id.btn_submit)).check(matches(not(isEnabled())))

        onView(withId(R.id.et_number)).perform(typeText("340989"))
        onView(withId(R.id.btn_submit)).check(matches(isEnabled()))

        onView(withId(R.id.et_number)).perform(typeText("9895"))
        onView(withId(R.id.btn_submit)).check(matches(not(isEnabled())))

    }

    @Test
    public fun checkIfCodeInputViewIsDisplayedWhenCorrectNumberInputted() {
        onView(withId(R.id.et_number)).perform(typeText("9895940989"))
        onView(withId(R.id.btn_submit)).perform(click())
        intended(hasComponent(DashboardActivity::class.java.name))
    }

}