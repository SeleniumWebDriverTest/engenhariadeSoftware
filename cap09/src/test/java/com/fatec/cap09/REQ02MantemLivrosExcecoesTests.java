package com.fatec.cap09;

import org.junit.Test;
import com.fatec.cap10.entidades.Livro;
import com.fatec.cap10.services.LivrosService;
import static org.junit.Assert.assertTrue;

public class REQ02MantemLivrosExcecoesTests {

	private LivrosService livrosService = new LivrosService();


  @Test
  public void CT02TestCadastroISBNRepetido() {
        
      Livro livro = new Livro();
      livro.setId(1);
      livro.setAutor("Augusto Cury");
      livro.setIsbn("1598");
      livro.setTitulo("Quem pensa enriquece");
      
      Livro livroRepetido = livro;
      
      livrosService.Save(livro);
       assertTrue(livrosService.Save(livroRepetido));   

  }
  
  @Test
  public void cadastroLivroCom3Caracter() {
	  
      Livro livro = new Livro();
      livro.setId(15);
      livro.setAutor("Desconhecido");
      livro.setIsbn("159");
      livro.setTitulo("DEsconhecido volume 2");
      
      assertTrue(livrosService.Save(livro));   

  }
  
  @Test
  public void cadastroLivroCom5Caracter() {
	 
      Livro livro = new Livro();
      livro.setId(15);
      livro.setAutor("Desconhecido");
      livro.setIsbn("15958");
      livro.setTitulo("DEsconhecido volume 2");
      
      assertTrue(livrosService.Save(livro));   
  }
  
  @Test
  public void CT03ISBNEmBranco() {
	  
      Livro livro = new Livro();
      livro.setId(15);
      livro.setAutor("Autor Desconhecido");
      livro.setIsbn("");
      livro.setTitulo("DEsconhecido volume 3");      
      
      assertTrue(livrosService.Save(livro));  
  }
  
  @Test
  public void CT04TituloEmBranco() {
	  
      Livro livro = new Livro();
      livro.setId(15);
      livro.setAutor("Autor Desconhecido");
      livro.setIsbn("2514");
      livro.setTitulo("");      
      
      assertTrue(livrosService.Save(livro));  
  }
 
  @Test
  public void CT05TituloEmBranco() {
	  
      Livro livro = new Livro();
      livro.setId(15);
      livro.setAutor("");
      livro.setIsbn("2514");
      livro.setTitulo("Desconhecido livro 8");      
      
      assertTrue(livrosService.Save(livro));  
  }
  public void awaitSeconds() {
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

  }
}
