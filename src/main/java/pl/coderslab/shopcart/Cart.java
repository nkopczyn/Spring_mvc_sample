package pl.coderslab.shopcart;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)

public class Cart {
    private List<CartItem> cartItems;

    public Cart(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public String getCartItems() {
        StringBuilder stringBuilder = new StringBuilder();
        for (CartItem item : this.cartItems) {
            stringBuilder.append("product: " + item.getProduct() + ", quantity: " + item.getQuantity());
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItems=" + cartItems +
                '}';
    }
}
