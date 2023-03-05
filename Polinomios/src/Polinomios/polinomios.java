package Polinomios;

import javax.swing.JOptionPane;

public class polinomios 
{

	public static void main(String[] args) 
	{
		
		/*String Spol= "";
		String Spol2= "-x^5+5x^3+3x-2";
		String Vs[]= Entrada(Spol);
		String	Vs2[]=Entrada(Spol2);
		PolinomiosF1 pol= new PolinomiosF1(Vs2); 
		PolinomiosF1 res= new PolinomiosF1();
		PolinomioF3 pol2= new PolinomioF3(Vs);*/
		
		
		menu();
		
		//pol.eliminar(2);
		//Spol=pol.reconstruir();
		//res=res.multiplicarF2F3(pol,pol2);
		//pol2.valorx(2);
		//pol.insertarMonomio(Vs);
		//pol.insertarMononmio(Vs);
		//pol.eliminarMonomio(5);
		//PolinomiosF1 aux=pol2.multiplicar(pol);
		//pol.valorx(2);
		//res.mostrar();
		//mostrarentrada(Vs);
		
		//System.out.println(Spol);
		

	}
	
	public static void mostrarentrada(String Vs[])
	{
		for (int k=0;k<Vs.length;k++) 
		{
		
			System.out.print("["+Vs[k]+"]");
			
		}
	}
	
	
	public static void menu()
	{
		String pol=""; 
	
		
		int  Opcion;
	       String Menu= "Menú:\n" +
	                    "1.	Forma 1.\n" +
	                    "2.	Forma 2.\n" +
	                    "3.	Forma 3.\n" +
	                    "0. Salir.\n";
	       do 
	       {   
	       pol=(JOptionPane.showInputDialog("Ingrese el polinomio."));       
	       }
	       while (pol=="");
	       String Vs[]=Entrada(pol);
	       do 
	       {
	           Opcion=Integer.parseInt(JOptionPane.showInputDialog(Menu));
	           if(Opcion>3 && Opcion<0)
	           {
	        	   do {
	        	   Opcion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion correspondiente al menu."));
	        	   }
	        	   while(Opcion>3 && Opcion<0);
	           }
	           switch (Opcion)
	           {
	               case 1: PolinomiosF1 pol1 = new PolinomiosF1(Vs);
	                    pol1.menu();
	                    break;
	               case 2:PolinomioF2 pol2 = new PolinomioF2(Vs);
	                    pol2.menu();
	                    break;
	               case 3:PolinomioF3 pol3 = new PolinomioF3(Vs);
	                    pol3.menu();
	                    break;
	                    
	               case 0:System.exit(0);
	                    break;
	           }
	       }
	       while(Opcion!=0);
	}
	
	
	public static String[] Entrada(String Spol)
	{	int j=0, k;
		String S=""; 
		char Vc[]= Spol.toCharArray();
		int tam=Vc.length;
		if(tam<2)
		{
			tam=Vc.length+1;
		}
		String Vs[]= new String[tam];
		
		for (int i = 0; i < tam ; i++) 
		{
			if(i<Vc.length)
			{
			if(Character.isDigit(Vc[i])|| Vc[i]== '-')
			{
				
				
				S=S+Vc[i];
				if(Vc[i]=='-'&& Vc[i+1]=='x')
				{
					
					S=S+'1';
					
				}
				if(i+1== Vc.length || Vc[i+1]=='+'|| Vc[i+1]=='-')
				{
				/*	if(i+1== Vc.length || Vc[i-1]!='^'|| Vc[i-1]!='')
					{
						Vs[j]="0";
						j++;
					}*/
					
					
					Vs[j]=S;
					S="";
					j++;
					Vs[j]="0";
					j++		;
				}
				
			}
			else
			{
				if(Vc[i]== 'x')
				{
					
					if(i>1 && !Character.isDigit(Vc[i-1]) && Vc[i-1]!= '-')
					{
						S=S+'1';
						
					}
					else
					{	
						if(i==0)
						S=S+'1';
						
					}

					
					Vs[j]= S;
					S="";
					j++;

				 
					
						
					
					if( i+1==Vc.length || Vc[i+1] != '^' )
					{
						Vs[j]="1";
						j++;
						;
					}
					
						
				}
					
			}
			
			if(Vc[i]== '^')
			{
				k=i+1;
				while(k<Vc.length && Character.isDigit(Vc[k]))
				{
					
						S=S+Character.toString(Vc[k]);
						i++;
						k++;
					
					
				}
				Vs[j]=S;
				S="";
				
				j++;
			}
			}
			
			
			
		}
	
		return Vs;
	}
	}


