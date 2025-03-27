fun main() {

    menu()

}

// QUESTÃO 1 -Valide para que o usuario digite somente letras

val exprecaoRegular = Regex("[0-5]")


//Instanciando uma lista multavel
var listaconvidados: MutableList<Convidado> = mutableListOf<Convidado>()
private fun menu() {
    do {
        println("-------Menu-------")
        println("1- Cadastrar ")
        println("2- Listar ")
        println("3- Editar ")
        println("4- Excluir ")
        println("5- Sair ")
        println("6- Buscar")

        val opcao = readln()// Validar

        if (exprecaoRegular.matches(opcao)) {
            when (opcao.toInt()) {
                1 -> {
                    println("Cadastrando ")
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

                5 -> {
                    println("Buscando ...")
                    buscar()
                }


                0 -> println("Sair ")
            }
        }
    } while (opcao != "0")
}

private fun cadastrar() {

    //instancia
    var convidado = Convidado()

    println("Qual o seu nome ? ")
    //val nome =readln()
    convidado.nome = readln()//QUESTÃO 1

    println("Qual vai ser o presente")
    convidado.presete = readln()

    println("Qual sua restrição alimenter ")

    convidado.alimetar = readln()

    listaconvidados.add(convidado)

}


// fun algumaCoisa(): tipo espera que a função
// retorne alguma coisa
private fun listar(): String {

    var i = 0

    if (validar()) {
        println("Não ha convidados")
    }

    listaconvidados.forEach { convidado ->

        println(
            "Posição: ${i++}" +

                    "Nome: ${convidado.nome};" +
                    "Presente: ${convidado.presete} ; " +
                    "Restrição: ${convidado.alimetar}  ; " +
                    "vai ir a festa ? ${convidado.presenca}\n"
        )
    }
    return "Listagem foi um sucesso"
}


private fun editar(): Boolean {

    if (validar()) {
        listar()
        println("Digite a posição a ser editada ")
        val posicao = readln().toInt()

        println("O convidado vai ? s/n")
        val resposta = readln()

        when (resposta) {
            "S" -> listaconvidados[posicao].presenca = true
            "n" -> listaconvidados[posicao].presenca = false
        }
    }

    return true
}

private fun excluir(): Boolean {

    if (validar()) {
        listar()

        println("Qual posição vc deseja remover ")
        val posicao = readln().toInt()

        listaconvidados.removeAt(posicao)
        /*convidado.nome = ""
        convidado.alimetar = ""
        convidado.presete = ""
        convidado. presenca = false */

        println("Convidado excluido")
    }
    return true
}

private fun buscar() {
    var i = 0
    if (validar()) {
        print("Digite o nome da pessoa que voce busca")
        val busca = readln()
        listaconvidados.forEach { convidado ->
            // O contains busca uma string dentro de uma outra string
            if (convidado.nome.contains(busca)) {
                println(" Posição: $i, Nome: ${convidado.nome}")
            }
            i++
        }
    }

}

private fun validar(): Boolean {
    if (listaconvidados.isEmpty()) {
        println("Lista vazia ")
        return false
    }
    return true
}