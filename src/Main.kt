fun main() {

    menu()

}


var convidado:Convidado = Convidado()

//Instanciando uma lista multavel
var listaconvidados : MutableList< Convidado> = mutableListOf< Convidado>()
private fun menu() {
    do {


        println("-------Menu-------")
        println("1- Cadastrar ")
        println("2- Listar ")
        println("3- Editar ")
        println("4- Excluir ")
        println("5- Sair ")

        val opcao = readln().toInt()// Validar



        when (opcao) {
            1 -> {println("Cadastrando ")
                cadastrar()

            }
            2 -> {
                println("Listando  ")
            listar()
            }

            3 -> {
                println("Editando ")
                editar()
            }

            4 -> {
                println("Excluindo ")
                excluir()
            }


            0 -> println("Sair ")
        }
    } while (opcao != 0)
}

private fun cadastrar(){

    //instancia
    var convidado = Convidado()

    println("Qual o seu nome ? ")
    //val nome =readln()
    convidado.nome= readln()

    println("Qual vai ser o presente")
    //val presente = readln()
    convidado.presete = readln()

    println("Qual sua restrição alimenter ")
     //val alimento = readln()
    convidado.alimetar = readln()

    listaconvidados.add( convidado)

}


// fun algumaCoisa(): tipo espera que a função
// retorne alguma coisa
private fun listar() {

    var i = 0

    if(listaconvidados.isEmpty()){
        println("Não ha convidados")
    }
    else {
        listaconvidados.forEach { convidado ->

            println(
                "Posição: ${i++}"+

                "Nome: ${convidado.nome};" +
                        "Presente: ${convidado.presete} ; " +
                        "Restrição: ${convidado.alimetar}  ; " +
                        "vai ir a festa ? ${convidado.presenca}\n"
            )
        }
    }
}



private  fun editar (): Boolean {

    if (listaconvidados.isEmpty()) {
        println("A lista esta vazia ")
        return false
    }

    listar()
    println("Digite a posição a ser editada ")
    val posicao = readln().toInt()

    println("O convidado vai ? s/n")
    val resposta = readln()


    when (resposta) {
        "S" -> listaconvidados[posicao].presenca = true
        "n" -> listaconvidados[posicao].presenca = false
    }

    return true
}
private  fun excluir ():Boolean {

    if (listaconvidados.isEmpty()) {
        println("A Lista esta vazia ")
        return false
    }

    listar()

    println("Qual posição vc deseja remover ")
    val posicao = readln().toInt()

    listaconvidados.removeAt(posicao)
    /*convidado.nome = ""
    convidado.alimetar = ""
    convidado.presete = ""
    convidado. presenca = false */

    println("Convidado excluido")
    return true
}