public class Print {
    public void Message(String message)
    {
        System.out.println(message);
        System.out.println();
    }

    public void Message(Petala petala)
    {
        System.out.println("Pétala em cor e tom " + petala.getCor());
        System.out.println();
    }

    public void Message(Flor flor)
    {
        Petala petala = flor.GetPetala();
        System.out.println("Flor com pétalas pintadas de " + petala.getCor());
        System.out.println();
    }

    public void Message(Jardim jardim)
    {
        String cor1 = jardim.getFlor1().GetPetala().getCor();
        String cor2 = jardim.getFlor2().GetPetala().getCor();

        System.out.println("Jardim com flores pintadas de " + cor1 + " e " + cor2);
        System.out.println();
    }

    public void Message(Pracinha pracinha)
    {
        String cor1 = pracinha.jardim1.getFlor1().GetPetala().getCor();
        String cor2 = pracinha.jardim1.getFlor2().GetPetala().getCor();
        String cor3 = pracinha.jardim2.getFlor1().GetPetala().getCor();
        String cor4 = pracinha.jardim2.getFlor2().GetPetala().getCor();

        System.out.println("Pracinha com dois jardins:");
        System.out.println("Um ao norte com flores em " + cor1 + " e " + cor2 + ",");
        System.out.println("outro ao sul com flores no tom " + cor3 + " e " + cor4);
        System.out.println();
    }
}
