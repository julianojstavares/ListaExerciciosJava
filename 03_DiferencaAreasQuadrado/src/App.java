public class App {
    public static void main(String[] args) throws Exception {
        Retangulo r1 = new Retangulo(0, 0, 10, 5);
        Retangulo r2 = new Retangulo(1, 0, 9, 5);

        if(r1.interceptaRetangulo(r2))
        {
            System.out.println("O retângulo 1 está interceptando o retângulo 2");
        }
        else
        {
            System.out.println("Nada aconteceu");
        }

        if(r1.diferencaRetangulos(r2) != -1)
        {
            System.out.println("A diferença é " + r1.diferencaRetangulos(r2));
        }

    }
}
