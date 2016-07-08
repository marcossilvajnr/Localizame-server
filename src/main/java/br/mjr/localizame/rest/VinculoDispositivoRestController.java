package br.mjr.localizame.rest;

import br.mjr.localizame.bo.impl.ManagerBOImpl;
import br.mjr.localizame.model.DispositivoMobile;
import br.mjr.localizame.model.VinculoDispositivoPosicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by marcos on 7/5/16.
 */

@RestController
@RequestMapping(value = "/rest/vinculodispositivo/")
public class VinculoDispositivoRestController {
    @Autowired
    ManagerBOImpl managerBO;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HttpStatus> getVinculo(@RequestHeader(value = "key") String key){
        try {
            if (key != null && !key.isEmpty()){
                if (managerBO.getVinculoMap().containsKey(key)) {
                    return new ResponseEntity(managerBO.getVinculoMap().get(key), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> setVinculo(@RequestBody VinculoDispositivoPosicao vinculoDispositivoPosicao){
        try {
            String key = vinculoDispositivoPosicao.getDispositivoMobileCurrent().getId();
            if (key != null && !key.isEmpty()){
                if (managerBO.getVinculoMap().containsKey(key)) {
                    managerBO.adicionaVinculo(vinculoDispositivoPosicao);
                    return new ResponseEntity(managerBO.getVinculoMap().get(key), HttpStatus.OK);
                } else {
                    managerBO.adicionaVinculo(vinculoDispositivoPosicao);
                    return new ResponseEntity(managerBO.getVinculoMap().get(key), HttpStatus.CREATED);
                }
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> updateVinculo(@RequestBody VinculoDispositivoPosicao vinculoDispositivoPosicao) {
        try {
            // Verifico se a chave é válida
            String keyCurrent = vinculoDispositivoPosicao.getDispositivoMobileCurrent().getId();
            if (keyCurrent == null || keyCurrent.isEmpty()){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }

            // Verifico se a chave é válida
            String keyFollow = vinculoDispositivoPosicao.getDispositivoMobileFollow().getId();
            if (keyFollow == null || keyFollow.isEmpty()){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }

            // Verifico se existe na colecao
            if (!managerBO.getVinculoMap().containsKey(keyCurrent)) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }

            // Verifico se existe na colecao
            if (!managerBO.getVinculoMap().containsKey(keyFollow)) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }

            // Atualizo apenas o current
            managerBO.atualizaVinculoCurrent(vinculoDispositivoPosicao);

            System.err.println(managerBO.getVinculoMap().get(keyFollow).toString());

            // Devolvo o follow
            return new ResponseEntity(managerBO.getVinculoMap().get(keyFollow), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> removeVinculo(@RequestHeader(value = "key") String key) {
        try {
            if (key != null && !key.isEmpty()){
                if (managerBO.getVinculoMap().containsKey(key)) {
                    VinculoDispositivoPosicao vinculoDispositivoPosicao = managerBO.getVinculoMap().get(key);
                    managerBO.getVinculoMap().remove(vinculoDispositivoPosicao.getDispositivoMobileCurrent().getId());
                    managerBO.getVinculoMap().remove(vinculoDispositivoPosicao.getDispositivoMobileFollow().getId());
                    return new ResponseEntity(HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
