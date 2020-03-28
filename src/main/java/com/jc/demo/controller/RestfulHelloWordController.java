package com.jc.demo.controller;

import com.jc.demo.restfull.Man;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController //代表這是一個存放RESTful API的Controller
public class RestfulHelloWordController {

    private List<Man> manDB = new ArrayList<>();

    /**
     * 呼叫man
     * @param name
     * @return
     */
    @GetMapping(value = "/man/{name}")
    public ResponseEntity<Man> getName(@PathVariable("name") String name){
        Man manI = new Man();
        manI.setName(name);

        return ResponseEntity.ok().body(manI);
    }

    /**
     * DB操作範例
     * @param id
     * @return
     */
    @GetMapping(value = "/getMan/{id}")
    public ResponseEntity<Man> getManDB(@PathVariable("id") Integer id){
        Optional<Man> manOpL = manDB.stream()
                .filter(man ->
                        man.getId() == id
                )
                .findFirst();

        if (manOpL.isPresent()) {
            Man manI = manOpL.get();
            return ResponseEntity.ok().body(manI);
        }

        return ResponseEntity.notFound().build();
    }


}
