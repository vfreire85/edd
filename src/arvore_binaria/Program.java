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

public class Program {
	int nivel;
	public static void main(String[] args) {	
		No novo_no = new No(5);
		String tab = "\t";
		
		ArvoreBinaria.inserir(novo_no, 1);
		ArvoreBinaria.inserir(novo_no, 2);
		ArvoreBinaria.inserir(novo_no, 3);
		ArvoreBinaria.inserir(novo_no, 4);
		ArvoreBinaria.inserir(novo_no, 0);
		ArvoreBinaria.inserir(novo_no, 6);
		ArvoreBinaria.inserir(novo_no, 7);
		ArvoreBinaria.inserir(novo_no, 8);
		ArvoreBinaria.inserir(novo_no, 9);
		ArvoreBinaria.inserir(novo_no, 10);
		
		ArvoreBinaria.atravessaEConta(novo_no);
		//Como imprimir os nós por nível com tabs
		for (int x = 0; x <= 10; x++) {
            int nivel = ArvoreBinaria.recebeNivel(novo_no, x);
            String repete = tab.repeat(nivel);
            if (nivel != 0)
                System.out.println(repete + x);
            else
                System.out.println("-");
		}
	}
}
