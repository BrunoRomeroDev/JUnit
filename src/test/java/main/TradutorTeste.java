package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class TradutorTeste {
	private Tradutor tr;

	@Before
	public void criarTradutor(){
		tr =new Tradutor("teste");
	}
	
	@Test
	public void verificaObjetoNull() {
		assertNotNull(tr);
	}
	
	@Test
	public void tradutorSemPalavras() {
		assertTrue(tr.estaVazio());
	}
	
	@Test
	public void umaTraducao() {
		tr.adicionarTraducao("bom","good");
		assertFalse(tr.estaVazio());
		assertEquals("good",tr.traduzir("bom"));
	}

	@Test
	public void duasTraducoes() {
		tr.adicionarTraducao("bom","good");
		tr.adicionarTraducao("mau","bad");
		assertEquals("good",tr.traduzir("bom"));
		assertEquals("bad",tr.traduzir("mau"));
	}
	
	@Test
	public void duasTraducoesMesmaPalavra() {
		tr.adicionarTraducao("bom","good");
		tr.adicionarTraducao("bom","nice");
		assertEquals("good, nice",tr.traduzir("bom"));
	}
	
	@Test
	public void traduzirFrase() {
		tr.adicionarTraducao("guerra","war");
		tr.adicionarTraducao("é","is");
		tr.adicionarTraducao("ruim","bad");
		assertEquals("war is bad",tr.traduzirFrase("guerra é ruim"));
	}
	
	@Test
	public void traduzirFraseComDuasTraducoesMesmaPalavra() {
		tr.adicionarTraducao("paz","peace");
		tr.adicionarTraducao("é","is");
		tr.adicionarTraducao("bom","good");
		tr.adicionarTraducao("bom","nice");
		assertEquals("peace is good",tr.traduzirFrase("paz é bom"));
	}
	
	@Test
	public void verificaObjetoTradutor() {
		String text2 = "teste";//new String("teste");
		//verifica o objeto e o conteudo
		assertSame( tr.getText(), text2);

	}
	
	@Test
	public void verificaElementos() {
		String text2 = new String("teste");
		//verifica o conteudo
		assertEquals( tr.getText(), text2);
	}
	

}
