package edu.luc.etl.cs313.scala.clickcounter
package ui

import android.view.View
import org.mockito.Mockito._
import org.scalatest.FunSpec
import org.scalatest.mock.MockitoSugar
import model.BoundedCounter

/**
 * A concrete unit test for InputListener that uses stubbing and mocking
 * to replace the real dependencies (collaborators) and test the
 * interactions.
 */
class InputListenerSpec extends FunSpec with MockitoSugar {

  /** Factory method for test fixtures. */
  def fixture() = new {
    // create fake instances of the collaborators
    val mdl = mock[BoundedCounter]
    // Scala-specific: one of the collaborators is a stackable trait (mixin).
    // This one is a stub (as opposed to a mock) because we are not asserting
    // or verifying anything on it.
    trait FakeViewUpdater {
      def updateView() = { }
    }
    // create system-under-test (SUT)
    val adapter = new InputListener with FakeViewUpdater {
      override lazy val model = mdl // injected dependency
    }
  }

  val DUMMY: View = null

  describe("A clickcounter input listener") {
    it("passes onIncrement to the model") {
      // create and import fixture
      val f = fixture()
      import f._
      // exercise SUT
      adapter.onIncrement(DUMMY)
      // verify interaction with the mock
      verify(mdl).increment()
    }
    it("passes onDecrement to the model") {
      // create and import fixture
      val f = fixture()
      import f._
      // exercise SUT
      adapter.onDecrement(DUMMY)
      // verify interaction with the mock
      verify(mdl).decrement()
    }
    it("passes onReset to the model") {
      // create and import fixture
      val f = fixture()
      import f._
      // exercise SUT
      adapter.onReset(DUMMY)
      // verify interaction with the mock
      verify(mdl).reset()
    }
  }
}
