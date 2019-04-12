package osvaldo.unifacear.edu.br.cruzadinha.entity;

/**
 * Created by osval on 08/03/2019.
 */

public class Resultado {

    private Integer id;
    private boolean ganhador;


    @Override
    public String toString() {
        return id + "  " + (ganhador ? "Circulo ganhou!": "X ganhou!");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isGanhador() {
        return ganhador;
    }

    public void setGanhador(boolean ganhador) {
        this.ganhador = ganhador;
    }
}
