import scala.io.Source
import java.io.File
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;

object EulerApp {

  /** The main entry point for an Euler solution. Just calls `answer`. */
  def main(args: Array[String]) {
    if ((args.length < 2)||(args.length >= 2 && !args(1).forall(_.isDigit))) {
      println("Usage: run [generate|solve d]")
    }else{
    
    args(0) match {
      case "generate" => generate(args(1))
      case "solve" => solve(args(1))
      case _ =>
        println("Usage: run [generate|solve d]")
    }
    }
  }

  def generate(num: String) = {
    val questionNumber = getQuestionNumber(num)
    val fullName = "src/main/scala/Euler" + questionNumber + ".scala";
    val file = new File(fullName);
    if (file.exists()) {
      println(fullName + " already exists.");
      sys.exit(255);
    }

    println("Generating " + fullName + "...");
    val out = new PrintWriter(new FileWriter(file));
    out.println("object Euler" + questionNumber + " extends EulerTrait {");
    out.println("  def answer = \"<insert brilliant solution here>\"");
    out.println("}");
    out.close();
  }

  def solve(num: String) = {
    val questionNumber = getQuestionNumber(num)
    val n: Int = Integer.valueOf(num).intValue();
    val eulerQuestion = "Euler" + questionNumber + "$"
    val answer = getAnswer(eulerQuestion)
    println(answer)
  }

  private def getQuestionNumber(num: String): String = {

    val n: Int = Integer.valueOf(num).intValue();
    val questionNumber = "%03d".format(n)
    questionNumber
  }
  
  private def getAnswer(eulerQuestion: java.lang.String): Any = {
    try{
    val cons = Class.forName(eulerQuestion).getDeclaredConstructors();

    cons(0).setAccessible(true);
    val someObjectTrait: EulerTrait = cons(0).newInstance().asInstanceOf[EulerTrait]
    val answer = someObjectTrait.answer
    answer
    }catch{
      case _ =>println("Question "+eulerQuestion +" is not available")
    }
  }
}
