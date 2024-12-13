package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Compass;
import ru.appline.logic.CompassModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final CompassModel COMPASS_MODEL = CompassModel.getInstance();

    @PostMapping(value = "/createCompass", consumes = "application/json")
    public String createPet(@RequestBody Compass compass){

        COMPASS_MODEL.add(compass,1);
        return ("Создан компас");
    }

    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public String getSide(@RequestBody Map<String,Integer> req){
        Compass compass =  COMPASS_MODEL.getFromList(1);
        int grad = (req.get("Degree"));

        if (grad < 0 | grad> 360) return ("Degree must be in range [0-360]");

        if (grad >= Integer.parseInt(compass.getEast().split("-")[0]) & grad <= Integer.parseInt(compass.getEast().split("-")[1]))
        {
            return ("Side : East");
        }else if (grad >= Integer.parseInt(compass.getSouth().split("-")[0]) & grad <= Integer.parseInt(compass.getSouth().split("-")[1])){
            return ("Side : South");
        }else if (grad >= Integer.parseInt(compass.getWest().split("-")[0]) & grad <= Integer.parseInt(compass.getWest().split("-")[1])){
            return ("Side : West");
        }else if (grad >= Integer.parseInt(compass.getNorthEast().split("-")[0]) & grad <= Integer.parseInt(compass.getNorthEast().split("-")[1])){
            return ("Side : NorthEast");
        }else if (grad >= Integer.parseInt(compass.getNorthWest().split("-")[0]) & grad <= Integer.parseInt(compass.getNorthWest().split("-")[1])){
            return ("Side : NorthWest");
        }else if (grad >= Integer.parseInt(compass.getSouthWest().split("-")[0]) & grad <= Integer.parseInt(compass.getSouthWest().split("-")[1])){
            return ("Side : SouthWest");
        }else if (grad >= Integer.parseInt(compass.getSouthEast().split("-")[0]) & grad <= Integer.parseInt(compass.getSouthEast().split("-")[1])){
            return ("Side : SouthEast");
        }else return("Side : North");
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Compass> getAll(){
        return COMPASS_MODEL.getAll();
    }

}
