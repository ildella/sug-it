def follow(x: String)= println("follow "+x)
def show (x: String)= println("show "+x)
def list() = println("list")

def usage() = { 
    println("usage:\n [follow <word>|show <word>|list]")
    exit(1)
}
args match {
    case Array("follow", word) => follow(word)
    case Array("show", word)   => show(word)
    case Array("list")         => list()
    case _ => usage()
}
// vim: set ts=4 sw=4 et:
