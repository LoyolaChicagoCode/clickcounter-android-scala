package edu.luc.etl.cs313.scala.clickcounter
package ui

import android.view.View
import model.BoundedCounter

/**
 * An input listener mixin as part of the Adapter in the Model-View-Adapter pattern.
 * It maps semantic events to interactions with the model. To enable unit testing,
 * this has no class-level dependencies on Android and is separate from the view
 * updater by leaving the updateView method abstract.
 */
trait InputListener {

  protected val model: BoundedCounter

  /**
   * Handles the semantic increment event. (Semantic as opposed to, say, a
   * concrete button press.) This and similar events are connected to the
   * corresponding onClick events (actual button presses) in the view itself,
   * usually with the help of the graphical layout editor; the connection also
   * shows up in the XML source of the view layout.
   */
  def onIncrement(view: View) = { model.increment() ; updateView() }

  /** Handles the semantic decrement event. */
  def onDecrement(view: View) = { model.decrement() ; updateView() }

  /** Handles the semantic decrement event. */
  def onReset(view: View) = { model.reset() ; updateView() }

  /** Updates the view from the model. */
  protected def updateView(): Unit
}

/**
 * A view updater mixin as part of the Adapter in the Model-View-Adapter pattern.
 * It implements the `updateView` method to update the view from the model.
 */
trait ViewUpdater extends TypedViewHolder {

  protected val model: BoundedCounter

  /** Updates the view from the model. */
  protected def updateView() = {
    // update display
    findView(TR.textview_value).setText(model.get.toString)
    // afford controls according to model state
    findView(TR.button_increment).setEnabled(! model.isFull)
    findView(TR.button_decrement).setEnabled(! model.isEmpty)
  }
}