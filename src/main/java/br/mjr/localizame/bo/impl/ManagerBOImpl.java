package br.mjr.localizame.bo.impl;

import br.mjr.localizame.bo.interfaces.ManagerBO;
import br.mjr.localizame.helper.CoordinateHelper;
import br.mjr.localizame.model.VinculoDispositivoPosicao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcos on 7/5/16.
 */

@Service
public class ManagerBOImpl implements ManagerBO {
    private static Logger log = LoggerFactory.getLogger(ManagerBOImpl.class);
    private Map<String, VinculoDispositivoPosicao> vinculoMap = new HashMap<>();

    @Autowired CoordinateHelper coordinateHelper;

    @Override
    public void adicionaVinculo(VinculoDispositivoPosicao vinculoDispositivoPosicao) {
        String key = vinculoDispositivoPosicao.getDispositivoMobileCurrent().getId();
        if (!vinculoMap.containsKey(key)) {
            // Adiciona o vinculo do cuurent
            vinculoDispositivoPosicao.setForaAlcanse(false);
            vinculoMap.put(key, vinculoDispositivoPosicao);

            // Adiciona o vinculo do follow
            VinculoDispositivoPosicao vinculoDispositivoPosicaoAux = new VinculoDispositivoPosicao();
            vinculoDispositivoPosicaoAux.setDispositivoMobileCurrent(vinculoDispositivoPosicao.getDispositivoMobileFollow());
            vinculoDispositivoPosicaoAux.setPosicaoMobileCurrent(vinculoDispositivoPosicao.getPosicaoMobileFollow());
            vinculoDispositivoPosicaoAux.setDispositivoMobileFollow(vinculoDispositivoPosicao.getDispositivoMobileCurrent());
            vinculoDispositivoPosicaoAux.setPosicaoMobileFollow(vinculoDispositivoPosicao.getPosicaoMobileCurrent());
            vinculoDispositivoPosicaoAux.setAlcanceMetros(vinculoDispositivoPosicao.getAlcanceMetros());
            vinculoDispositivoPosicaoAux.setForaAlcanse(false);
            vinculoMap.put(vinculoDispositivoPosicaoAux.getDispositivoMobileCurrent().getId(), vinculoDispositivoPosicaoAux);
        }
    }

    @Override
    public void atualizaVinculoCurrent(VinculoDispositivoPosicao vinculoDispositivoPosicao) {
        // Atualizo a posicao gps do mandante
        String keyCurrent = vinculoDispositivoPosicao.getDispositivoMobileCurrent().getId();
        if (vinculoMap.containsKey(keyCurrent)) {
            vinculoMap.get(keyCurrent).setPosicaoMobileCurrent(vinculoDispositivoPosicao.getPosicaoMobileCurrent());
        }
    }

    @Override
    public void atualizaVinculoFollow(VinculoDispositivoPosicao vinculoDispositivoPosicao) {
        // Atualizo a posicao gps do follow
        String keyFollow = vinculoDispositivoPosicao.getDispositivoMobileFollow().getId();
        if (vinculoMap.containsKey(keyFollow)) {
            vinculoMap.get(keyFollow).setPosicaoMobileFollow(vinculoDispositivoPosicao.getPosicaoMobileCurrent());
        }
    }

    public Map<String, VinculoDispositivoPosicao> getVinculoMap() {
        return vinculoMap;
    }
}
