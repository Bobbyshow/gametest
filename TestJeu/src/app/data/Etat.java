package app.data;
/**
 * Enumère tous les états possible d'une entité lors d'un combat
 * 
 * @author Anthony
 *
 */
public enum Etat {
	ATTENTE, /* En période d'attente (wait)*/
	PRET, /* Prêt à attendre son tour pour choisir son coup */
	CHOIX, /* Periode de choix */
	CHOIX_ATTAQUE, /* Decide qui attaquer */
	ATTAQUE, /* Décide d'attaquer */
	FIN_ATTAQUE, /* Fin d'attaque */
	FIN_TOUR, /* Fin du tour d'action*/
	DEFENSE, /* Decide de se défendre */
	ATTENTE_DEF, /* Attente défensive */
	CHOIX_MAGIE, /* Utilise une magie */
	CHOIX_OBJET, /* Utilise un objet */
	CHOIX_COMBO,  /* Utilise un combo */
	DYING, /* Entité en train de mourrir */
	DEAD, /* Entité morte */
	WIN /* Entité victorieuse */
}
