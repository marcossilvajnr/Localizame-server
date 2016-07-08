package br.mjr.localizame.bo.interfaces;

import br.mjr.localizame.model.VinculoDispositivoPosicao;

/**
 * Created by marcos on 7/5/16.
 */

public interface ManagerBO {
    void adicionaVinculo(VinculoDispositivoPosicao vinculoDispositivoPosicao);
    void atualizaVinculoCurrent(VinculoDispositivoPosicao vinculoDispositivoPosicao);
    void atualizaVinculoFollow(VinculoDispositivoPosicao vinculoDispositivoPosicao);
}
