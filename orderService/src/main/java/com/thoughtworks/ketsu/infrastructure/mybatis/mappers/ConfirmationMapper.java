package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;

import com.thoughtworks.ketsu.domain.confirmation.Confirmation;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ConfirmationMapper {
    void save(@Param("info") Map<String, Object> info);

    Confirmation getConfirmation(@Param("oid") String oid);
}
