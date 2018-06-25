package Liste;

public abstract class LISTENELEMENT
{
    abstract int RestlaengeGeben();
    abstract KNOTEN HintenEinfuegen(DATENELEMENT dNeu);
    abstract LISTENELEMENT NachfolgerGeben();
    abstract DATENELEMENT DatenelementGeben();
    abstract DATENELEMENT EndeGeben(DATENELEMENT d);
    abstract LISTENELEMENT KnotenEntfernen(DATENELEMENT d);
}
