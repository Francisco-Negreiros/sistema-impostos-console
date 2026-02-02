# Sistema de Impostos em Java (Console)

Projeto desenvolvido em Java com foco em **Programação Orientada a Objetos**,  
**arquitetura limpa**, **validações no domínio** e **persistência em arquivo CSV**.

Este sistema permite cadastrar contribuintes, calcular impostos e manter os dados
persistidos entre execuções.

---

## Conceitos Aplicados

- Programação Orientada a Objetos (POO)
- Herança e Polimorfismo
- Classes Abstratas
- Enum para tipagem forte (`TipoContribuinte`)
- Validações centralizadas no domínio
- Persistência em arquivo `.csv`
- Separação por camadas (application, domain, repository, service)
- Boas práticas de commits e organização de projeto

---

## Funcionalidades

- ✅ Cadastro de Pessoa Física
- ✅ Cadastro de Pessoa Jurídica
- ✅ Listagem de contribuintes
- ✅ Cálculo de impostos individuais e total
- ✅ Persistência de dados em CSV
- ✅ Confirmação ao sair do sistema
- ✅ Validação de entradas inválidas

---

## Estrutura do Projeto

```text
src/
 ├─ application/
 │   ├─ ConsoleUI.java
 │   └─ ProgramaImpostos.java
 │
 ├─ domain/
 │   ├─ Contribuinte.java
 │   ├─ PessoaFisica.java
 │   ├─ PessoaJuridica.java
 │   ├─ TipoContribuinte.java
 │
 │   ├─ repository/
 │   │   └─ ContribuinteCSVRepository.java
 │
 │   └─ service/
 │       ├─ CalculadoraImpostos.java
 │       └─ RelatorioImpostos.java
 │
dados/
 └─ contribuintes.csv
```

## Como Executar

1. Clone o repositório: https://github.com/Francisco-Negreiros/sistema-impostos-console.git
2. Importe o projeto em uma IDE Java (Eclipse, IntelliJ, etc.)
3. Execute a classe: application.ProgramaImpostos.java

## Observações Técnicas

- Todas as validações de negócio estão centralizadas no domínio
- O sistema utiliza `IllegalArgumentException` para entradas inválidas
- O arquivo CSV é criado automaticamente caso não exista
- O Enum `TipoContribuinte` elimina condicionais espalhadas pelo código

---