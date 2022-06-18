package testes;

import java.util.regex.*; 
import java.io.*;       

public class ExpressaoRegular1{ 
  public static void main(String args[]){ 
    Console console = System.console(); 

    // Obtém a expressão regular 
    String regex = console.readLine("%nInforme a expressão: "); 
    Pattern pattern = Pattern.compile(regex); 

    // Obtém a entrada 
    String source = console.readLine("Informe a entrada: "); 
    Matcher matcher = pattern.matcher(source); 

    // Mostra as similaridades 
    while(matcher.find()){ 
      System.out.printf("Encontrado: \"%s\" de %d à %d.%n", 
      matcher.group(), matcher.start(), matcher.end()); 
    } 
  } 
} 