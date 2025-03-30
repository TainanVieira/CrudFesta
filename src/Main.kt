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
        println("5- buscar ")
        println("0- sair")

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

    val  validarNome = Regex("^[A-Za-zÀ-ÖØ-öø-ÿ\\s]+\$")
    //instancia
    var convidado = Convidado()
    var nomeVal: Boolean

    do {

        println("Qual o seu nome ? ")
         val nome = readln()//QUESTÃO 1

        if (validarNome.matches(nome)){
            convidado.nome = nome
            nomeVal = true
        }else{
            println("O nome esta invalido favor repetir com apenas letras e espaços ")
            nomeVal = false
        }
    }while (!nomeVal)



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
        val valiPresenca = Regex("^[SN]$") // garante que seja apenas S ou N

      val  posicao = validarNumeroInt("Digite a  posição que deseja  editar ",
          0, listaconvidados.size -1)

        var resposta: String

        do {

            println("O convidado vai ? s/n")
            resposta = readln().uppercase()// converte para maiusculo
            if (!valiPresenca.matches(resposta)) {
                println("Erro digite apenas S para sim ou N para não ")
            }
        } while (!valiPresenca.matches(resposta))

        listaconvidados[posicao].presenca = (resposta == "S")

        println("Convidado atulizado com sucesso ")



    }
    return  true
}

private fun excluir(): Boolean {


    if (validar()) {
        listar()

        val posicao = validarNumeroInt(mensagem = "Digite a posição que deseja remover ",
            0, listaconvidados.size -1)


        listaconvidados.removeAt(posicao)

        println("Convidado excluido")
    }
    return true
}

private fun buscar() {


    if (validar()) {

        val validarNome = Regex("^[A-Za-zÀ-ÖØ-öø-ÿ\\s]+\$") // Permite apenas letras e espaços
        var busca: String

        do {


        print("Digite o nome da pessoa que voce busca")
         busca = readln().trim()

            if (!validarNome.matches(busca)){
            println("Erro digite apenas letras")
            }
            else{
                break // sai do loop
            }
        }while (true)

        busca.lowercase()// converte para minusculas

        var encontrado = false
        listaconvidados.forEachIndexed { i, convidado ->
            if (convidado.nome.lowercase().contains(busca)) {
                println("Posição: $i, Nome: ${convidado.nome}")
                encontrado = true
            }
        }

        if (!encontrado) {
            println("Nenhum convidado encontrado com esse nome.")
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

private fun  validarNumeroInt(mensagem: String, min:Int, max: Int):Int{
    val regexNumero = Regex("^\\d+\$") // Aceita apenas números inteiros
    var numero: Int?

    do {
        println(mensagem)
        val input = readln()

        if (regexNumero.matches(input)) {
            numero = input.toInt()
            if (numero in min..max) {
                return numero // Retorna o valor válido
            } else {
                println("Erro: Digite um número entre $min e $max.")
            }
        } else {
            println("Erro: Digite apenas números!")
        }

    } while (true)
}


