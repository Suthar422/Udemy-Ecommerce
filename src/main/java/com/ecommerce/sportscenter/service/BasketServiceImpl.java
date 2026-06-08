package com.ecommerce.sportscenter.service;

import com.ecommerce.sportscenter.entity.Basket;
import com.ecommerce.sportscenter.entity.BasketItem;
import com.ecommerce.sportscenter.model.BasketItemResponse;
import com.ecommerce.sportscenter.model.BasketResponse;
import com.ecommerce.sportscenter.repository.BasketRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BasketServiceImpl implements BasketService{

    private final BasketRepository basketRepository;

    public BasketServiceImpl(BasketRepository basketRepository){
        this.basketRepository = basketRepository;
    }

    @Override
    public List<BasketResponse> getAllBaskets() {
        log.info("Fetching All Baskets...");
        List<Basket> basketList = (List<Basket>) basketRepository.findAll();
        //now we use streams operator to map with response
        List<BasketResponse> basketResponses = basketList.stream()
                .map(this::convertToBasketResponse)
                .toList();

        return basketResponses;
    }

    @Override
    public BasketResponse getBasketById(String basketId) {
        log.info("Fetching Basket by Id:{}", basketId);
        Optional<Basket> basketOptional =  basketRepository.findById(basketId);
        if(basketOptional.isPresent()){
            Basket basket = basketOptional.get();
            log.info("Fetch basket by id: {}", basketId);
            return convertToBasketResponse(basket);
        }else {
            log.info("Basket with id: {} NOT FOUND!", basketId);
        }
        return null;
    }

    @Override
    public void deleteBasketById(String basketId) {
        log.info("Deleting basket by its id: {}", basketId);
        basketRepository.deleteById(basketId);
        log.info("Deleted basket by Id: {}", basketId);
    }

    @Override
    public BasketResponse createBasket(Basket basket) {
        log.info("Creating Basket");
        Basket savedBasket = basketRepository.save(basket);
        log.info("Basket created with id: {}", savedBasket.getId());
        return convertToBasketResponse(savedBasket);
    }

    private BasketResponse convertToBasketResponse(Basket basket) {
            if(basket == null) return null;

            List<BasketItemResponse> itemResponses = basket.getItems().stream()
                    .map(this::convertToBasketItemResponse)
                    .collect(Collectors.toList());

            return BasketResponse.builder()
                    .id(basket.getId())
                    .items(itemResponses)
                    .build();
    }

    private BasketItemResponse convertToBasketItemResponse(BasketItem basketItem) {
        return BasketItemResponse.builder()
                .id(basketItem.getId())
                .name(basketItem.getName())
                .description(basketItem.getDescription())
                .price(basketItem.getPrice())
                .pictureUrl(basketItem.getPictureUrl())
                .productBrand(basketItem.getProductBrand())
                .productType(basketItem.getProductType())
                .quantity(basketItem.getQuantity())
                .build();
    }
}
