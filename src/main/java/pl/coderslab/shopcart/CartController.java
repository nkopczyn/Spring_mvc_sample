package pl.coderslab.shopcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class CartController {
    private final Cart cart;
    private final ProductDao productDao;

    // wstrzykiwanie do konstruktora, Spring stworzy Cart gdy będzie tworzyć CartController
    @Autowired
    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }

    @RequestMapping("/addtocart/{idProduct}/{quantityProduct}")
    @ResponseBody
    public String addtocart(@PathVariable Long idProduct,
                            @PathVariable Integer quantityProduct) {

        // poszukać produktu po id w produktdao
        Product product = null;
        for (Product item : productDao.getList()) {
            if (item.getId().equals(idProduct)) {
                product = item;
                break;
            }
        }
        if (product == null) {
            return "Nie znaleziono produktu o id: " + idProduct;
        }

        // addCartItem(CartItem)
        cart.addToCart(new CartItem(quantityProduct, product));

        return "addtocart";
    }

    @RequestMapping("/cart")
    @ResponseBody
    public String displayCart() {
       return cart.getCartItems();

    }


}
