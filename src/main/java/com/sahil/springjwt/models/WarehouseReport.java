package com.sahil.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseReport {
	private String partNo;
    private Long quantity;
    private Long inward;
    private Long outward;
    private Long closingStock;
    private long productId;
}
