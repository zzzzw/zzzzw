package lab;  
import java.math.BigDecimal;  
public class sanjiao 
{      
	 private double bianone;  
     private double biantwo;  
     private double bianthree;   
     private String []Strtype={"锐角三角形","直角三角形","钝角三角形","不是三角形哦"};
     private int type;    
     private double area;  
     public sanjiao()
     {}     
     private void paixu()
     {       
    	 double temp=0;   
    	 if(bianthree<biantwo)
    	 {       
    		 temp=bianthree; 
    		 bianthree=biantwo; 
    		 biantwo=temp;    
    	 }    
    	 if(bianthree<bianone)
    	 {       
    		 temp=bianthree;  
    		 bianthree=bianone;  
    		 bianone=temp;    
    	 }    
     }    
     private void puantype()
     {  
    	 this.paixu(); 
    	 if(getArea()==0)
    	 {      
    		 this.type=3;   
    	 }   
    	 else   
    	 {   
    		 double pingfa1=bianthree*bianthree;
    		 double pingfa2=bianone*bianone+biantwo*biantwo;  
    		 if(pingfa1==pingfa2)       
    			 this.type=1;      
    		 else if(pingfa1<pingfa2)     
    			 this.type=0;     
    		 else      
    			 this.type=2;     
    		 }     
    	 }     
     public sanjiao(double one,double two,double three)
     {      
    	 this.bianone=one;    
    	 this.biantwo=two;    
    	 this.bianthree=three;    
    }     
     public void setbian(double one,double two,double three)
     {      
    	 this.bianone=one;   
    	 this.biantwo=two;    
    	 this.bianthree=three;    
     }       
    public String getType()
    {       
    	this.puantype();   
    	return Strtype[type]; 
    }      
    public double getArea()
    {      
    	double s=(this.bianone+ this.biantwo+ this.bianthree)/2; 
    	double area2=s*(s- this.bianone)*(s- this.biantwo)*(s- this.bianthree);  
    	if(area2>0)
    	{area=Math.sqrt(area2);}
    	else
    	{area=0;}       
    	BigDecimal bd = new BigDecimal(area);  
    	bd = bd.setScale(2,BigDecimal.ROUND_HALF_EVEN);  
    	return bd.doubleValue();   
      }    
    public boolean istriangle()
    {       
    	boolean is=true;    
    	if(getArea()==0)
    	{is=false;}    
    	return is;    
     } 
  }