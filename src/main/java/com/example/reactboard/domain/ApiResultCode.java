package com.example.reactboard.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("API 응답 코드")
public enum ApiResultCode {
    @ApiModelProperty(value= "정상")
    succeed,

    @ApiModelProperty(value = "실패")
    failed
}
