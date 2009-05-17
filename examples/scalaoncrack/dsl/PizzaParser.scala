package dsl

import scala.io.Source
import scala.util.parsing.combinator.syntactical.StandardTokenParsers

object MainPizzaParser extends Application {

  val parser = new PizzaParser
  val s = "PIZZA PIZZA 2 PIZZE 1 BIRRA BIRRA E PIZZA E 2 BIRRE";
  val result = parser.parse(s)
  println("pizze: " + parser.pizze)
  println("birre: " + parser.birre)
}

class PizzaParser extends StandardTokenParsers {
  
  var birre: Int = 0
  var pizze: Int = 0
  
  lexical.reserved += ("PIZZA", "BIRRA", "PIZZE", "BIRRE", "E")
  def program = (opt("E") ~> ciboExp)+;
  def ciboExp = (numericLit ~ cibo ^^ {
 case n ~ "BIRRE" => birre += n.toInt
                                case n ~ "BIRRA" => birre += n.toInt
                                case n ~ "PIZZA" => pizze += n.toInt
                                case n ~ "PIZZE" => pizze += n.toInt
  																		} 
                 | cibo ^^ 	{
															case "BIRRA" => birre += 1
															case "PIZZA" => pizze += 1
                 						})
  def cibo = ("PIZZA" | "BIRRA" | "PIZZE" | "BIRRE")


  def parse(input: String) = {
    val tokens = new lexical.Scanner(input)
    phrase(program)(tokens)
  }
}

