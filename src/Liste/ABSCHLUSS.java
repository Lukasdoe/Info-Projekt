package Liste;

public class ABSCHLUSS extends LISTENELEMENT
{
    public ABSCHLUSS() {        
    }
    
    LISTENELEMENT NachfolgerGeben() {
        return this;
    }
    
    DATENELEMENT DatenelementGeben() {
        return null;
    }

    int RestlaengeGeben()  {
        return 0;
    }
    
    KNOTEN HintenEinfuegen(DATENELEMENT dNeu)  {
        return new KNOTEN(dNeu, this);
    }
    
    LISTENELEMENT KnotenEntfernen(DATENELEMENT d)  {
       return this; 
    }
    
    DATENELEMENT EndeGeben(DATENELEMENT d)  {
        return d;
    }
}
