package app.data;
/**
 * Enum�re tous les �tats possible d'une entit� lors d'un combat
 * 
 * @author Anthony
 *
 */
public enum Etat {
	ATTENTE, /* En p�riode d'attente (wait)*/
	PRET, /* Pr�t � attendre son tour pour choisir son coup */
	CHOIX, /* Periode de choix */
	CHOIX_ATTAQUE, /* Decide qui attaquer */
	ATTAQUE, /* D�cide d'attaquer */
	FIN_ATTAQUE, /* Fin d'attaque */
	FIN_TOUR, /* Fin du tour d'action*/
	DEFENSE, /* Decide de se d�fendre */
	ATTENTE_DEF, /* Attente d�fensive */
	CHOIX_MAGIE, /* Utilise une magie */
	CHOIX_OBJET, /* Utilise un objet */
	CHOIX_COMBO,  /* Utilise un combo */
	DYING, /* Entit� en train de mourrir */
	DEAD, /* Entit� morte */
	WIN /* Entit� victorieuse */
}
