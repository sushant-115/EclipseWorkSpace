package app;
import app.Product;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestHbm {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() throws ClassNotFoundException {
		Class.forName("Product");
		fail("Not yet implemented");
	}

}
