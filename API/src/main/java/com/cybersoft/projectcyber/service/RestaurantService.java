package com.cybersoft.projectcyber.service;

import com.cybersoft.projectcyber.dto.CategoryDTO;
import com.cybersoft.projectcyber.dto.MenuDTO;
import com.cybersoft.projectcyber.dto.RestaurantDTO;
import com.cybersoft.projectcyber.entity.Food;
import com.cybersoft.projectcyber.entity.MenuRestaurant;
import com.cybersoft.projectcyber.entity.RateRestaurant;
import com.cybersoft.projectcyber.entity.Restaurant;
import com.cybersoft.projectcyber.payload.request.RestaurantRequest;
import com.cybersoft.projectcyber.repository.RestaurantRepository;
import com.cybersoft.projectcyber.service.uploadFile.FilesStorageService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    FilesStorageService filesStorageService;
    @Autowired
    RedisTemplate redisTemplate;

    private final Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();

    public boolean insertRestaurant(RestaurantRequest restaurantRequest) {
        boolean isSuccess = false;
        try {
            boolean isSaveFile = filesStorageService.save(restaurantRequest.getFile());
            if(isSaveFile) {
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantTitle(restaurantRequest.getRestaurantTitle());
                restaurant.setRestaurantSubTitle(restaurantRequest.getRestaurantSubTitle());
                restaurant.setAddress(restaurantRequest.getAddress());
                restaurant.setRestaurantDesc(restaurantRequest.getRestaurantDesc());
                restaurant.setIsFreeShip(restaurantRequest.getIsFreeShip());

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date opendate = simpleDateFormat.parse(restaurantRequest.getOpenDate());
                restaurant.setOpenDate(opendate);

                restaurantRepository.save(restaurant);
                isSuccess = true;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isSuccess;
    }

    public List<RestaurantDTO> getRestaurantHomePage() {
        String dataRedis = String.valueOf(redisTemplate.opsForValue().get("restaurentHomePage"));
        List<RestaurantDTO> listreRestaurantDTO = new ArrayList<>();
        if(dataRedis != null) {
            PageRequest pageRequest = PageRequest.of(0, 6);
            Page<Restaurant> listdata = restaurantRepository.findAll(pageRequest);
            for (Restaurant restaurant : listdata) {
                RestaurantDTO restaurantDTO = new RestaurantDTO();
                restaurantDTO.setRestaurantTitle(restaurant.getRestaurantTitle());
                restaurantDTO.setRestaurantSubTitle(restaurant.getRestaurantSubTitle());
                restaurantDTO.setImage(restaurant.getRestaurantImage());
                restaurantDTO.setIsFreeShip(restaurant.getIsFreeShip());
                restaurantDTO.setRating(caclRatingRestaurant(restaurant.getRateRestaurants()));
                listreRestaurantDTO.add(restaurantDTO);
            }
            String datajson = gson.toJson(listreRestaurantDTO);
            redisTemplate.opsForValue().set("restaurentHomePage" , datajson);
        }else{
            Type listType = new TypeToken<List<List<RestaurantDTO>>>() {}.getType();
            listreRestaurantDTO = gson.fromJson(dataRedis , listType);
        }
        return listreRestaurantDTO;
    }
    public double caclRatingRestaurant(List<RateRestaurant> rateRestaurantList) {
        double totalPoints = 0;
        for (RateRestaurant rateRestaurant : rateRestaurantList) {
            totalPoints += rateRestaurant.getRatePoint();
        }
        return totalPoints / rateRestaurantList.size();
    }
    public RestaurantDTO getRestaurantById(int id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()) {
            Restaurant data = restaurant.get();
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setRestaurantTitle(data.getRestaurantTitle());
            restaurantDTO.setRestaurantSubTitle(data.getRestaurantSubTitle());
            restaurantDTO.setImage(data.getRestaurantImage());
            restaurantDTO.setIsFreeShip(data.getIsFreeShip());

            List<CategoryDTO> listcategoryDTO = new ArrayList<>();
            for(MenuRestaurant menuRestaurant:data.getMenuRestaurants()){
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setCategoryName(menuRestaurant.getCategories().getCategoryName());
                List<MenuDTO> listmenudto = new ArrayList<>();
                for (Food food : menuRestaurant.getCategories().getFoods()){
                    MenuDTO menuDTO = new MenuDTO();
                    menuDTO.setTitle(food.getFoodName());
                    menuDTO.setIsFreeShip(food.getIsFreeShip());
                    listmenudto.add(menuDTO);
                }
                categoryDTO.setMenuList(listmenudto);
                listcategoryDTO.add(categoryDTO);
            }
            restaurantDTO.setListcategories(listcategoryDTO);
            return restaurantDTO;
        }
        return null;
    }
}
