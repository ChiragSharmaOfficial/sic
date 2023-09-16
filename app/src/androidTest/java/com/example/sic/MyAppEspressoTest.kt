import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.sic.MainActivity
import com.example.sic.DetailActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import au.edu.swin.sdmd.thecontest.R
import au.edu.swin.sdmd.thecontest.R.layout.activity_detail

@RunWith(AndroidJUnit4::class)
class MyAppEspressoTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testMainActivityUI() {
        // Click on the first item in the list
        Espresso.onView(ViewMatchers.withId(R.id.listView))
            .perform(ViewActions.actionOnItemAtPosition(0, ViewActions.click()))

        // Check if the com.example.sic.DetailActivity is displayed
        Espresso.onView(ViewMatchers.withId(R.id.itemName)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.ratingBar)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        // Add more checks as needed for other UI elements in com.example.sic.DetailActivity
    }

    @Test
    fun testDetailActivityUI() {
        // Create a sample Item for testing
        val item = Item(
            name = "Test Item",
            rating = 4.0,
            attribute = "Sample Attribute",
            pricePerDay = 10.0,
            imageResourceId = R.drawable.placeholder_imagea,
            reservationData = "Sample Reservation Data"
        )

        // Create an intent with the sample item
        val intent = DetailActivity.ne wIntent(
            InstrumentationRegistry.getInstrumentation().targetContext,
            item
        )

        // Launch com.example.sic.DetailActivity with the intent
        val activityScenario = ActivityScenario.launch<DetailActivity>(intent)

        // Perform UI testing specific to com.example.sic.DetailActivity
        Espresso.onView(ViewMatchers.withId(R.id.itemName)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.ratingBar)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Customize UI testing actions and assertions for com.example.sic.DetailActivity
        // Example:
        // Espresso.onView(ViewMatchers.withId(R.id.attributeRadioGroup)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        // Espresso.onView(ViewMatchers.withId(R.id.priceEditText)).perform(ViewActions.typeText("20.0"), ViewActions.closeSoftKeyboard())
        // Espresso.onView(ViewMatchers.withId(R.id.saveButton)).perform(ViewActions.click())

        // Add more test actions and assertions for com.example.sic.DetailActivity here
        // For example, interact with UI elements, perform actions, and make assertions

        // Don't forget to close the activity scenario when done
        activityScenario.close()
    }
}
