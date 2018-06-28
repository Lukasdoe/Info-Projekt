package Graph;

public class KNOTEN
{
    private String bezeichnung;

    public KNOTEN(String b)
    {
        bezeichnung = b;
    }

    
    public String BezeichnungGeben()
    {
        return bezeichnung;
    }
    
     public String BezFormatGeben(int breite)
    {
        return (bezeichnung+"              ").substring(0, breite-1);
    }
}
