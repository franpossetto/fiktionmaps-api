package com.mapToFiction.mapToFiction.mapper;
import com.mapToFiction.mapToFiction.model.Fiction;
import com.mapToFiction.mapToFiction.service.dto.FictionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SceneMapper.class)
public interface FictionMapper extends EntityMapper<FictionDTO, Fiction> {
}


