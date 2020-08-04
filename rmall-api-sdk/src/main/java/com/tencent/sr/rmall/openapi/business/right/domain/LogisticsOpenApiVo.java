package com.tencent.sr.rmall.openapi.business.right.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * openapi配送信息
 * @author Z_RT
 * @date 2020年6月29日
 */
@Data
@ApiModel(description = "openapi配送信息")
public class LogisticsOpenApiVo {

	/**
	 * 配送单号
	 */
	@ApiModelProperty("配送单号")
	private String logisticsNo;
	/**
	 * 物流状态
	 */
	@ApiModelProperty("物流状态")
	private Integer logisticsStatus;

	/**
	 * 配送公司名称
	 */
	@ApiModelProperty("配送公司名称")
	private String logisticsCompanyName;
	/**
	 * 收货人所在省份
	 */
	@ApiModelProperty("收货人所在省份")
	private String receiverProvince;
	/**
	 * 收货人所在城市
	 */
	@ApiModelProperty("收货人所在城市")
	private String receiverCity;
	/**
	 * 收货人所在区/县
	 */
	@ApiModelProperty("收货人所在区/县")
	private String receiverCounty;
	/**
	 * 收货人所在乡镇/街道
	 */
	@ApiModelProperty("收货人所在乡镇/街道")
	private String receiverArea;
	/**
	 * 收货人详细地址
	 */
	@ApiModelProperty("收货人详细地址")
	private String receiverAddress;

}
