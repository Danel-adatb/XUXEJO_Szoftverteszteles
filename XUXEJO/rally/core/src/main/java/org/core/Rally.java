package org.core;


import org.enums.Brand;
import org.enums.Category;
import org.enums.Country;
import org.enums.Type;
import org.core.exceptions.InvalidDate;
import org.core.exceptions.InvalidID;
import org.core.exceptions.InvalidTime;
import org.core.exceptions.InvalidWeekNumber;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Rally implements AccidentMessage, Comparable<Rally> {
	public static Map<String, Integer> engineRange;		//Motor henger�rtartalm�nak megfelelts�ge (csal�s figyel�se)

	static {
		engineRange = new HashMap<>();
		engineRange.put("1.0", 1000);
		engineRange.put("1.3", 1300);
		engineRange.put("1.6", 1600);
	}
	
	protected long id;									//Adatok ID-je
	protected String pilot;								//Pil�ta neve
	protected Country country;							//Amelyik orsz�gban lesz a rally
	protected int week;									//Ahanyadik h�ten lesz az �vben a verseny
	protected boolean racing;							//Versenyben van-e m�g a pil�ta (yes/no)
	protected LocalDate date;							//Pontos d�tuma a versenynek
	protected Brand brand;								//Pil�ta aut�j�nak m�rk�ja
	protected Type type;								//-||- tipusa
	protected Category category;						//-||- kateg�ri�ja
	protected double time; 								//Az adott pil�ta ideje
	protected Integer engine;							//Motornak a nagys�ga
	
	//Regul�ris kifejez�s arra, hogy minden rendben van a pil�t�kkal baleset eset�n
	@Override
	public void OK() {
		System.out.println("Crew OK!");
	}
	
	//Constructors
	public Rally(long id, String pilot, Country country, int week, boolean racing, LocalDate date, Brand brand, Type type,
			Category category, double time, String engine) throws InvalidDate, InvalidID, InvalidWeekNumber, InvalidTime {
		super();
		setID(id);
		setPilot(pilot);
		setCountry(country);
		setWeek(week);
		setRacing(racing);
		setDate(date);
		setBrand(brand);
		setType(type);
		setCategory(category);
		setTime(time);
		setEngine(engine);
	}
	
	public Rally(long id, String pilot, Country country, int week, boolean racing, LocalDate date, Brand brand, Type type,
			Category category, double time, Integer engine) throws InvalidDate, InvalidID, InvalidWeekNumber, InvalidTime {
		super();
		setID(id);
		setPilot(pilot);
		setCountry(country);
		setWeek(week);
		setRacing(racing);
		setDate(date);
		setBrand(brand);
		setType(type);
		setCategory(category);
		setTime(time);
		setEngine(engine);
	}
	
	public Rally() {
		
	}
	
	//Getters, Setters
	public Integer getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engineRange.get(engine);
	}
	
	public void setEngine(Integer engine) {
		this.engine = engine;
	}
	
	public long getID() {
		return id;
	}
	
	public void setID(long id) throws InvalidID {
		String s = String.valueOf(id);
		if(!isNumeric(s)) {
			throw new InvalidID(id);
		}
		
		if(id < 0) {
			throw new InvalidID(id);
		}
		
		this.id = id;
	}

	public String getPilot() {
		return pilot;
	}

	public void setPilot(String pilot) {
		this.pilot = pilot;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) throws InvalidWeekNumber {
		if(week <= 1 || week > 52) {
			throw new InvalidWeekNumber(week);
		}
	
		this.week = week;
	}

	public boolean isRacing() {
		return racing;
	}

	public void setRacing(boolean racing) {
		this.racing = racing;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) throws InvalidDate {
		LocalDate currentdate = LocalDate.now();
		if (date.isAfter(currentdate) || date.isBefore(LocalDate.of(currentdate.getYear(), 1, 1))) {
			throw new InvalidDate(date);
		}
		
		this.date = date;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getTime() {
		return time;
	}

	//perc.m�sodperc
	//Van egy DeadLine Time ami alatt teljes�teni kell a szakaszt (60.0 m�sodperc)
	public void setTime(double time) throws InvalidTime {
		String decimalRegex = "^[0-9]+([\\.][0-9]+)?$";
		String tempTime = Double.toString(time);
		if(!tempTime.matches(decimalRegex)) {
			throw new InvalidTime(time);
		}
		
		if(time < 0) {
			throw new InvalidTime(time);
		} else if (time > 59.59) {
			throw new InvalidTime(time);
		}
			
		this.time = time;
	}
	
	//----------------------------------------------------------
	
	//Check for Numeric value
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        long d = Long.parseLong(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	//Get all Fords
	public Boolean isFord() {
		if(!(brand == Brand.FORD)) {
			return false;
		}
		
		return true;
	}
	
	 @Override
	 public int compareTo(Rally o) {
		  if (this.getTime() > o.getTime()) {
			  return 1;
		  } else if (this.getTime() < o.getTime()) {
			  return -1;
		  }
		  return 0;
	 }

	 //Check if Pilot exists
	 public Boolean containsPilot(String pilot) {
		if(pilot != this.getPilot()) {
			return false;
		}
		
		return true;
	 }
}

