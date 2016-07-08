package br.mjr.localizame.rest;

import br.mjr.localizame.bo.impl.ManagerBOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marcos on 7/1/16.
 */

@RestController
@RequestMapping(value = "/rest/status/")
public class StatusRestController {
    @Autowired ManagerBOImpl managerBO;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HttpStatus> showStatus(){
        try {
            return new ResponseEntity(managerBO.getVinculoMap().values().toArray(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
