/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf(0.0,0.0,0.0)): Boolean {
    return materiasENotas.put(materia, notas) != null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 *
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 *
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia:String){

    if(!materiasENotas.containsKey(materia)){
        println("Materia $materia não encontrada")
    }
    else{
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var cont = 1
            for(nota:Double in listaNotas){
                println("Nota ${cont++}: $nota")

            }
            println("Média: ${calcularMedia(materia)}")
        }
        else{
            println("Não foi possível mostrar as notas da matéria $materia")
        }

        println()
    }


}

/*Retorna a média obtida apartir de uma lista de notas */
fun calcularMedia(materia: String): Double {
    if (!materiasENotas.containsKey(materia)) {
        println("Matéria $materia não encontrada")
        return 0.0 // Retorno padrão em caso de erro
    } else {
        val listaNotas = materiasENotas[materia]
        if (!listaNotas.isNullOrEmpty()) {
            val soma = listaNotas.sum()
            val media = soma / listaNotas.size 
            return media
        } else {
            println("A lista de notas para $materia está vazia ou nula")
            return 0.0 // Retorno padrão em caso de lista vazia
        }
    }
}






/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia:String, vararg nota:Double){
    if(!materiasENotas.containsKey(materia)){
        println("Matéria $materia não encontrada!")
    }
    else{
        for (n in nota) {
            adicionarNota(materia, n)
            }
        }

    }





fun main(){
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional
    adicionarDisciplina("Álgebra", mutableListOf(10.0,9.0,8.0))


    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(notas = mutableListOf(10.0,9.0,8.0),materia="Estrutura de Dados")

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão. Dica: utilize mutableListOf()
    //0K!

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina("Inglês Instrumental")

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarNota("Álgebra", 8.0)
    adicionarNota("Álgebra", 8.5)
    adicionarNota("Álgebra", 8.8)
    adicionarNota("Estrutura de Dados", 7.0)
    adicionarNota("Estrutura de Dados", 9.0)
    adicionarNota("Estrutura de Dados", 8.5)
    adicionarNota("Inglês Instrumental", 9.4)
    adicionarNota("Inglês Instrumental", 10.0)
    adicionarNota("Inglês Instrumental", 9.0)



    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    mostrarNotas("Álgebra")
    mostrarNotas("Estrutura de Dados")
    mostrarNotas("Inglês Instrumental")

    // 7. adicionarDisciplina -> adicione mais 1 disciplina

    adicionarDisciplina("Estatística")

    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();
    //OK!



    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("Estatística",9.0,8.0,6.5)

    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    mostrarNotas("Estatística")


    // Bônus: (Não vai ganhar nada, ou melhor mais ganhar mais conhecimento >:O)

    // 11: calcularMedia -> Implemente a função calcularMedia()
    //OK!

    // 12: calcularMedia -> calcule a media de 2 disciplinas
    calcularMedia("Álgebra")
    calcularMedia("Estrutura de Dados")

    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas
    //OK!

    // 14: mostrarNotas -> mostre as notas de 1 disciplina
    mostrarNotas("Estatística")
}
