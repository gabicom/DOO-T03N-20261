import java.util.Scanner;

public class Planta {

    static Scanner scan = new Scanner(System.in);

    int quant;
    double valor;

    public Planta() {
    }

    public int leituraQuant() {

        System.out.println("\nInforme a quantidade da planta:");
        quant = scan.nextInt();
        scan.nextLine();
        return quant;
    }

    public double leituraValor() {

        System.out.println("Informe o valor da planta:");
        valor = scan.nextDouble();
        scan.nextLine();
        return valor;
    }

    public double calcularPrecoTotal() {
        
        double total = quant * valor;

            if (quant > 10) {
                double desconto = total * 0.05;
                total = total - desconto;
                System.out.println("Desconto de 5% aplicado!");
            }
    
        return total;
    }
}
