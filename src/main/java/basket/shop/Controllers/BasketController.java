package basket.shop.Controllers;

import basket.shop.Exceptions.BascetIsEmpptyException;
import basket.shop.Exceptions.IdAlreadyAddedException;
import basket.shop.Services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store/order")
public class BasketController {
    private final BasketService corzinka;

    public BasketController(BasketService corzinka){
        this.corzinka = corzinka;
    }

    //Добавление товаров
    @GetMapping(path = "/add")
    public String add(@RequestParam("id") int id){
        try{
            return corzinka.addIds(id);
        } catch (IdAlreadyAddedException e){
            return "Этот товар уже есть!";
        }
    }

    //Вывод корзины
    @GetMapping(path = "/get")
    public String get(){
        try{
            return corzinka.idsGet().toString();
        } catch (BascetIsEmpptyException e){
            return "Корзина пуста!";
        }
    }
}
