package br.com.mps_cadatro_back.controller;

import br.com.mps_cadatro_back.model.TipoCadastro;
import br.com.mps_cadatro_back.repository.TipoCadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tipoCadastro")
public class TipoCadastroController {

    @Autowired
    TipoCadastroRepository tipoCadastroRepository;


    @PostMapping
    public ResponseEntity insertTipoCadastro(@RequestBody TipoCadastro tipoCadastro) {

        try {
            TipoCadastro _tipoCadastro = tipoCadastroRepository
                    .save(tipoCadastro);
            return new ResponseEntity(_tipoCadastro, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
