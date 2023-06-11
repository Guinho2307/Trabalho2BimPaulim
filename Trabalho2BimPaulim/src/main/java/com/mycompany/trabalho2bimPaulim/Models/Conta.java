/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho2bimPaulim.Models;

/**
 *
 * @author guilh
 */
public class Conta {
     private int id;
    private int numConta;
   
    private String nome;
    private double Saldo;
    private double saldoMovimentacao;
    private double calculoSaldoDep;
    private double calculoSaldoSaque;
    private double calculoTotal;
    
    public Conta() {
    }

    public Conta(int id, int numConta, String nome, double Saldo, double saldoMovimentacao, double calculoSaldoDep, double calculoSaldoSaque, double calculoTotal) {
        this.id = id;
        this.numConta = numConta;
        this.nome = nome;
        this.Saldo = Saldo;
        this.saldoMovimentacao = saldoMovimentacao;
        this.calculoSaldoDep = calculoSaldoDep;
        this.calculoSaldoSaque = calculoSaldoSaque;
        this.calculoTotal = calculoTotal;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public double getSaldoMovimentacao() {
        return saldoMovimentacao;
    }

    public void setSaldoMovimentacao(double saldoMovimentacao) {
        this.saldoMovimentacao = saldoMovimentacao;
    }

    public double getCalculoSaldoDep() {
        return calculoSaldoDep;
    }

    public void setCalculoSaldoDep(double calculoSaldoDep) {
        this.calculoSaldoDep = calculoSaldoDep;
    }

    public double getCalculoSaldoSaque() {
        return calculoSaldoSaque;
    }

    public void setCalculoSaldoSaque(double calculoSaldoSaque) {
        this.calculoSaldoSaque = calculoSaldoSaque;
    }

    public double getCalculoTotal() {
        return calculoTotal;
    }

    public void setCalculoTotal(double calculoTotal) {
        this.calculoTotal = calculoTotal;
    }

  
    public void calculototal(){
       calculoTotal += Saldo + saldoMovimentacao ;
       
    }
    
    public void calc (){
        calculoSaldoDep += Saldo;
    }
    public void calc2(){
        calculoSaldoSaque += calculoTotal + saldoMovimentacao;
    }
     
     
    
    
    @Override
    public String toString() {
        return "Conta{" + "id=" + id + ", numConta=" + numConta + ", nome=" + nome + ", Saldo Inicial=" + Saldo + ", saldoMovimentacao=" + saldoMovimentacao + ", calculoTotal=" + calculoTotal + '}';
    }

   
   

    
 
}
