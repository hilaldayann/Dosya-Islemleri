/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication99;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Hilal
 */
public class JavaApplication99 {

    /**
     * @param args the command line arguments
     */
    public static int dizi1Boyutu=0;
    public static int dizi2Boyutu = 0;
    public static int[] dizi1;
    public static int[] dizi2;
    public static int[] dizi3;
    int x;
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        dosyayiOku();
        siralamaYap();
        dizileriBirlestir();
        dosyayiYaz();
        aramaYap();
    }
    private static void dosyayiOku(){
        try
        {
            String okunan=null;
            File dosyaAdi=new File("diziler.txt");
            Scanner okuyucu=new Scanner(dosyaAdi);
            
            do
            {
                okunan = okuyucu.nextLine();
//              System.out.println(okunan);
                if (okunan.equalsIgnoreCase("dizi2")) 
                {
                    dizi1Boyutu--;
                    break;
                }
                dizi1Boyutu++; 
                
            }while(okuyucu.hasNextLine());
            
            do
            {
                okunan = okuyucu.nextLine();
//              System.out.println(okunan);
                dizi2Boyutu++; 
            }while(okuyucu.hasNextLine());
            
            dizi1 = new int[dizi1Boyutu];
            dizi2 = new int[dizi2Boyutu];    
            
            dizi3 = new int[dizi1Boyutu + dizi2Boyutu];
            
            System.out.println("Dosyanızda Bulunan 1. Dizinin Boyutu : " + dizi1Boyutu);
            okuyucu = new Scanner(dosyaAdi);
            okuyucu.nextLine();
            
            System.out.print("Dosyanızda Bulunan 1. Dizinin Elemanları :  ");
            for (int i = 0; i < dizi1.length; i++)
            {
                okunan = okuyucu.nextLine();
                int x = Integer.parseInt(okunan);
                dizi1[i] = x;
                System.out.print(dizi1[i] + "  ");
            }
            System.out.println(" ");
            
            System.out.println("Dosyanızda Bulunan 1. Dizinin Boyutu : " + dizi2Boyutu); 
            okuyucu.nextLine();
            System.out.print("Dosyanızda Bulunan 2. Dizinin Elemanları :  ");
            for (int k = 0; k < dizi2.length; k++)
                {
                    okunan = okuyucu.nextLine();
                    int x = Integer.parseInt(okunan);
                    dizi2[k] = x;
                    System.out.print(dizi2[k] + "  ");
                }
            System.out.println();
            
        }
        
        catch(Exception e)
        {
            System.out.println("Bir Hata İle Karşılaşıldı.");
        }
    }
    private static void siralamaYap(){
        try{
            for (int i = 0; i < dizi1.length-1; i++)
            {
                int sayi = dizi1[i];
                int degisken = i;
                for (int j = i+1; j < dizi1.length; j++)
                {
                    if (dizi1[j] < sayi)
                    {
                        sayi = dizi1[j];
                        degisken = j;
                    }
                }
                if (degisken != i)
                {
                    dizi1[degisken] = dizi1[i];
                    dizi1[i] = sayi;
                }       
            }
            
            System.out.print("Dosyanızda Bulunan 1. Dizinin Sıralanmış Hali : ");
            for (int k = 0; k < dizi1.length; k++)
            System.out.print(dizi1[k] + "  ");
            
            for (int i = 0 ;i < dizi2.length-1; i++)
            {
                int sayi = dizi2[i];
                int degisken = i;
                for (int j = i+1; j < dizi2.length; j++)
                {
                    if (dizi2[j] < sayi)
                    {
                        sayi = dizi2[j];
                        degisken = j;
                    }
                }
                if (degisken != i)
                {
                    dizi2[degisken] = dizi2[i];
                    dizi2[i] = sayi;
                }
            }
            
            System.out.println();
            System.out.print("Dosyanızda Bulunan 2. Dizinin Sıralanmış Hali : ");
            for (int k = 0; k < dizi2.length; k++)
            System.out.print(dizi2[k] + "  ");
            
        }
        catch(Exception e)
        {
            System.out.println("Bir Hata İle Karşılaşıldı.");
        }
    }
    private static void dizileriBirlestir(){
        System.out.println();
        System.out.print("Sıralanmış Olan Dizilerinizin Birleştirilmiş Hali : ");
        try
        {
            int i=0,j=0,k=0,h=0;
            while (k != dizi3.length)
                if (dizi1[i] < dizi2[j]) 
                {
                    dizi3[k] = dizi1[i];
                    i = i + 1;
                    k = k + 1;
                    if (i == dizi1.length)
                        for (h = j; h < dizi2.length; h = h + 1) 
                        {
                            dizi3[k] = dizi2[h];
                            k = k + 1;
                        }
                }
                else 
                {
                    dizi3[k] = dizi2[j];
                    k = k + 1;
                    j = j + 1;
                    if (j == dizi2.length)
                        for (h = i; h < dizi2.length; h = h + 1) 
                        {
                            dizi3[k] = dizi1[h];
                            k = k + 1;
                        }
                }
            for (h = 0; h < dizi3.length; h = h + 1)
                System.out.print(dizi3[h] + " ");
        }
        
        catch(Exception e)
        {
            System.out.println("Bir Hata İle Karşılaşıldı.");
        }
    }
     private static void dosyayiYaz(){
        try{
            BufferedWriter bufferedWriter = null;
            File file = new File("siralanmisDiziler.txt");
            if(!file.exists())
            {
                file.createNewFile();
            }
            
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter=new BufferedWriter(fileWriter);
            for (int i = 0; i < dizi3.length; i++)
            {
                String content=String.valueOf(dizi3[i]);
                bufferedWriter.write(content+"\n");
                bufferedWriter.flush();
            }
            bufferedWriter.close();
        }
        
        catch(Exception e)
        {
            System.out.println("Bir Hata İle Karşılaşıldı.");
        }
    }
    public static void aramaYap() throws FileNotFoundException{
        System.out.println("  ");
        System.out.print("Arama Yapmak İstediğiniz Sayıyı Giriniz : ");
        Scanner scan = new Scanner(System.in);
        String girilensayi;
        firstWhile: while(true){
            girilensayi = scan.nextLine();
            if(sayiMi(girilensayi) == true){
                secondWhile: while(true) {

                    File dosya = new File("siralanmisDiziler.txt");
                    Scanner okuyucu = new Scanner(dosya);
                    int satir = 1;
                    boolean kontrol = false;
                    thirdWhile:while(okuyucu.hasNext()) {
                        int a = Integer.parseInt(okuyucu.nextLine());
                        int y = Integer.parseInt(girilensayi);
                        if(y == a)
                        {
                            System.out.println("Aradığınız Sayı Dosyada " + satir + ". Satırda Bulunmaktadır.");
                            System.out.print("Devam Etmek İçin Tekrardan Bir Sayı Girişi Gerçekleştiriniz : ");
                            kontrol=true;
                            continue firstWhile;
                        }
                        satir++;
                    }
                    okuyucu.close();
                    if(!kontrol) {
                        System.out.println("Aradığınız değer bulunamadı.");
                        System.out.print("Lütfen Başka Bir Sayı Girişi Gerçekleştiriniz : ");
                    }
                    continue firstWhile;
                }
            }
            else{
                System.out.println("Sayı Değerleri Yerine Herhangi Bir Karakter Girdiğinizden Dolayı Program Sonlandırılmıştır.");
                return;
            }
        }
    }
    
    public static boolean sayiMi(String girilen){
        try{
            Integer.parseInt(girilen);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
