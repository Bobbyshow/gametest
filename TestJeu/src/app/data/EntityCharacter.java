package app.data;
/**
 * class EntityCharacter
 * 
 * @author Anthony
 *
 */
public class EntityCharacter {
	/* Statistique de base */
	private int _lvl; /* niveau de l'entité */
	private int _hp; /* PV de l'entité */
	private int _hp_max; /* PV max de l'entité */
	private int _mp; /* MP de l'entité */
	private int _mp_max; /* MP max de l'entité */
	private Armor _armure; /* Armure porté par l'entité */
	private int _atk; /* Attaque */
	private int _def; /* defense */
	private int _matk; /* attaque magique */
	private int _mdef; /* defense magique */
	private int _bonus; /* puissance bonus */
	private int _malus; /* puissance malus */
	private float _vitesse; /* vitesse du personnage */
	/*Statistique lors d'un combat */
	private int _cur_atk; /* Attaque courante */
	private int _cur_def; /* defense courante */
	private int _cur_matk; /* attaque magique courante */
	private int _cur_mdef; /* defense magique courante*/
	private int _cur_bonus; /* puissance bonus courante*/
	private int _cur_malus; /* puissance malus courante*/
	
	private float _temps; /*  tour du joueur est actif quand tps = 0*/
	private Etat _etat; /* Etat de l'entité */
	private EntityCharacter _cible; /* Entité prise pour cible */
	public EntityCharacter(int lvl, int hp, int mp, int atk, int def, int matk, int mdef, int bonus, int malus){
		_lvl = lvl;
		_hp = hp;
		_hp_max=hp;
		_mp = mp;
		_mp_max = mp;
		_atk = atk;
		_def = def;
		_matk = matk;
		_mdef = mdef;
		_bonus = bonus;
		_malus = malus;
		_armure = new Armor();
		_vitesse = (float) 0.30;
		_cur_atk = _atk;
		_cur_def = _def + _armure.recup_def_total_armure();
		_cur_matk = _matk;
		_cur_mdef = _mdef; /* defense magique */
		_cur_bonus = _bonus; /* puissance bonus */
		_cur_malus = _malus;
		init_temps();
	}
	public float get_temps() {
		return _temps;
	}
	public int get_hp_max() {
		return _hp_max;
	}
	public void set_hp_max(int _hp_max) {
		this._hp_max = _hp_max;
	}
	public int get_mp_max() {
		return _mp_max;
	}
	public void set_mp_max(int _mp_max) {
		this._mp_max = _mp_max;
	}
	public int get_lvl() {
		return _lvl;
	}
	public void set_lvl(int _lvl) {
		this._lvl = _lvl;
	}
	public int get_hp() {
		return _hp;
	}
	public void set_hp(int _hp) {
		this._hp = _hp;
	}
	public int get_mp() {
		return _mp;
	}
	public void set_mp(int _mp) {
		this._mp = _mp;
	}
	public int get_atk() {
		return _atk;
	}
	public void set_atk(int _atk) {
		this._atk = _atk;
	}
	public int get_def() {
		return _def;
	}
	public void set_def(int _def) {
		this._def = _def;
	}
	public int get_matk() {
		return _matk;
	}
	public void set_matk(int _matk) {
		this._matk = _matk;
	}
	public int get_mdef() {
		return _mdef;
	}
	public void set_mdef(int _mdef) {
		this._mdef = _mdef;
	}
	public int get_bonus() {
		return _bonus;
	}
	public void set_bonus(int _bonus) {
		this._bonus = _bonus;
	}
	public int get_malus() {
		return _malus;
	}
	public void set_malus(int _malus) {
		this._malus = _malus;
	}
	public Armor get_armure() {
		return _armure;
	}
	public void set_armure(Armor _armure) {
		this._armure = _armure;
	}	
	public Etat get_etat() {
		return _etat;
	}
	public void set_etat(Etat e) {
		_etat = e;
	}
	public int get_cur_atk() {
		return _cur_atk;
	}
	public void set_cur_atk(int _cur_atk) {
		this._cur_atk = _cur_atk;
	}
	public int get_cur_def() {
		return _cur_def;
	}
	public void set_cur_def(int _cur_def) {
		this._cur_def = _cur_def;
	}
	public int get_cur_matk() {
		return _cur_matk;
	}
	public void set_cur_matk(int _cur_matk) {
		this._cur_matk = _cur_matk;
	}
	public int get_cur_mdef() {
		return _cur_mdef;
	}
	public void set_cur_mdef(int _cur_mdef) {
		this._cur_mdef = _cur_mdef;
	}
	public int get_cur_bonus() {
		return _cur_bonus;
	}
	public void set_cur_bonus(int _cur_bonus) {
		this._cur_bonus = _cur_bonus;
	}
	public int get_cur_malus() {
		return _cur_malus;
	}
	public void set_cur_malus(int _cur_malus) {
		this._cur_malus = _cur_malus;
	}
	public boolean tourActive(){
		_temps -= _vitesse;
		return (_temps <= 0.0);
	}
	public void init_temps(){
		_temps = 100;
	}
	public void prendPourCible(EntityCharacter cib){
		_cible = cib;
	}
	public void AttaqueEnnemi(EntityCharacter cib){
		int attaque = _atk * 100;
		cib.set_hp(cib.get_hp()-(attaque-cib.get_cur_def()));
	}
	public boolean estMort(){
		return _hp <= 0;
	}
}
