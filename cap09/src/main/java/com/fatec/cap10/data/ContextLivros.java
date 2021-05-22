package com.fatec.cap10.data;
import java.util.List;
import com.fatec.cap10.entidades.Livro;

public class ContextLivros {
	
    private LivroDAO livros = new LivroDAO();
    
    public List<Livro> getAll(){    	
    	return livros.livros;
    }
    
    public Livro getLivroById(int idLivro) {
    	
    	return verifica(idLivro);
    }
    
    public boolean Save(Livro livro) {
    	
    	try {
    		 livros.livros.add(livro);
    		 return true;
    		
    	}catch(Exception ex) {
    		
    		return false;
    	}
    }

    public boolean Update(Livro livro) {
    	try {
    	 Livro livroList = verifica(livro.getId());
    	 livros.livros.remove(livroList);
    	 livros.livros.add(livro);
   		 return true;
   		
   	}catch(Exception ex) {
   		
   		return false;
   	}
    }
    
    public boolean delete(int id) {
    	try {

    	Livro livrodalist = verifica(id);
    	livros.livros.remove(livrodalist);
    	return true;
       	}catch(Exception ex) {
       		return false;
       	}
    }
    
    private Livro verifica(int id) {     		
		for( Livro l : livros.livros) {
    	      if (l.getId() == id) {
    	         return l;
    	      }
    	   }
		return null;
    	}
    



}
