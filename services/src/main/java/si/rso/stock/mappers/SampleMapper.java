package si.rso.stock.mappers;

import si.rso.stock.lib.Sample;
import si.rso.stock.persistence.SampleEntity;

public class SampleMapper {
    
    public static Sample fromEntity(SampleEntity entity) {
        return new Sample();
    }
    
}