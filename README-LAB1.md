# Desafio de Projeto (Lab1)

Desafio de Projeto criado para avaliação do conteúdo técnico explorado no repositório [aprenda-kotlin-com-exemplos](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos). **Nesse contexto, iremos abstrair o seguinte domínio de aplicação:**

**A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**

---

## Solução Proposta

A solução para este desafio foi implementada em Kotlin, seguindo as melhores práticas e uma estrutura de projeto organizada. O código-fonte principal pode ser encontrado no arquivo `desafio1.kt`.

### Como Encontrar o Arquivo da Solução

O arquivo com a implementação completa está localizado no seguinte caminho dentro do projeto:

`src/main/kotlin/desafio1.kt`

### Estrutura do Código

A solução foi modelada utilizando as seguintes classes para abstrair o domínio proposto:

-   `enum class Nivel`: Enumeração para os níveis de dificuldade (`BASICO`, `INTERMEDIARIO`, `DIFICIL`).
-   `data class Usuario`: Representa os alunos da plataforma.
-   `data class ConteudoEducacional`: Modela os cursos, com nome e duração.
-   `data class Formacao`: É a classe central que organiza os conteúdos. Ela contém:
    -   A lógica para `matricular()` um ou mais usuários, evitando duplicidade.
    -   A função `exibirDetalhes()` que imprime no console um relatório completo da formação, incluindo nome, nível, duração total, lista de conteúdos e alunos inscritos.

A função `main` contém um cenário de exemplo completo, com a criação de múltiplos conteúdos, formações e usuários, demonstrando o processo de matrícula e a exibição dos relatórios.

### Como Executar o Código

1.  Navegue até o arquivo `src/main/kotlin/desafio1.kt` no seu IDE.
2.  Localize a função `main()`.
3.  Clique no ícone de "play" (▶️) que aparece na margem esquerda, ao lado da declaração da função.
4.  Selecione a opção **Run 'Desafio1Kt'** no menu que surgir.

O resultado da execução, com os logs de matrícula e os relatórios detalhados de cada formação, será exibido na janela de console **Run**.
