package com.example.desafio

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            if (inscritos.contains(usuario)) {
                println("⚠️  Usuário '${usuario.nome}' já está matriculado na formação '$nome'.")
            } else {
                inscritos.add(usuario)
                println("✅ Usuário '${usuario.nome}' matriculado com sucesso na formação '$nome'.")
            }
        }
    }
    
    fun getInscritos(): List<Usuario> {
        return inscritos.toList()
    }

    private fun calcularDuracaoTotal(): Int {
        return conteudos.sumOf { it.duracao }
    }

    fun exibirDetalhes() {
        val duracaoTotal = calcularDuracaoTotal()
        println("=====================================================")
        println("Formação: '$nome' - Nível: $nivel")
        println("Duração: $duracaoTotal minutos (${duracaoTotal / 60}h ${duracaoTotal % 60}min)")
        println("-----------------------------------------------------")
        println("Conteúdos Educacionais:")
        if (conteudos.isEmpty()) {
            println("  - (Nenhum conteúdo cadastrado)")
        } else {
            conteudos.forEach {
                println("  - ${it.nome} (${it.duracao} min)")
            }
        }
        println("-----------------------------------------------------")
        println("Alunos Matriculados (${inscritos.size}):")
        if (inscritos.isEmpty()) {
            println("  - (Nenhum aluno matriculado)")
        } else {
            inscritos.forEach {
                println("  - ${it.nome}")
            }
        }
        println("=====================================================")
        println() // Linha em branco para separar relatórios
    }
}

fun main() {
    println("### Sistema de Gerenciamento de Formações Educacionais ###")
    println()

    // --- Definição dos Conteúdos Educacionais ---
    val conteudoIntroKotlin = ConteudoEducacional("Introdução ao Ecossistema Kotlin", 90)
    val conteudoPOOKotlin = ConteudoEducacional("Programação Orientada a Objetos com Kotlin", 120)
    val conteudoCoroutines = ConteudoEducacional("Kotlin Coroutines e Programação Concorrente", 180)
    val conteudoIntroAndroid = ConteudoEducacional("Fundamentos do Desenvolvimento Android", 150)
    val conteudoUIAndroid = ConteudoEducacional("Construindo Interfaces com Jetpack Compose", 240)


    // --- Criação das Formações ---
    val formacaoKotlin = Formacao(
        "Desenvolvedor Kotlin",
        Nivel.INTERMEDIARIO,
        listOf(conteudoIntroKotlin, conteudoPOOKotlin)
    )

    val formacaoKotlinAvancado = Formacao(
        "Kotlin Avançado & Concorrência",
        Nivel.DIFICIL,
        listOf(conteudoIntroKotlin, conteudoPOOKotlin, conteudoCoroutines)
    )

    val formacaoAndroid = Formacao(
        "Desenvolvedor Android com Kotlin",
        Nivel.INTERMEDIARIO,
        listOf(conteudoIntroKotlin, conteudoIntroAndroid, conteudoUIAndroid)
    )


    // --- Criação dos Usuários ---
    val usuarioJoao = Usuario("João Silva")
    val usuarioMaria = Usuario("Maria Oliveira")
    val usuarioPedro = Usuario("Pedro Santos")
    val usuarioAna = Usuario("Ana Costa")


    // --- Processo de Matrícula ---
    println("--- Iniciando matrículas ---")
    println()
    formacaoKotlin.matricular(usuarioJoao, usuarioMaria)
    formacaoKotlinAvancado.matricular(usuarioJoao, usuarioPedro, usuarioAna)
    formacaoAndroid.matricular(usuarioMaria, usuarioAna)

    // Tentativa de matricular novamente para testar a lógica de duplicidade
    formacaoKotlin.matricular(usuarioJoao)
    
    println()
    println("--- Fim das matrículas ---")
    println()


    // --- Exibição dos detalhes das formações ---
    println("--- Relatório Final das Formações ---")
    println()
    formacaoKotlin.exibirDetalhes()
    formacaoKotlinAvancado.exibirDetalhes()
    formacaoAndroid.exibirDetalhes()
}
