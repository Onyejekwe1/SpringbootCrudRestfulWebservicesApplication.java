package net.javaguides.springboot.provider;

import lombok.var;
import net.javaguides.springboot.dto.IrrigationConfigurationDto;
import net.javaguides.springboot.dto.LandDto;
import net.javaguides.springboot.entity.Land;

import java.util.Calendar;
import java.util.Date;

public class LandData {
    public static final String SERIAL_NUMBER = "6733729AER";
    public static final float LAND_AREA = 77614;
    public static final String LAND_PURPOSE = "Cassava Farming";
    public static final String SOIL_TYPE = "loamy soil";

    public static final LandDto getLandDTO(String serialNumber, String soilType, String landPurpose, float area){

        LandDto land = new LandDto();
        land.setSerialNumber(serialNumber);
        land.setLandPurpose(landPurpose);
        land.setSoilType(soilType);
        land.setArea(area);
        return land;
    }

    public static final LandDto getDefaultLandDTO(){

        LandDto land = new LandDto();
        land.setSerialNumber(SERIAL_NUMBER);
        land.setLandPurpose(LAND_PURPOSE);
        land.setSoilType(SOIL_TYPE);
        land.setArea(LAND_AREA);
        return land;
    }

    public static final IrrigationConfigurationDto getDefaultConfigureDTO(){

        var calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        var timeSlot =  calendar.getTime();
        IrrigationConfigurationDto configure = new IrrigationConfigurationDto();
        configure.setDeviceName("dev3345");
        configure.setLitresOfWater(200);
        configure.setDurationInMinutes(2500);
        configure.setTimeSlot(timeSlot);
        configure.setIrrigationIntervalInDays(2);
        return configure;
    }

    public static final Land getLandFromLandDTO(LandDto dto,Long id){
        Land land = new Land();
        land.setSerialNumber(dto.getSerialNumber());
        land.setLandPurpose(dto.getLandPurpose());
        land.setSoilType(dto.getSoilType());
        land.setArea(dto.getArea());
        land.setId(id);
        return land;
    }
}
