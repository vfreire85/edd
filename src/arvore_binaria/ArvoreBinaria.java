/*
 Programa de árvores binárias e processamento
 Versão 1.0
 Autor: Victor Freire de Carvalho
 Data: 10/05/2024
 Programa escrito para a disciplina de Estrutura de Dados
 do curso de Tecnólogo em Análise e Desenvolvimento de 
 Sistemas da Faculdade Senac EAD.
   */


package arvore_binaria;

import java.util.LinkedList;
import java.util.Queue;
//Implementação da classe do nó
class No {
	long id;
	No esq, dir;
	
	public No (long id) {
		this.id = id; 
		esq = dir = null;
	}
}

public class ArvoreBinaria {
	public static No raiz;
	public ArvoreBinaria() { ArvoreBinaria.raiz = null; }
	//A inserção de nós na árvore binária faz uso de outras duas estruturas de dados pré-existentes na biblioteca básica do Java: Fila e Lista Encadeada
	public static No inserir(No raiz, long id) {
		if (raiz == null) {
			raiz = new No(id);
			return raiz;
		}
		
		Queue<No> q = new LinkedList<>();
		q.offer(raiz);
		while (!q.isEmpty()) {
			No temp = q.poll();
			if (temp.esq == null) {
				temp.esq = new No(id);
				break;
			}
			else 
				q.offer(temp.esq);
			
			if (temp.dir == null) {
				temp.dir = new No(id);
				break;
			}
			else
				q.offer(temp.dir);
		}
		return raiz;
	}
	//Este é o método que retorna a quantidade de nós esquerdos, com exceção do nó raiz
	public static void atravessaEConta(No raiz) {
		int contador = -1;
		
		if (raiz == null)
            return;

        Queue<No> q = new LinkedList<>();
        q.offer(raiz);
        while (!q.isEmpty()) {
            No temp = q.poll();
            if (temp.esq != null)
                q.offer(temp.esq);
            	contador++;
        }
        System.out.println("Total de nós da esquerda festiva: " + contador);
	}
	//Este método retorna o nível de cada nó em uma árvore binária
	static int recebeNivelUtil(No raiz, int id, int nivel)
    {
        if (raiz == null)
            return 0;
 
        if (raiz.id == id)
            return nivel;
 
        int nivelabaixo
            = recebeNivelUtil(raiz.esq, id, nivel + 1);
        if (nivelabaixo != 0)
            return nivelabaixo;
 
        nivelabaixo
            = recebeNivelUtil(raiz.dir, id, nivel + 1);
        return nivelabaixo;
    }
	
	static int recebeNivel(No raiz, int id)
    {
        return recebeNivelUtil(raiz, id, 1);
    }	
}
