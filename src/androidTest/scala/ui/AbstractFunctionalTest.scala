package edu.luc.etl.cs313.scala.clickcounter.ui

import org.junit.Assert._
import org.junit.Test
import org.scalatest.mock.MockitoSugar

/**
 * An abstract GUI-based functional test for the clickcounter app.
 * This follows the XUnit Testcase Superclass pattern.
 */
trait AbstractFunctionalTest extends MockitoSugar with ViewTestHelper {

  @Test def activityExists(): Unit =
    assertNotNull(activity)

  @Test def activityHasCorrectInitialValue(): Unit =
    assertEquals(0, displayedValue)

  @Test def activityScenarioIncReset(): Unit = {
    assertEquals(0, displayedValue)
    assertTrue(incButton.isEnabled)
    assertFalse(decButton.isEnabled)
    assertTrue(resetButton.isEnabled)
    assertTrue(incButton.performClick())
    assertEquals(1, displayedValue)
    assertTrue(incButton.isEnabled)
    assertTrue(decButton.isEnabled)
    assertTrue(resetButton.isEnabled)
    assertTrue(resetButton.performClick())
    assertEquals(0, displayedValue)
    assertTrue(incButton.isEnabled)
    assertFalse(decButton.isEnabled)
    assertTrue(resetButton.isEnabled)
  }

  @Test def activityScenarioIncUntilFull(): Unit = {
    assertEquals(0, displayedValue)
    assertTrue(incButton.isEnabled)
    assertFalse(decButton.isEnabled)
    assertTrue(resetButton.isEnabled)
    while (incButton.isEnabled) {
      val v = displayedValue
      assertTrue(incButton.performClick())
      assertEquals(v + 1, displayedValue)
    }
    assertFalse(incButton.isEnabled)
    assertTrue(decButton.isEnabled)
    assertTrue(resetButton.isEnabled)
  }
}
