public class App {
    public static void main(String[] args) throws Exception {
        Quadrado quadrado = new Quadrado();
        quadrado.Draw();

        Circulo circulo = new Circulo();
        circulo.Draw();

        Triangulo triangulo = new Triangulo();
        triangulo.Draw();
        PassaParametroPorHeranca(quadrado);

    }

    public static void PassaParametroPorHeranca(Figura f) 
    {
        f.DrawShape();
    }
}
