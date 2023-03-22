package com.example.testDEMO.controller;

import com.example.testDEMO.model.*;
import com.example.testDEMO.service.DiscountService;
import com.example.testDEMO.service.ProductService;
import com.example.testDEMO.service.PurchaseService;
import com.example.testDEMO.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private ProductService productService;
    private DiscountService discountService;
    private UserService userService;
    private PurchaseService purchaseService;
    private NotificationService notificationService;

    //добавление нового товара
    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    //изменение инф о продукте
    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product),HttpStatus.ACCEPTED);
    }

    //добавление новой скидки
    @PostMapping("/discounts")
    public ResponseEntity<Discount> addDiscount(@RequestBody Discount discount){
        return new ResponseEntity<>(discountService.createDiscount(discount),HttpStatus.CREATED);
    }

    //изменение инф о скидке
    @PutMapping("/discounts")
    public ResponseEntity<Discount> updateDiscount(@RequestBody Discount discount){
        return new ResponseEntity<>(discountService.updateDiscount(discount),HttpStatus.OK);
    }

    //просмотр инф о юзере по юзернейму
    @GetMapping("/users/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        return new ResponseEntity<>(userService.getUserByUserName(username),HttpStatus.OK);
    }

    //удаление юзера по юзернейму
    @DeleteMapping("users/{username}")
    public ResponseEntity<Void> deleteUserByUsername(@PathVariable String username){
        userService.deleteUserByUsername(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //пополнение баланса по юзернейму
    @PutMapping("/users/{username}/balance")
    public ResponseEntity<User> deleteUserByUsername(@PathVariable String username,@RequestParam Double amount){
        return new ResponseEntity<>(userService.updateUserBalance(username,amount),HttpStatus.OK);
    }

    //заморозка юзера по юзернейму
    @PutMapping("/users/{username}/freeze")
    public ResponseEntity<User> freezeUser(@PathVariable String username, @RequestParam Boolean frozen){
        return new ResponseEntity<>(userService.freezeAccount(username,frozen),HttpStatus.OK);
    }

    //уведомление юзера по юзернейму
    @PostMapping("/users/{username}/notifications")
    public ResponseEntity<Notification> sendNotificationToUser(@PathVariable String username, @RequestBody Notification notification) {
        Notification sentNotification = notificationService.sendToUser(username, notification);
        return new ResponseEntity<>(sentNotification ,HttpStatus.CREATED);
    }

    //история покупок юзера по юзернейму
    @GetMapping("/users/{username}/purchases")
    public ResponseEntity<List<Purchase>> getUserPurchasesByUsername(@PathVariable String username) {
        return new ResponseEntity<>(purchaseService.getPurchaseByUser(userService.getUserByUserName(username)) ,HttpStatus.OK);
    }

}
