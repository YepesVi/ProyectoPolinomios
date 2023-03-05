package Polinomios;

import javax.swing.JOptionPane;

public class PolinomiosF1 
{

	private int VF1[],Du;

	
	
		public PolinomiosF1()
		{
			Du=0;
			VF1= new int[20];
		}
		public PolinomiosF1(int Exp)
		{
			Du=Exp+1;
			VF1=new int[Du+1];
			VF1[0]=Exp;
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
			return VF1;
		}
		
		public void SetVect(int Vaux[])
		{
			VF1=Vaux;
		}
		
		public int GetD(int Pos)
		{
			return VF1[Pos];
		}
		
		public void SetD(int Pos, int Dat)
		{
			VF1[Pos]= Dat;
		}

		public PolinomiosF1(String Vs[])
		{
			int Grado=0;
			for(int i=1; i<Vs.length; i=i+2)
			{
				if(Vs[i] != null)
				{
					if(Integer.parseInt(Vs[i])>Grado)
					{
						Grado=Integer.parseInt(Vs[i]);
					}
				}
			}
			Du=Grado+1;
			VF1= new int[Grado+2];
			VF1[0]=Grado;
			for(int j=1; Vs[j]!= null ;j=j+2)
			{
				VF1[Du- Integer.parseInt(Vs[j]) ]= Integer.parseInt(Vs[j-1]);
			}
			/*for (int k=0;k<VF1.length;k++) 
			{
			
				System.out.print("["+VF1[k]+"]");
				
			}*/
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
		
		
		public PolinomiosF1 multiplicar(PolinomiosF1 pol)
		{
			PolinomiosF1 res=new PolinomiosF1(this.GetD(0)+pol.GetD(0));
			for(int i=1;i<=this.GetDu();i++)
			{
				for(int j=1;j<=pol.GetDu();j++)
				{
					
					res.SetD(res.GetDu()-((this.GetDu()-i)+(pol.GetDu()-j)), res.GetD(res.GetDu()-((this.GetDu()-i)+(pol.GetDu()-j)))+this.GetD(i)* pol.GetD(j));
				}
			}
			return res;
		}
		
		
		public void valorx(int x)
		{
			int res=0;
			for(int i=1;i<=this.GetDu();i++)
			{
				res= res+ (this.GetD(i) *( (int)Math.pow(x, this.Du-i) ) );
			}
			JOptionPane.showMessageDialog(null, res);
			
			
		}
		
		
		public PolinomiosF1 suma(PolinomiosF1 pol)
		{
			PolinomiosF1 res= new PolinomiosF1();
			int dif=0;
			if(this.GetDu()<pol.GetDu()) 
			{
				dif=pol.GetDu()-this.GetDu();
				res.SetVect(pol.GetVect());
				res.SetDu(pol.GetDu());
				for(int j=1;j<=pol.GetDu();j++)
				{
					if(j>dif)
					{
						res.SetD(j, (pol.GetD(j)+this.GetD(j-dif)));
					}
					
					
				}
			}
			else 
			{
				dif=this.GetDu()-pol.GetDu();
				res.SetVect(this.GetVect());
				res.SetDu(this.GetDu());
				for(int j=1;j<=this.GetDu();j++)
				{
					if(j>dif )
					{
						res.SetD(j, (this.GetD(j)+pol.GetD(j-dif)));
					}
				}
			}
	
			
			return res;
		}
		
		
		public void insertarMononmio(String monom[])
		{
			if(this.GetDu()==0)
			{
				PolinomiosF1 pol= new PolinomiosF1(monom);
				this.SetVect(pol.GetVect());
				this.SetDu(pol.GetDu());
			}
			else
			{	
				if(Integer.parseInt(monom[1])> this.GetD(0))
				{
					this.redimensionar(Integer.parseInt(monom[1]));
					
				}
				this.SetD(this.GetDu()-Integer.parseInt(monom[1]), this.GetD(this.GetDu()-Integer.parseInt(monom[1]))+ Integer.parseInt(monom[0]));
			}
		}
		
		public void eliminar(int exp)
		{
				
				this.SetD(this.GetDu()-exp, 0);
				if(exp==this.GetD(0))
				{
					this.Ajustar();
				}
			
		}
		
 
		
		public void Ajustar()
		{
			int i=1, Cont=0, j=1;
			while(this.GetD(i)==0 && i<=this.GetDu())
			{
				Cont++;
				i++;
			}
			while(j<=(this.GetDu())-Cont)
			{
				this.SetD(j, this.GetD(j+Cont));
				j++;
				
				
				
			}
			this.redimensionar(this.GetDu()-Cont-1);
			
			
		}
		
		
		public void redimensionar(int grad)
		{	
			PolinomiosF1 aux = new PolinomiosF1(grad);
			if(grad>this.GetD(0))
			{
				
				for(int i=1;i<=this.GetDu();i++)
				{
					aux.SetD(i+(grad-this.GetD(0)), this.GetD(i));
				}
				this.SetVect(aux.GetVect());
				this.SetDu(aux.GetDu());
			}
			else
			{
				
				for(int i=1;i<=(this.GetDu()-(this.GetD(0)-grad));i++)
				{
					aux.SetD(i, this.GetD(i));
				}
				this.SetVect(aux.GetVect());
				this.SetDu(aux.GetDu());
			}
			
			
			
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
		                    "8. Sumar con forma 3 = forma 2.\n"+
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
		    		       	this.insertarMononmio(Vs);
		                    break;
		               case 2: Dato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente del termino que desea eliminar."));
		            	   	if(Dato>this.GetD(0) || Dato<0)
		            	   	{
		            	   		JOptionPane.showMessageDialog(null, "No se puede eliminar debido a que el exponente no esta en el polinomio.");
		            	   	}
		            	   	else
		            	   	{
		            	   		if(this.Du>0)
				            	{
		            	   			this.eliminar(Dato);	
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
				    		       	PolinomiosF1 pol2 = new PolinomiosF1(Vs), res=new PolinomiosF1();
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
				    		       	PolinomiosF1 pol2 = new PolinomiosF1(Vs), res=new PolinomiosF1();
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
				    		       	PolinomioF2 res=new PolinomioF2();
				    		       	res=res.sumaF1F3(this, pol2);
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
		
		
		
		
		public PolinomiosF1 multiplicarF2F3(PolinomioF2 forma2, PolinomioF3 forma3)
		{
			Nodo p=forma3.getPunta();
			PolinomiosF1 res=new PolinomiosF1(forma2.GetD(2)+p.GetExp());
			for(int i=2;i<=forma2.GetDu();i=i+2)
			{
				p=forma3.getPunta();
				while(p!=null)
				{
					res.SetD(res.GetDu()-(forma2.GetD(i)+p.GetExp()), res.GetD(res.GetDu()-(forma2.GetD(i)+p.GetExp()))+(forma2.GetD(i-1)* p.GetCoe()) );
					p=p.getLiga();
				}	
			}
			
			
			
			return res;
		}
		
		
		
		public String reconstruir()
		{
			String s="";
			for(int i=1; i<=this.GetDu();i++)
			{
				if(this.GetD(i)>0)
				{
					s=s+ "+";
				}
				if(this.GetD(i)!=0)
				{
				s= s + Integer.toString(this.GetD(i));
				if(this.GetDu()-i>0)
				{
					s=s+"x";
				}
				
				if(this.GetDu()-i > 1)
				{
					s=s+"^" +Integer.toString(this.GetDu()-i);
				}
				}
				
			}
			
			
			
			return s;
		}






}
