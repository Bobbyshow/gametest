package app.data;
/**
 * class Armor
 * 
 * @author Anthony
 *
 */
public class Armor {
	private Equipment _bras_g; /*equipement du bras gauche*/
	private Equipment _bras_d; /*equipement du bras droit*/
	private Equipment _jambe_d; /*equipement de la jambe droite*/
	private Equipment _jambe_g; /*equipement de la jambe gauche*/
	private Equipment _corps; /*equipement du corps*/
	public Armor(){
		_bras_g = new Equipment();
		_bras_d = new Equipment();
		_jambe_d = new Equipment();
		_jambe_g = new Equipment();
		_corps = new Equipment();
	}
	public Equipment get_bras_g() {
		return _bras_g;
	}
	public void set_bras_g(Equipment _bras_g) {
		this._bras_g = _bras_g;
	}
	public Equipment get_bras_d() {
		return _bras_d;
	}
	public void set_bras_d(Equipment _bras_d) {
		this._bras_d = _bras_d;
	}
	public Equipment get_jambe_d() {
		return _jambe_d;
	}
	public void set_jambe_d(Equipment _jambe_d) {
		this._jambe_d = _jambe_d;
	}
	public Equipment get_jambe_g() {
		return _jambe_g;
	}
	public void set_jambe_g(Equipment _jambe_g) {
		this._jambe_g = _jambe_g;
	}
	public Equipment get_corps() {
		return _corps;
	}
	public void set_corps(Equipment _corps) {
		this._corps = _corps;
	}
	public int recup_def_total_armure(){
		return _bras_g.getDef() + _bras_d.getDef() + 
			   _jambe_d.getDef() + _jambe_g.getDef() +
			   _corps.getDef();
	}
}
