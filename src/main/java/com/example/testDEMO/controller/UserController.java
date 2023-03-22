package com.example.testDEMO.controller;

import com.example.testDEMO.model.*;
import com.example.testDEMO.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private ProductService productService;
    private DiscountService discountService;
    private UserService userService;
    private PurchaseService purchaseService;
    private ReviewService reviewService;
    private NotificationService notificationService;

    //регистрация нового пользователя в магазине
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    //вход пользователя в учетную запись по юзернейму и паролю
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String username, @RequestParam String password) {
        return new ResponseEntity<>(userService.login(username, password),HttpStatus.OK);
    }

    //покупка товара по его id
    @PostMapping("/products/{id}/buy")
    public ResponseEntity<Purchase> buyProductById(@PathVariable Long id) {
        return new ResponseEntity<>(purchaseService.buyProductById(id),HttpStatus.CREATED);
    }

    //отзыв о товаре по его id
    @PostMapping("/products/{id}/reviews")
    public ResponseEntity<Review> addReviewToProductById(@PathVariable Long id, @RequestBody Review review) {
        Review savedReview = productService.addReviewToProductById(id,review);
        return new ResponseEntity<>(savedReview,HttpStatus.CREATED);
    }

    //оценка товара по его идентификатору
    @PostMapping("/products/{id}/ratings")
    public ResponseEntity<Rating> addRatingToProductById(@PathVariable Long id,@RequestBody Rating rating) {
        Rating savedRating = productService.addRatingToProductById(id, rating);
        return new ResponseEntity<>(savedRating,HttpStatus.CREATED);
    }

    //просмотр истории покупок
    @GetMapping("/{userId}/purchases")
    public ResponseEntity<List<Purchase>> getMyPurchases(@PathVariable Long id) {
        List<Purchase> purchases = purchaseService.getPurchaseByUserId(id);
        return new ResponseEntity<>(purchases,HttpStatus.OK);
    }

    //возврат покупки по ее id
    @PutMapping("/purchases/{id}/return")
    public ResponseEntity<Purchase> returnPurchaseById(@PathVariable Long id) {
        Purchase returnedPurchase = purchaseService.getPurchaseById(id);
        return new ResponseEntity<>(returnedPurchase ,HttpStatus.OK);
    }

    //просмотр уведомлений
    @GetMapping("/{userId}/notifications")
    public ResponseEntity<List<Notification>> getMyNotifications(@PathVariable Long id) {
        List<Notification> notifications = notificationService.getNotificationsByUserId(id);
        return new ResponseEntity<>(notifications ,HttpStatus.OK);
    }

    //подача заявки на регистрацию организации
    @PostMapping("/organizations")
    public ResponseEntity<Organization> applyForOrganization(@RequestBody @Valid Organization organization,@RequestBody @Valid User user) {
        Organization appliedOrganization = userService.applyForOrganization(organization,user);
        return new ResponseEntity<>(appliedOrganization ,HttpStatus.CREATED);
    }
}
