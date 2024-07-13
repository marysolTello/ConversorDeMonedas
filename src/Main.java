
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Converter conv = new Converter("",0,"","");
        boolean menuSelection = true;
        String menuText = "---------------------------------------------------------\n" +
                "Bienvenido al Conversor de Monedas \n" +
                "Elija una opción para realizar la conversión \n" +
                "\n"+
                "1) Dólar estadounidense ->  Peso argentino \n" +
                "2) Peso argentino       ->  Dólar estadounidense \n" +
                "3) Dólar estadounidense ->  Real brasileño \n" +
                "4) Real brasileño       ->  Dólar estadounidense \n" +
                "5) Dólar estadounidense ->  Peso colombiano \n" +
                "6) Peso colombiano      ->  Dólar estadounidense \n" +
                "7) Dólar estadounidense ->  Peso mexicano \n" +
                "8) Peso mexicano        ->  Dólar estadounidense \n" +
                "9) Salir \n" +
                "\n"+
                "Elija una opción válida:";
        String menuConverted =  "######################################################### \n" +
                "Elige la cantidad que deseas convertir:  ";
        Scanner opt = new Scanner(System.in);
        


        String url_api = "https://v6.exchangerate-api.com/v6/cc7d1940e5e0e4d85d20111c/pair/";
        while(menuSelection){
            System.out.println(menuText);
            try{
                int option = opt.nextInt();
                if (option == 9) {
                    menuSelection = false;
                    System.out.println("Gracias por usar el conversor de monedas.");
                    break;
                }
                Scanner qty = new Scanner(System.in);
                System.out.println(menuConverted);
                int qt = qty.nextInt();
                switch (option) {
                    case 1: {
                        // Dólar estadounidense -> Peso Argentino
                        conv.setCantidad(qt);
                        conv.setUrl_api(url_api);
                        conv.setPais1("USD");
                        conv.setPais2("ARS");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 2: {
                        // Peso Argentino -> Dólar estadounidense
                        conv.setCantidad(qt);
                        conv.setUrl_api(url_api);
                        conv.setPais1("ARS");
                        conv.setPais2("USD");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 3: {
                        // Dólar estadounidense -> Real brasileño
                        conv.setCantidad(qt);
                        conv.setUrl_api(url_api);
                        conv.setPais1("USD");
                        conv.setPais2("BRL");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 4: {
                        // Real brasileño -> Dólar estadounidense
                        conv.setCantidad(qt);
                        conv.setUrl_api(url_api);
                        conv.setPais1("BRL");
                        conv.setPais2("USD");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 5: {
                        // Dólar estadounidense -> Peso colombiano
                        conv.setCantidad(qt);
                        conv.setUrl_api(url_api);
                        conv.setPais1("USD");
                        conv.setPais2("COP");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 6: {
                        // Peso colombiano -> Dólar estadounidense
                        conv.setCantidad(qt);
                        conv.setUrl_api(url_api);
                        conv.setPais1("COP");
                        conv.setPais2("USD");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 7: {
                        // Dólar estadounidense -> Peso mexicano
                        conv.setCantidad(qt);
                        conv.setUrl_api(url_api);
                        conv.setPais1("USD");
                        conv.setPais2("MXN");
                        System.out.println(conv.conversion());
                        break;
                    }
                    case 8: {
                        // Peso mexicano -> Dólar estadounidense
                        conv.setCantidad(qt);
                        conv.setUrl_api(url_api);
                        conv.setPais1("MXN");
                        conv.setPais2("USD");
                        System.out.println(conv.conversion());
                        break;
                    }
                    default: {
                        System.out.println("Opción Inválida. Elija una opción entre 1 y 9.");
                        break;
                    }
                }
            }catch (InputMismatchException ex){
                System.out.println("Debe ingresar un número entero.");
                opt.next();
            }

        }
    }
}