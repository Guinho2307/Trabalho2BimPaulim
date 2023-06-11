/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.trabalho2bimPaulim;

import com.mycompany.trabalho2bimPaulim.Models.Conta;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class Trabalho2BimPaulim {

    public static void main(String[] args) {
        double calculoSaldos = 0;
        //-----------------------MÉTODO DE CADASTRO DO CLIENTE--------------------------
        int tamanhoQTD = Integer.parseInt(JOptionPane.showInputDialog("Quantas contas bancarias ira cadastrar?"));
        // aqui o vetor com o tamanho informado
        Conta vetor[] = new Conta[tamanhoQTD];

        //aqui ele cria uma PARA, que registra o usuario com o nome
        //da pessoa, o saldo, e o numero da conta é o id criado pelo i ( contador)
        for (int i = 0; i < vetor.length; i++) {
            Conta conta = new Conta();
            conta.setId(i + 1);
            conta.setNumConta(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da sua conta")));
            conta.setNome(JOptionPane.showInputDialog("Digite o nome da Pessoa"));
            conta.setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Informe o Saldo")));

            vetor[i] = conta;
            conta.calculototal();
        }

        Integer option = -1;
        String loop = "";

        do {

            //---------------------------------PAINEL DE PERGUNTA AO USUÁRIO---------------      
            option = Integer.parseInt(JOptionPane.showInputDialog("===== Sistema de Conta Bancária =====\n"
                    + "1. Ordenar contas por número da conta\n"
                    + "2. Ordenar contas por saldo da conta\n"
                    + "3. Realizar Depósito\n"
                    + "4. Realizar Saque\n"
                    + "5. Verificar saldo negativo\n"
                    + "6. Verificar saldo Total\n"
                    + "7. Imprimir todas Contas Cadastradas\n"
                    + "0. Sair\n"
                    + "===============BANCO DOS REPROVADOS============="));

//--------------------------MÉTODO DE ORDENAR CONTAS PELO NÚMERO DA CONTA-------
            if (option.equals(1)) {
                int chave, j;
                for (int i = 1; i < vetor.length; i++) {
                    Conta conta = vetor[i];
                    chave = conta.getNumConta();
                    for (j = i - 1; (j >= 0 && vetor[j].getNumConta() > chave); j--) {
                        vetor[j + 1] = vetor[j];
                    }
                    vetor[j + 1] = conta;

                }
                for (int k = 0; k < vetor.length; k++) {
                    Conta conta = vetor[k];
                    System.out.println(conta.toString());
                    System.out.println("\n");
                }

                //--------------------------MÉTODO DE ORDENAR CONTAS PELO SALDO----------------      
            } else if (option.equals(2)) {
                int j;
                double chave;
                for (int i = 1; i < vetor.length; i++) {
                    Conta conta = vetor[i];
                    chave = conta.getSaldo();
                    for (j = i - 1; (j >= 0 && vetor[j].getSaldo() > chave); j--) {
                        vetor[j + 1] = vetor[j];
                    }
                    vetor[j + 1] = conta;
                }
                for (int k = 0; k < vetor.length; k++) {
                    Conta conta = vetor[k];
                    System.out.println(conta.toString());
                    System.out.println("\n");
                }
//-----------------------MÉTODO DE DEPOSITO PELA CONTA OU NOME PESSOA-----------
            } else if (option.equals(3)) {

                Integer dep = Integer.parseInt(JOptionPane.showInputDialog("Deseja depositar "
                        + " por qual opção?\n"
                        + "1 = Numero da conta\n"
                        + "2 = Nome da pessoa\n"));
//-------------------DEPOSITO PELO NUMERO DA CONTA------------------------------
                if (dep.equals(1)) {

                    Integer deposito = Integer.parseInt(JOptionPane.showInputDialog("Qual"
                            + "o numero da conta deseja realizar Deposito?"));
                    double valorDep = Double.parseDouble(JOptionPane.showInputDialog("Qual "
                            + "valor deseja realizar o Deposito?"));
                    for (int i = 0; i < vetor.length; i++) {
                        Conta conta = vetor[i];

                        if (vetor[i].getNumConta() == deposito) {

                            vetor[i].setSaldoMovimentacao(valorDep);

                            conta.calculototal();

                        }
                    }
//-------------------DEPOSITO PELO NOME DO CLIENTE------------------------------            
                } else if (dep.equals(2)) {
                    String deposito2 = JOptionPane.showInputDialog("Qual"
                            + "o nome da pessoa que deseja realizar deposito?");
                    double valorDep = Double.parseDouble(JOptionPane.showInputDialog("Qual "
                            + "valor deseja depositar?"));

                    for (int i = 0; i < vetor.length; i++) {
                        Conta conta = vetor[i];

                        if (vetor[i].getNome().equals(deposito2)) {

                            vetor[i].setSaldoMovimentacao(valorDep);

                            conta.calculototal();

                        }
                    }
                }
//-------------------------------METODO DE SAQUE--------------------------------
            } else if (option.equals(4)) {
                Integer dep = Integer.parseInt(JOptionPane.showInputDialog("Deseja sacar "
                        + " por qual opção?\n"
                        + "1 = Numero da conta\n"
                        + "2 = Nome da pessoa\n"));
//-------------------SAQUE PELO NUMERO DA CONTA---------------------------------
                if (dep.equals(1)) {
                    Integer deposito = Integer.parseInt(JOptionPane.showInputDialog("Qual"
                            + "o numero da conta deseja realizar Saque?"));
                    double valorDep = Double.parseDouble(JOptionPane.showInputDialog("Qual "
                            + "valor deseja realizar saque? "));

                    for (int i = 0; i < vetor.length; i++) {
                        Conta conta = vetor[i];

                        if (vetor[i].getNumConta() == deposito) {

                            vetor[i].setSaldoMovimentacao(valorDep * -1);

                            conta.calculototal();

                        }
                    }

//-------------------SAQUE PELO NOME DO CLIENTE---------------------------------                
                } else if (dep.equals(2)) {
                    String deposito2 = JOptionPane.showInputDialog("Qual"
                            + "o nome da pessoa que deseja realizar o saque?");
                    double valorDep = Double.parseDouble(JOptionPane.showInputDialog("Qual"
                            + " valor deseja realizar saque?"));

                    for (int i = 0; i < vetor.length; i++) {
                        Conta conta = vetor[i];

                        if (vetor[i].getNome().equals(deposito2)) {

                            vetor[i].setSaldoMovimentacao(valorDep * -1);

                            conta.calculototal();

                        }
                    }
                }
//-------------------IMPRIMIR CONTAS SALDO NEGATIVO-----------------------------
            } else if (option.equals(5)) {
                for (int i = 0; i < vetor.length; i++) {
                    Conta conta = vetor[i];

                    conta.calculototal();
                    if (conta.getCalculoTotal() < 0 || conta.getSaldoMovimentacao() < 0) {
                        System.out.println("Contas que possui saldo Negativo\n"
                                + " Nº da conta: " + vetor[i].getNumConta() + "\n"
                                + "Saldo:" + vetor[i].getSaldo() + "\n"
                                + "Saldo Movimentação:" + vetor[i].getSaldoMovimentacao() + "\n"
                                + "Saldo total: " + vetor[i].getCalculoTotal() + "\n");
                    } else {
                        JOptionPane.showMessageDialog(null, "Não existe conta saldo negativo");
                    }
                }
//-------------------IMPRIMIR A SOMA DE TODOS SALDOS ATUALIZADOS DO BANCO-------                          
            } else if (option.equals(6)) {

                for (int i = 0; i < vetor.length; i++) {
                    Conta conta = vetor[i];
                    calculoSaldos+= conta.getCalculoTotal();
                }
                System.out.println("==============================================");
                System.out.println("A soma de todos saldos é " + calculoSaldos + "\n");

//-------------------IMPRIMIR TODAS CONTAS CADASTRADAS--------------------------                          
            } else if (option.equals(7)) {
                System.out.println("==============================================");
                System.out.println("Contas cadastradas \n");
                for (int i = 0; i < vetor.length; i++) {
                    Conta conta = vetor[i];
                    System.out.println(conta.toString());
                    System.out.println("\n");
                }
            } else if (option.equals(0)) {
                JOptionPane.showMessageDialog(null, "Obrigado por usar o Banco dos Reprovados");
            }

        } while (!option.equals(0));
    }
}
