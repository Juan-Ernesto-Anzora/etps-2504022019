package sv.edu.utec.recicleview;

public class Modelo {

    private String NoombPeli;
    private String GeneroPeli;
    private String DirecPeli;
    private String anioPeli;
    private int ImgPeli;
    private String duraPeli;
    private String fechPeli;
    private double clasifcar;

    public String getNoombPeli() {
        return NoombPeli;
    }

    public void setNoombPeli(String noombPeli) {
        NoombPeli = noombPeli;
    }

    public String getGeneroPeli() {
        return GeneroPeli;
    }

    public void setGeneroPeli(String generoPeli) {
        GeneroPeli = generoPeli;
    }

    public String getDirecPeli() {
        return DirecPeli;
    }

    public void setDirecPeli(String direcPeli) {
        DirecPeli = direcPeli;
    }

    public String getAnioPeli() {
        return anioPeli;
    }

    public void setAnioPeli(String anioPeli) {
        this.anioPeli = anioPeli;
    }

    public int getImgPeli() {
        return ImgPeli;
    }

    public void setImgPeli(int imgPeli) {
        ImgPeli = imgPeli;
    }

    public String getDuraPeli() {
        return duraPeli;
    }

    public void setDuraPeli(String duraPeli) {
        this.duraPeli = duraPeli;
    }

    public String getFechPeli() {
        return fechPeli;
    }

    public void setFechPeli(String fechPeli) {
        this.fechPeli = fechPeli;
    }

    public double getClasifcar() {
        return clasifcar;
    }

    public void setClasifcar(double clasifcar) {
        this.clasifcar = clasifcar;
    }
}
