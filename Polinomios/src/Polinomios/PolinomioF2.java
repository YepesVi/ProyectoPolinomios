package Polinomios;

import javax.swing.JOptionPane;

public class PolinomioF2 
{
	private int VF2[],Du;
	
	
	public PolinomioF2()
	{
		Du=0;
		VF2= new int[20];
	}
	public PolinomioF2(int Term)
	{
		
		Du=Term*2;
		VF2=new int[Du+1];
		VF2[0]= Term;
	}
	

	public int GetDu()
	{
		return(Du);
	}
	
	public void SetDu(int d)
	{
		Du=d;
	}
	
	public int[] GetVect()
	{
		return VF2;
	}
	
	public void SetVect(int Vaux[])
	{
		VF2=Vaux;
	}
	
	public int GetD(int Pos)
	{
		return VF2[Pos];
	}
	
	public void SetD(int Pos, int Dat)
	{
		VF2[Pos]= Dat;
	}

	public void mostrar()
	{
		String s="";
		for (int k=0;k<=this.GetDu();k++) 
		{
		
			
			s=s+"["+this.GetD(k)+"]";
		}
		JOptionPane.showMessageDialog(null, s);
	}

	public PolinomioF2(String Vs[])
{
	int j=0 , Va[]=new int[2];
	for(int i=0; i<Vs.length; i++)
	{
		if(Vs[i] != null)
		{
			j++;
		}
	}
	Du=j;
	VF2= new int[Du+1];
	VF2[0]=j/2;
	
	for(int k=0;  k<Vs.length&&Vs[k]!= null ;k++)
	{
		if(k<Vs.length)
		VF2[k+1]= Integer.parseInt(Vs[k]);
	}
	
	for(int p=2;p<VF2.length;p=p+2)
	{
		for(int q=p+2;q<VF2.length;q=q+2)
		{
			if(VF2[p]<VF2[q])
			{
				Va[0]=VF2[p-1];
				Va[1]=VF2[p];
				VF2[p-1]=VF2[q-1];
				VF2[p]=VF2[q];
				VF2[q-1]=Va[0];
				VF2[q]=Va[1];
			}
		}
	}
	
	
	
	}
	
	
	public void insertarMonomio(String monom[])
	{
		if(this.GetDu()==0)
		{
			this.SetD(0, 1);
			this.SetDu(2);
			this.SetD(1, Integer.parseInt(monom[0]));
			this.SetD(2, Integer.parseInt(monom[1]));
		}
		else
		{
		PolinomioF2 aux=new PolinomioF2(this.GetD(0)+1);
		int j=2;
		boolean x=false,z=false, y=false, help=false;
		if(this.GetDu()==0)
		{
			aux.SetD(1, Integer.parseInt(monom[0]));
			aux.SetD(2, Integer.parseInt(monom[1]));
		}
		else
		{
		for(int i=2;i<=this.GetDu();i++)
		{
			
			
			
			if((Integer.parseInt(monom[1])>this.GetD(2)) && i==2)
			{
				aux.SetD(1, Integer.parseInt(monom[0]));
				aux.SetD(2, Integer.parseInt(monom[1]));
				i=i+2;
				j=i;
				aux.SetD(i-1, this.GetD(1));
				aux.SetD(i, this.GetD(2));
				x=true;
				i=i+2;
			}
			else
			{
				if(this.GetD(j)>Integer.parseInt(monom[1]) && Integer.parseInt(monom[1])>this.GetD(i))
				{
					aux.SetD(j+2,Integer.parseInt(monom[1]));
					aux.SetD(j+1, Integer.parseInt(monom[0]));
					x=true;
					j=i;
					i=i+2;
					
				}
				else 
				{	if(this.GetD(i)== Integer.parseInt(monom[1]))
					{
						aux.SetD(i-1, (this.GetD(i-1)+ Integer.parseInt(monom[0])));
						aux.SetD(i, this.GetD(i));
						aux.SetDu(this.GetDu());
						help=true;
						aux.SetD(0, this.GetD(0));
						if(aux.GetD(i-1)==0)
						{
							aux.SetD(i, 0);
							y=true;
							aux.SetD(0, this.GetD(0)-1);
							aux.SetDu(this.GetDu()-2);
						}
						j=i;
						i=i+2;
					}
					else
					{
						if(i==this.Du && Integer.parseInt(monom[1])< this.GetD(i))
						{
							aux.SetD(i+2, Integer.parseInt(monom[1]));
							aux.SetD(i+1, Integer.parseInt(monom[0]));
							x=false;
							z=true;
						}
					}
				}
			}
			
			if(i<=aux.GetDu() && x==true)
			{
			aux.SetD(i-1, this.GetD(j-1));
			aux.SetD(i, this.GetD(j));
			j=i;
			i++;
			}
			else
			{	if(i<=aux.GetDu()&& (aux.GetD(0)>this.GetD(0)|| help==true))
				{
					aux.SetD(i-1, this.GetD(i-1));
					aux.SetD(i, this.GetD(i));
					j=i;
					i++;
				}
				else
				{
					if(y==true && i+2<=this.GetDu())
					{
						aux.SetD(i-1, this.GetD(i+1));
						aux.SetD(i, this.GetD(i+2));
						j=i;
						i++;
					}
				}
			
			}
			
			if(i+1>this.GetDu()&& i<=aux.GetDu() && z==false)
				
			{
				i++;
				aux.SetD(i-1, this.GetD(j-1));
				aux.SetD(i, this.GetD(j));
			}
		}
		}
		this.SetVect(aux.GetVect());
		this.SetDu(aux.GetDu());
		}
	}
	
	public void insertarMonomio(int monom[])
	{
		String mono[]= new String[2];
		mono[0]=Integer.toString(monom[0]);
		mono[1]=Integer.toString(monom[1]);
		this.insertarMonomio(mono);
	}
	
	public void eliminarMonomio(int grad)
	{
		for(int i=2;i<=this.GetDu();i=i+2)
		{
			if( this.GetD(i)==grad)
			{
				this.SetD(i-1, 0);
				this.SetD(i, 0);
				this.ajustar(i);
			}
		}
	}
	
	public void valorx(int x)
	{
		int res=0;
		for(int i=2;i<=this.GetDu();i=i+2)
		{
			res= res+ (this.GetD(i-1) *( (int)Math.pow(x, this.GetD(i)) ) );
		}
		
		JOptionPane.showMessageDialog(null, res);
	}
	
	public String reconstruir()
	{
		String s="";
		for(int i=1; i<=this.GetDu();i=i+2)
		{
			if(this.GetD(i)>0)
			{
				s=s+ "+";
			}
			s= s + Integer.toString(this.GetD(i));
			if(this.GetD(i+1)>0)
			{
				s=s+"x";
			}
			
			if(this.GetD(i+1) > 1)
			{
				s=s+"^" +Integer.toString(this.GetD(i+1));
			}
			
			
		}
		
		
		
		return s;
	}
	
		

	public void ajustar(int i)

	{
		int Cont=0, j=i;
		while(i<=this.GetDu()&& this.GetD(i)==0 )
		{
			Cont=Cont+2;
			this.SetD(0, this.GetD(0)-1);
			i++;
		}
		while(j<=(this.GetDu())-Cont)
		{
			this.SetD(j-1, this.GetD(j-1+Cont));
			this.SetD(j, this.GetD(j+Cont));
			j=j+2;
		}
		this.SetDu(this.GetDu()-Cont);
	
	}

	

	public PolinomioF2 multiplicar(PolinomioF2 pol)
	{	int vaux[]=new int[2];
		PolinomioF2 res = new PolinomioF2();
		for(int i=2;i<=this.GetDu();i=i+2)
		{
			for(int j=2;j<=pol.GetDu();j=j+2)
			{
				vaux[0]=this.GetD(i-1)*pol.GetD(j-1);
				vaux[1]=this.GetD(i)+pol.GetD(j);
				res.insertarMonomio(vaux);
			}
		}
		return res;
		
	}
	
	public PolinomioF2 Suma(PolinomioF2 pol)
	{	int i=2, vaux[]=new int[2];
		
		PolinomioF2 res= new PolinomioF2();
		if(this.GetDu()<pol.GetDu()) 
		{
			res.SetVect(pol.GetVect());
			res.SetDu(pol.GetDu());
			for(int j=2;j<=pol.GetDu();j=j+2)
			{
				i=2;
			
				while( i<=this.GetDu() && pol.GetD(j)!= this.GetD(i) )
				{
					
					
					if(j !=2 &&pol.GetD(j-2)>this.GetD(i)&& this.GetD(i)>pol.GetD(j))
					{
						vaux[0]=this.GetD(i-1);
						vaux[1]=this.GetD(i);
						res.insertarMonomio(vaux);
					}
					else
					{
						if(j==pol.GetDu() && pol.GetD(j)>this.GetD(i))
						{
							vaux[0]=this.GetD(i-1);
							vaux[1]=this.GetD(i);
							res.insertarMonomio(vaux);
						}
						else
						{
							if( i== 2 && j==2 && pol.GetD(j)<this.GetD(i) )
							{
								vaux[0]=this.GetD(i-1);
								vaux[1]=this.GetD(i);
								res.insertarMonomio(vaux);
							}
						}
					}
					i=i+2;
				}
				if(i<=this.GetDu() && pol.GetD(j)== this.GetD(i)) 
				{
					res.SetD(j-1, pol.GetD(j-1)+ this.GetD(i-1));
					res.SetD(j, pol.GetD(j));
					
					
				}
				
				
				
			}
		}	
		else 
		{
			res.SetVect(this.GetVect());
			res.SetDu(this.GetDu());
			for(int j=2;j<=this.GetDu();j=j+2)
			{
				i=2;
			
				while( i<=pol.GetDu() && this.GetD(j)!= pol.GetD(i) )
				{
					
					
					if(j !=2 &&this.GetD(j-2)>pol.GetD(i)&& pol.GetD(i)>this.GetD(j))
					{
						vaux[0]=pol.GetD(i-1);
						vaux[1]=pol.GetD(i);
						res.insertarMonomio(vaux);
					}
					else
					{
						if(j==this.GetDu() && this.GetD(j)>pol.GetD(i))
						{
							vaux[0]=pol.GetD(i-1);
							vaux[1]=pol.GetD(i);
							res.insertarMonomio(vaux);
						}
						else
						{
							if( i== 2 && j==2 && this.GetD(j)<pol.GetD(i) )
							{
								vaux[0]=pol.GetD(i-1);
								vaux[1]=pol.GetD(i);
								res.insertarMonomio(vaux);
							}
						}
					}
					i=i+2;
				}
				if(i<=pol.GetDu() && this.GetD(j)== pol.GetD(i)) 
				{
					res.SetD(j-1, this.GetD(j-1)+ pol.GetD(i-1));
					res.SetD(j, this.GetD(j));
					
					
				}
				
				
				
			}

		
		
		}
		return res;
	}
	
	
	
	
	public PolinomioF2 suma(PolinomioF2 pol)
	{
		PolinomioF2 res= new PolinomioF2();
		int i=2, vaux[]=new int[2];
		boolean x=false, y=false;
		if(this.GetDu()<pol.GetDu()) 
		{
			res.SetVect(pol.GetVect());
			res.SetDu(pol.GetDu());
			for(int j=2;j<=pol.GetDu();j=j+2)
			{
				i=2;
				
				while(i<=this.GetDu()&& pol.GetD(j)!=this.GetD(i))
				{
					if(j+2<=pol.GetDu() && pol.GetD(j)>this.GetD(i)&& this.GetD(i)>pol.GetD(j+2))
					{
						x=true;
						vaux[0]=this.GetD(i-1);
						vaux[1]=this.GetD(i);
						res.insertarMonomio(vaux);
						
					}
					else
					{
						if(j==2 && this.GetD(i)>pol.GetD(j) )
						{
							y=true;
							vaux[0]=this.GetD(i-1);
							vaux[1]=this.GetD(i);
							res.insertarMonomio(vaux);
						}
						else
						{
							if(j==pol.GetDu()&& pol.GetD(j)>this.GetD(i))
							{
								vaux[0]=this.GetD(i-1);
								vaux[1]=this.GetD(i);
								res.insertarMonomio(vaux);
							}
						}
					}
					i=i+2;
				}
				if(i<=this.GetDu() && pol.GetD(j)==this.GetD(i))
				{
					vaux[0]=this.GetD(i-1);
					vaux[1]=this.GetD(i);
					res.insertarMonomio(vaux);
				}
				else
				{
					if(i>this.GetDu()&& x==false && y==false)
					{	
						res.SetD(j-1,pol.GetD(j-1));
						res.SetD(j, pol.GetD(j));	
					}
		
		
				}
			}
				
		}
		else 
		{
			res.SetVect(this.GetVect());
			res.SetDu(this.GetDu());
			for(int j=2;j<=this.GetDu();j=j+2)
			{
				i=2;
				
				while(i<=pol.GetDu()&& this.GetD(j)!=pol.GetD(i))
				{
					if(j+2<=this.GetDu() && this.GetD(j)>pol.GetD(i)&& pol.GetD(i)>this.GetD(j+2))
					{
						x=true;
						vaux[0]=pol.GetD(i-1);
						vaux[1]=pol.GetD(i);
						res.insertarMonomio(vaux);
						
					}
					else
					{
						if(j==2 && pol.GetD(i)>this.GetD(j) )
						{
							y=true;
							vaux[0]=pol.GetD(i-1);
							vaux[1]=pol.GetD(i);
							res.insertarMonomio(vaux);
						}
						else
						{
							if(j==this.GetDu()&& this.GetD(j)>pol.GetD(i))
							{
								vaux[0]=pol.GetD(i-1);
								vaux[1]=pol.GetD(i);
								res.insertarMonomio(vaux);
							}
						}
					}
					i=i+2;
				}
				if(i<=pol.GetDu() && this.GetD(j)==pol.GetD(i))
				{
					vaux[0]=pol.GetD(i-1);
					vaux[1]=pol.GetD(i);
					res.insertarMonomio(vaux);
				}
				else
				{
					if(i>this.GetDu()&& x==false && y==false)
					{	
						res.SetD(j-1,pol.GetD(j-1));
						res.SetD(j, pol.GetD(j));	
					}
					
		
				}
			}
		}

		
		return res;
	}
	
	public PolinomioF2 sumaF1F3(PolinomiosF1 forma1, PolinomioF3 forma3 )
	{
		boolean x=false;
		int vaux[]=new int[2];
		Nodo p=forma3.getPunta();
		PolinomioF2 res= new PolinomioF2();
		for(int i=1;i<=forma1.GetDu();i++)
		{	x=false;
			p=forma3.getPunta();
			while(p!=null && (forma1.GetDu()-i)!=p.GetExp())
			{
				if(i==1 && (forma1.GetDu()-i)<p.GetExp())
				{
					vaux[0]=p.GetCoe();
					vaux[1]=p.GetExp();
					x=true;
					res.insertarMonomio(vaux);
				}
				else
				{
					if(i==forma1.GetDu() && (forma1.GetDu()-i)>p.GetExp())
					{
						x=true;
						vaux[0]=p.GetCoe();
						vaux[1]=p.GetExp();
						res.insertarMonomio(vaux);
					}
					else
					{
						if(i<forma1.GetDu() && (forma1.GetDu()-i)>p.GetExp() && p.GetExp()>(forma1.GetDu()-i+1))
						{
							x=true;
							vaux[0]=p.GetCoe();
							vaux[1]=p.GetExp();
							res.insertarMonomio(vaux);
						}

					}
				}
				p=p.getLiga();
			}
			if(p!=null &&(forma1.GetDu()-i)==p.GetExp())
			{
				vaux[0]=forma1.GetD(i)+p.GetCoe();
				vaux[1]=p.GetExp();
				res.insertarMonomio(vaux);
			}
			else
			{
				if(p==null && x==false && forma1.GetD(i)!=0)
				{
					vaux[0]=forma1.GetD(i);
					vaux[1]=(forma1.GetDu()-i);
					res.insertarMonomio(vaux);
				}
			}
			
			
		}
		
		
		
		return res;		
	}
	
	public void menu()
	{
		String pol=""; 
		
		String Vs[];
		int Dato, Opcion;
	       String Menu= "Menú:\n" +
	                    "1.	Insertar termino.\n" +
	                    "2.	Eliminar termino..\n" +
	                    "3.	Mostrar forma.\n" +
	                    "4. Reconstruir.\n"+
	                    "5. Evaluar polinomio con valor x.\n"+
	                    "6. Sumar.\n "+
	                    "7.	Multiplicar.\n "+
	                    "8. Multiplicar con forma 3 = forma 1.\n"+
	                    "0. Salir al menu anterior.\n";
	       
	      
	       
	       
	       do 
	       {
	    	   pol="";
	           Opcion=Integer.parseInt(JOptionPane.showInputDialog(Menu));
	           if(Opcion>8 && Opcion<0)
	           {
	        	   do {
	        	   Opcion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion correspondiente al menu."));
	        	   }
	        	   while(Opcion>8 && Opcion<0);
	           }
	           switch (Opcion)
	           {
	               case 1: do 
			       		{   
	    		       		pol=(JOptionPane.showInputDialog("Ingrese el termino."));       
			       		}
	    		       	while (pol=="");
	    		       	Vs=polinomios.Entrada(pol);
	    		       	this.insertarMonomio(Vs);
	                    break;
	               case 2: Dato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente del termino que desea eliminar."));
	            	   	if(Dato<0)
	            	   	{
	            	   		JOptionPane.showMessageDialog(null, "No se puede eliminar debido a que el exponente no esta en el polinomio.");
	            	   	}
	            	   	else
	            	   	{
	            	   		if(this.Du>0)
			            	{
	            	   			this.eliminarMonomio(Dato);	
			            	}
	            	   		else
	            	   		{
	            	   			if(this.Du==0)
	            	   			{
	            	   				JOptionPane.showMessageDialog(null, "No se puede eliminar debido a que el polinomio no existe.");
	            	   			}
	            	   		}
	            	   	}
	            	   		
	                    break;
	               case 3:
	            	   if(this.Du>0)
	            	   {
	            		   this.mostrar();
	            	   }
	            	   else
	            	   {
	            		   JOptionPane.showMessageDialog(null,"El polinomio no existe, puede insertar para volver a crearlo." );
	                    
	            	   }
	            	   break;
	               case 4: if(this.Du>0)
		            	   {
		            		   pol=this.reconstruir();
		            		   JOptionPane.showMessageDialog(null, pol);
		            	   }
		            	   else
		            	   {
		            		   JOptionPane.showMessageDialog(null,"El polinomio no existe, puede insertar para volver a crearlo." );
		                    
		            	   }
                    	break;
	               case 5:if(this.Du>0)
		            	   {
	            	   			Dato=Integer.parseInt(JOptionPane.showInputDialog("ingrese el valor de x"));
	            	   			this.valorx(Dato);
	            	   			
		            	   }
		            	   else
		            	   {
		            		   JOptionPane.showMessageDialog(null,"El polinomio no existe, puede insertar para volver a crearlo." );
		                    
		            	   }
                    	break;
	               case 6:if(this.Du>0)
		            	   {
	            	   			do 
					       		{   
			    		       		pol=(JOptionPane.showInputDialog("Ingrese el otro polinomio."));       
					       		}
			    		       	while (pol=="");
			    		       	Vs=polinomios.Entrada(pol);
			    		       	PolinomioF2 pol2 = new PolinomioF2(Vs), res=new PolinomioF2();
			    		       	res=this.suma(pol2);
			    		       	res.mostrar();
		            	   }
		            	   else
		            	   {
		            		   JOptionPane.showMessageDialog(null,"El polinomio no existe, puede insertar para volver a crearlo." );
		                    
		            	   }
	            	   
	            	   
                    	break;
	               case 7: if(this.Du>0)
	            	   		{
	           	   				do 
					       		{   
			    		       		pol=(JOptionPane.showInputDialog("Ingrese el otro polinomio."));       
					       		}
			    		       	while (pol=="");
			    		       	Vs=polinomios.Entrada(pol);
			    		       	PolinomioF2 pol2 = new PolinomioF2(Vs), res=new PolinomioF2();
			    		       	res=this.multiplicar(pol2);
			    		       	res.mostrar();
		            	   }
		            	   else
		            	   {
		            		   JOptionPane.showMessageDialog(null,"El polinomio no existe, puede insertar para volver a crearlo." );
		                    
		            	   }
                    	
                    	break;
	               case 8:if(this.Du>0)
		            	   {
	           	   			do 
					       		{   
			    		       		pol=(JOptionPane.showInputDialog("Ingrese el otro polinomio."));       
					       		}
			    		       	while (pol=="");
			    		       	Vs=polinomios.Entrada(pol);
			    		       	PolinomioF3 pol2 = new PolinomioF3(Vs);
			    		       	PolinomiosF1 res=new PolinomiosF1();
			    		       	res=res.multiplicarF2F3(this, pol2);
			    		       	res.mostrar();
		            	   }
		            	   else
		            	   {
		            		   JOptionPane.showMessageDialog(null,"El polinomio no existe, puede insertar para volver a crearlo." );
		                    
		            	   }
       	   
	                    break;
	               
	           }
	       }
	       while(Opcion!=0);
	}
	
	
	
	
	
}
	


	


