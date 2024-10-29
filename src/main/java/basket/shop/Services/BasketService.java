package basket.shop.Services;

import basket.shop.Basket;
import basket.shop.Exceptions.BascetIsEmpptyException;
import basket.shop.Exceptions.IdAlreadyAddedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    @Autowired
    private Basket basket;

    //Добавление товаров
    public String addIds(int id) throws IdAlreadyAddedException {
        if (!basket.bascetGet().contains(id)){
            basket.bascetAdd(id);
            return "Товар успешно добавлен!";
        }
        throw new IdAlreadyAddedException("Этот товар уже добавлен!");
    }

    //Вывод корзины
    public List<Integer> idsGet() throws BascetIsEmpptyException {
        if (!basket.bascetGet().isEmpty()){
            return basket.bascetGet();
        }
        throw new BascetIsEmpptyException("Корзина пуста!");
    }
}