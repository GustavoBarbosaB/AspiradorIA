package application;

public class Estado {
    private boolean A;
    private boolean B;
    private String posicao;
    private Estado esq;

    public Estado(String posicao, boolean A, boolean B) {
        this.A = A;
        this.B = B;
        this.posicao = posicao;
    }

    public Estado getEsq() {
        return esq;
    }

    public void setEsq(Estado esq) {
        this.esq = esq;
    }

    public Estado getDir() {
        return dir;
    }

    public void setDir(Estado dir) {
        this.dir = dir;
    }

    private Estado dir;

    public boolean isA() {
        return A;
    }

    public boolean isB() {
        return B;
    }

    public void setA(boolean A) {
        this.A = A;
    }

    public void setB(boolean B) {
        this.B = B;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String toString() {
        return this.posicao + " " +  this.isA() + " " + this.isB();
    }

    public boolean equals(Object o) {
        if (o instanceof Estado) {
            if (((Estado)o).toString().equals(this.toString()))
                return true;
        }
        return false;
    }
}
