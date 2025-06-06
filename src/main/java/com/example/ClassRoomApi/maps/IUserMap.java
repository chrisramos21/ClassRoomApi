package com.example.ClassRoomApi.maps;

import com.example.ClassRoomApi.DTO.DTOUser;
import com.example.ClassRoomApi.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IUserMap {

    IUserMap INSTACE = Mappers.getMapper(IUserMap.class);


    //Creando el DTO

    DTOUser transformModelDTO(User user);

}
