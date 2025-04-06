# Trabalho Prático – Estrutura de Dados 3 (AED3)

## 🧠 O que o nosso trabalho faz?

Este projeto tem como objetivo a implementação de um sistema de gerenciamento de séries e episódios utilizando arquivos binários, uma classe genérica de CRUD e estruturas de indexação como Hash Extensível e Árvore B+ para garantir eficiência nas operações.

As operações de **criação, leitura, atualização e exclusão (CRUD)** estão implementadas para **séries** e **episódios**, sendo que o relacionamento 1:N (uma série com múltiplos episódios) é representado e indexado eficientemente por meio da **Árvore B+**.

Além disso, todas as inserções e buscas fazem uso de índices indiretos (para séries, via Tabela Hash com CPF como chave e ID como valor) e índices de chave composta (para episódios, com `idSerie` + `idEpisodio`).

---

## 👥 Participantes

- Alexandre Augusto Niess Ferreira
- Gabriel Valedo Batista Silva
- Henrique Giberti Piló Fernandes
- Leonardo Amaral Passos Figueiredo

---

## 🧱 Estrutura do Projeto

### 📁 entidades

- **`Serie.java`**

  - Atributos: `id`, `nome`, `genero`, `ano`
  - Métodos principais: `toByteArray()`, `fromByteArray()`, `toString()`

- **`Episodio.java`**
  - Atributos: `id`, `idSerie`, `temporada`, `numero`, `titulo`
  - Métodos principais: `toByteArray()`, `fromByteArray()`, `toString()`

### 📁 persistencia

- **`Arquivo.java`** (classe genérica)
  - Métodos principais: `create()`, `read()`, `update()`, `delete()`
- **`ArquivoSerie.java`**
  - Herda de `Arquivo<Serie>`
  - Usa `HashExtensivel<ParCPFID>` como índice indireto
- **`ArquivoEpisodio.java`**
  - Herda de `Arquivo<Episodio>`
  - Usa `ArvoreBMais<ParIdSerieIdEpisodio>` para indexar episódios por série

### 📁 indexacao

- **`ParCPFID.java`**
  - Registro usado para hash baseado no CPF
- **`ParIdSerieIdEpisodio.java`**
  - Chave composta para relacionar `idSerie` e `idEpisodio` na Árvore B+

### 📁 aed3

- **`Registro.java`**
  - Interface base para leitura e escrita binária
- **`RegistroArvoreBMais.java`**
  - Interface específica para uso na Árvore B+
- **`HashExtensivel.java`**
  - Implementação de Tabela Hash com Cestos e arquivos
- **`ArvoreBMais.java`**
  - Implementação completa de Árvore B+ para chaves compostas

### 📁 controle

- **`ControleSeries.java`**
  - Gerencia lógica de série: validações, chamadas de persistência
- **`ControleEpisodios.java`**
  - Gerencia lógica de episódios, inclusive checando se série existe antes de adicionar episódio
  - Implementa visualização de episódios por temporada

### 📄 Main.java

- Interface principal de execução
- Menu para testes das operações CRUD

###Visualização da Estrutura de Pastas:

```
├── Main.java
├── README.md
├── aed3
    ├── Arquivo.java
    ├── ArvoreBMais.java
    ├── HashExtensivel.java
    ├── ParIDEndereco.java
    ├── Registro.java
    ├── RegistroArvoreBMais.java
    └── RegistroHashExtensivel.java
├── controle
    ├── ControleEpisodios.java
    └── ControleSeries.java
├── entidades
    ├── Episodio.java
    └── Serie.java
├── indexacao
    └── ParIdSerieIdEpisodio.java
├── persistencia
    ├── ArquivoEpisodio.java
    └── ArquivoSerie.java
└── visao
    ├── VisaoEpisodios.java
    └── VisaoSeries.java
```

---

💻 Compilação
No terminal, na raiz do projeto, execute:

```
javac */*.java Main.java
```

Isso irá compilar todos os arquivos .java, incluindo os que estão em subpastas.

🚀 Execução
Depois de compilar, execute o projeto com:

```
java Main
```

---

## 🛠️ Experiência de Desenvolvimento

O desenvolvimento foi desafiador, especialmente na parte de integração entre a Árvore B+ e o relacionamento entre episódios e séries. Algumas das dificuldades incluíram:

- Aprender a utilizar `RandomAccessFile` corretamente.
- Corrigir erros de pacotes e importações no macOS.
- Implementar corretamente a lógica de inserção e divisão na árvore B+.
- Garantir que os métodos genéricos da classe `Arquivo` fossem corretamente herdados.

Com esforço, conseguimos alcançar os objetivos, e todas as funcionalidades especificadas foram implementadas e testadas com sucesso.

---

## ✅ Checklist de Implementação

| Requisito                                                                                                                                                  | Status |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------- | ------ |
| As operações de inclusão, busca, alteração e exclusão de séries estão implementadas e funcionando corretamente?                                            | ✅ Sim |
| As operações de inclusão, busca, alteração e exclusão de episódios, por série, estão implementadas e funcionando corretamente?                             | ✅ Sim |
| Essas operações usam a classe CRUD genérica para a construção do arquivo e as classes Tabela Hash Extensível e Árvore B+ como índices diretos e indiretos? | ✅ Sim |
| O atributo de ID de série, como chave estrangeira, foi criado na classe de episódios?                                                                      | ✅ Sim |
| Há uma árvore B+ que registre o relacionamento 1:N entre episódios e séries?                                                                               | ✅ Sim |
| Há uma visualização das séries que mostre os episódios por temporada?                                                                                      | ✅ Sim |
| A remoção de séries checa se há algum episódio vinculado a ela?                                                                                            | ✅ Sim |
| A inclusão da série em um episódio se limita às séries existentes?                                                                                         | ✅ Sim |
| O trabalho está funcionando corretamente?                                                                                                                  | ✅ Sim |
| O trabalho está completo?                                                                                                                                  | ✅ Sim |
| O trabalho é original e não a cópia de um trabalho de outro grupo?                                                                                         | ✅ Sim |

---

> **Nota**: Este `README.md` pode ser complementado com prints do terminal, trechos de código e até GIFs de funcionamento, para melhor visualização no GitHub.

Se quiser, posso salvar e te mandar o arquivo pronto! Deseja isso?
