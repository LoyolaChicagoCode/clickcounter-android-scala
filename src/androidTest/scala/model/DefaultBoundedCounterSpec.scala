package edu.luc.etl.cs313.scala.clickcounter.model

/** A concrete testcase subclass for StatelessBoundedCounter. */
class DefaultBoundedCounterSpec extends AbstractBoundedCounterSpec {
  override def fixture() = new DefaultBoundedCounter(0, 10)
}
