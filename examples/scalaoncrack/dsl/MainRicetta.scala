package dsl

object MainRicetta extends Application with RicettaParser {
  
  /*
   http://www.cibo360.it/cucina/mondo/spaghetti_carbonara.htm
   */
  
  Ingredienti
  - 400 g di ("spaghetti");
  - 150 g di ("pancetta affumicata") o di ("guanciale");
  - 30 g di ("pecorino romano") o ("parmigiano"); 
  - 2 uova "intere";
  - sale e pepe;
  
  println(ingredienti)

  nuovaRicetta
  
  /*
  http://www.cibo360.it/cucina/mondo/pesto_genovese.htm
  */

  Ingredienti
	- 30 foglie di ("basilico appena colto");
	- 120 g di ("fiore sardo DOP grattuggiato");
	- 100 g di ("parmigiano reggiano DOP grattuggiato");
	- 2 spicchi di ("aglio");
	- 1/2 bicchiere di ("olio extra-vergine d'oliva ligure");
	- 50 g di ("pinoli")
	- sale 
  
  println(ingredienti)
 
  //prove, non implementate del tutto
 
  - del ("vino rosso") o del ("vino rosato")
  - del ("pane") e del ("vino")
  - 50 g di ("pane") o di ("grissini")
  - 50 g di ("pane") e del ("salame")
  - 50 g di ("pane") o 50 g di ("grissini")
  - del ("pane") o 50 g di ("vino")
  - 2 uova ("rotte") o ("intere")
  - pepe e sale e sale o pepe
}
