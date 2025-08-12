package com.github.sugarmgp.demoproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author SugarMGP
 */
@Data
@Builder
@AllArgsConstructor
public class BaseListResponse<T> {
    private List<T> list;
}
