package edu.luc.etl.cs313.scala.clickcounter
package ui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import model.{DefaultBoundedCounter, BoundedCounter}

/**
 * The main Android activity, which provides the required lifecycle methods.
 * By mixing in the abstract Adapter behavior, this class serves as the Adapter
 * in the Model-View-Adapter pattern. It connects the Android GUI view with the
 * model. The model implementation is configured externally via the resource
 * R.string.model_class.
 */
class MainActivity extends Activity with InputListener with ViewUpdater {

  private def TAG = "clickcounter-android-scala"

  // inject the dependency on the model into the stackable mixin traits
  override lazy val model = new DefaultBoundedCounter

  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    Log.i(TAG, "onCreate")
    // inject the (implicit) dependency on the view
    setContentView(R.layout.main)
  }

  override def onStart() = {
    super.onStart()
    Log.i(TAG, "onStart")
    updateView()
  }
}