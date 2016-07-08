package br.mjr.localizame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by marcos on 7/5/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class VinculoDispositivoPosicao implements Serializable {
    private static final long serialVersionUID = 1L;
    private DispositivoMobile dispositivoMobileCurrent;
    private PosicaoMobile posicaoMobileCurrent;
    private DispositivoMobile dispositivoMobileFollow;
    private PosicaoMobile posicaoMobileFollow;
    private Integer alcanceMetros;
    private Boolean foraAlcanse;

    public VinculoDispositivoPosicao() {}

    public VinculoDispositivoPosicao(DispositivoMobile dispositivoMobileCurrent, PosicaoMobile posicaoMobileCurrent, DispositivoMobile dispositivoMobileFollow, PosicaoMobile posicaoMobileFollow, Integer alcanceMetros, Boolean foraAlcanse) {
        this.dispositivoMobileCurrent = dispositivoMobileCurrent;
        this.posicaoMobileCurrent = posicaoMobileCurrent;
        this.dispositivoMobileFollow = dispositivoMobileFollow;
        this.posicaoMobileFollow = posicaoMobileFollow;
        this.alcanceMetros = alcanceMetros;
        this.foraAlcanse = foraAlcanse;
    }

    public DispositivoMobile getDispositivoMobileCurrent() {
        return dispositivoMobileCurrent;
    }

    public void setDispositivoMobileCurrent(DispositivoMobile dispositivoMobileCurrent) {
        this.dispositivoMobileCurrent = dispositivoMobileCurrent;
    }

    public PosicaoMobile getPosicaoMobileCurrent() {
        return posicaoMobileCurrent;
    }

    public void setPosicaoMobileCurrent(PosicaoMobile posicaoMobileCurrent) {
        this.posicaoMobileCurrent = posicaoMobileCurrent;
    }

    public DispositivoMobile getDispositivoMobileFollow() {
        return dispositivoMobileFollow;
    }

    public void setDispositivoMobileFollow(DispositivoMobile dispositivoMobileFollow) {
        this.dispositivoMobileFollow = dispositivoMobileFollow;
    }

    public PosicaoMobile getPosicaoMobileFollow() {
        return posicaoMobileFollow;
    }

    public void setPosicaoMobileFollow(PosicaoMobile posicaoMobileFollow) {
        this.posicaoMobileFollow = posicaoMobileFollow;
    }

    public Integer getAlcanceMetros() {
        return alcanceMetros;
    }

    public void setAlcanceMetros(Integer alcanceMetros) {
        this.alcanceMetros = alcanceMetros;
    }

    public Boolean getForaAlcanse() {
        return foraAlcanse;
    }

    public void setForaAlcanse(Boolean foraAlcanse) {
        this.foraAlcanse = foraAlcanse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VinculoDispositivoPosicao that = (VinculoDispositivoPosicao) o;

        if (dispositivoMobileCurrent != null ? !dispositivoMobileCurrent.equals(that.dispositivoMobileCurrent) : that.dispositivoMobileCurrent != null)
            return false;
        if (posicaoMobileCurrent != null ? !posicaoMobileCurrent.equals(that.posicaoMobileCurrent) : that.posicaoMobileCurrent != null)
            return false;
        if (dispositivoMobileFollow != null ? !dispositivoMobileFollow.equals(that.dispositivoMobileFollow) : that.dispositivoMobileFollow != null)
            return false;
        if (posicaoMobileFollow != null ? !posicaoMobileFollow.equals(that.posicaoMobileFollow) : that.posicaoMobileFollow != null)
            return false;
        if (alcanceMetros != null ? !alcanceMetros.equals(that.alcanceMetros) : that.alcanceMetros != null)
            return false;
        return foraAlcanse != null ? foraAlcanse.equals(that.foraAlcanse) : that.foraAlcanse == null;

    }

    @Override
    public int hashCode() {
        int result = dispositivoMobileCurrent != null ? dispositivoMobileCurrent.hashCode() : 0;
        result = 31 * result + (posicaoMobileCurrent != null ? posicaoMobileCurrent.hashCode() : 0);
        result = 31 * result + (dispositivoMobileFollow != null ? dispositivoMobileFollow.hashCode() : 0);
        result = 31 * result + (posicaoMobileFollow != null ? posicaoMobileFollow.hashCode() : 0);
        result = 31 * result + (alcanceMetros != null ? alcanceMetros.hashCode() : 0);
        result = 31 * result + (foraAlcanse != null ? foraAlcanse.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VinculoDispositivoPosicao{" +
                "dispositivoMobileCurrent=" + dispositivoMobileCurrent +
                ", posicaoMobileCurrent=" + posicaoMobileCurrent +
                ", dispositivoMobileFollow=" + dispositivoMobileFollow +
                ", posicaoMobileFollow=" + posicaoMobileFollow +
                ", alcanceMetros=" + alcanceMetros +
                ", foraAlcanse=" + foraAlcanse +
                '}';
    }
}
