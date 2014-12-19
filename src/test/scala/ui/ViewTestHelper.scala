package edu.luc.etl.cs313.scala.clickcounter.ui

/**
 * A helper for tests with dependencies on views.
 * Provides auxiliary methods for easy access to UI widgets.
 */
trait ViewTestHelper {

  /** The activity to be provided by concrete subclasses of this test. */
  def activity(): MainActivity

  def valueTextView() = activity.findView(TR.textview_value)

  def displayedValue() = valueTextView().getText.toString.toInt

  def incButton() = activity.findView(TR.button_increment)

  def decButton() = activity.findView(TR.button_decrement)

  def resetButton() = activity.findView(TR.button_reset)
}
