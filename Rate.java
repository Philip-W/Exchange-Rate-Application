
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;


public class Rate {
//Class that gets the exchange rate and returns it via getRate();

  private String a, b;
  private final String URL_TEMPLATE =
    "http://download.finance.yahoo.com/d/quotes.csv?s=%s%s=X&f=l1";
  private String Rate = "";

  public Rate(String a, String b){
    try{
    Rate = calcrate(a, b);}
    catch (IOException e){
      System.out.println("Error with connection");
    }

  }

  public String getRate(){
    return Rate;
  }


  public String calcrate(String a, String b)throws IOException{
    URL url = new URL(String.format(URL_TEMPLATE, a, b));
    URLConnection connect = url.openConnection();
    InputStream in = connect.getInputStream();
    Scanner input = new Scanner(in);
    double rate = input.nextDouble();
    String r = "" + rate;
    return r;
  }
}
