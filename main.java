
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;


public class main{



  public static void main(String[] args){
    double r = 10000;
    try {r = getRate("GBP", "USD");}
    catch (IOException e) {System.out.println("failed");}

    System.out.println(r);
  }




  public static double getRate(String a, String b) throws IOException{
    String URL_TEMPLATE =
      "http://download.finance.yahoo.com/d/quotes.csv?s=%s%s=X&f=l1";
    URL url = new URL(String.format(URL_TEMPLATE, a, b));
    URLConnection connect = url.openConnection();
    InputStream in = connect.getInputStream();
    Scanner input = new Scanner(in);
    double rate = input.nextDouble();

    return rate;
  }


}
