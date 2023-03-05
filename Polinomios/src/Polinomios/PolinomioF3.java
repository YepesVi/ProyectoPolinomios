package Polinomios;

import javax.swing.JOptionPane;

public class PolinomioF3 
{
		private Nodo Punta;
		
		
		public	PolinomioF3()
		{
			Punta=null;
		}
		
		public Nodo getPunta()
		{
			return Punta;
		}
		
		public PolinomioF3(String Vs[]) 
		{
			for(int i=0; i<Vs.length;i=i+2)
			{
				if(i+1<Vs.length&& Vs[i+1]!=null)
				{
					InsertarOrdenado(Integer.parseInt(Vs[i]),Integer.parseInt(Vs[i+1]));
					
				}
			}
		}
		

		
		public void mostrar()
		   {
		       Nodo p=Punta;
		       String salida="";
		       if(Punta==null)
		       {
		    	   System.out.print("Lista Vacia.");
		       }
		       else
		       {
		           while(p!=null)
		           {
		               salida=salida+"["+p.GetCoe()+"]"+"["+p.GetExp()+"]";
		                p=p.getLiga();
		           }
		           JOptionPane.showMessageDialog(null, salida);
		       }    
		   }    
		
		public void InsertarFinal(int Coe, int Exp)
		{
			Nodo x=new Nodo(Coe,Exp), p=Punta;
			if(Punta==null)
			{
				Punta=x;
			}
			while(p.getLiga()!=null)
			{
				p=p.getLiga();
			}
			p.setLiga(x);
		}
		
		public void eliminar(int exp)
		{
			Nodo p=Punta, q=p;
			if(exp==Punta.GetExp())
			{
				Punta=Punta.getLiga();
			}
			else
			{
				while(p!=null)
				{
					
					if(p!=Punta && p.GetExp()==exp)
					{
						q.setLiga(p.getLiga());
					}
					q=p;
					p=p.getLiga();
				}
			}
		}
		
		public void InsertarOrdenado(int Coe, int Exp)
		{	
			Nodo p=Punta, q=p;
			Nodo x=new Nodo(Coe,Exp);
			if(Punta==null)
			{
				Punta=x;
						
			}
			else
			{
				while(p!= null)
				{
					
					if(Punta.GetExp()<x.GetExp())
					{
						x.setLiga(Punta);
						Punta=x;
					
					}
					else
					{
						
						if(x.GetExp()<p.GetExp() && p.getLiga()== null)
						{
							p.setLiga(x);
						}
						else
						{
							if(p.GetExp()==x.GetExp())	
							{	
								if(p.GetCoe()!=x.GetCoe())
								{
									x.SetCoe(p.GetCoe()+x.GetCoe());
								}
								
								p.SetCoe(x.GetCoe());
								
								if(p.GetCoe()==0)
								{
									if(p==Punta)
									{
										Punta=p.getLiga();
									}
									else
									{
										q.setLiga(p.getLiga());
									}
								}
							}
							else
							{
								if(p.GetExp()<x.GetExp() && x.GetExp()<q.GetExp())
								{
									x.setLiga(p);
									q.setLiga(x);
								
								}
							}
								
							}
						}
					q=p;
					p=p.getLiga();
					}
					
				}
			}
		
		public void InsertarOrdenado(int Coe, int Exp, boolean c)
		{	
			Nodo p=Punta, q=p;
			Nodo x=new Nodo(Coe,Exp);
			if(Punta==null)
			{
				Punta=x;
						
			}
			else
			{
				while(p!= null)
				{
					
					if(Punta.GetExp()<x.GetExp())
					{
						x.setLiga(Punta);
						Punta=x;
					
					}
					else
					{
						
						if(x.GetExp()<p.GetExp() && p.getLiga()== null)
						{
							p.setLiga(x);
						}
						else
						{
							if(p.GetExp()==x.GetExp())
							{
								p.SetCoe(x.GetCoe()+p.GetCoe());
								if(p.GetCoe()==0)
								{
									if(p==Punta)
									{
										Punta=p.getLiga();
									}
									else
									{
										q.setLiga(p.getLiga());
									}
								}
							}
							else
							{
								if(p.GetExp()<x.GetExp() && x.GetExp()<q.GetExp())
								{
									x.setLiga(p);
									q.setLiga(x);
								
								}
							}
								
							}
						}
					q=p;
					p=p.getLiga();
					}
					
				}
			}

		public PolinomioF3 suma(PolinomioF3 pol)
		{
			boolean c=false;
			Nodo p=Punta,a=p, q=pol.Punta;
			PolinomioF3 res= new PolinomioF3();
			
			while(p!=null)
			{	
				q=pol.Punta;
				c=false;
				while (q!=null&& p.GetExp()!=q.GetExp() )
				{
					
					if(p==Punta &&   q.GetExp()>  p.GetExp())
					{
						res.InsertarOrdenado(q.GetCoe(), q.GetExp());
						c=true;
					}
					else 
					{
						if(a.GetExp()>q.GetExp()&& q.GetExp()>p.GetExp())
						{
							res.InsertarOrdenado(q.GetCoe(), q.GetExp());
							c=true;
						}
						else
						{
							if(p.getLiga()==null && q.GetExp()<p.GetExp())
							{
								res.InsertarOrdenado(q.GetCoe(), q.GetExp());
								c=true;
							}
						}
						
					}
				
					
					q=q.getLiga();
				}
				if(q != null && p.GetExp()==q.GetExp())
				{
					res.InsertarOrdenado(q.GetCoe()+p.GetCoe(), q.GetExp());
					q=q.getLiga();
					if(q!=null && p.getLiga()==null && q.GetExp()<p.GetExp() )
					{
						res.InsertarOrdenado(q.GetCoe(), q.GetExp());
					}
					
				}
				else
				{
					if(q == null && c==false)
					{
						res.InsertarOrdenado(p.GetCoe(), p.GetExp());
					}
					else
					{
						if(q==null && p.getLiga()==null)
						{
							res.InsertarOrdenado(p.GetCoe(), p.GetExp());
						}
					}
				}
				a=p;
				p=p.getLiga();
			}
			
			
			
			
			
			return res;
					
		}

		public PolinomioF3 multiplicar(PolinomioF3 pol)
		{
			PolinomioF3 res =new PolinomioF3();
			Nodo p=Punta, q=pol.Punta;
			
			while(p!=null)
			{
				q=pol.Punta;
				while(q!=null)
				{
					res.InsertarOrdenado(q.GetCoe()*p.GetCoe(), p.GetExp()+q.GetExp());
					
					
					q=q.getLiga();		
				}
				
				
				
				p=p.getLiga();
			}
			
			
			
			return res;
		}

		public void valorx(int x)
		{
			int res=0;
			Nodo p=Punta;
			while(p!=null)
			{
				res= res+ (p.GetCoe()) *( (int)Math.pow(x, p.GetExp()));
				p=p.getLiga();
			}
			JOptionPane.showMessageDialog(null, res);
			
		}

		public String reconstruir()
		{
			String s="";
			Nodo p=Punta;
			if(Punta==null)
			{
				s="\nNo hay polinomonio por reconstruir.";
			}
			else
			{
				while(p!=null)
				{
					if(p.GetCoe()>=0)
					{
						s=s+"+";
					}
					s=s+ Integer.toString(p.GetCoe());
					if(p.GetExp()>0)
					{
						s=s+"x";
					}
					if(p.GetExp()>1)
					{
						s=s+"^"+ Integer.toString(p.GetExp());
					}
					p=p.getLiga();
				}
			}
			
			return s;
			
		}

		public void menu()
		{
			String pol=""; 
			int vaux[]= new int[2];
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
		                    "0. Salir al menu anterior.\n";
		       
		      
		       
		       
		       do 
		       {
		    	   pol="";
		           Opcion=Integer.parseInt(JOptionPane.showInputDialog(Menu));
		           if(Opcion>7 && Opcion<0)
		           {
		        	   do {
		        	   Opcion=Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion correspondiente al menu."));
		        	   }
		        	   while(Opcion>7 && Opcion<0);
		           }
		           switch (Opcion)
		           {
		               case 1: do 
				       		{   
		    		       		pol=(JOptionPane.showInputDialog("Ingrese el termino."));       
				       		}
		    		       	while (pol=="");
		    		       	Vs=polinomios.Entrada(pol);
		    		       	vaux[0]=Integer.parseInt(Vs[0]);
		    		       	vaux[1]=Integer.parseInt(Vs[1]);
		    		       	
		    		       	this.InsertarOrdenado(vaux[0], vaux[1]);
		                    break;
		               case 2: Dato=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente del termino que desea eliminar."));
		            	   	if(Dato<0)
		            	   	{
		            	   		JOptionPane.showMessageDialog(null, "No se puede eliminar debido a que el exponente no esta en el polinomio.");
		            	   	}
		            	   	else
		            	   	{
		            	   		if(Punta!=null)
				            	{
		            	   			this.eliminar(Dato);	
				            	}
		            	   		else
		            	   		{
		            	   			if(Punta==null)
		            	   			{
		            	   				JOptionPane.showMessageDialog(null, "No se puede eliminar debido a que el polinomio no existe.");
		            	   			}
		            	   		}
		            	   	}
		            	   		
		                    break;
		               case 3:
		            	   if(Punta!=null)
		            	   {
		            		   this.mostrar();
		            	   }
		            	   else
		            	   {
		            		   JOptionPane.showMessageDialog(null,"El polinomio no existe, puede insertar para volver a crearlo." );
		                    
		            	   }
		            	   break;
		               case 4: if(Punta!=null)
			            	   {
			            		   pol=this.reconstruir();
			            		   JOptionPane.showMessageDialog(null, pol);
			            	   }
			            	   else
			            	   {
			            		   JOptionPane.showMessageDialog(null,"El polinomio no existe, puede insertar para volver a crearlo." );
			                    
			            	   }
	                    	break;
		               case 5:if(Punta!=null)
			            	   {
		            	   			Dato=Integer.parseInt(JOptionPane.showInputDialog("ingrese el valor de x"));
		            	   			this.valorx(Dato);
		            	   			
			            	   }
			            	   else
			            	   {
			            		   JOptionPane.showMessageDialog(null,"El polinomio no existe, puede insertar para volver a crearlo." );
			                    
			            	   }
	                    	break;
		               case 6:if(Punta!=null)
			            	   {
		            	   			do 
						       		{   
				    		       		pol=(JOptionPane.showInputDialog("Ingrese el otro polinomio."));       
						       		}
				    		       	while (pol=="");
				    		       	Vs=polinomios.Entrada(pol);
				    		       	PolinomioF3 pol2 = new PolinomioF3(Vs), res=new PolinomioF3();
				    		       	res=this.suma(pol2);
				    		       	res.mostrar();
			            	   }
			            	   else
			            	   {
			            		   JOptionPane.showMessageDialog(null,"El polinomio no existe, puede insertar para volver a crearlo." );
			                    
			            	   }
		            	   
		            	   
	                    	break;
		               case 7: if(Punta!=null)
		            	   		{
		           	   				do 
						       		{   
				    		       		pol=(JOptionPane.showInputDialog("Ingrese el otro polinomio."));       
						       		}
				    		       	while (pol=="");
				    		       	Vs=polinomios.Entrada(pol);
				    		       	PolinomioF3 pol2 = new PolinomioF3(Vs), res=new PolinomioF3();
				    		       	res=this.multiplicar(pol2);
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

