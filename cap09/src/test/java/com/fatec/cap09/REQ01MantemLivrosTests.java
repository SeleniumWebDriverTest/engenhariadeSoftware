package com.fatec.cap09;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.fatec.cap10.entidades.Livro;
import com.fatec.cap10.services.LivrosService;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertTrue;

import java.util.*;

public class REQ01MantemLivrosTests {
  
	private LivrosService livrosService = new LivrosService();

  @Test
  public void CT01TestCadastroComSucesso() {
      
         Livro livro = new Livro();
         livro.setId(1);
         livro.setAutor("Augusto Cury");
         livro.setIsbn("1598");
         livro.setTitulo("Quem pensa enriquece");
         
         livrosService.Save(livro);
         
         List<Livro> listLivros = livrosService.getAll();
         assertTrue(livro.equals(listLivros.get(0)));
  }
  
  @Test
  public void pegarLivroPorID() {
	  
	  Livro livroTest = new Livro();
	  livroTest.setId(100);
	  livroTest.setAutor("Test autor");
	  livroTest.setIsbn("1566");
	  livroTest.setTitulo("Teste livro cadastrado");
      
      livrosService.Save(livroTest);	  
	  
     Livro livroId = livrosService.getLivroById(100);
      assertTrue(livroTest.equals(livroId));
  }
  
}
