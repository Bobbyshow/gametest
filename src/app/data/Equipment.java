package app.data;

public class Equipment {
	private int def; /* d�fense de l'equipement */
	private int mdef; /* defense de l'�quipement */
	private String details; /* d�tails de l'objet */
	private int atk_bonus = 0; /* Bonus attaque */
	private int matk_bonus = 0; /*bonus atk magique */
	private int bonus_bonus = 0; /* bonus de bonus */
	private int malus_bonus = 0; /* bonus de malus */
	
	public Equipment(){
		def = 0;
		details = "";
	}
	public void createEquipment(int defense, String det){
		def = defense;
		details = det;
	}
	public int getDef() {
		return def;
	}
	public int getMdef() {
		return mdef;
	}
	public String getDetails() {
		return details;
	}
	public int getBonus(String str){
		switch (str){
			case "atk":
			break;
			case "def":
			break;
		}
		return 1;
	}

}