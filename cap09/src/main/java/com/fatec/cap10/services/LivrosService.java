package com.fatec.cap10.services;

import java.util.List;

import com.fatec.cap10.data.ContextLivros;
import com.fatec.cap10.entidades.Livro;

public class LivrosService {
	
	private ContextLivros livros = new ContextLivros();
	
	public List<Livro> getAll(){
		
		return livros.getAll();
	}
	
	public Livro getLivroById(int idLivro) {
		return livros.getLivroById(idLivro);
	}
	public boolean Save(Livro livro) {
		
		if(modelValidate(livro)&&validateISBN(livro.getIsbn()))
			return livros.Save(livro);
		return false;
		
	}
	
	private boolean validateISBN(String livroIsbn) {
		// TODO Auto-generated method stub
		for (Livro livro : getAll()) {
			if(livro.getIsbn().equals(livroIsbn))
				System.out.println("o ISBN "+livroIsbn+" ja foi cadastrado");
				return false;
		}
		
		return true;
	}

	public boolean Update(Livro livro) {
		
		if(modelValidate(livro))
			return livros.Update(livro);
		return false;
	}
	
	public boolean delete(int idLivro) {
		
		return livros.delete(idLivro);
	}

	private boolean modelValidate(Livro livro) {
		// TODO Auto-generated method stub
		if(livro.getIsbn().isBlank()) {
			System.out.println("ISBN não pode ser cadastrado em Branco");
             return false;
		}
		
		if(livro.getIsbn().toCharArray().length != 4) {
			System.out.println("ISBN pode ter apenas 4 caracteres");
			return false;
		}
		
		if(livro.getAutor().isBlank()) {
			System.out.println("O Autor não pode estar em branco");
			return false;
		}

        if(livro.getTitulo().isBlank()) {
			System.out.println("O Titulo não pode estar em branco");
            return false;
        }

		return true;
	}

}
