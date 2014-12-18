package edu.luc.etl.cs313.scala.clickcounter
package ui

import android.view.View
import org.mockito.Mockito._
import org.scalatest.FunSpec
import org.scalatest.mock.MockitoSugar
import model.BoundedCounter

/**
 * A unit test of AbstractAdapter that uses mocking to satisfy the dependencies
 * (collaborators).
 */
class InputListenerSpec extends FunSpec with MockitoSugar {

  /** Factory method for test fixtures. */
  def fixture() = new {
    // create fake instances of the collaborators
    val mdl = mock[BoundedCounter]
    // Scala-specific: one of the collaborators is a stackable trait (mixin)
    trait FakeViewUpdater {
      def updateView() = { }
    }
    // create subject-under-test (SUT)
    val adapter = new InputListener with FakeViewUpdater {
      override lazy val model = mdl // injected dependency
    }
  }

  describe("A clickcounter adapter") {
    it("passes onIncrement to the model") {
      // create and import fixture
      val f = fixture()
      import f._
      // exercise SUT
      adapter.onIncrement(null)
      // verify interaction with collaborators
      verify(mdl).increment()
    }
    it("passes onDecrement to the model") {
      // create and import fixture
      val f = fixture()
      import f._
      // exercise SUT
      adapter.onDecrement(null)
      // verify interaction with collaborators
      verify(mdl).decrement()
    }
    it("passes onReset to the model") {
      // create and import fixture
      val f = fixture()
      import f._
      // exercise SUT
      adapter.onReset(null)
      // verify interaction with collaborators
      verify(mdl).reset()
    }
  }
}
