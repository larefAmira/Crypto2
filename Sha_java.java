/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha_java;

import java.security.MessageDigest;

/**
 *
 * @author siemens
 */
public class Sha_java {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[]  args)
            throws Exception
    {
       
     String y = "00005d10cc11e27bd8d4d1ce91bc725665ddbaa6ca2498ef38a88a58ad48cdb4";
     String id = "laref amira";
     String h;
     int  x = 1;
     int i ;
     int n = 1;
     
     //System.out.println("Nom et Prenom : " + id);
      
     for(i=0 ; i<n ; i++)
     {
      // convert x to string methode 2:
       String newx =Integer.toString(x);
     //concatiner id||x
      h = id.concat(newx);
     
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(h.getBytes());
        byte byteData[] = md.digest();

        //convertir le tableau de bits en une format hexa

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < byteData.length; j++)
        {
         sb.append(Integer.toString((byteData[j] & 0xff) + 0x100, 16).substring(1));
        }
        
        //comparaison entre le sb(nom||x) et Y
         int compareTo = y.compareTo(sb.toString());
       
         if (compareTo < 0)  // ==> h > y
         {   
              //  incrementer X
             x++; 
             n++;
         
         }   
           if  (compareTo >= 0){ // ==> h <= y
        
         //System.out.println(" X: " +x);
         System.out.println(" X: " +newx);
         System.out.println(" Nombre Iteration" +i); 
         System.out.println(" Hachage: " + sb.toString()); 
       break;
         }        }  
}  } 
     

     

