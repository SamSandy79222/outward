package com.sahil.springjwt.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.springjwt.models.ReportSaved;
import com.sahil.springjwt.models.WarehouseReport;
import com.sahil.springjwt.repository.ReportSavedRepository;


@RestController
@RequestMapping("/warehousereport")
public class WarehouseReportController {

	@Autowired
	ReportSavedRepository reportSavedRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/{warehouseId}")
    public List<WarehouseReport> getWarehouseReport(@PathVariable Long warehouseId) {
//        String sql = "SELECT " +
//                     "product.part_no, " +
//                     "opentock.quantity, " +
//                     "(sale_return_item.qty + purchase_items.qty) as inward, " +
//                     "(purchase_return_items.qty + sale_items.qty) as outward, " +
//                     "(opentock.quantity + ((sale_return_item.qty + purchase_items.qty) - (purchase_return_items.qty + sale_items.qty))) as closingstock " +
//                     "FROM purchase_items " +
//                     "JOIN sale_return_item ON purchase_items.purchase_id = sale_return_item.sritemid " +
//                     "JOIN sale_items ON sale_return_item.sritemid = sale_items.sitem_id " +
//                     "JOIN purchase_return_items ON sale_items.sitem_id = purchase_return_items.pritemid " +
//                     "JOIN product ON purchase_return_items.pritemid = product.product_id " +
//                     "JOIN opentock ON product.product_id = opentock.stock_id " +
//                     "WHERE opentock.warehouses = ?";
        
        String sql = "SELECT\r\n"
        		+ "    os.quantity,\r\n"
        		+ "    p.product_id,\r\n"
        		+ "    p.part_no,\r\n"
        		+ "    (CASE WHEN pi.qty IS NULL THEN 0 ELSE pi.qty END + CASE WHEN sri.qty IS NULL THEN 0 ELSE sri.qty END) AS inward,\r\n"
        		+ "    (CASE WHEN pri.qty IS NULL THEN 0 ELSE pri.qty END + CASE WHEN si.qty IS NULL THEN 0 ELSE si.qty END) AS outward,\r\n"
        		+ "    (os.quantity + \r\n"
        		+ "     ((CASE WHEN pi.qty IS NULL THEN 0 ELSE pi.qty END) + \r\n"
        		+ "     (CASE WHEN sri.qty IS NULL THEN 0 ELSE sri.qty END)) -\r\n"
        		+ "     ((CASE WHEN pri.qty IS NULL THEN 0 ELSE pri.qty END) +\r\n"
        		+ "     (CASE WHEN si.qty IS NULL THEN 0 ELSE si.qty END))\r\n"
        		+ "    ) AS closingstock\r\n"
        		+ "FROM product AS p\r\n"
        		+ "INNER JOIN opentock AS os ON p.product_id = os.products\r\n"
        		+ "LEFT JOIN purchase_items AS pi ON p.product_id = pi.product_id\r\n"
        		+ "LEFT JOIN sale_return_item AS sri ON p.product_id = sri.product_id\r\n"
        		+ "LEFT JOIN purchase_return_items AS pri ON p.product_id = pri.product_id\r\n"
        		+ "LEFT JOIN sale_items AS si ON p.product_id = si.product_id\r\n"
        		+ "WHERE os.warehouses =?;";
        
        List<WarehouseReport> reports = jdbcTemplate.query(
                sql,
                new Object[]{warehouseId},
                (rs, rowNum) -> {
                    WarehouseReport report = new WarehouseReport();
//                    ReportSaved reportSaved=new ReportSaved();
                    report.setPartNo(rs.getString("part_no"));
                    report.setQuantity(rs.getLong("quantity"));
                    report.setInward(rs.getLong("inward"));
                    report.setOutward(rs.getLong("outward"));
                    report.setClosingStock(rs.getLong("closingstock"));
                    report.setProductId(rs.getLong("product_id"));
//                    reportSaved.setPartNo(rs.getString("part_no"));
//                    reportSaved.setQuantity(rs.getLong("quantity"));
//                    reportSaved.setInward(rs.getLong("inward"));
//                    reportSaved.setOutward(rs.getLong("outward"));
//                    reportSaved.setClosingStock(rs.getLong("closingstock"));
                    
//                    reportSavedRepository.save(reportSaved);
                    return report;
                }

        );

        return reports;
    }
	
	
	
	@GetMapping("/{warehouse}/{start_date}/{end_date}")
    public List<WarehouseReport> getWarehouseReportbyDate(@PathVariable Long warehouse,
//    		@PathVariable ("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start_date,
//    		@PathVariable ("end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end_date)
@PathVariable(value = "start_date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date start_date,
@PathVariable(value = "end_date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date end_date)

	{

        String sql = "SELECT\r\n"
        		+ "    os.quantity,\r\n"
        		+ "    p.product_id,\r\n"
        		+ "    p.part_no,\r\n"
        		+ "    purchase.created_date,\r\n"
        		+ "    purchase_return.date,\r\n"
        		+ "    sale.date,\r\n"
        		+ "    sale_return.date,\r\n"
        		+ "    (CASE WHEN pi.qty IS NULL THEN 0 ELSE pi.qty END + CASE WHEN sri.qty IS NULL THEN 0 ELSE sri.qty END) AS inward,\r\n"
        		+ "    (CASE WHEN pri.qty IS NULL THEN 0 ELSE pri.qty END + CASE WHEN si.qty IS NULL THEN 0 ELSE si.qty END) AS outward,\r\n"
        		+ "    (os.quantity + \r\n"
        		+ "     (CASE WHEN pi.qty IS NULL THEN 0 ELSE pi.qty END) + \r\n"
        		+ "     (CASE WHEN sri.qty IS NULL THEN 0 ELSE sri.qty END) - \r\n"
        		+ "     (CASE WHEN pri.qty IS NULL THEN 0 ELSE pri.qty END) - \r\n"
        		+ "     (CASE WHEN si.qty IS NULL THEN 0 ELSE si.qty END)\r\n"
        		+ "    ) AS closingstock\r\n"
        		+ "FROM product AS p\r\n"
        		+ "INNER JOIN opentock AS os ON p.product_id = os.products\r\n"
        		+ "LEFT JOIN purchase_items AS pi ON p.product_id = pi.product_id\r\n"
        		+ "LEFT JOIN sale_return_item AS sri ON p.product_id = sri.product_id\r\n"
        		+ "LEFT JOIN purchase_return_items AS pri ON p.product_id = pri.product_id\r\n"
        		+ "LEFT JOIN sale_items AS si ON p.product_id = si.product_id\r\n"
        		+ "\r\n"
        		+ "LEFT JOIN purchase on purchase.p_id =pi.p_id\r\n"
        		+ "LEFT JOIN purchase_return on purchase_return.prid=pri.p_rid\r\n"
        		+ "LEFT JOIN sale on sale.sale_id =si.sale_id\r\n"
        		+ "LEFT JOIN sale_return on sale_return.srid=sri.srid\r\n"
        		+ "WHERE os.warehouses = ?\r\n"
        		+ "    AND (purchase.created_date)>= ? \r\n"
        		+ "    AND (purchase.created_date) <= ?;";
        
        List<WarehouseReport> reports = jdbcTemplate.query(
                sql,
//              new Object[]{warehouse},
   new Object[]{warehouse,start_date,end_date},

                (rs, rowNum) -> {
                    WarehouseReport report = new WarehouseReport();
                    report.setPartNo(rs.getString("part_no"));
                    report.setQuantity(rs.getLong("quantity"));
                    report.setInward(rs.getLong("inward"));
                    report.setOutward(rs.getLong("outward"));
                    report.setClosingStock(rs.getLong("closingstock"));
                    report.setProductId(rs.getLong("product_id"));

                    return report;
                }
                
        );

        return reports;
    }
}
