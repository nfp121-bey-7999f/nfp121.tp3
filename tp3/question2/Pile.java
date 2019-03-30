package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (arda )
 * @version (un num√©ro de version ou une date)
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
     * Ajoute un objet ‡ la pile.
     * 
     * @param Object i : object ‡ ajouter.
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
     * Retourne le dernier ÈlÈment ajoutÈ.
     */
    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();

        return this.zone[ptr-1]; 
    }
    
    /**
     * Donne le nombre maximum d'ÈlÈments que peut contenir la pile.
     */

    public int capacite() {
       return this.zone.length;
    }
    
    /**
     * Donne le nombre d'ÈlÈments que contient la pile ‡ cet instant.
     */
    public int taille() {
        if(estVide()){
            ptr = 0;
        }
        return this.ptr;
    }
    
    /**
     * MÈthode retournant true si la pile est vide.
     */
    public boolean estVide() {
       return this.ptr == 0;
    }
    
    /**
     * MÈthode retournant true si la pile est pleine.
     */
    public boolean estPleine() {
        return this.ptr == this.zone.length;
    }

     public boolean equals(Object o) {
        boolean equals = false;
        if (o instanceof Pile) {
            Pile pile = (Pile)o;
            // DÈfinit si les deux piles ont la mÍme capacitÈ et le mÍme nombre d'ÈlÈments.
            equals = capacite() == pile.capacite() && taille() == pile.taille();
            if (equals) {
                for (int i = ptr - 1; i >= 0; i--) {
                    // Compare chaque ÈlÈment depuis le sommet de chaque pile.
                    Object a = zone[i], b = pile.zone[i];
                    if (a != null) {
                        equals &= a.equals(b);
                    } else {
                        equals = false;
                    }                   
                    if (!equals) {
                        // Si il existe au moins une diffÈrence dans les deux piles c'est qu'elles ne sont pas Ègales, il n'est pas nÈcessaire de poursuivre la comparaison.
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
