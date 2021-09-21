package com.isaac.collegeapp.businesslogic;

import com.isaac.collegeapp.model.BuildingDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BuildingBL {

   public List<BuildingDAO> filterPhdBuildings (List<BuildingDAO> buildingDAOList);
   public List<BuildingDAO> getBuildingDAOList ();
   public BuildingDAO getBuildingById(Integer buildingid);
   public  BuildingDAO updateBuilding(BuildingDAO buildingDAO);
   public  BuildingDAO deleteBuilding(BuildingDAO buildingDAO);
   public BuildingDAO createBuilding(BuildingDAO buildingDAO);

}
