package edu.luc.etl.cs313.scala.clickcounter.ui

import org.junit.runner.RunWith
import org.robolectric.{Robolectric, RobolectricTestRunner}
import org.scalatest.junit.JUnitSuite

/**
 * Concrete Robolectric test subclass. The Robolectric-based tests
 * cannot run in parallel, so it is easiest just to stack all
 * abstract test superclasses (realized as stackable traits)
 * onto this concrete subclass.
 */
@RunWith(classOf[RobolectricTestRunner])
class RobolectricTestSuite extends JUnitSuite
with AbstractFunctionalTest
with AbstractViewUpdaterTest {
  override lazy val activity =
    Robolectric.buildActivity(classOf[MainActivity]).create().start().resume().get
}
