package edu.luc.etl.cs313.scala.clickcounter
package ui

import org.junit.Test
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar
import model.BoundedCounter

/**
 * An abstract GUI-based functional test for the clickcounter app.
 * This follows the XUnit Testcase Superclass pattern.
 */
trait AbstractViewUpdaterTest extends MockitoSugar with ViewTestHelper {

  @Test def viewUpdaterAccessesModel(): Unit = {
    // create fake instances of the collaborators
    val mdl = mock[BoundedCounter]
    // Scala-specific: one of the collaborators is a stackable trait (mixin)
    trait FakeTypedActivityHolder extends TypedActivityHolder {
      override def findViewById(id: Int) = activity.findViewById(id)
    }
    // create subject-under-test (SUT)
    val updater = new ViewUpdater with FakeTypedActivityHolder {
      override lazy val model = mdl // injected dependency
    }
    // exercise SUT
    updater.updateView()
    // verify interaction with the mock
    verify(mdl).get
    verify(mdl).isEmpty
    verify(mdl).isFull
  }
}
