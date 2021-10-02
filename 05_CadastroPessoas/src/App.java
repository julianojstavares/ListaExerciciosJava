public class App {
    public static void main(String[] args) throws Exception {
        Pessoa joaozinho = new Pessoa();
        Pessoa jonaszinho = new Pessoa();

        joaozinho.setNome("Joaozinho");
        joaozinho.setEndereco("Rua A");
        joaozinho.setIdade("5");

        jonaszinho.setNome("Jonaszinho");
        jonaszinho.setEndereco("Rua B");
        jonaszinho.setIdade("5");

        CRUDPessoas crud = new CRUDPessoas();

        crud.AdicionarPessoa(joaozinho);
        crud.AdicionarPessoa(jonaszinho);

        System.out.println(crud.GerarRelatorio()); 

        crud.RemoverPessoa(joaozinho);

        System.out.println(crud.GerarRelatorio()); 

        jonaszinho.setNome("Jonas");
        crud.AtualizarPessoa(jonaszinho);

        System.out.println(crud.GerarRelatorio()); 
    }
}
