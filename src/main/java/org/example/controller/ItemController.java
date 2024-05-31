package org.example.controller;

import org.example.model.Item;
import org.example.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;
    private final String ENDPOINT = "api/v1/items";

    @CrossOrigin
    @GetMapping(ENDPOINT)
    public List<Item> getAll(){
        return itemService.getAll();
    }

    @CrossOrigin
    @PostMapping(ENDPOINT)
    public ResponseEntity<Item> insert(@RequestBody Item item){
        itemService.add(item);
        return ResponseEntity.status(201).body(item);
    }

    @CrossOrigin
    @PutMapping(ENDPOINT)
    public ResponseEntity<Item> update(@RequestBody Item item){
        itemService.update(item);
        return ResponseEntity.status(204).body(item);
    }

    @CrossOrigin
    @DeleteMapping(ENDPOINT + "/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        itemService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
