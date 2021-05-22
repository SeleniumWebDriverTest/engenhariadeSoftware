package com.fatec.cap10.data;

import java.util.ArrayList;
import java.util.List;
import com.fatec.cap10.entidades.*;

public class LivroDAO {
    
	public static List<Livro> livros;
	
	 public LivroDAO() {
		
		 if(livros == null)
			 livros = new ArrayList<>();
	 }
}
