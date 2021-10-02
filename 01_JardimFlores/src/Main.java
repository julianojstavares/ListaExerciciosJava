public class Main {
    public static void main(String[] args) throws Exception {
        Print print = new Print();

        //Petalas
        Petala petala_c = new Petala();
        petala_c.setCor("ciano");

        Petala petala_m = new Petala();
        petala_m.setCor("magenta");

        Petala petala_y = new Petala();
        petala_y.setCor("amarelo");

        Petala petala_k = new Petala();
        petala_k.setCor("preto");

        Petala petala_r = new Petala();
        petala_r.setCor("vermelho");

        Petala petala_g = new Petala();
        petala_g.setCor("verde");

        Petala petala_b = new Petala();
        petala_b.setCor("azul");

        Petala petala_a = new Petala();
        petala_a.setCor("branco");


        //Flores
        Flor tulipa = new Flor();
        tulipa.SetPetala(petala_b);

        Flor margarida = new Flor();
        margarida.SetPetala(petala_a);
        
        Flor cravo = new Flor();
        cravo.SetPetala(petala_r);

        Flor crisantemo = new Flor();
        crisantemo.SetPetala(petala_y);


        //Jardins
        Jardim jardim_norte = new Jardim();
        jardim_norte.setFlor1(tulipa);
        jardim_norte.setFlor2(margarida);

        Jardim jardim_sul = new Jardim();
        jardim_sul.setFlor1(cravo);
        jardim_sul.setFlor2(crisantemo);


        //Pracinha
        Pracinha praca_matriz = new Pracinha();
        praca_matriz.setJardim1(jardim_norte);
        praca_matriz.setJardim2(jardim_sul);


        //prints
        print.Message(petala_c);
        print.Message(cravo);
        print.Message(jardim_sul);
        print.Message(praca_matriz);
    }
}
