/*
  The prime factors of 13195 are 5, 7, 13 and 29.

  What is the largest prime factor of the number 600851475143 ?
*/

object Euler003 extends EulerTrait {
  val number = 600851475143l
  // find the smallest factor
  // recusively   call the same method  with the value of number/ smallest facor
  def maxPrimeFactor(number: Long):Long = (2l to math.sqrt(number).toLong) find (n => number % n == 0) match {
    case Some(factor) => maxPrimeFactor(number / factor)
    case _ => number
  }

 def answer = maxPrimeFactor(number)
}
