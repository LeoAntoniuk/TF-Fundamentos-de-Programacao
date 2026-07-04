# Sistema de Gerenciamento Acadêmico

Trabalho final da disciplina de **Fundamentos de Programação**.

A ideia do projeto é simular um sistema acadêmico de uma faculdade, onde dá pra cadastrar alunos, professores e turmas, registrar notas nas avaliações e depois consultar um monte de informações: médias, rankings, buscas e por aí vai. Tudo roda no console, direto no terminal.

---

## Sumário

1. [Integrantes do grupo](#integrantes-do-grupo)
2. [Como funciona](#como-funciona)
3. [Funcionalidades](#funcionalidades)
4. [Diagrama de classes do projeto](#diagrama-de-classes-do-projeto)
5. [Estrutura do projeto](#estrutura-do-projeto)
6. [Conceitos da disciplina usados](#conceitos-da-disciplina-usados)
7. [Como executar](#como-executar)
8. [Fontes utilizadas](#fontes-utilizadas)
9. [Observações](#observações)
10. [Dificuldades encontradas](#dificuldades-encontradas)
11. [Divisão de tarefas](#divisão-de-tarefas)
12. [Lições aprendidas](#lições-aprendidas)
13. [Reflexão sobre o desenvolvimento](#reflexão-sobre-o-desenvolvimento)

---

## Integrantes do grupo

- Leonardo Antoniuk - 26103880
- João Vitor - 26103549
- José Lucas Freitas - 26103574
- Gabriel Gemelli Bonadiman - 26102989

---

## Como funciona

Quando o programa inicia, ele já vem com **3 cursos**, **39 matérias** e **59 avaliações** pré-cadastrados (isso foi combinado em aula, pra não ter que digitar tudo toda vez que fosse testar). A partir daí, o menu principal oferece 6 áreas:

```
0 - Encerrar o programa
1 - Cadastros
2 - Alterações
3 - Informações
4 - Rankings
5 - Médias
6 - Busca
```

### Funcionalidades

- **Cadastros:** professores, turmas, alunos, notas e adicionar aluno em uma turma (cada turma tem limite de 30 alunos).
- **Alterações:** dá pra editar praticamente tudo depois de cadastrado — nome/formação do professor, nome/idade/curso/semestre do aluno, dados da turma e até corrigir uma nota já lançada.
- **Informações:** listagens completas de professores, alunos (todos ou um específico, mostrando quantas matérias já fez e quantas faltam pra se formar), turmas, cursos, matérias, avaliações e todas as notas registradas.
- **Rankings:** ranking de notas individuais e ranking de média geral dos alunos, os dois podendo ser ordenados do maior pro menor ou do menor pro maior.
- **Médias:** média da turma por matéria, média do aluno em cada matéria, média do curso, média da matéria e média geral de tudo que foi lançado.
- **Busca:** procurar professor, aluno, turma, curso ou matéria pelo código/ID.

---

## Diagrama de classes do projeto

<div align="center">

<img height="180em" src="images/Diagrama%20TF%20-%20Sistema%20Acadêmico%20(Object%20Classes).png"/>

</div>

## Estrutura do projeto

O projeto foi dividido em classes, cada uma representando uma "coisa" do mundo real:

| Classe | O que representa |
|---|---|
| `Student` | Aluno (ID, nome, idade, curso e semestre atual) |
| `Teacher` | Professor (ID, nome e formação) |
| `Course` | Curso (código, nome, duração em semestres e total de matérias) |
| `Subject` | Matéria (código, nome e carga horária) |
| `Class` | Turma (número, nome, professor, matéria e vetor de até 30 alunos) |
| `Assessment` | Avaliação (descrição, peso e a matéria a que pertence) |
| `Grade` | Nota (liga um aluno a uma avaliação com um valor de 0 a 10) |
| `App` | Classe principal, onde ficam os menus e toda a lógica do sistema |

Cada classe de modelo tem seus atributos privados com getters e setters, do jeito que vimos em aula sobre encapsulamento.

---

## Conceitos da disciplina usados

- **Vetores (arrays):** todos os dados ficam armazenados em vetores de tamanho fixo (ex: `Student[90]`, `Grade[200]`), com variáveis contadoras (`studentNum`, `gradeNum` etc.) pra saber quantas posições já estão ocupadas.
- **Laços `for` e `do-while`:** os menus todos rodam em `do-while` até o usuário escolher sair, e os `for` são usados pra percorrer os vetores nas listagens, buscas e cálculos.
- **Estruturas condicionais (`if` e `switch`):** o `switch` controla a navegação dos menus e os `if` fazem as validações.
- **Bubble Sort:** usado nos rankings pra ordenar as notas e as médias. Foi baseado nos slides da professora, mas otimizado pra não percorrer os índices que já estão ordenados no final do vetor.
- **Média ponderada:** as notas são calculadas levando em conta o peso de cada avaliação (por exemplo, Prova 1 vale 25% e Prova 2 vale 50%), então a média é `soma(nota × peso) / soma(pesos)`.
- **Validação de entrada:** o programa não deixa cadastrar nome vazio, idade fora de 1 a 120, nota fora de 0 a 10, nem lançar duas notas pro mesmo aluno na mesma avaliação.
- **Geração de ID único:** alunos e professores recebem um ID aleatório de 8 dígitos gerado com `Random`, e o programa verifica num vetor de IDs já usados pra garantir que não repita.
- **Entrada de dados com `BufferedReader`:** a leitura do teclado é feita com `BufferedReader` + `InputStreamReader` (indicado pela professora), convertendo com `Integer.parseInt()` ou `Double.parseDouble()` quando precisa de número.

---

## Como executar

Precisa ter o Java instalado. Na raiz do projeto:

```bash
cd src/main/java
javac *.java
java App
```

Ou simplesmente abrir o projeto no IntelliJ e rodar a classe `App`.

---

## Fontes utilizadas:

- <a href="https://www.w3schools.com/java/java_bufferedreader.asp">BufferedReader - Indicado pela professora e pesquisado</a>
- <a href="https://www.w3schools.com/dsa/dsa_algo_bubblesort.php">BubbleSort - Demonstrado pela professora em aula e pesquisado</a>

---

## Observações

- Os cursos disponíveis são Engenharia de Software, Engenharia Mecânica e Medicina, cada um com suas próprias matérias e avaliações.
- Como o foco da disciplina é lógica de programação, o projeto usa só vetores e estruturas básicas — nada de `ArrayList`, banco de dados ou bibliotecas externas. Os dados existem apenas enquanto o programa está rodando.

---

## Dificuldades encontradas

- O grupo no geral não teve muitas dificuldades, porém, no desenvolvimento do projeto, sempre que algum membro do grupo teve alguma dúvida ou alguma dificuldade, sempre era perguntado no nosso grupo e algum dos integrantes sabia o que fazer ou tinha alguma ideia para `auxiliar e explicar` o que poderia ser feito.
- Alguns `Bugs` no decorrer do desenvolvimento e no final foram encontrados, porém olharmos o código eram apenas erros de lógica ou de Classes mal utilizadas.

## Divisão de tarefas

- `Arquitetura - Leonardo e João Vitor`
- `Menus - Todos integrantes`
- `Cadastros - José Lucas`
- `Informações - Gabriel`
- `Alterações - João Vitor`
- `Rankings - Leonardo`
- `Médias - Leonardo`
- `Busca - José Lucas`
- `Testes - Todos integrantes`
- `Procurar bugs - Gabriel`
- `Resolução de bugs - João Vitor`
- `README - Leonardo e João Vitor`

## Lições aprendidas

- O desenvolvimento deste projeto permitiu consolidar diversos conteúdos apresentados durante a disciplina. Foi possível compreender melhor a importância do encapsulamento, da composição entre objetos, da organização em métodos, da modularização do código e da utilização de vetores de objetos. Também foi possível perceber a importância do planejamento antes da implementação das funcionalidades, reduzindo retrabalho e facilitando futuras manutenções.

## Reflexão sobre o desenvolvimento

- Desenvolver este projeto foi uma boa oportunidade para colocar em prática os conteúdos vistos durante a disciplina. No início, tivemos algumas dificuldades para organizar as classes e fazer com que elas se relacionassem corretamente, além de implementar todas as funcionalidades utilizando apenas vetores, já que não era permitido utilizar estruturas como ArrayList. Durante o desenvolvimento, percebemos que planejar melhor antes de começar a programar faz bastante diferença. Em alguns momentos foi necessário reorganizar partes do código e criar novos métodos para deixar o sistema mais organizado e facilitar futuras alterações. Também aprendemos a importância de validar os dados inseridos pelo usuário para evitar erros durante a execução do programa. Outro ponto importante foi a realização de testes conforme novas funcionalidades eram implementadas. Isso ajudou a encontrar problemas que não eram percebidos logo de início e permitiu corrigir erros antes de adicionar novas partes ao sistema. No final, além de reforçar os conhecimentos sobre Programação Orientada a Objetos, vetores, métodos e estruturas de repetição, o projeto também mostrou a importância da organização do código, do trabalho em equipe e da divisão das tarefas. Foi um trabalho que exigiu dedicação, mas que contribuiu bastante para entendermos melhor como desenvolver um sistema completo utilizando apenas os recursos estudados na disciplina.
