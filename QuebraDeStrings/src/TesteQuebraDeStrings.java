import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TesteQuebraDeStrings {

	private CamelCaseConverter conv = new CamelCaseConverter();
	private List<String> convertedList;
	
	@Test
	public void emptyString()
	{
		assertTrue( conv.isEmpty( "" ) );
		assertTrue( conv.isEmpty( null ) );
		assertTrue( conv.isEmpty( " " ) );
		assertFalse( conv.isEmpty( "Test" ) );
	}
	
	@Test
	public void startWithNumber()
	{
		assertTrue( conv.startWithNumber( "10Primeiros" ) );
		assertFalse( conv.startWithNumber( "Primeiros10" ) );
	}
	
	@Test
	public void haveSpeacialChars()
	{
		assertTrue( conv.haveSpeacialChars( "@Test") );
		assertTrue( conv.haveSpeacialChars( "T#est") );
		assertTrue( conv.haveSpeacialChars( "Tes$t") );
		assertTrue( conv.haveSpeacialChars( "Test&") );
		assertTrue( conv.haveSpeacialChars( "Test ") );
		assertTrue( conv.haveSpeacialChars( "nome#Composto") );
		assertFalse( conv.haveSpeacialChars( "Test" ) );
	}
	
	@Test
	public void convertToCamelCase()
	{
		convertedList = conv.ConvertCamelCase( "nome" );
		assertEquals( convertedList.get(0) , "nome" );
		assertEquals( convertedList.size() , 1 );
		
		convertedList = conv.ConvertCamelCase( "nomeComposto" );
		assertEquals( convertedList.get(0) , "nome" );
		assertEquals( convertedList.get(1) , "composto" );
		assertEquals( convertedList.size() , 2 );
		
		convertedList = conv.ConvertCamelCase( "NomeComposto" );
		assertEquals( convertedList.get(0) , "nome" );
		assertEquals( convertedList.get(1) , "composto" );
		assertEquals( convertedList.size() , 2 );
		
		convertedList = conv.ConvertCamelCase( "CPF" );
		assertEquals( convertedList.get(0) , "cpf" );
		assertEquals( convertedList.size() , 1 );
		
		convertedList = conv.ConvertCamelCase( "numeroCPF" );
		assertEquals( convertedList.get(0) , "numero" );
		assertEquals( convertedList.get(1) , "cpf" );
		assertEquals( convertedList.size() , 2 );
		
		convertedList = conv.ConvertCamelCase( "numeroCPFContribuinte" );
		assertEquals( convertedList.get(0) , "numero" );
		assertEquals( convertedList.get(1) , "cpf" );
		assertEquals( convertedList.get(2) , "contribuinte" );
		assertEquals( convertedList.size() , 3 );
		
		convertedList = conv.ConvertCamelCase( "recupera10Primeiros" );
		assertEquals( convertedList.get(0) , "recupera" );
		assertEquals( convertedList.get(1) , "10" );
		assertEquals( convertedList.get(2) , "primeiros" );
		assertEquals( convertedList.size() , 3 );
	}
}
