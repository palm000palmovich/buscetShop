package basket.shop;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class Basket {
    private final List<Integer> ids = new ArrayList<>();

    //Добавление товаров
    public void bascetAdd(int id){
        ids.add(id);
    }

    //Вывод товаров
    public List<Integer> bascetGet(){
        return ids;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "ids=" + ids +
                '}';
    }

}