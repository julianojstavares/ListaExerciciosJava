public class Flor {
    Petala petala;
    String nome;

    public void SetPetala(Petala petala)
    {
        this.petala = petala;
    }

    public boolean TemPetala(Petala petala)
    {
        if (petala == null) {
            return false;
        }
        return true;
    }

    public Petala GetPetala()
    {
        return this.petala;
    }

}
