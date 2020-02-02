package com.ilegra.frapkiewicz.challenge.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ilegra.frapkiewicz.challenge.model.Sale;
import com.ilegra.frapkiewicz.challenge.model.SaleItem;

class SaleParserTest {

	private SaleParser parser;
	
	@BeforeEach
	void setUp() throws Exception {
		parser = new SaleParser();
	}

	@AfterEach
	void tearDown() throws Exception {
		parser = null;
	}

	@Test
	void testWithValidValue() {
		Sale sale = new Sale();
		sale.setId("003");
		sale.setSaleId(10l);
		sale.setSalesname("Pedro");
		sale.setSaleItems(Arrays.asList( 
				new SaleItem(1l, 10, 100.0),
				new SaleItem(2l, 30, 2.50),
				new SaleItem(3l, 40, 3.10)));
		
		assertEquals(sale, parser.tryParse("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro").get());
	}
	
	@Test
	void testWithEmptyValue() {
		assertFalse(parser.tryParse("").isPresent());
	}

	@Test
	void testWithInvalidLimiter() {
		assertFalse(parser.tryParse("003ç10ç[1ç10ç100,2ç30ç2.50,3ç40ç3.10]çPedro").isPresent());
		assertFalse(parser.tryParse("003-10-[1-10-100,2-30-2.50,3-40-3.10]-Pedro").isPresent());
		assertFalse(parser.tryParse("003-10ç[1ç10ç100,2ç30ç2.50,3ç40ç3.10]-Pedro").isPresent());
	}
	
	@Test
	void testWithInvalidId() {
		assertFalse(parser.tryParse("3ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro").isPresent());
		assertFalse(parser.tryParse("03ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro").isPresent());
		assertFalse(parser.tryParse("001ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro").isPresent());
	}
	
	@Test
	void testWithInvalidSalesname() {
		assertFalse(parser.tryParse("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]ç").isPresent());
		assertFalse(parser.tryParse("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]ç123").isPresent());
		assertFalse(parser.tryParse("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro Alves").isPresent());
	}
	
	@Test
	void testWithInvalidSalesItem() {
		assertFalse(parser.tryParse("003ç10ç[]Pedro").isPresent());
		assertFalse(parser.tryParse("003ç10ç[1-10-100,id-30-2.50,3-40-3.10]çPedro").isPresent());
		assertFalse(parser.tryParse("003ç10ç[1-10-100,2-30-2.50,3-40-]çPedro").isPresent());
	}
}
