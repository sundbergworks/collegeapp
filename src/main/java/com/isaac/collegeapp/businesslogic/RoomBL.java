package com.isaac.collegeapp.businesslogic;

import com.isaac.collegeapp.model.RoomDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoomBL {

   public List<RoomDAO> filterPhdRooms (List<RoomDAO> roomDAOList);
   public List<RoomDAO> getRoomDAOList ();
   public RoomDAO getRoomById(Integer roomid);
   public  RoomDAO updateRoom(RoomDAO roomDAO);
   public  RoomDAO deleteRoom(RoomDAO roomDAO);
   public RoomDAO createRoom(RoomDAO roomDAO);

}
