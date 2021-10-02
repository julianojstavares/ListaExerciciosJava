public class Retangulo {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Retangulo(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * @return int return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return int return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return int return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return int return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }


    public boolean contemPonto(int x, int y)
    {
        if((x >= x1) && (x <= x2) && (y >= y1) && (y <= y2))
        {
            return true;
        }
        return false;
    }

    public boolean interceptaRetangulo(Retangulo retangulo)
    {
        int points = 0; 
        if(contemPonto(retangulo.getX1(), retangulo.getY1()))
        {
            points++;
        }

        if(contemPonto(retangulo.getX1(), retangulo.getY2()))
        {
            points++;
        }

        if(contemPonto(retangulo.getX2(), retangulo.getY1()))
        {
            points++;
        }

        if(contemPonto(retangulo.getX2(), retangulo.getY2()))
        {
            points++;
        }
        return (points == 4);
    }

    public double getArea()
    {
        double larguraX = this.x2 - this.x1;
        double alturaY= this.y2 - this.y1;
        return larguraX * alturaY;
    }

    public double diferencaRetangulos(Retangulo retangulo)
    {
        if(interceptaRetangulo(retangulo))
        {
            return getArea() - retangulo.getArea();
        }
        return -1;
    }

}
