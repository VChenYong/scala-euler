/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91* 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/
object Euler004 extends EulerTrait {
  def answer = (100 to 999).flatMap(a=>(a to 999).map(b=> a*b)).filter( c=> c.toString == c.toString.reverse).max
}
