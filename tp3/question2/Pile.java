package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (arda )
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;
   /**
    * constructeur par initialisation
    * @param taille :nombre d'elements de la pile.
    */
   
    public Pile(int taille) {
   if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.zone = new Object[taille];
        this.ptr = 0;
    }
    
   /**
    * constructeur par defaut  .
    */
    public Pile() {
        this( PileI.CAPACITE_PAR_DEFAUT);
    }
    
    /**
     * Ajoute un objet � la pile.
     * 
     * @param Object i : object � ajouter.
     */
    public void empiler(Object i) throws PilePleineException {
       if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = i;
        this.ptr++;
    }
    /**
     * Supprime l'objet de la pile.
     * 
     */
    public Object depiler() throws PileVideException {
       if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }
    
    /**
     * Retourne le dernier �l�ment ajout�.
     */
    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();

        return this.zone[ptr-1]; 
    }
    
    /**
     * Donne le nombre maximum d'�l�ments que peut contenir la pile.
     */

    public int capacite() {
       return this.zone.length;
    }
    
    /**
     * Donne le nombre d'�l�ments que contient la pile � cet instant.
     */
    public int taille() {
        if(estVide()){
            ptr = 0;
        }
        return this.ptr;
    }
    
    /**
     * M�thode retournant true si la pile est vide.
     */
    public boolean estVide() {
       return this.ptr == 0;
    }
    
    /**
     * M�thode retournant true si la pile est pleine.
     */
    public boolean estPleine() {
        return this.ptr == this.zone.length;
    }

     public boolean equals(Object o) {
        boolean equals = false;
        if (o instanceof Pile) {
            Pile pile = (Pile)o;
            // D�finit si les deux piles ont la m�me capacit� et le m�me nombre d'�l�ments.
            equals = capacite() == pile.capacite() && taille() == pile.taille();
            if (equals) {
                for (int i = ptr - 1; i >= 0; i--) {
                    // Compare chaque �l�ment depuis le sommet de chaque pile.
                    Object a = zone[i], b = pile.zone[i];
                    if (a != null) {
                        equals &= a.equals(b);
                    } else {
                        equals = false;
                    }                   
                    if (!equals) {
                        // Si il existe au moins une diff�rence dans les deux piles c'est qu'elles ne sont pas �gales, il n'est pas n�cessaire de poursuivre la comparaison.
                        break;
                    }
                }
            }
        }
        return equals;
    }
  
        
        
        
    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            Object item = zone[i];
            if (item != null) {
                sb.append(item.toString());
                if (i > 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
