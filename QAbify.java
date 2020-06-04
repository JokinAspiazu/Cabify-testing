
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import com.cabify.qabify.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class QAbifyDemo {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void qAbifyDemo() {
        ViewInteraction appCompatEditText = onView(
allOf(withId(R.id.user_name_edit_text),
childAtPosition(
childAtPosition(
withClassName(is("android.support.constraint.ConstraintLayout")),
0),
0),
isDisplayed()));
        appCompatEditText.perform(click());
        
        ViewInteraction appCompatEditText2 = onView(
allOf(withId(R.id.user_name_edit_text),
childAtPosition(
childAtPosition(
withClassName(is("android.support.constraint.ConstraintLayout")),
0),
0),
isDisplayed()));
        appCompatEditText2.perform(replaceText("user@qabify.com"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText3 = onView(
allOf(withId(R.id.password_edit_text),
childAtPosition(
childAtPosition(
withClassName(is("android.support.constraint.ConstraintLayout")),
0),
1),
isDisplayed()));
        appCompatEditText3.perform(replaceText("1234Abc"), closeSoftKeyboard());
        
        ViewInteraction appCompatButton = onView(
allOf(withId(R.id.login_button), withText("LOGIN"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
2),
1),
isDisplayed()));
        appCompatButton.perform(click());

        //somehow, get the value from the captcha        
        String observed_captcha_text = onView (allOf(withId(R.id.captcha_text.toString()));
        
        ViewInteraction appCompatButton2 = onView(
allOf(withId(R.id.captcha_button), withText("Next"),
childAtPosition(
childAtPosition(
withClassName(is("android.support.constraint.ConstraintLayout")),
0),
1),
isDisplayed()));
        appCompatButton2.perform(click());
        
        ViewInteraction appCompatEditText4 = onView(
allOf(withId(R.id.captcha_text),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
4),
1),
isDisplayed()));
        appCompatEditText4.perform(click());
        
        ViewInteraction appCompatEditText5 = onView(
allOf(withId(R.id.captcha_text),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
4),
1),
isDisplayed()));
        appCompatEditText5.perform(replaceText("744"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText6 = onView(
allOf(withId(R.id.captcha_text), withText(observed_captcha_text),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
4),
1),
isDisplayed()));
        appCompatEditText6.perform(click());
        
        ViewInteraction appCompatSpinner = onView(
allOf(withId(R.id.drop_off_point),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
1),
1),
isDisplayed()));
        appCompatSpinner.perform(click());
        
        DataInteraction appCompatTextView = onData(anything())
.inAdapterView(childAtPosition(
withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
0))
.atPosition(1);
        appCompatTextView.perform(click());
        
        ViewInteraction appCompatButton3 = onView(
allOf(withId(R.id.estimate_button), withText("EstIMATE"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
6),
0),
isDisplayed()));
        appCompatButton3.perform(click());
        
        ViewInteraction appCompatButton4 = onView(
allOf(withId(R.id.request_button), withText("Request Car"),
childAtPosition(
childAtPosition(
withClassName(is("android.widget.LinearLayout")),
6),
1),
isDisplayed()));
        appCompatButton4.perform(click());
        
        ViewInteraction textView2 = onView(
allOf(withId(R.id.journeyPrice), withText("35.2 €"),
childAtPosition(
allOf(withId(R.id.JourneyLayout),
childAtPosition(
withId(R.id.journeyList),
0)),
1),
isDisplayed()));
        textView2.check(matches(withText("35.2 €")));
        }
    
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup)parent).getChildAt(position));
            }
        };
    }
    }
