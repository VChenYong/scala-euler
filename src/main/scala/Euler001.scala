object Euler1 extends EulerTrait{
  def answer = (1 until 1000).filter(x=>x%3==0||x%5==0).sum
}