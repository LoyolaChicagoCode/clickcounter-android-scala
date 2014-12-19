package edu.luc.etl.cs313.scala.clickcounter.model

/** A mutable counter abstraction. */
trait Counter {

  /** Returns the counter value. */
  def get(): Int

  /** Increments the counter value. */
  def increment(): Unit

  /** Decrements the counter value. */
  def decrement(): Unit
}