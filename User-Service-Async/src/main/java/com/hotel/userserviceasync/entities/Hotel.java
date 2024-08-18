package com.hotel.userserviceasync.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {
    
    private Long hotelId;
    private String name;
    private String location;
    private String about;
}
