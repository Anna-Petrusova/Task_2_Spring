package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json")
    public String createPet(@RequestBody Pet pet){

        petModel.add(pet,newId.getAndIncrement());
        if (newId.get()==2){
            return ("Поздравляем! Вы создали первого питомца!");
        } else {
            return ("Поздравляем! Вы создали питомца!");
        }

    }

    @DeleteMapping(value = "/deletePet", consumes = "application/json")
    public String deletePet(@RequestBody Map<String,Integer> id){

        int id_num = id.get("id");
        if (id_num==0){
            petModel.deleteAll();
            return ("Все питомцы удалены");

        } else if (id_num>0) {
            if (!petModel.haveId(id_num))
            {
                return("Такого питомца нет");
            }
            else{
                petModel.deleteById(id_num);
                return("Удалён питомец №"+ id_num);
            }
        }else {
            return("ID должен быть больше 0");
        }
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer,Pet> getAll(){
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String,Integer> id){
        return petModel.getFromList(id.get("id"));
    }

    @PutMapping(value = "/putPet", consumes = "application/json", produces = "application/json")
    public String putPet(@RequestBody Map<String,String> map){

        if (!petModel.haveId(Integer.parseInt(map.get("id"))))
        {
            return("Такого питомца нет");

        } else{
            petModel.add(new Pet(map.get("name"),map.get("type"),Integer.parseInt(map.get("age"))),Integer.parseInt(map.get("id")));
            return("Данные питомца №"+ map.get("id")+" изменены");
        }

    }

}
