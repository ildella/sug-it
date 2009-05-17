package dsl

class UnitaDiMisura(qta: Int, unita: String) {
  override def toString = qta + " " + unita;
}

class Cibo(nome: String) {
  override def toString = nome;
}

class Ingrediente(cibo: Cibo, qta: UnitaDiMisura) {
  override def toString = qta + " di " + cibo;
}

class QtaParser {
}

trait CiboExp {
  var descr: String = ""
}

class CiboExpImpl extends CiboExp {
}

trait QtaExp {
  
  var ricettaExp: RicettaExp = null
  
  var unita:String = "";
  var qta: Int = 0;
  
  def add(di: CiboExp) {
	  ricettaExp.add(new Cibo(di.descr))    
  }
  
  def g(di: CiboExp) = { unita = "grammi"; add(di); ricettaExp }
  
  def foglie(di: CiboExp) = { unita = "foglie"; add(di); ricettaExp }
  
  def spicchi(di: CiboExp) = {unita = "spicchi"; add(di); ricettaExp }

  def bicchiere(di: CiboExp) = {unita = "bicchiere"; add(di); ricettaExp }

}

class QtaExpImpl(ricetta: RicettaExp) extends QtaExp {
  ricettaExp = ricetta;
}

trait RicettaParser extends RicettaExp with CiboExp {
  
}

trait RicettaExp {
  
  val ciboExp = new CiboExpImpl
  val qtaExp =  new QtaExpImpl(this)
  
  var ingredienti:List[Ingrediente] = List()

  def unary_-() = {this} 

  implicit def intToQtaParser(x: Int) = { qtaExp.qta = x; qtaExp }
  implicit def intToQtaParser2(x: Int) = { qtaExp.qta = x; this }
  
  def Ingredienti = this
  
  def di(descr: String) = { 
    ciboExp.descr = descr; ciboExp
  }

  def del(descr: String) = { 
    ciboExp.descr = descr; this
  }
  
  def e(x: RicettaExp) = {this}

  def o(x: String) = {this}

  def o(x: CiboExp) = {this}

  def o(x: RicettaExp) = {qtaExp}

  // cibi
  def uova(tipo: String) = { 
    qtaExp.unita = ""
	  add(new Cibo("uova " + tipo))
	  this
  }

  def sale = {
    val cibo = new Cibo("sale")
    qtaExp.qta = 1
    qtaExp.unita = "po'"
    add(cibo)
    this
  }
  
  def pepe = {
    val cibo = new Cibo("pepe")
    qtaExp.qta = 1
    qtaExp.unita = "po'"
    add(cibo)
    this
  }

  def add(cibo: Cibo) {
    ingredienti = ingredienti ::: List(new Ingrediente(cibo, new UnitaDiMisura(Math.abs(qtaExp.qta), qtaExp.unita)))
  }
  
  def nuovaRicetta = {ingredienti = List()}
}

