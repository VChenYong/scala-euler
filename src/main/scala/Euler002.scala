/*
Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

 */

object Euler002 extends EulerTrait {
  def answer = {
    lazy val fibonacci: Stream[Int] = 0 #:: 1 #:: fibonacci.zip(fibonacci.tail).map(p => p._1 + p._2)
    fibonacci.view.takeWhile(_ <= 4000000).filter(_ % 2 == 0).sum
  }

}
