# Banco Digital

Este é um projeto de um sistema simples de banco digital, implementado em Java. O sistema permite a criação de contas correntes e poupança, com funcionalidades básicas de depósito, saque, transferência e impressão de extratos.

## Funcionalidades

- **Conta Corrente**: Permite realizar operações bancárias como saque, depósito e transferência. Inclui um método específico para imprimir o extrato.
- **Conta Poupança**: Similar à conta corrente, mas focada em poupança, também permite realizar as mesmas operações com uma impressão de extrato diferenciada.
- **Transferências**: O sistema permite a transferência de valores entre contas.
- **Clientes**: Cada conta é associada a um cliente que possui um nome.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes e interfaces:

- `Banco`: Responsável por armazenar as contas e o nome do banco.
- `Conta`: Classe abstrata que representa uma conta genérica com métodos comuns, como sacar, depositar, transferir e imprimir extrato.
- `ContaCorrente`: Extende `Conta` e imprime um extrato específico para contas correntes.
- `ContaPoupanca`: Extende `Conta` e imprime um extrato específico para contas poupança.
- `Cliente`: Representa um cliente com um nome.
- `IConta`: Interface que define os métodos principais para uma conta bancária (`sacar`, `depositar`, `transferir`, `imprimirExtrato`).

## Exemplo de Uso

A seguir, um exemplo de como utilizar o sistema para criar um cliente e contas, realizar operações e imprimir extratos:

```java
public static void main(String[] args) {
    Cliente Lucas = new Cliente();
    Lucas.setNome("Lucas");

    Conta cc = new ContaCorrente(Lucas);
    Conta cp = new ContaPoupanca(Lucas);
    
    cc.depositar(100);
    cc.transferir(100, cp);

    cc.imprimirExtrato();
    cp.imprimirExtrato();
}
