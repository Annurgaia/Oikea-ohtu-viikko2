package ohtu.verkkokauppa;


public class ViitegeneraattoriImpl implements Viitegeneraattori {
    
    private int seuraava;
    
    public ViitegeneraattoriImpl(){
        seuraava = 1;    
    }
    
    public int uusi(){
        return seuraava++;
    }
}