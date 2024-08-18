package com.hotel.userserviceasync.service.fallback;

import org.springframework.stereotype.Component;

import com.hotel.userserviceasync.entities.Hotel;
import com.hotel.userserviceasync.external.services.HotelService;

@Component
public class HotelServiceFallback implements HotelService {

    @Override
    public Hotel getHotel(Long hotelId) {
        return Hotel.builder().hotelId(hotelId).name("Hotel not found feign").location("Location not found").about("About not found").build();
    }

    


}
