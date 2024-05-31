package org.example.service;

import org.example.model.Item;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    static List<Item> items = new ArrayList<>();

    public ItemService(){
        for (int i = 0; i <= 10; i++) {
            items.add(new Item(i, "teste"+ i));
        }
    }
    public List<Item> getAll(){
        return items;
    }

    public void add(Item item){

        Optional<Integer> newId = items.stream()
                                       .map(Item::getId)
                                       .max(Integer::compareTo);

        if(newId.isPresent()){
            item.setId(newId.get() + 1);
        }else{
            item.setId(1);
        }

        items.add(item);
    }

    public void delete(int id){
        items.removeIf(data -> data.getId() == id);
    }

    public void update(Item item){
        items.set(item.getId(), item);
    }
}
