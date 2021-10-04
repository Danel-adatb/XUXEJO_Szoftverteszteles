package hu.uni.miskolc.teszteles;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Auto implements HanggalRendelkezo {
	public static Map<String, Integer> hengerurtartalomErtekek;
	
	static {
		hengerurtartalomErtekek = new HashMap<>();
		hengerurtartalomErtekek.put("1.0", 998);
		hengerurtartalomErtekek.put("1.2", 1199);
		hengerurtartalomErtekek.put("1.4", 1390);
		hengerurtartalomErtekek.put("1.6", 1560);
		hengerurtartalomErtekek.put("1.8", 1789);
		hengerurtartalomErtekek.put("2.0", 1998);
	}
	
	private String gyarto;
	private String modell;
	private Integer hengerurtartalom;
	private String rendszam;
	private Uzemanyag uzemanyag;
	private LocalDate gyartas;
	private String szinHex;
	private boolean korozott;
	private String forgalmi;
	private Valto valto;
	private Kivitel kivitel;
	private int ajtok;
	
	@Override
	public void dudal() {
		System.out.println("Tütû!");
	}

	//Konstruktor
	public Auto(String gyarto, String modell, String hengerurtartalom, String rendszam,
			Uzemanyag uzemanyag, LocalDate gyartas, String szinHex, boolean korozott, String forgalmi, Valto valto,
			Kivitel kivitel, int ajtok) {
		super();
		this.gyarto = gyarto;
		this.modell = modell;
		setHengerurtartalom(hengerurtartalom);;
		this.rendszam = rendszam;
		this.uzemanyag = uzemanyag;
		this.gyartas = gyartas;
		this.szinHex = szinHex;
		this.korozott = korozott;
		this.forgalmi = forgalmi;
		this.valto = valto;
		this.kivitel = kivitel;
		this.ajtok = ajtok;
	}
	
	//Getter, Setterek
	public String getGyarto() {
		return gyarto;
	}

	protected void setGyarto(String gyarto) {
		this.gyarto = gyarto;
	}

	public String getModell() {
		return modell;
	}

	protected void setModell(String modell) {
		this.modell = modell;
	}

	public Integer getHengerurtartalom() {
		return hengerurtartalom;
	}

	public void setHengerurtartalom(String hengerurtartalom) {
		this.hengerurtartalom = hengerurtartalomErtekek.get(hengerurtartalom);
	}

	public String getRendszam() {
		return rendszam;
	}

	public void setRendszam(String rendszam) {
		this.rendszam = rendszam;
	}

	public Uzemanyag getUzemanyag() {
		return uzemanyag;
	}

	public void setUzemanyag(Uzemanyag uzemanyag) {
		this.uzemanyag = uzemanyag;
	}

	public LocalDate getGyartas() {
		return gyartas;
	}

	protected void setGyartas(LocalDate gyartas) {
		this.gyartas = gyartas;
	}

	public String getSzinHex() {
		return szinHex;
	}

	public void setSzinHex(String szinHex) {
		this.szinHex = szinHex;
	}

	public boolean isKorozott() {
		return korozott;
	}

	public void setKorozott(boolean korozott) {
		this.korozott = korozott;
	}

	public String getForgalmi() {
		return forgalmi;
	}

	public void setForgalmi(String forgalmi) {
		this.forgalmi = forgalmi;
	}

	public Valto getValto() {
		return valto;
	}

	public void setValto(Valto valto) {
		this.valto = valto;
	}

	public Kivitel getKivitel() {
		return kivitel;
	}

	protected void setKivitel(Kivitel kivitel) {
		this.kivitel = kivitel;
	}

	public int getAjtok() {
		return ajtok;
	}

	protected void setAjtok(int ajtok) {
		this.ajtok = ajtok;
	}
	
	
	
}
