package org.core.test;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import org.core.Rally;
import org.enums.Brand;
import org.enums.Category;
import org.enums.Country;
import org.enums.Type;
import org.core.exceptions.InvalidDate;
import org.core.exceptions.InvalidID;
import org.core.exceptions.InvalidTime;
import org.core.exceptions.InvalidWeekNumber;

public class RallyTest {
	
	Rally testRally;

	@Before
	public void initRally() {
		testRally = new Rally();
	}
	
	//InvalidID
		@Test
		public void test_GoodID() throws InvalidID {
			long id = 1;
			testRally.setID(id);
		}
		
		@Test(expected = InvalidID.class)
		public void test_BeforeNullInvalidID() throws InvalidID {
			long id = -1;
			testRally.setID(id);
		}
		
	//Getter, Setter - Pilot
		@Test
		public void test_getPilot() {
			testRally.getPilot();
		}
		
		@Test
		public void test_setPilot() {
			testRally.setPilot("Szab� D�niel");
		}
		
	//Getter, Setter - Country
		@Test
		public void test_getCountry() {
			testRally.getCountry();
		}
		
		@Test
		public void test_setCountry() {
			testRally.setCountry(Country.ESTONIA);
		}
		
	//InvalidWeekNumber
		@Test
		public void test_GoodWeekNumber() throws InvalidWeekNumber {
			int week = 23;
			testRally.setWeek(week);
		}
		
		@Test(expected = InvalidWeekNumber.class)
		public void test_NullWeekNumber() throws InvalidWeekNumber {
			int week = 0;
			testRally.setWeek(week);
		}
		
		@Test(expected = InvalidWeekNumber.class)
		public void test_BeforeValidWeekNumber() throws InvalidWeekNumber {
			int week = -1;
			testRally.setWeek(week);
		}
		
		@Test(expected = InvalidWeekNumber.class)
		public void test_AfterValidWeekNumber() throws InvalidWeekNumber {
			int week = 53;
			testRally.setWeek(week);
		}
		
	//Racing
		@Test
		public void test_getRacing() {
			testRally.isRacing();
		}
		
		@Test
		public void test_setRacing() {
			testRally.setRacing(true);
		}
	
	//InvalidDate
		@Test
		public void test_GoodDate() throws InvalidDate {
			String date = "2021-03-03";
			testRally.setDate(LocalDate.parse(date));
		}
		
		@Test(expected = InvalidDate.class)
		public void test_EarlyDate() throws InvalidDate {
			String date = "0110-01-01";
			testRally.setDate(LocalDate.parse(date));
		}
		
		@Test(expected = InvalidDate.class)
		public void test_LateDate() throws InvalidDate {
			String date = "2023-01-01";
			testRally.setDate(LocalDate.parse(date));
		}
		
	//Brand
		@Test
		public void test_getBrand() {
			testRally.getBrand();
		}
		
		@Test
		public void test_setBrand() {
			testRally.setBrand(Brand.FORD);
		}
		
	//Type
		@Test
		public void test_getType() {
			testRally.getType();
		}
		
		@Test
		public void test_setType() {
			testRally.setType(Type.PUMA);
		}
		
	//Category
		@Test
		public void test_getCategory() {
			testRally.getCategory();
		}
		
		@Test
		public void test_setCategory() {
			testRally.setCategory(Category.WRC);
		}

	//InvalidTime
		@Test
		public void test_GoodTimeWithDot() throws InvalidTime {
			double time = 1.23;
			testRally.setTime(time);
		}
		
		@Test
		public void test_GoodTimeWithoutDot() throws InvalidTime {
			double time = 1;
			testRally.setTime(time);
		}
		
		@Test(expected = InvalidTime.class)
		public void test_TimeBeforeNull() throws InvalidTime {
			double time = -1.12;
			testRally.setTime(time);
		}
		
		@Test(expected = InvalidTime.class)
		public void test_TimeAfterDeadLineTime() throws InvalidTime {
			double time = 60.01;
			testRally.setTime(time);
		}
		
	//Engine
		@Test
		public void test_getEngine() {
			testRally.getEngine();
		}
		
		@Test
		public void test_setEngine() {
			testRally.setEngine("1.6");
		}
		
	//Whole Model Test
		@Test
		public void test() throws InvalidDate, InvalidID, InvalidTime, InvalidWeekNumber {
			testRally = new Rally(1, "Ott Tanak", Country.MONZA, 24, true, LocalDate.of(2021, 6, 9), Brand.TOYOTA, Type.YARIS,
					Category.WRC, 23.17, "1.6");
		}
}

