package Polinomios;

public class Nodo {
	
	   private int Exp;
	   private int Coe;
	   private Nodo liga;
	   //Método constructor

	    public Nodo(int Coe, int Exp)
	    {
	        this.Exp = Exp;
	        this.Coe= Coe;
	        liga=null;
	    }
	    
	    
	    public int GetCoe() {
	        return Coe;
	    }

	    public void SetCoe(int Coe) {
	        this.Coe = Coe;
	    }

	    public int GetExp() {
	        return Exp;
	    }

	    public void SetExp(int Exp) {
	        this.Exp = Exp;
	    }

	    public Nodo getLiga() {
	        return liga;
	    }

	    public void setLiga(Nodo liga) {
	        this.liga = liga;
	    }
	    
	}


