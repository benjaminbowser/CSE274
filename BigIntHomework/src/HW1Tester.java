// Benjamin Bowser
// CSE274 UA
import static org.junit.Assert.*;

import org.junit.Test;

public class HW1Tester {

	@Test
	public void constructorTest1() {
		MyBigInt con1 = new MyBigInt();
		assertEquals(con1.toString(), 0, 0);
	}

	@Test
	public void constructorTest2() {
		MyBigInt con2 = new MyBigInt(215156156156L);
		assertEquals(con2.toString(), "215156156156");
	}
	@Test
	public void constructorTest3() {
		MyBigInt con3 = new MyBigInt("5365376388384338387638763843684368515615645789478156058151560");
		assertEquals(con3.toString(), "5365376388384338387638763843684368515615645789478156058151560");
	}

	@Test
	public void additionTest1() 
	{
		MyBigInt t1 = new MyBigInt(100L);
		MyBigInt t2 = new MyBigInt(1202L);
		String sum1 = t1.add(t2).toString();

		assertEquals(Integer.parseInt(sum1), 1302, 0);
	}

	@Test
	public void additionTest2() 
	{
		MyBigInt t1 = new MyBigInt(-100L);
		MyBigInt t2 = new MyBigInt(-1202L);
		String sum1 = t1.add(t2).toString();

		assertEquals(Integer.parseInt(sum1), -1302, 0);
	}

	@Test
	public void additionTest3() 
	{
		MyBigInt t1 = new MyBigInt(10000000000L);
		MyBigInt t2 = new MyBigInt(-1202L);
		String sum1 = t1.add(t2).toString();
		assertEquals(sum1, "9999998798");
	}

	@Test
	public void additionTest4() {
		MyBigInt t1 = new MyBigInt(-100L);
		MyBigInt t2 = new MyBigInt(-10L);
		String sum1 = t1.add(t2).toString();
		assertEquals(sum1, "-110");
	}

	@Test
	public void additionTest5() {
		MyBigInt t1 = new MyBigInt("100");
		MyBigInt t2 = new MyBigInt("-2");
		String sum1 = t1.add(t2).toString();
		assertEquals(sum1, "98");
	}
	
	@Test
	public void additionTest6() {
		MyBigInt t1 = new MyBigInt("146879461");
		MyBigInt t2 = new MyBigInt("167916430");
		String sum1 = t1.add(t2).toString();
		assertEquals(sum1, "314795891");
	}
	
	@Test
	public void additionTest7() {
		MyBigInt t1 = new MyBigInt("10000");
		MyBigInt t2 = new MyBigInt(0L);
		String sum1 = t1.add(t2).toString();
		assertEquals(sum1, "10000");
	}
	
	@Test
	public void additionTest8() {
		MyBigInt t1 = new MyBigInt(146879461L);
		MyBigInt t2 = new MyBigInt("167916430");
		String sum1 = t1.add(t2).toString();
		assertEquals(sum1, "314795891");
	}
	
	@Test
	public void additionTest9() {
		MyBigInt t1 = new MyBigInt();
		MyBigInt t2 = new MyBigInt("167916430");
		String sum1 = t1.add(t2).toString();
		assertEquals(sum1, "167916430");
	}
	
	@Test
	public void additionTest10() {
		MyBigInt t1 = new MyBigInt(274271174L);
		MyBigInt t2 = new MyBigInt();
		String sum1 = t1.add(t2).toString();
		assertEquals(sum1, "274271174");
	}
	
	@Test
	public void additionTest11() {
		MyBigInt t1 = new MyBigInt(-274271174L);
		MyBigInt t2 = new MyBigInt(20L);
		String sum1 = t1.add(t2).toString();
		assertEquals(sum1, "-274271154");
	}

	@Test
	public void subtractionTest1() {
		MyBigInt t1 = new MyBigInt();
		MyBigInt t2 = new MyBigInt(-200);
		String sum1 = t1.subtract(t2).toString();
		assertEquals(sum1, "-200");
	}
	
	@Test
	public void subtractionTest2() {
		MyBigInt t1 = new MyBigInt(-100L);
		MyBigInt t2 = new MyBigInt(-201L);
		String sum1 = t1.subtract(t2).toString();
		assertEquals(sum1, "101");
	}

	@Test
	public void subtractionTest3() {
		MyBigInt t1 = new MyBigInt(100L);
		MyBigInt t2 = new MyBigInt(100L);
		String sum1 = t1.subtract(t2).toString();
		assertEquals(sum1, "00");
	}

	@Test
	public void subtractionTest4() {
		MyBigInt t1 = new MyBigInt(-100L);
		MyBigInt t2 = new MyBigInt(100L);
		String sum1 = t1.subtract(t2).toString();
		assertEquals(sum1, "-200");
	}

	@Test
	public void subtractionTest5() {
		MyBigInt t1 = new MyBigInt(100L);
		MyBigInt t2 = new MyBigInt(200L);
		String sum1 = t1.subtract(t2).toString();
		assertEquals(sum1, "-100");
		// Shows issue with subtracting a big number from
		// a smaller number.
	}
	
	@Test
	public void subtractionTest6() {
		MyBigInt t1 = new MyBigInt(100L);
		MyBigInt t2 = new MyBigInt();
		String sum1 = t1.subtract(t2).toString();
		assertEquals(sum1, "100");
	}
	
	@Test
	public void subtractionTest7() {
		MyBigInt t1 = new MyBigInt("200");
		MyBigInt t2 = new MyBigInt();
		String sum1 = t1.subtract(t2).toString();
		assertEquals(sum1, "200");
	}
	
	@Test
	public void subtractionTest8() {
		MyBigInt t1 = new MyBigInt("446000");
		MyBigInt t2 = new MyBigInt(14652L);
		String sum1 = t1.subtract(t2).toString();
		assertEquals(sum1, "431348");
	}
	
	@Test
	public void subtractionTest9() {
		MyBigInt t1 = new MyBigInt("-446000");
		MyBigInt t2 = new MyBigInt("-14652");
		String sum1 = t1.subtract(t2).toString();
		assertEquals(sum1, "431348");
	}
	
	@Test
	public void subtractionTest10() {
		MyBigInt t1 = new MyBigInt("99999990");
		MyBigInt t2 = new MyBigInt("1");
		String sum1 = t1.subtract(t2).toString();
		assertEquals(sum1, "99999989");
	}
	
	@Test
	public void subtractionTest11() {
		MyBigInt t1 = new MyBigInt("-99999990");
		MyBigInt t2 = new MyBigInt();
		String sum1 = t1.subtract(t2).toString();
		assertEquals(sum1, "-99999990");
	}
}